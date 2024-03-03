package com.ex.classs;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClasssApplicationTests {

	@Test
	void testSoma() {
		int a = 5;
		int b = 3;
		int resultado = a + b;
		// Verifica se a soma de 'a' e 'b' é igual a 8
		assert resultado == 8 : "A soma de " + a + " e " + b + " deve ser igual a 8, mas foi " + resultado;
	}

}

