package com.ajes.service;

import com.ajes.model.Role;
import com.ajes.model.User;
import com.ajes.repository.UserRepository;
import com.ajes.security.UserServiceSecurityInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceSecurityInterface {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleService roleService;

    public User addUser(User user){
    	if(user.getRole().isEmpty()) {
    		Role role = new Role();
    		role = roleService.getRoleById(1);
    		Collection<Role> list = new ArrayList<Role>();
    		list.add(role);
    		user.setRole(list);
    		return userRepository.save(user);
    	}
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(Integer userId){
        return userRepository.findById(userId).get();
    }

    public User deleteUserById(Integer userId){
        User user = getUserById(userId);
        userRepository.deleteById(userId);
        return user;
    }

    public User updateUserById(Integer userId, User user){
        user.setUserId(userId);
        return userRepository.save(user);
    }

    public User getUserByUserName(String userName){
   User user=userRepository.findUserByUserName(userName).get();
   return user;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        System.out.println("User service loadUserByUsername....6");
        System.out.println(username);
        Optional<User> userOpt = userRepository.findUserByUserName(username);
        System.out.println(userOpt.toString());
        System.out.println("loadUserByUsername....7");
        User user = userOpt.get();
        System.out.println(userOpt.get()+".....");
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassWord(),user.getRole());
        System.out.println("........loadUserByUsername....8");
        return userDetails;
    }

}
