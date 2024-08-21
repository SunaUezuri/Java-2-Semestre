package br.com.fiap.model.exception;

public class MesesInvalidosException extends Exception{

    public MesesInvalidosException(String mensagem){
        super(mensagem);
    }

    public MesesInvalidosException(){
        super("O mês deve ser entre 1 e 12!");
    }
}
