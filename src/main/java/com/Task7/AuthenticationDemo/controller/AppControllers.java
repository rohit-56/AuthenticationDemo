package com.Task7.AuthenticationDemo.controller;

import com.Task7.AuthenticationDemo.Config.JwtUtils;
import com.Task7.AuthenticationDemo.models.AuthenticationRequest;
import com.Task7.AuthenticationDemo.models.AuthenticationResponse;
import com.Task7.AuthenticationDemo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppControllers {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/hello")
    public String getMsg(){
        return "Hello World !";
    }

    @PostMapping("/authenticate")
    public ResponseEntity createauthenticate(@RequestBody AuthenticationRequest authenticationRequest)throws Exception{
        System.out.println(authenticationRequest.getUsername()+" ehellllllllllllllllllllllllllllllllllllllllllll");
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        }
        catch (BadCredentialsException e){
            throw new Exception("Bad Credentials Exception",e);
        }
        UserDetails userDetails=myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        String token=jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

}
