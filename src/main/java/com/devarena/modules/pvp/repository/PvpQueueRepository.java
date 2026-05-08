package com.devarena.modules.pvp.repository;

import com.devarena.modules.pvp.entity.PvpQueue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PvpQueueRepository extends JpaRepository<PvpQueue, Long> {
}