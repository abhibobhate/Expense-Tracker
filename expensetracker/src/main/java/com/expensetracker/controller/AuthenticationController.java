package com.expensetracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String user, @RequestParam String password) {
        return new ResponseEntity<>("Login Successfully", HttpStatus.OK);
    }
}
