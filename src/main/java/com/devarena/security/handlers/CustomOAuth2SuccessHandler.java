package com.devarena.security.handlers;

import com.devarena.modules.auth.entity.RefreshToken;
import com.devarena.modules.auth.entity.User;
import com.devarena.modules.auth.enums.Roles;
import com.devarena.modules.auth.repository.RefreshTokenRepository;
import com.devarena.modules.auth.repository.UserRepository;
import com.devarena.security.jwt.JwtTokenProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class CustomOAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public CustomOAuth2SuccessHandler(UserRepository userRepository,
                                      RefreshTokenRepository refreshTokenRepository,
                                      JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    @Transactional
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String picture = oAuth2User.getAttribute("picture");

        User user = userRepository.findByEmail(email)
                .orElseGet(() -> createNewOAuthUser(email, name, picture));

        String accessToken = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().name());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getEmail(), user.getRole().name());

        // Salvar Refresh Token
        refreshTokenRepository.deleteByUser(user);
        RefreshToken rt = new RefreshToken();
        rt.setUser(user);
        rt.setToken(refreshToken);
        rt.setIsRevoked(false);
        refreshTokenRepository.save(rt);

        // Redirecionar para o frontend com os tokens (Padrão SPA)
        // Em produção, isso deve apontar para a URL do seu Frontend
        String targetUrl = UriComponentsBuilder.fromUriString("http://localhost:5173/oauth2/callback")
                .queryParam("token", accessToken)
                .queryParam("refreshToken", refreshToken)
                .build().toUriString();

        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }

    private User createNewOAuthUser(String email, String name, String picture) {
        User user = new User();
        user.setEmail(email);
        user.setDisplayName(name);
        user.setAvatarUrl(picture);
        user.setPassword(null); // OAuth2 users don't have a local password initially
        user.setRole(Roles.USER);
        user.setIsActive(true); // OAuth2 email is considered verified
        user.setLevel(1);
        user.setXp(0);
        user.setPlan("FREE");
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }
}
