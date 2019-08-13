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
public class UserController {
    @Autowired
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> GetAllUser(){
        return userRepository.findAll();
    }

    public User GetUserById(Long id){
        return userRepository.getOne(id);
    }

    public List<User> GetUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

   public void AddNewUser(@RequestBody User user)
   {
       userRepository.save(user);
   }

   public void DeleteUser(@RequestBody Long id){
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) return;
        userRepository.deleteById(id);
   }

   public void EditUser(@RequestBody User user)
   {
       userRepository.save(user);
   }

   public List<User> SearchUser(String username){
        List<User> list = userRepository.findByNameContains(username);
        return list;
   }

   public boolean Transfer(Long id1, Long id2, Long balance){
        if(balance < 0) return false;

        Optional<User> user1 = userRepository.findById(id1);
        Optional<User> user2 = userRepository.findById(id2);

        if(!user1.isPresent() || !user2.isPresent()) return false;
        Long BalanceUser1 = user1.get().getBalance();
        Long BalanceUser2 = user2.get().getBalance();

        if(BalanceUser1 < balance) return false;

        user1.get().setBalance(BalanceUser1 - balance);
        user2.get().setBalance(BalanceUser2 + balance);
        userRepository.save(user1.get());
        userRepository.save(user2.get());
        return true;

   }

   public User CheckLogin(String email, String password){
        List<User> list = userRepository.findByEmail(email);
        for(User user : list){
            if(user.getPassword().equals(password)) return user;
        }
        return null;
   }
}
