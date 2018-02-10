package com.smsaleservis.amclclient.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	protected SocketData socket_data;
	
	public void connect() throws NullPointerException, UnknownHostException, IOException {
		
		if (socket_data.isConnectionEstablished())
			throw new IOException("The connection is already established.");
		
		if (socket_data.getHostName() == null)
			throw new NullPointerException("The host name wasn't declared.");
		if (socket_data.getHostName() == null)
			throw new NullPointerException("The communication port wasn't declared.");
		
		socket_data.setSocket(new Socket(socket_data.getHostName(), socket_data.getCommunicationPort()));
		socket_data.setBufferedReader(new BufferedReader(new InputStreamReader(socket_data.getSocket().getInputStream())));
		socket_data.setBufferedWriter(new BufferedWriter(new OutputStreamWriter(socket_data.getSocket().getOutputStream())));
		
		if (socket_data.getSocket() == null || socket_data.getBufferedReader() == null || socket_data.getBufferedWriter() == null)
			throw new IOException("Failed to establish connection.");
		
		socket_data.setConnectionEstablished(true);
		
		socket_data.getSocket().setKeepAlive(true);
		
	}
	
	public SocketData getSocketData() {
		
		return socket_data;
	}
	
}
