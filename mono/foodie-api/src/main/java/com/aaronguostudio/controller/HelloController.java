package com.aaronguostudio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/hello")
    public Object hello () {
        logger.info("Hello");
        logger.debug("Hello");
        logger.warn("Hello");
        logger.error("Hello");
        return "Hello World";
    }

    @GetMapping("/setSession")
    public Object setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("userInfo", "new user");
        session.setMaxInactiveInterval(3600);
        session.getAttribute("userInfo");
//        session.removeAttribute("userInfo");
        return "ok";
    }
}
