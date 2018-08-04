package controller;

import entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.impl.UserService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public ResponseEntity<?> getAllUsers() {
        List<User> users = userService.getUsers();
        if (users == null) {
            log.error("Users not found, data: " + new Timestamp(new Date().getTime()) + "User's list : " + users.toString());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else
            log.info("Users founded: " + new Timestamp(new Date().getTime()) + "User's list : " + users.toString());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<?> getOne(String login) {
        User user = userService.getUser(login);                 //проверка на null?
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @RequestMapping()
//    public  ResponseEntity<?> saveUser(User user){
//        User savedUser = userService.addUser(user);
//        return ;
//    }

}