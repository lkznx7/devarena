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
import com.devarena.security.jwt.JwtTokenProvider;
import com.devarena.shared.exceptions.BusinessException;
import com.devarena.shared.exceptions.ResourceNotFoundException;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
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
    private final EmailValidator emailValidator;

    public AuthServiceImpl(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            EmailValidator emailValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.emailValidator = emailValidator;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {

        String email = request.email();

         if (userRepository.findByEmail(email)!=null) {
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
        String TokenVerification = jwtTokenProvider.generateEmailVerificationToken(user.getId());
        System.out.println("Simulando envio de email para: " + user.getEmail());
        System.out.println("Token de verificação: " + TokenVerification);
        String accessToken = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().name());
        UserResponse userResponse = userMapper.toUserResponse(user);
        //cria metodo para verificar email ,mandando codigo no email
        return new AuthResponse(accessToken, userResponse);
    }
    @Override
    public AuthResponse login(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        if (user.getActive()==false){
            throw new BusinessException("E-mail não verificado. Verifique sua caixa de entrada.");
        }
        String token = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().name());
        //cria metodo para verificar email ,mandando codigo no email, se verificado mudar estado para active true
        return new AuthResponse(token, userMapper.toUserResponse(user)) ;
    }

    @Override
    public void forgotPassword(ForgotPasswordRequest request) {

        // 1. Buscar usuário pelo e-mail (userRepository.findByEmail)
        //    - Se não encontrar, OPTIONAL: não revelar se o e-mail existe por segurança
        //      (retornar silenciosamente sem erro)
        //
        // 2. Gerar token de recuperação:
        //    - String resetToken = jwtTokenProvider.generatePasswordResetToken(user.getId())
        //
        // 3. Salvar token de reset no usuário (campo temporário ou tabela separada)
        //    - user.setResetPasswordToken(resetToken)
        //    - user.setResetPasswordExpires(LocalDateTime.now().plusMinutes(15))
        //    - userRepository.save(user)
        //
        // 4. Simular envio de e-mail:
        //    - System.out.println("Simulando envio de email para: " + user.getEmail())
        //    - System.out.println("Token de recuperação: " + resetToken)
        //    - System.out.println("Link: /auth/reset-password?token=" + resetToken)

        System.out.println("Simulando envio de email para: " + request.email());
    }

    @Override
    public void resetPassword(ResetPasswordRequest request) {
        // TODO: PASSO A PASSO - Lógica de Negócio
        //
        // 1. Validar token:
        //    - Buscar usuário pelo reset token (userRepository.findByResetPasswordToken)
        //    - Se não encontrar, lançar BusinessException("Token inválido ou expirado")
        //
        // 2. Verificar expiração:
        //    - Se user.getResetPasswordExpires() < LocalDateTime.now()
        //      lançar BusinessException("Token expirado. Solicite novamente.")
        //
        // 3. Atualizar senha:
        //    - user.setPassword(passwordEncoder.encode(request.newPassword()))  // 1 única vez
        //    - Limpar tokens de reset (setResetPasswordToken(null), setResetPasswordExpires(null))
        //    - user.setUpdatedAt(LocalDateTime.now())
        //
        // 4. Salvar (userRepository.save)
        //
        // 5. Opcional: Invalidar todos os RefreshTokens existentes do usuário
        //    - refreshTokenRepository.deleteByUser(user)

        User user = null;
        user.setPassword(passwordEncoder.encode(request.newPassword()));
    }

    @Override
    public void verifyEmail(String token) {
        // TODO: PASSO A PASSO - Lógica de Negócio
        //
        // 1. Validar token JWT:
        //    - String userId = jwtTokenProvider.validateEmailVerificationToken(token)
        //    - Se token inválido/expirado, lançar exceção adequada
        //
        // 2. Buscar usuário pelo ID:
        //    - User user = userRepository.findById(UUID.fromString(userId))
        //    - Se não encontrar, lançar ResourceNotFoundException
        //
        // 3. Verificar se já está ativo:
        //    - Se user.getActive() == true, retornar (já verificado)
        //
        // 4. Ativar usuário:
        //    - user.setActive(true)
        //    - user.setUpdatedAt(LocalDateTime.now())
        //
        // 5. Salvar (userRepository.save)

        jwtTokenProvider.validateEmailVerificationToken(token);
    }

    @Override
    public UserResponse onboarding(OnboardingRequest request, String userEmail) {
        // 1. Busca o usuário que já está logado (identificado pelo e-mail do Token)
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        // 2. Validação simples de nome
        if (request.displayName() == null || request.displayName().length() < 3) {
            throw new BusinessException("O nome de exibição deve ter pelo menos 3 caracteres.");
        }

        // 3. "Dando vida" ao perfil
        user.setDisplayName(request.displayName());
        user.setAvatarUrl(request.avatarUrl());
        user.setUpdatedAt(LocalDateTime.now());

        // 4. Salva as mudanças
        userRepository.save(user);

        // 5. Converte para o DTO de resposta que o Frontend Next.js entende
        return userMapper.toUserResponse(user);
    }
}
