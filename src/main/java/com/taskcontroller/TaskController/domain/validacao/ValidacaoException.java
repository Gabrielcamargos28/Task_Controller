package com.taskcontroller.TaskController.domain.validacao;

public class ValidacaoException extends RuntimeException{
    public ValidacaoException(String mensagem){
        super(mensagem);
    }
}
