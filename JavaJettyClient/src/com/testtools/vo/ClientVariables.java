package com.testtools.vo;

public class ClientVariables 
{
	public final String SID="sid"; 
	public final String ID="id"; 
	public final String BODY="body"; 
	public final String SESSION="session"; 
	public final String INVITE="invite";
	public final String SERVICE_UNAVILABLE="service-unavailable";
	
	private String sid=null;
	private String sessionId=null;
	private boolean isInviteReceived=false;
	private boolean isServiceUnavailble=false;
	/**
	 * @param sid the sid to set
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}
	/**
	 * @return the sid
	 */
	public String getSid() {
		return sid;
	}
	/**
	 * @param sessionId the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * @param isInviteReceived the isInviteReceived to set
	 */
	public void setInviteReceived(boolean isInviteReceived) {
		this.isInviteReceived = isInviteReceived;
	}
	/**
	 * @return the isInviteReceived
	 */
	public boolean isInviteReceived() {
		return isInviteReceived;
	}
	/**
	 * @param isServiceUnavailble the isServiceUnavailble to set
	 */
	public void setServiceUnavailble(boolean isServiceUnavailble) {
		this.isServiceUnavailble = isServiceUnavailble;
	}
	/**
	 * @return the isServiceUnavailble
	 */
	public boolean isServiceUnavailble() {
		return isServiceUnavailble;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
