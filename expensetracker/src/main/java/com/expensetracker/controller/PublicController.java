package com.expensetracker.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    Logger log = LogManager.getLogger(PublicController.class);

    @GetMapping("/get")
    public String get() {
        log.info("log success");
        return "success";
    }
}
