package com.devarena.modules.email.controller;

import com.devarena.modules.auth.entity.User;
import com.devarena.modules.email.dto.TokenValidationDTO;
import com.devarena.modules.email.entity.TokenEmail;
import com.devarena.modules.email.service.EmailService;
import com.devarena.modules.email.service.TokenEmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {

    private final EmailService emailService;
    private final TokenEmailService tokenService;

    public EmailController(EmailService emailService, TokenEmailService tokenService) {
        this.emailService = emailService;
        this.tokenService = tokenService;
    }

    @PostMapping("/confirmacao")
    public ResponseEntity<TokenEmail> gerar(@RequestBody User user) {
        // Agora passamos o user para o service saber de quem é o e-mail
        TokenEmail novoToken = tokenService.CriarToken(user);
        return ResponseEntity.ok(novoToken);
    }

    @PostMapping("/validar")
    public ResponseEntity<String> validar(@RequestBody TokenValidationDTO dto) {
        try {
            TokenEmail tokenNoBanco = tokenService.buscarTokenPorEmail(dto.email());

            boolean isValido = tokenService.validarTokenEmail(tokenNoBanco, dto.tokenDigitado(), dto.email());

            if (isValido) {
                tokenService.apagarTokenEmail(tokenNoBanco);
                return ResponseEntity.ok("Token validado com sucesso! Acesso liberado.");
            }

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido.");

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}