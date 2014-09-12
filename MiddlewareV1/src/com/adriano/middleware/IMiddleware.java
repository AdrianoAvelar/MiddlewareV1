package com.adriano.middleware;

public interface IMiddleware {
	void send(String msg);
	String receive();
}
