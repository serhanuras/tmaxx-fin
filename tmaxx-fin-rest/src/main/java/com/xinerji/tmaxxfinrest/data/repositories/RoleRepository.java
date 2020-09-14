package com.xinerji.tmaxxfinrest.data.repositories;

import com.xinerji.tmaxxfinrest.data.model.Role;
import com.xinerji.tmaxxfinrest.data.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(RoleName roleName);
}
