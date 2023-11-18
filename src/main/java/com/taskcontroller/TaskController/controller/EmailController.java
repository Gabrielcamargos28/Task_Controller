package com.taskcontroller.TaskController.controller;

import com.taskcontroller.TaskController.domain.email.DadosEnviarEmail;
import com.taskcontroller.TaskController.domain.email.Email;
import com.taskcontroller.TaskController.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/enviar-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody @Valid DadosEnviarEmail dados){
        Email email = new Email();
        BeanUtils.copyProperties(dados,email);
        System.out.println(dados);
        emailService.sendEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
