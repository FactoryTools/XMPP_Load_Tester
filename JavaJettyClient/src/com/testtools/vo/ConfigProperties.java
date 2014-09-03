package com.testtools.vo;

public class ConfigProperties {
	private  static String serverName=null;
	private  static int port=0;
	private  static String bindservlet=null;
	private  static String username=null;
	private  static String password=null;
	private  static int overactivityDelay=0;
	private  static int chatDuration=0;
	private  static int chatsPerUser=0;
	private  static int threadCount=0;
	private  static int delay=0;
	
	
	public static String getServerName() {
		return serverName;
	}

	public static void setServerName(String serverName) {
		ConfigProperties.serverName = serverName;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		ConfigProperties.port = port;
	}

	public static String getBindservlet() {
		return bindservlet;
	}

	public static void setBindservlet(String bindservlet) {
		ConfigProperties.bindservlet = bindservlet;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		ConfigProperties.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		ConfigProperties.password = password;
	}

	public static int getOveractivityDelay() {
		return overactivityDelay;
	}

	public static void setOveractivityDelay(int overactivityDelay) {
		ConfigProperties.overactivityDelay = overactivityDelay;
	}

	public static int getChatDuration() {
		return chatDuration;
	}

	public static void setChatDuration(int chatDuration) {
		ConfigProperties.chatDuration = chatDuration;
	}

	public static int getChatsPerUser() {
		return chatsPerUser;
	}

	public static void setChatsPerUser(int chatsPerUser) {
		ConfigProperties.chatsPerUser = chatsPerUser;
	}

	public static int getThreadCount() {
		return threadCount;
	}

	public static void setThreadCount(int threadCount) {
		ConfigProperties.threadCount = threadCount;
	}

	public static int getDelay() {
		return delay;
	}

	public static void setDelay(int delay) {
		ConfigProperties.delay = delay;
	}

}
