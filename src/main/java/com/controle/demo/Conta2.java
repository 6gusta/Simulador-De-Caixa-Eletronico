package com.controle.demo;

public class Conta2 extends Numerodaconta {


    @Override
    public String getTipodeconta() {
        return tipodeconta;
    }
    @Override
    public void setTipodeconta(String tipodeconta) {
        this.tipodeconta = tipodeconta;
    }

    @Override
    public String getSenha(){
        return senha;
    }

    
  
    public void setSenha(String senha){
        this.senha=senha;
    }

    @Override
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    @Override
    public void bancocaixa(){
        System.out.println(" VOCE ESTA NO BANCO ITAU ");
    }


    
}

