package com.taskcontroller.TaskController.domain.email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public record DadosEnviarEmail(
        //@NotBlank
        String ownerRef,
        //@NotBlank
        //@jakarta.validation.constraints.Email
        String emailFrom,
        //@NotBlank
        //@Email
        String emailTo,
        //@NotBlank
        String subject,
        //@NotBlank
        String text,
        LocalDateTime sendDateEmail,
        StatusEmail statusEmail,
        MultipartFile[] files
) {
}
