package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.HolaMundoController;

@SpringBootTest
class PruebaApplicationTests {
	
	@Autowired
	private HolaMundoController holaMundoController;

	@Test
	void contextLoads() {
		String name = "pepito";
		String response = holaMundoController.Hola(name);
		assertEquals("Hola2 pepito", response);
	}

}
