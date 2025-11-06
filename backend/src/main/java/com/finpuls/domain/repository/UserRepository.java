package com.finplus.domain.repository;

import com.finplus.domain.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByClientId(String clientId);
    boolean existsByClientId(String clientId);
}