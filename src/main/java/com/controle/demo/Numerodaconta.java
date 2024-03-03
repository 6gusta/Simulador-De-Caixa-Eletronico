package com.controle.demo;
public abstract class Numerodaconta {

    private int numcartao;
    protected String nome;
    protected int valor;
    protected String senha;
    protected   String tipodeconta;
    protected String pouc;
    





    public String getPouc() {
        return pouc;
    }

    public void setPouc(String pouc) {
        this.pouc = pouc;
    }

    public String getTipodeconta() {
        return tipodeconta;
    }

    public void setTipodeconta(String tipodeconta) {
        this.tipodeconta = tipodeconta;
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public int getnumcartao() {
        return numcartao;
    }

    public void setnumcartao(int numcartao) {
        this.numcartao = numcartao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getSenha() {
        return senha;
    }

    
}

