package com.devarena.modules.user.repository;

import com.devarena.modules.user.entity.XpTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XpTransactionRepository extends JpaRepository<XpTransaction, Long> {
}