package com.devarena.modules.auth.service;

import com.devarena.modules.auth.dto.request.ForgotPasswordRequest;
import com.devarena.modules.auth.dto.request.OnboardingRequest;
import com.devarena.modules.auth.dto.request.RegisterRequest;
import com.devarena.modules.auth.dto.request.ResetPasswordRequest;
import com.devarena.modules.auth.dto.response.AuthResponse;
import com.devarena.modules.auth.dto.response.UserResponse;
import com.devarena.modules.auth.entity.User;
import com.devarena.modules.auth.enums.Roles;
import com.devarena.modules.auth.mapper.UserMapper;
import com.devarena.modules.auth.repository.UserRepository;
import com.devarena.modules.email.service.TokenEmailService;
import com.devarena.security.jwt.JwtTokenProvider;
import com.devarena.shared.exceptions.BusinessException;
import com.devarena.shared.exceptions.ResourceNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final TokenEmailService tokenEmailService;

    public AuthServiceImpl(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            TokenEmailService tokenEmailService) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.tokenEmailService = tokenEmailService;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        String email = request.email();

        if (userRepository.findByEmail(email).isPresent()) {
            throw new BusinessException("E-mail já cadastrado");
        }

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setDisplayName(request.email().split("@")[0]);
        user.setRole(Roles.USER);
        user.setIsActive(false);
        user.setLevel(1);
        user.setXp(0);
        user.setPlan("FREE");
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        tokenEmailService.CriarToken(user);

        return new AuthResponse(null, userMapper.toUserResponse(user));
    }

    @Override
    public AuthResponse login(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        if (user.getActive() == false) {
            throw new BusinessException("E-mail não verificado. Verifique sua caixa de entrada.");
        }

        String token = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().name());
        return new AuthResponse(token, userMapper.toUserResponse(user));
    }

    @Override
    public void forgotPassword(ForgotPasswordRequest request) {
        Optional<User> userOpt = userRepository.findByEmail(request.email());
        if (userOpt.isEmpty()) {
            return;
        }

        User user = userOpt.get();
        tokenEmailService.CriarToken(user);
    }

    @Override
    public void resetPassword(ResetPasswordRequest request) {
        var tokenEmail = tokenEmailService.buscarTokenPorEmail(request.email());

        tokenEmailService.validarTokenEmail(tokenEmail, request.token(), request.email());

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        user.setPassword(passwordEncoder.encode(request.newPassword()));
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);

        tokenEmailService.apagarTokenEmail(tokenEmail);
    }

    @Override
    public void verifyEmail(String tokenDigitado, String email) {
        var tokenEmail = tokenEmailService.buscarTokenPorEmail(email);

        tokenEmailService.validarTokenEmail(tokenEmail, tokenDigitado, email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        if (user.getActive() == true) {
            return;
        }

        user.setActive(true);
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);

        tokenEmailService.apagarTokenEmail(tokenEmail);
    }

    @Override
    public UserResponse onboarding(OnboardingRequest request, String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        if (request.displayName() == null || request.displayName().length() < 3) {
            throw new BusinessException("O nome de exibição deve ter pelo menos 3 caracteres.");
        }

        user.setDisplayName(request.displayName());
        user.setAvatarUrl(request.avatarUrl());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        return userMapper.toUserResponse(user);
    }
}