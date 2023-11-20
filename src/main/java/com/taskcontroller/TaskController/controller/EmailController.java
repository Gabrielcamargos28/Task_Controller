package com.taskcontroller.TaskController.controller;

import com.taskcontroller.TaskController.domain.email.DadosEnviarEmail;
import com.taskcontroller.TaskController.domain.email.Email;
import com.taskcontroller.TaskController.service.EmailService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SecurityRequirement(name = "BearerToken")
@RestController
@RequestMapping("email")
public class EmailController {

    @Autowired
    EmailService emailService;

    /*@PostMapping("/enviar-email")
    public ResponseEntity<Email> sendingEmail(DadosEnviarEmail dados) throws MessagingException {
        Email email = new Email();
        BeanUtils.copyProperties(dados,email);
        System.out.println(dados);
        emailService.sendEmail(email,dados.files());
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }*/
    @PostMapping("/enviar-email")
    public ResponseEntity<Email> sendingEmail(@RequestBody DadosEnviarEmail dados) throws MessagingException {
        Email email = new Email();
        BeanUtils.copyProperties(dados,email);
        System.out.println(dados);
        emailService.sendEmail(email,dados.files());
        return new ResponseEntity<>(email, HttpStatus.CREATED);
}
}
