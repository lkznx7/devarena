package com.devarena.modules.pvp.repository;

import com.devarena.modules.pvp.entity.PvpMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PvpMatchRepository extends JpaRepository<PvpMatch, Long> {
}