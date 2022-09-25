package br.com.banco;

import br.com.banco.excption.ValorNegativoExcption;

public abstract class Conta {

    private int numeroConta;
    private String titulaConta;
    private int agenciaConta;
    private double saldoConta;



    public Conta(int numeroConta, String titulaConta, double saldoConta) {
        this.numeroConta = numeroConta;
        this.titulaConta = titulaConta;
        this.saldoConta = saldoConta;
        this.agenciaConta = 1234;
    }

    public Conta(int numeroConta, String titulaConta, double saldoConta, int agenciaConta) {
        this.numeroConta = numeroConta;
        this.titulaConta = titulaConta;
        this.saldoConta = saldoConta;
        this.agenciaConta = agenciaConta;
    }

    public double sacar(double totalSaque){

        if(totalSaque > this.saldoConta || totalSaque < 0){
            throw new ValorNegativoExcption("Verifique sua solicitacao de saque e tente novamente");
        }

        this.saldoConta -= totalSaque;

        return totalSaque;
    }


    public double depositar(double totalDeposito){
        if(totalDeposito < 0){
            throw new ValorNegativoExcption("Voce esta tentando depositar um valor negativo, tente novamente");
        }
        this.saldoConta += totalDeposito;

        return totalDeposito;
    }


    public void verSaldo(){
        System.out.println("Titular: " + this.titulaConta + " - Saldo: " + this.saldoConta);
    }

    public double transferir(double valorQTransferi, Conta contaQueVaiReceber){

        if(valorQTransferi > this.saldoConta){
            throw new ValorNegativoExcption("Voce esta tentando transferir um valor maior que o seu saldo");
        }

        double saldoAnterior = contaQueVaiReceber.getSaldoConta();

        contaQueVaiReceber.setSaldoConta(valorQTransferi + saldoAnterior);

        this.saldoConta -= valorQTransferi;

        return saldoConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }
}
