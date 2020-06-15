package net.prosylite.jwtappdemo.controller;

import net.prosylite.jwtappdemo.dto.AdminUserDto;
import net.prosylite.jwtappdemo.model.User;
import net.prosylite.jwtappdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id){
        User user = userService.findById(id);
        if (user == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
