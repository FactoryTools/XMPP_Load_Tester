package com.testtools.utils;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import com.testtools.vo.ConfigProperties;


public class LoadConfig {
	private final String configPath="";
	private final String configFileName="config.xml";
	
	//Load the data from config file
	public void loadConfigXMLData()
	{
		try
		{
			File configFile=new File("..\\JavaJettyClient\\resources\\config\\config.xml");
			DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder= dbFactory.newDocumentBuilder();
			Document doc=docBuilder.parse(configFile);
			
			doc.getDocumentElement().normalize();
			
			NodeList nodeList=doc.getElementsByTagName("server");
			for(int dataLength=0; dataLength<nodeList.getLength(); dataLength++)
			{
				Node node=nodeList.item(dataLength);
				Element element=(Element)node;
				System.out.println(element.getElementsByTagName("host").item(0).getTextContent());
				
				ConfigProperties.setServerName(element.getElementsByTagName("host").item(0).getTextContent());
				System.out.println(element.getElementsByTagName("port").item(0).getTextContent());
				ConfigProperties.setPort(Integer.parseInt(element.getElementsByTagName("port").item(0).getTextContent()));
				System.out.println(element.getElementsByTagName("bindservlet").item(0).getTextContent());
				ConfigProperties.setBindservlet(element.getElementsByTagName("bindservlet").item(0).getTextContent());

			}
			
			nodeList=doc.getElementsByTagName("client");
			for(int dataLength=0; dataLength<nodeList.getLength(); dataLength++)
			{
				Node node=nodeList.item(dataLength);
				Element element=(Element)node;
				System.out.println(element.getElementsByTagName("login").item(0).getTextContent());
				ConfigProperties.setUsername(element.getElementsByTagName("login").item(0).getTextContent());
				
				System.out.println(element.getElementsByTagName("password").item(0).getTextContent());
				ConfigProperties.setPassword(element.getElementsByTagName("password").item(0).getTextContent());
				
				System.out.println(element.getElementsByTagName("overactivitydelay").item(0).getTextContent());
				ConfigProperties.setOveractivityDelay(Integer.parseInt(element.getElementsByTagName("overactivitydelay").item(0).getTextContent()));
				
				System.out.println(element.getElementsByTagName("chatduration").item(0).getTextContent());
				ConfigProperties.setChatDuration(Integer.parseInt(element.getElementsByTagName("chatduration").item(0).getTextContent()));
				
				System.out.println(element.getElementsByTagName("chatsperuser").item(0).getTextContent());
				ConfigProperties.setChatsPerUser(Integer.parseInt(element.getElementsByTagName("chatsperuser").item(0).getTextContent()));
					
			}
			
			nodeList=doc.getElementsByTagName("load");
			for(int dataLength=0; dataLength<nodeList.getLength(); dataLength++)
			{
				Node node=nodeList.item(dataLength);
				Element element=(Element)node;
				
				System.out.println(element.getElementsByTagName("threads").item(0).getTextContent());
				ConfigProperties.setThreadCount(Integer.parseInt(element.getElementsByTagName("threads").item(0).getTextContent()));
				
				System.out.println(element.getElementsByTagName("delay").item(0).getTextContent());
				ConfigProperties.setDelay(Integer.parseInt(element.getElementsByTagName("delay").item(0).getTextContent()));
				
			}
			
		}
		catch(Exception e)
		{
			//Log exception here and do not start the tool
			System.out.println("Exception"+e);
		}
	}
}
