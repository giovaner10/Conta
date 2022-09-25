package br.com.banco.excption;

public class ValorNegativoExcption extends RuntimeException{

    public ValorNegativoExcption(String message) {
        super(message);
    }
}
