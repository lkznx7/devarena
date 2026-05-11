package com.devarena.modules.email.controller;

import com.devarena.modules.auth.entity.User;
import com.devarena.modules.email.dto.Email;
import com.devarena.modules.email.dto.TokenValidationDTO;
import com.devarena.modules.email.entity.TokenEmail;
import com.devarena.modules.email.service.EmailService;
import com.devarena.modules.email.service.TokenEmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/test")
    public ResponseEntity<String> sendTestEmail(@RequestParam String to) {
        Email email = new Email(
                to,
                "DevArena - Teste de E-mail",
                "Olá!\n\nEste é um e-mail de teste do DevArena.\n\nSe você recebeu, a configuração está funcionando!"
        );
        emailService.sendEmail(email);
        return ResponseEntity.ok("E-mail enviado para: " + to);
    }
}