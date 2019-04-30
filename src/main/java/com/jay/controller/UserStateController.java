package com.jay.controller;
import com.jay.entities.UserState;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import com.jay.service.UserStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 控制层
 *
 * @author YanZhen
 * @since 2019-02-22 11:09
 */
@Controller
@RequestMapping("/user-state")
public class UserStateController {
    @Autowired
    private UserStateService userStateService;

    @GetMapping("/page1")
    public ModelAndView page1(@RequestParam("m1") String m1, String m2) {
        ModelAndView modelAndView = new ModelAndView("page1");
        List<UserState> userStates = userStateService.find();
        modelAndView.addObject("userStates", userStates);
        return modelAndView;
    }
}
