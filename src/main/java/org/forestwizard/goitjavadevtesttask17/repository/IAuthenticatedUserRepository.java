package org.forestwizard.goitjavadevtesttask17.repository;

import org.forestwizard.goitjavadevtesttask17.data.AuthenticatedUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAuthenticatedUserRepository extends JpaRepository<AuthenticatedUser, Long> {
    Optional<AuthenticatedUser> findByUsername(String username);
}
