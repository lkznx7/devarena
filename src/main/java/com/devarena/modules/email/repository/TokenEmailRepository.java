package com.devarena.modules.email.repository;

import com.devarena.modules.email.entity.TokenEmail;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalTime;
import java.util.Optional;

public interface TokenEmailRepository extends JpaRepository<TokenEmail, Integer> {
    Optional<TokenEmail> findByTokenAndEmail(String token, String email);

    @Modifying
    @Transactional
    @Query("DELETE FROM TokenEmail t WHERE t.expireAt < :agora")
    void deleteByExpireAtBefore(LocalTime agora);

    Optional<TokenEmail> findByEmail(String email);

}
