package com.smsaleservis.amclclient.network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.Socket;

class SocketData {
	
	private String host_name;
	private int communication_port;
	
	Socket socket;
	BufferedReader buffered_reader;
	BufferedWriter buffered_writer;
	
	boolean connection_established = false;
	
	public SocketData() {
		
	}
	
	public SocketData(String host_name, int communication_port) {
		
		try {
			
			setHostName(host_name);
			setCommunication(communication_port);
			
		} catch(IOException e) {
			
			System.err.println(e.getMessage());
			
		}
		
	}
	
	public void setHostName(String host_name) throws IOException {
		
		if (isConnectionEstablished())
			throw new IOException("Couldn't change host name because the connection is established.");
		
		this.host_name = host_name;
		
	}
	
	public void setCommunication(int communication_port) throws IOException {
		
		if (isConnectionEstablished())
			throw new IOException("Couldn't change host name because the connection is established.");
		
		this.communication_port = communication_port;
		
	}
	
	void setSocket(Socket socket) {
		
		this.socket = socket;
		
	}
	
	void setBufferedReader(BufferedReader buffered_reader) {
		
		this.buffered_reader = buffered_reader;
		
	}
	
	void setBufferedWriter(BufferedWriter buffered_writer) {
		
		this.buffered_writer = buffered_writer;
		
	}
	
	void setConnectionEstablished(boolean connection_established) {
		
		this.connection_established = connection_established;
		
	}
	
	public String getHostName() {
		
		return host_name;
	}
	
	public int getCommunicationPort() {
		
		return communication_port;
	}
	
	Socket getSocket() {
		
		return socket;
	}
	
	BufferedReader getBufferedReader() {
		
		return buffered_reader;
	}
	
	BufferedWriter getBufferedWriter() {
		
		return buffered_writer;
	}
	
	boolean areCommunicationElementsOk() {
		
		if (getSocket() == null || getBufferedReader() == null || getBufferedWriter() == null)
			return false;
		
		return true;
	}
	
	public boolean isConnectionEstablished() {
		
		return connection_established;
	}
	
}
