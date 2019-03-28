package com.springboot.mybatises.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @GetMapping("/")
    public String home1() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String home() {
        return "/index";
    }

    @GetMapping("/user/index")
    public String admin() {
        return "user/index";
    }

    @GetMapping("/login")
    public String user() {
        return "login";
    }

    @GetMapping("/login-error")
    public String login(Model model) {
        model.addAttribute("loginError",true);
        return "login";
    }

    @GetMapping("/401")
    public String error401() {
        return "401";

    }
}
