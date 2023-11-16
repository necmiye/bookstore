package com.bookstore.bookstore.repositories;

import com.bookstore.bookstore.entities.Role;
import com.bookstore.bookstore.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
