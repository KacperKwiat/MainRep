package com.example.movies.controller;

import com.example.movies.dto.UserDto;
import com.example.movies.model.User;
import com.example.movies.repository.UserRepository;
import com.example.movies.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin("http://loclahost:3000")
@RequestMapping("/movies")
public class UserController {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    UserService userService;


    @GetMapping("/cachable/test/users")
    public ResponseEntity<List<UserDto>> testFindAll(){
        log.info("UserController: FindALL");
        List<UserDto>usersAll=userService.findAll();
        return new ResponseEntity<>(usersAll, HttpStatus.OK);
    }

    @GetMapping( "/cachable/{id}/user")
    public ResponseEntity<UserDto> getMovie(@PathVariable Long id) {
        log.info("UserController: getById");
        UserDto user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping( "/cachable/add/user")
    public ResponseEntity<Long> createOrUpdate(@RequestBody UserDto userDto) {
        log.info("UserController: createOrUpdateUser");
        var user = userService.saveOrUpdate(userDto);
        return new ResponseEntity<>((long)user, HttpStatus.OK);
    }
    @GetMapping("/usersAll")
    public List<User>getAll(){
        return userRepository.getAll();
    }
    
    @GetMapping("/users/{id}")
    public User getById(@PathVariable("id")Long id){
        return userRepository.getById(id);
    }
    
    @PostMapping("/newUser")
    public int adduser(@RequestBody User User){
        return userRepository.save(User);
    }
    
    @PutMapping("editUser/{id}")
    public int updateuser(@PathVariable("id") Long id, @RequestBody User user){
        return userRepository.update(id, user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public int deletuser(@PathVariable("id") Long id){
        return userRepository.delete(id);
    }
}
