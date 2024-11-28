package com.example.arkusztest.web;

import com.example.arkusztest.users.User;
import com.example.arkusztest.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/summary")
public class SummaryController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public String summary(Model model)
    {
        List<User> userList = (List<User>) userRepository.findAll();
        model.addAttribute("usersList",userList);
        return "summary";
    }
}
