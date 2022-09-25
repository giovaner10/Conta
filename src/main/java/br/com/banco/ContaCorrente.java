package br.com.banco;

import br.com.banco.excption.ValorNegativoExcption;

public class ContaCorrente extends Conta {


    private double credito = VALOR_INICIAL_CREDITO;


    public static final double BONUS_DEPOSITO_ACIMA_MIL = 1.05;
    public static final double VALOR_INICIAL_CREDITO = 100;


    public ContaCorrente(int numeroConta, String titulaConta, double saldoConta, int agencia) {
        super(numeroConta, titulaConta, saldoConta, agencia);
    }


    @Override
    public double depositar(double totalDeposito) {


        if(totalDeposito < 0){
            throw new ValorNegativoExcption("Voce esta tentando depositar um valor negativo, tente novamente");
        }

        if(totalDeposito > 1000){
            totalDeposito = totalDeposito * BONUS_DEPOSITO_ACIMA_MIL;
        }
        return super.depositar(totalDeposito);
    }


    @Override
    public double sacar(double totalSaque) {

        if(this.getSaldoConta() + credito < totalSaque){
            throw new ValorNegativoExcption("O seu saldo + creditos sao insuficientes para o saque");
        }

        if(totalSaque > 10000){
            throw new ValorNegativoExcption("O valor que vc quer sacar eh muito alto, procure uma agencia fisica");
        }

        if(totalSaque > this.getSaldoConta()){
            this.credito +=  this.getSaldoConta() - totalSaque;
            this.setSaldoConta(0);
        }else {
            this.setSaldoConta(this.getSaldoConta() - totalSaque);

        }

        return this.getSaldoConta();
    }


    public void verCredito(){
        System.out.println(this.credito);
    }
}
