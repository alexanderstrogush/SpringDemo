package com.alexstrog.controller;

import com.alexstrog.model.User;
import com.alexstrog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute User user, ModelAndView modelAndView) {
        userService.add(user);
        List<User> users = userService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("users", users);
        modelAndView.setViewName("users");
        return modelAndView;
    }

    public ModelAndView get(@RequestParam("u_id") Long id, ModelAndView modelAndView) {
        modelAndView.addObject("user", userService.getById(id).get());
        modelAndView.setViewName("user");
        return modelAndView;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<User> users = userService.getAll().orElseGet(Collections::emptyList);
        modelAndView.addObject("users", users);
        modelAndView.setViewName("users");
        return modelAndView;
    }
}
