
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.testtools.utils.LoadConfig;


public class ClientStarter {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		
		
		//Load the configuration data from config.xml
		new LoadConfig().loadConfigXMLData();
		
//		for(int i=0;i<2000;i++)
//		{
//			new ServerConnector().send("dataaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbcccccccccccccccccccccccccccc");
//		}
		///The below code is for initiating chats from same client
		int noOfClients=1;
		ExecutorService executor= Executors.newFixedThreadPool(noOfClients);
		int req=0;
		for(int j=0;j<noOfClients;j++)
		{
			req=(j+1)*1000;
			executor.execute(new ThreadCreater(req));
			//(new Thread(new  ThreadCreater(req))).start();
		}
		System.out.println("done");
		executor.shutdown();
//		while (!executor.isTerminated()) {
//		    try {
//		    	executor.awaitTermination(10, TimeUnit.SECONDS);
//		    } catch (InterruptedException e) {
//		        e.printStackTrace();
//		    }
//		}
		
		System.out.println("done1");
		return;
	}
	

}
