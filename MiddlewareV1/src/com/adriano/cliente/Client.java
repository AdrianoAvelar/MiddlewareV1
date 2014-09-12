package com.adriano.cliente;

import com.adriano.middleware.IMiddleware;
import com.adriano.middleware.Middleware;

public class Client{
	
	public static void main(String[] args) {
		IMiddleware m = new Middleware();
		System.out.println("Cliente enviou mensagem...\n");
		m.send("teste");
	}
}