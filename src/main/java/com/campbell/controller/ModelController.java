package com.campbell.controller;

import com.campbell.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Campbell
 * @date 2021/12/4
 */
@Controller
public class ModelController {

    @RequestMapping("/model")
    public ModelAndView test() {
        ModelAndView mv = new ModelAndView("model");
        mv.addObject("person", new Person("zhangsan", 10, 1));
        return mv;
    }
}
