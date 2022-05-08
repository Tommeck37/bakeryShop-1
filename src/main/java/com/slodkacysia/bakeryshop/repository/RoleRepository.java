package com.slodkacysia.bakeryshop.repository;

import com.slodkacysia.bakeryshop.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);

    Role save(Role role);
}