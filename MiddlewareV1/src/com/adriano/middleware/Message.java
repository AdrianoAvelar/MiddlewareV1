package com.adriano.middleware;

public class Message {

	private String msg;
	public Message(String msg){
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return this.msg;
	}
}
