package com.ajes.controller;

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

@RestController
@RequestMapping("/ajes")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {


    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtility;

    @GetMapping("/home/")
    public String getUserService(String userService) {
        return "getUserService";

    }

    @PostMapping("/logging1")
    public ResponseEntity<?> logIn(@RequestBody() AuthenticationRequest authenticationRequest) {
        System.out.println("login");
        System.out.println(authenticationRequest + "...............");
        try {
            System.out.println("login try block");
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUserName(), authenticationRequest.getPassword());
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        } catch (BadCredentialsException e) {

            System.out.println("login catch block ");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid");

        }

        UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUserName());

        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        String jwtToken = jwtUtility.generateJwtToken(userDetails);
        authenticationResponse.setJwtToken(jwtToken);
        System.out.println("login try block2");
        return ResponseEntity.ok(authenticationResponse);
    }
}