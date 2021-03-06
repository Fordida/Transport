package com.gmail.dengtao.joe.transport;

import org.junit.Test;

import com.gmail.dengtao.joe.transport.demo.handler.DemoClientHandler;

public class SocketConnectorTest {
	
	private String host = "127.0.0.1";
	private int port = 7000;

	@Test
	public void test() throws Exception {
		SocketConnector connector = new SocketConnector();
		
		// sometimes, you should init before...
		connector.init();
		
		// Custom setting...
		connector.setSelectTimeout(10000);
		connector.setReceiveBufferSize(1024);
		connector.setSendBufferSize(1024);
		
		// Inject the biz handler.
		connector.setHandler(new DemoClientHandler());

		// Open connection to host:port
		// Thread will be blocked in here.
		connector.open(host, port);
	}

}
