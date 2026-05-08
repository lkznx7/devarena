package com.devarena.modules.challenge.repository;

import com.devarena.modules.challenge.entity.ChallengeTestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeTestCaseRepository extends JpaRepository<ChallengeTestCase, Long> {
}