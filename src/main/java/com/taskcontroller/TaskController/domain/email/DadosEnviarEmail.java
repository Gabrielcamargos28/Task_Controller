package com.taskcontroller.TaskController.domain.email;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

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
        StatusEmail statusEmail
) {
}
