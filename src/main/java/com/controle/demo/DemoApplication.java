package com.controle.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		
    // Crie uma instância de MinhaConta, que estende Numerodaconta
    Conta1 c1 = new Conta1();
    c1.setnumcartao(44072853);
    c1.setnome("Gusta");
	c1.setValor(20000);
	c1.setSenha("0375");
    c1.setTipodeconta("CAIXA ");
    c1.setPouc("poupança ");
    
    


    // conta 2

    Conta2 a1= new Conta2();
    a1.setnumcartao(44028922);
    a1.setnome("cauã");
    a1.setValor(1000);
    a1.setSenha("0376");
    a1.setTipodeconta(" ITAU ");
    a1.setPouc(" corrente ");
    Caixaeletronico caixas = new Caixaeletronico();

    caixas.Caixaeletronic(a1);


    // Crie uma instância de Caixaeletronico
    Caixaeletronico caixa = new Caixaeletronico();

    // Chame o método Caixaeletronic() passando a instância de MinhaConta como argumento
    caixa.Caixaeletronic(c1);



	}
	

}
