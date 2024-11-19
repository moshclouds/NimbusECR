package com.learn.ecr.nimbus_ecr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class Api {
    @GetMapping("")
    public Object getServerStatus() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "server online");
        return ResponseEntity.ok(response);
    }
}
