package com.devarena.modules.user.repository;

import com.devarena.modules.auth.entity.User;
import com.devarena.modules.user.entity.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserStatsRepository extends JpaRepository<UserStats, Long> {
    Optional<UserStats> findByUser(User user);
}
