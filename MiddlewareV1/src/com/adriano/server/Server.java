package com.adriano.server;

import java.io.IOException;

import com.adriano.middleware.Middleware;

public class Server {
	
	public static void main(String[] args) throws IOException {
		Middleware m = new Middleware();
		System.out.println("Servidor inicializado...\n");
		while (true) {
			System.out.println("Servidor recebeu: "+m.receive());
		}
	}
}