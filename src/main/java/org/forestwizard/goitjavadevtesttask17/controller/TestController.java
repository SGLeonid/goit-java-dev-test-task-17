package org.forestwizard.goitjavadevtesttask17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class TestController {
    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView view = new ModelAndView("index");
        view.addObject("content", "Hello, World!");
        return view;
    }
}
