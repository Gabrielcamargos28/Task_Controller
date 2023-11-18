package com.taskcontroller.TaskController.service;

import com.taskcontroller.TaskController.domain.email.Email;
import com.taskcontroller.TaskController.domain.email.StatusEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public Email sendEmail(Email email){
        email.setSendDateEmail(LocalDateTime.now());
        SimpleMailMessage message = new SimpleMailMessage();

        try{
            message.setFrom("testeapiemailptc@gmail.com");
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            javaMailSender.send(message);
            email.setStatusEmail(StatusEmail.SENT);
            log.info("Enviado com sucesso");
            return email;
        }catch (MailException e){
            email.setStatusEmail(StatusEmail.ERROR);
            throw new MailException("Erro") {
                @Override
                public Throwable getRootCause() {
                    return super.getRootCause();
                }
            };
        }
    }

}
