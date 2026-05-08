package com.devarena.modules.challenge.repository;

import com.devarena.modules.challenge.entity.ChallengeHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeHintRepository extends JpaRepository<ChallengeHint, Long> {
}