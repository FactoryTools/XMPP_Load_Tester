import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;

import com.testtools.Exceptions.InvalidSidException;
import com.testtools.Exceptions.ServiceUnavailableException;
import com.testtools.utils.PacketParser;
import com.testtools.vo.ClientVariables;




public class ThreadCreater implements Runnable{
	
	private int req=0;
	private String wrapper="";
	
	public ThreadCreater(int req)
	{
		this.req=req;
	}
	
	public void run()
	{
		//int req=896318;
		String sid=null;
		String smeid="Sukesh";
		String response=null;
		String roomIdAliasSessionId=null;
		HttpClient httpClient=new HttpClient();
		//BoshConnector boshConnector=new BoshConnector(httpClient);
		BoshConnector boshConnector=new BoshConnector();
		Thread.currentThread().setName("Client1");
		ClientVariables clientVariables=new ClientVariables();
		PacketParser packetParser=new PacketParser(clientVariables);
		InvalidSidException invalidSidException = new InvalidSidException("Invalid Sid recieved from Server.");
		
		for(int i=0;i<1;i++)
		{
			try
			{
				
				String request="<body secure=\"false\" rid=\""+req+"\" ver=\"1.6\" xmlns=\"http://jabber.org/protocol/httpbind\" wait=\"10\" hold=\"2\" />";
				req++;
				System.out.println("request:"+request);
				//new ServerConnector().send("dataaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcccccccccccccccccccccccccccc");
				
				response=boshConnector.send(request);
				
				System.out.println("response:"+response);
				
				if(response!=null)
				{
					if(response.contains("<title>Error 404 Invalid SID.</title>"))
					{
						throw invalidSidException;
					}
					sid=packetParser.extractSid(response);
					if(sid!=null)
					{
						request="<auth mechanism=\"ANONYMOUS\" xmlns=\"urn:ietf:params:xml:ns:xmpp-sasl\" />";
						request=frameXmppPacket(request,sid,req);
						req++;
						System.out.println("request:"+request);
						response=boshConnector.send(request);
						System.out.println("response:"+response);
						if(response.contains("<title>Error 404 Invalid SID.</title>"))
						{
							throw invalidSidException;
						}
						
						request="<iq type=\"set\" id=\"iq_2\"><bind xmlns=\"urn:ietf:params:xml:ns:xmpp-bind\"><resource>Energy</resource></bind></iq>";
						request=frameXmppPacket(request,sid,req);
						req++;
						System.out.println("request:"+request);
						response=boshConnector.send(request);
						System.out.println("response:"+response);
						if(response.contains("<title>Error 404 Invalid SID.</title>"))
						{
							throw invalidSidException;
						}
						
						
						request="<iq type=\"set\" id=\"iq_5\"><session xmlns=\"urn:ietf:params:xml:ns:xmpp-session\" /></iq>";
						request=frameXmppPacket(request,sid,req);
						req++;
						System.out.println("request:"+request);
						response=boshConnector.send(request);
						System.out.println("response:"+response);
						if(response.contains("<title>Error 404 Invalid SID.</title>"))
						{
							throw invalidSidException;
						}
						
						request="<presence><status>Available</status><priority>5</priority></presence>";
						request=frameXmppPacket(request,sid,req);
						req++;
						System.out.println("request:"+request);
						response=boshConnector.send(request);
						System.out.println("response:"+response);
						if(response.contains("<title>Error 404 Invalid SID.</title>"))
						{
							throw invalidSidException;
						}
						
						
						request="<iq type=\"set\" id=\"bindRes_8\"><bind xmlns=\"urn:ietf:params:xml:ns:xmpp-bind\" /></iq>";
						request=frameXmppPacket(request,sid,req);
						req++;
						System.out.println("request:"+request);
						response=boshConnector.send(request);
						System.out.println("response:"+response);
						if(response.contains("<title>Error 404 Invalid SID.</title>"))
						{
							throw invalidSidException;
						}
						
						request="<iq type=\"set\" id=\"session_11\"><session xmlns=\"urn:ietf:params:xml:ns:xmpp-session\" /></iq>";
						request=frameXmppPacket(request,sid,req);
						req++;
						System.out.println("request:"+request);
						response=boshConnector.send(request);
						System.out.println("response:"+response);
						if(response.contains("<title>Error 404 Invalid SID.</title>"))
						{
							throw invalidSidException;
						}
						
						
						for(int joinReq=0;joinReq<1;joinReq++)
						{
						
							request="<iq type=\"set\" id=\"invitation_14\" to=\"smart_chat_helpdesk@workgroup.att.com\"><join-queue "
							+"xmlns=\"http://jabber.org/protocol/workgroup\"><queue-notifications /><x xmlns=\"jabber:x:data\" type=\"submit\">"
							+"<field type=\"text-single\" var=\"att_id\"><value>bs576h</value></field><field type=\"text-single\" var=\"username\">"
							+"<value>JAVA CLIENT</value></field><field type=\"text-single\" var=\"workgroup\"><value>smart_chat_helpdesk@workgroup.att.com</value>"
							+"</field><field type=\"text-single\" var=\"Problem_Category\"><value>Feedback</value></field>"
							+"<field type=\"text-single\" var=\"tn\"><value>zxcz</value></field><field type=\"text-single\" "
							+"var=\"att_id\"><value>bs576h</value></field>"
							+"<field type=\"text-single\" var=\"agentWorkGroup\"><value>smartchat_demo_agent</value></field><field type=\"text-single\" "
							+"var=\"ChatSource\"><value>Android</value></field></x></join-queue></iq>";
							request=frameXmppPacket(request,sid,req);
							req++;
							System.out.println("request:"+request);
							response=boshConnector.send(request);
							System.out.println("response:"+response);
							
							if(response!=null)
							{
								if(response.contains("<title>Error 404 Invalid SID.</title>"))
								{
									throw invalidSidException;
								}
								roomIdAliasSessionId=packetParser.extractSessionId(response);
							}
							
							//roomIdAliasSessionId=response.substring(response.indexOf("id=\"")+4,response.indexOf("workgroup=\"")-2 );
							//System.out.println(roomIdAliasSessionId);
						}
								
						//Wait for the SME to accept the chat when the room will send an invite to join
						boolean inviteReceived=false;
						while(!inviteReceived)
						{
							request=frameXmppPingPacket(sid,req);
							req++;
							System.out.println("request:"+request);
							response=boshConnector.send(request);
							System.out.println("response:"+response);
							
							if(response!=null)
							{
								if(response.contains("<title>Error 404 Invalid SID.</title>"))
								{
									throw invalidSidException;
								}
							
								inviteReceived=packetParser.isInvite(response);
									
							}
						}
						
						//Join the room
						request="<presence to=\""+roomIdAliasSessionId+"@conference.att.com/"+sid+"\"><x xmlns=\"http://jabber.org/protocol/muc\" /></presence>";
						request=frameXmppPacket(request,sid,req);
						req++;
						System.out.println("request:"+request);
						response=boshConnector.send(request);
						System.out.println("response:"+response);
						
						if(response.contains("<title>Error 404 Invalid SID.</title>"))
						{
							throw invalidSidException;
						}
						
						//Wait for SME to close the chat
						boolean chatSessionClosedBySme=false;
						while(!chatSessionClosedBySme)
						{
							request="<body sid=\""+sid+"\" rid=\""+req+"\" xmlns=\"http://jabber.org/protocol/httpbind\" />";
							//find if SME has closed the room
							req++;
							System.out.println("request:"+request);
							response=boshConnector.send(request);
							System.out.println("response:"+response);
							if(response.contains("<title>Error 404 Invalid SID.</title>"))
							{
								throw invalidSidException;
							}
							
							
							//find its its close chat(unavialable packet)
							if(response!=null && response.contains("<presence") && response.contains("unavailable")) 
							{
								chatSessionClosedBySme=true;
							}
						}
						
						
						request="<presence to=\""+roomIdAliasSessionId+"@conference.att.com/"+sid+"\" type=\"unavailable\"><x xmlns=\"http://jabber.org/protocol/muc\" /></presence>";
						request=frameXmppPacket(request,sid,req);
						req++;
						System.out.println("request:"+request);
						response=boshConnector.send(request);
						System.out.println("response:"+response);
						if(response.contains("<title>Error 404 Invalid SID.</title>"))
						{
							throw invalidSidException;
						}
						
						
						//Send Offline Presence to openfire
						request="<presence type=\"unavailable\"/>";
						request=frameXmppPacket(request,sid,req);
						req++;
						System.out.println("request:"+request);
						response=boshConnector.send(request);
						System.out.println("response:"+response);
						if(response.contains("<title>Error 404 Invalid SID.</title>"))
						{
							throw invalidSidException;
						}
						
						//Disconnect from openfire
//						request="</stream>";
//						//req++;
//						System.out.println("request:"+request);
//						response=new BoshConnector().send(request);
//						System.out.println(response);
					}
				}
				else
				{
					System.out.println("Response is null for the connect");
				}
			}
			catch (InvalidSidException inse) 
			{
				System.out.println("Invalid Sid exception is thrown for the user with sid:"+sid+"."+inse);
				System.out.println("Ending the user thread");
			}
			catch(ServiceUnavailableException sue)
			{
				System.out.println("Invalid Sid exception is thrown for the user with sid:"+sid+"."+sue);
				System.out.println("Ending the user thread");
			}
			catch(IndexOutOfBoundsException iobe)
			{
				System.out.println("Index Out of Bound Exception for sid:"+sid+iobe);
				System.out.println("Ending the user thread");
			}
			catch (Exception e) {
				System.out.println("Exception in ThreadCreater class for sid:"+sid+e);
				System.out.println("Ending the user thread");
			}
			
			
		}
		
		
	}
	

	private String frameXmppPacket(String request,String sid, int req)
	{
		StringBuilder packet=new StringBuilder("<body sid=\""+sid+"\" rid=\""+req+"\" xmlns=\"http://jabber.org/protocol/httpbind\">");
		packet.append(request).append("</body>");
		return packet.toString();
	}
	
	private String frameXmppPingPacket(String sid, int req)
	{
		StringBuilder packet=new StringBuilder("<body sid=\""+sid+"\" rid=\""+req+"\" xmlns=\"http://jabber.org/protocol/httpbind\"/>");
		return packet.toString();
	}
	
//	private String filterResponse(String response,  req)
//	{
//		
//		return packet.toString();
//	}
	
}
