package com.example.users.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/register")
    public AppUser createNewUser(@RequestBody AppUser user) {
        userService.save(user);
        return user;
    }

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest) {

        // step 1 : Authentification
        Authentication authentication =  authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // step 2 : loadUserByUsername
        UserDetails userDetails = userService.loadUserByUsername(loginRequest.getUsername());

        // step 3 : generate token

        String token = jwtUtils.generateToken(userDetails);
        JwtResponse jwtResponse = new JwtResponse(token);

        return jwtResponse;

    }

}
