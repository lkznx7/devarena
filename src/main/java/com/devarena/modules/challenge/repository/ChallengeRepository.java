package com.devarena.modules.challenge.repository;

import com.devarena.modules.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    Optional<Challenge> findBySlug(String slug);
}
