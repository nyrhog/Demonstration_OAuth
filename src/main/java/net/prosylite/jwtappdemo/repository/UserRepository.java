package net.prosylite.jwtappdemo.repository;

import net.prosylite.jwtappdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String name);


}
