package com.uetcodecamp.jwb01.controller;

import com.uetcodecamp.jwb01.model.User;
import com.uetcodecamp.jwb01.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @RequestMapping("")
    public List<User> getAllUser(/*@RequestParam("name") String name*/){
        return userRepository.findAll();
      //  return userRepository.findByNameContains(name);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userRepository.getOne(id);
    }

    @PostMapping("")
    public User addNewUserById(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("")
    public User updateUserById(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            logger.error("User not found!!!");
            return;
        }

        userRepository.delete(user.get());
    }
    
}
