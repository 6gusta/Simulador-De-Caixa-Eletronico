package com.controle.demo;

public class Conta1 extends Numerodaconta {

    @Override
    public String getPouc(){
        return pouc;
    }
    
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
    public void saque(){
        System.out.println("valor sacado com sucesso ");
    }
}

