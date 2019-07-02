package com.example.hello.hello.controller;

import com.example.hello.hello.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenelController {


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;


    @GetMapping({"/", "/anasayfa"})
    public ModelAndView anasayfa(Model model) {
        ModelAndView modelAndView = new ModelAndView("anasayfa");
        return modelAndView;
    }



    @GetMapping({"/hakkinda"})
    public ModelAndView hakkinda(Model model) {
        ModelAndView modelAndView = new ModelAndView("hakkinda");
        return modelAndView;
    }
}
