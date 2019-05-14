package com.mybolg.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin/index")
public class IndexController {

    @GetMapping(value = "")
    public String login() {
        return "admin/index";
    }
}
