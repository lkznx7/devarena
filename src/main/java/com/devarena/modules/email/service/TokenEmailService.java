package com.devarena.modules.email.service;

import com.devarena.modules.auth.entity.User;
import com.devarena.modules.email.entity.TokenEmail;
import com.devarena.modules.email.repository.TokenEmailRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Random;

@Service
public class TokenEmailService {

     final TokenEmailRepository tokenEmailRepository;

    public TokenEmailService(TokenEmailRepository tokenEmailRepository) {
        this.tokenEmailRepository = tokenEmailRepository;
    }

    public TokenEmail CriarToken(User user) {
        String[] array = {
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < 6; i++) {
            sb.append(array[rand.nextInt(array.length)]);
        }

        String tokengerado = sb.toString();

        TokenEmail tokenFinal = new TokenEmail(tokengerado, user.getEmail());

        return tokenEmailRepository.save(tokenFinal);
    }

    public boolean validarTokenEmail(TokenEmail tokenNoBanco, String tokenDigitado, String emailDigitado) {

        if (tokenDigitado.equals(tokenNoBanco.getToken()) &&
                emailDigitado.equals(tokenNoBanco.getEmail()) &&
                LocalTime.now().isBefore(tokenNoBanco.getExpireAt())) {
            return true;
        }

        if (!tokenDigitado.equals(tokenNoBanco.getToken())) {
            throw new RuntimeException("Token inválido.");
        }
        if (!emailDigitado.equals(tokenNoBanco.getEmail())) {
            throw new RuntimeException("Este token não pertence a este usuário.");
        }
        if (LocalTime.now().isAfter(tokenNoBanco.getExpireAt())) {
            throw new RuntimeException("O token expirou. Gere um novo.");
        }
        return false;
    }

    public void apagarTokenEmail(TokenEmail token) {
        tokenEmailRepository.delete(token);
    }

    public TokenEmail buscarTokenPorEmail(String email) {
        return tokenEmailRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Nenhum token encontrado para este e-mail."));
    }
}