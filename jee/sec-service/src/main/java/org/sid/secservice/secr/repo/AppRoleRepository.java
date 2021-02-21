package org.sid.secservice.secr.repo;

import org.sid.secservice.secr.entities.AppRole;
import org.sid.secservice.secr.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
