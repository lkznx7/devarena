package com.devarena.modules.auth.service;

import com.devarena.modules.auth.dto.request.ForgotPasswordRequest;
import com.devarena.modules.auth.dto.request.OnboardingRequest;
import com.devarena.modules.auth.dto.request.RegisterRequest;
import com.devarena.modules.auth.dto.request.ResetPasswordRequest;
import com.devarena.modules.auth.dto.response.AuthResponse;
import com.devarena.modules.auth.dto.response.UserResponse;
import com.devarena.modules.auth.entity.User;
import com.devarena.modules.auth.mapper.UserMapper;
import com.devarena.modules.auth.repository.UserRepository;
import com.devarena.security.jwt.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthServiceImpl(
            UserRepository userRepository,
            UserMapper userMapper,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        // TODO: PASSO A PASSO - Lógica de Negócio
        //
        // 1. Verificar se o e-mail já está cadastrado (userRepository.findByEmail)
        //    - Se existir, lançar BusinessException("E-mail já cadastrado")
        //
        // 2. Converter RegisterRequest → User via userMapper.toUser(request)
        //
        // 3. Definir valores padrão:
        //    - password = passwordEncoder.encode(request.password())  // 1 única vez
        //    - displayName = request.email().split("@")[0]  // default temporário
        //    - role = Roles.PLAYER
        //    - isActive = false  // email precisa ser verificado
        //    - level = 1
        //    - xp = 0
        //    - plan = "FREE"
        //    - createdAt / updatedAt = LocalDateTime.now()
        //
        // 4. Gerar token de verificação de e-mail:
        //    - String verificationToken = jwtTokenProvider.generateEmailVerificationToken(user.getId())
        //
        // 5. Salvar user no banco (userRepository.save)
        //
        // 6. Simular envio de e-mail:
        //    - System.out.println("Simulando envio de email para: " + user.getEmail())
        //    - System.out.println("Token de verificação: " + verificationToken)
        //
        // 7. Retornar AuthResponse com token JWT (opcional no registro) e userMapper.toUserResponse(user)
        //
        // DICA: Para o registro, você pode gerar um token shorter-lived específico para email verification,
        //       diferente do token de autenticação. O JwtTokenProvider pode ter um método separado.

        return null;
    }

    @Override
    public AuthResponse login(String email, String password) {
        // TODO: PASSO A PASSO - Lógica de Negócio
        //
        // 1. Usar authenticationManager.authenticate(
        //        new UsernamePasswordAuthenticationToken(email, password)
        //    )
        //    - Se falhar, AuthenticationException será tratada pelo handler de exceções
        //
        // 2. Obter o User autenticado do SecurityContext:
        //    - Authentication auth = SecurityContextHolder.getContext().getAuthentication()
        //    - User user = (User) auth.getPrincipal()
        //
        // 3. Verificar se o usuário está ativo (user.getActive()):
        //    - Se false, lançar BusinessException("E-mail não verificado. Verifique sua caixa de entrada.")
        //
        // 4. Gerar token JWT com base no user:
        //    - String token = jwtTokenProvider.generateToken(user.getEmail(), user.getRole().name())
        //
        // 5. Retornar new AuthResponse(token, userMapper.toUserResponse(user))

        return null;
    }

    @Override
    public void forgotPassword(ForgotPasswordRequest request) {
        // TODO: PASSO A PASSO - Lógica de Negócio
        //
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
        // TODO: PASSO A PASSO - Lógica de Negócio
        //
        // 1. Buscar usuário pelo e-mail (userRepository.findByEmail)
        //    - Se não encontrar, lançar ResourceNotFoundException
        //
        // 2. Validar dados do onboarding (opcional mas recomendado):
        //    - displayName: não vazio, entre 3-30 caracteres
        //    - Se inválido, lançar BusinessException("Display name inválido")
        //
        // 3. Atualizar dados do usuário:
        //    - user.setDisplayName(request.displayName())
        //    - user.setAvatarUrl(request.avatarUrl())  // pode ser null/vazio
        //    - user.setUpdatedAt(LocalDateTime.now())
        //
        // 4. Salvar (userRepository.save)
        //
        // 5. Retornar userMapper.toUserResponse(user)

        User user = userRepository.findByEmail(userEmail).orElse(null);
        return userMapper.toUserResponse(user);
    }
}
