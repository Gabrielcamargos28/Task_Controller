package com.taskcontroller.TaskController.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class RedirecionamentoController {
    @GetMapping("/")
    public ModelAndView redirectToDocumentation() {
        return new ModelAndView("redirect:/swagger-ui.html");
    }
}
