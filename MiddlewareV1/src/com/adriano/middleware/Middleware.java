package com.adriano.middleware;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Middleware implements IMiddleware {
	int port, nr;
	String host;

	public Middleware() {
		this.port = 1500;
		this.host = "LocalHost";
		this.nr = 0;
	}

	private void sendTCP(String msg) throws UnknownHostException, IOException,
			Throwable {
		
		//Transpar�ncia de localiza��o
		Socket clientSocket = null;
		clientSocket = new Socket(host, port + nr % 10);
		nr++;
		DataOutputStream outToServer;
		outToServer = new DataOutputStream(clientSocket.getOutputStream());
		outToServer.writeBytes(msg);
		clientSocket.close();
	}

	private Message receiveTCP() throws IOException, Throwable {
		String msg = "";
		
		//Transpar�ncia de localiza��o
		ServerSocket welcomeSocket = new ServerSocket(port + nr % 10);
		nr++;
		Socket connectionSocket = welcomeSocket.accept();
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(
				connectionSocket.getInputStream()));
		msg = inFromClient.readLine();
		welcomeSocket.close();
		connectionSocket.close();
		Message m = new Message(msg);
		return m;
	}

	@Override
	public void send(String msg) {
		//Transpar�ncia de falhas est� sendo implementada?
		try {
			//Transpar�ncia de protocolo de comunica��o
			sendTCP(msg);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String receive() {
		//Transpar�ncia de falhas est� sendo implementada?
		try {
			//Transpar�ncia de protocolo de comunica��o
			return receiveTCP().toString();
		} catch ( Throwable e) {
			e.printStackTrace();
		}
		return null;
	}
}
