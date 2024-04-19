package com.ajes.controller;

import com.ajes.model.Login;
import com.ajes.security.AuthenticationRequest;
import com.ajes.security.AuthenticationResponse;
import com.ajes.service.LoginService;
import com.ajes.service.UserService;
import com.ajes.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
//@RequestMapping("/ajes")
//@CrossOrigin("https://project-client-kappa.vercel.app/")
public class LoginController {

//    @Autowired
//    private LoginService loginService;


//    @PostMapping("/login")
//    public Login addLogin(@RequestBody() Login login){
//        return loginService.addLogin(login);
//    }

//    @GetMapping("/login/")
//    public List<Login> getAllLogin(){
//        return loginService.getAllLogin();
//    }
//
//    @GetMapping("/login/{loginId}")
//    public Login getById(@PathVariable() Integer loginId){
//        return loginService.getLoginById(loginId);
//    }
//
//    @DeleteMapping("/login/{loginId}")
//    public Login deleteById(@PathVariable() Integer loginId){
//        return loginService.deleteLoginById(loginId);
//    }
//
//    @PutMapping("/login/{loginId}")
//    public Login updateById(@RequestBody() Login login,@PathVariable() Integer loginId){
//        return loginService.updateLoginId(loginId,login);
//    }

}
