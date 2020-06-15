package net.prosylite.jwtappdemo.security.jwt;

import net.prosylite.jwtappdemo.model.Role;
import net.prosylite.jwtappdemo.model.Status;
import net.prosylite.jwtappdemo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }
    public static JwtUser create( User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getEmail(),
                user.getStatus().equals(Status.ACTIVE),
                user.getUpdated(),
                mapToGrantedAuthorities(user.getRoles())
        );
    }
        private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles){
        return userRoles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }
}
