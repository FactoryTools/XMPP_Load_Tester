package com.testtools.utils;

import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.testtools.Exceptions.ServiceUnavailableException;
import com.testtools.vo.ClientVariables;


public class PacketParser {
	
	private ClientVariables clientVariables=null;
	private ServiceUnavailableException serviceUnavailableException=new ServiceUnavailableException("Service unavailable Exception");
	
	public PacketParser(ClientVariables clientVariables)
	{
		this.clientVariables=clientVariables;
	}
	
	public String extractSid(String response) throws ServiceUnavailableException
	{
		packetFilter(response);
		if(clientVariables.isServiceUnavailble())
		{
			throw serviceUnavailableException;
		}
		return clientVariables.getSid();
	}
	public String extractSessionId(String response) throws ServiceUnavailableException
	{
		packetFilter(response);
		if(clientVariables.isServiceUnavailble())
		{
			throw serviceUnavailableException;
		}
		return clientVariables.getSessionId();
	}
	public boolean isInvite(String response) throws ServiceUnavailableException
	{
		packetFilter(response);
		if(clientVariables.isServiceUnavailble())
		{
			throw serviceUnavailableException;
		}
		return clientVariables.isInviteReceived();
	}
	
	
	
	private void packetFilter(String packet)
	{
		try
		{
			SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
			saxParserFactory.setNamespaceAware(true);
			SAXParser saxParser =saxParserFactory.newSAXParser();
			DefaultHandler handler=new DefaultHandlerImpl(clientVariables);
			saxParser.parse(new InputSource(new StringReader(packet)), handler);		
		}
		catch(Exception e)
		{
			System.out.println("Error while converting the response to XML.");
			e.printStackTrace();
		}
	}
	

}
