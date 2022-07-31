package com.softinsa.springmvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  @Controller -> use String to get jsp file or html file by name, for example if returns
 *                "main menu" then spring boot will catch a file with same name ("main-menu.jsp")
 *
 * @RestController -> marks as class component which only serves as rest api (GET, POST, PUT, etc....)
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showMyPage() {
        return "main-menu";
    }
}
