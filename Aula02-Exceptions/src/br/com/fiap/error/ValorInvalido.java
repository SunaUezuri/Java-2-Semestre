package br.com.fiap.error;

public class ValorInvalido extends Exception{

    public ValorInvalido(String mensagem){super(mensagem);}

    public ValorInvalido(){super("Valor inválido!!! Precisa ser maior do que zero");}

    public ValorInvalido(double valor){super("Saldo inxuficiente, valor disponível: " + valor);}
}
