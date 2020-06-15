package net.prosylite.jwtappdemo.repository;

import net.prosylite.jwtappdemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}
