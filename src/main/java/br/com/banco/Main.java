package br.com.banco;

import br.com.banco.excption.ValorNegativoExcption;

public class Main {

    public static void main(String[] args) {
        ContaCorrente minhaConta = new ContaCorrente(12, "java", 100, 121) ;


        minhaConta.verSaldo();
        minhaConta.verCredito();


        try{

            minhaConta.sacar(150);


        }catch (ValorNegativoExcption e){
            System.out.println(e.getMessage());
        }

        minhaConta.verSaldo();
        minhaConta.verCredito();



    }
}
