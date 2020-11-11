package com.residwi.microservice.auth.repository;

import com.residwi.microservice.auth.entity.ERole;
import com.residwi.microservice.auth.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
