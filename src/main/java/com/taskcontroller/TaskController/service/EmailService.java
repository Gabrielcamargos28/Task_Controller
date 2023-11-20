package com.taskcontroller.TaskController.service;

import com.taskcontroller.TaskController.domain.email.Email;
import com.taskcontroller.TaskController.domain.email.StatusEmail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public Email sendEmail(Email email, MultipartFile[] files)throws MailException, MessagingException {
        email.setSendDateEmail(LocalDateTime.now());
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try{
            message.setFrom("testeapiemailptc@gmail.com");
            helper.setTo(email.getEmailTo());
            helper.setSubject(email.getSubject());
            helper.setText(email.getText());
            for(int i =0 ; i > files.length; i++){
                helper.addAttachment(
                        files[i].getOriginalFilename(),
                        new ByteArrayResource(files[i].getBytes()));
            }
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
