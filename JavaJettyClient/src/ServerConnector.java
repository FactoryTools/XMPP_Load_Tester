import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;


public class ServerConnector {
			
		public String send(String data)
		{
			String response="";
			try {
			    // Construct data
				
				
			    // Send data
			    URL url = new URL("http://localhost:8080/JettyTestProject1/http-bind");
			    
			    //URL url = new URL("http://127.0.0.1:8080/JettyTestProject1/http-bind");
				//URL url = new URL("http://smartchat-test.web.att.com:7070/http-bind");
			    URLConnection conn = url.openConnection();
			    ((HttpURLConnection)conn).setRequestMethod("GET");
			    conn.setDoInput(true);
			    conn.setDoOutput(true);
			    conn.setUseCaches(false);
			    conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + data.length());
			    //conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); //use multipart form data instead
			    //conn.setRequestProperty("Content-Length", ""+ data.length());
			    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			    wr.write(data);
			    wr.flush();

			    // Get the response
			    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			    String line;
			    while ((line = rd.readLine()) != null) 
			    {
			        //System.out.println(line);
			        response=line;
			    }
			    wr.close();
			    rd.close();
			    
			} 
			catch (Exception e) 
			{
				System.out.println("Exception in connecting to servlet:"+e);
			}
			return response;
		}

}
