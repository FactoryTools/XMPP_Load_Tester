package com.testtools.utils;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import com.testtools.vo.ClientVariables;

public class DefaultHandlerImpl extends DefaultHandler 
{
	private ClientVariables clientVariables=null;
	
	public DefaultHandlerImpl(ClientVariables clientVariables)
	{
		this.clientVariables=clientVariables;
	}
	public void startElement(String uri, String localName,String nodeName, Attributes attributes) throws SAXException
	{
		try
		{
			if(nodeName.equalsIgnoreCase(clientVariables.BODY))
			{
				clientVariables.setSid(attributes.getValue(clientVariables.SID));
			}
			if(nodeName.equalsIgnoreCase(clientVariables.SESSION))
			{
				clientVariables.setSessionId(attributes.getValue(clientVariables.ID));
			}
			if(nodeName.equalsIgnoreCase(clientVariables.INVITE))
			{
				clientVariables.setInviteReceived(true);
			}
			if(nodeName.equalsIgnoreCase(clientVariables.SERVICE_UNAVILABLE))
			{
				clientVariables.setServiceUnavailble(true);
			}
			//if invalid Sid then throw an exception
//			if(nodeName.equalsIgnoreCase(nodeName))
//			{
//				//throw exception;
//			}
		}
		catch(Exception e)
		{
			System.out.println("Error in default handler impl");
		}
	}
}
