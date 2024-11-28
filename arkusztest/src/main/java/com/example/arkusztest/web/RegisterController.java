package com.example.arkusztest.web;

import com.example.arkusztest.users.User;
import com.example.arkusztest.users.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping
public class RegisterController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String register(Model model)
    {
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/")
    public String processRegister(@Valid User user, Errors error, SessionStatus sessionStatus)
    {
        if(error.hasErrors())
        {
            return "register";
        }
        userService.registerUser(user);
        sessionStatus.setComplete();
        return "redirect:/summary";
    }

}
