import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;


public class BoshConnector 
{
	HttpClient httpClient;
	public BoshConnector()
	{
		
	}
	public BoshConnector(HttpClient httpClient)
	{
		this.httpClient=httpClient;
	}
	public String send(String request)
	{
		//PostMethod post= new PostMethod("https://smartchat-test2.web.att.com:7443/http-bind/");
		//PostMethod post= new PostMethod("http://blpv0052.bhdc.att.com:7070/http-bind/");
		PostMethod post= new PostMethod("http://smartchat-test2.web.att.com:7070/http-bind/");
		
		//String test="hellos~!@#$%^&*()_+=-`{}|:\"<>?/.,;'[]'	<HT>";
//		String test="this is/t hello /n/a";
//		post.setRequestHeader("Sukesh", test);
//		post.setRequestHeader("test", "HTTP/1.1");
		//String tes1t="\\u0001\\u0002\\u0001\\u0003\\u0004\\u0005\\u0006\\u0007\\u0008\\u0009\\u0001\\u0003\\u0004\\u0005\\u0006\\u0007\\u0008\\u0009\\u000A\\u000B\\u000C\\u000D\\u000E\\u000F\\u0010\\u0011\\u0012\\u0013\\u0014\\u0015\\u0016\\u0017\\u0018\\u0019\\u001A\\u001B\\u001C\\u001D\\u001E\\u001F World";
//		String tes1t="Accept: */*\r\n"+
//		"Accept-Language: en-US"+
//		"Referer: https://smartchat-sfdc.web.att.com/SME/att_im_project_agent.swf\r\n"+
//		"x-flash-version: 11,9,900,152\r\n"+
//		"Content-Type: text/xml\r\n"+
//		"Content-Length: 189\r\n"+
//		"Accept-Encoding: gzip, deflate\r\n"+
//		"User-Agent: Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/5.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0; InfoPath.3; MS-RTC LM 8; .NET4.0C; .NET4.0E)\r\n"+
//		"Host: smartchat-sfdc-of.web.att.com:7443\r\n"+
//		"Connection: Keep-Alive\r\n"+
//		"Cache-Control: no-cache\r\n"+
//		"Cookie: __utma=161676899.720931142.1387267438.1387267438.1387267438.1; __utmz=161676899.1387267438.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none); browserid=A001918222489; svariants=NA; cust_type=new; bn_u=6924920676346624686; attESSec=00807b8GJgSNyKkI1kU5y8M9Y1Jo-cdKJrxG_zL0IK-ojzp3uQ7xsBOBPzFRf34DCJYqBlV58_W7m0lEqcajrfGZEr0kNXBxhM77-Ft3WBA2gDMag-yYJyJ40XhDPnnO9C7bqTe_qZtTUTZEumir5JI30b3HGwFyBjroKsyjIZ20zaff7Y93dJsnJFBXMt_j7R4cXSTjNeEzUUC4lkJAivnys7NRtv2QexmCzbsmUcGqkjqn7VhKtRAXRL_c7kvVHRya; attESHr=SUKESH%7cSUKUMARAN%7css354d%40us%2eatt%2ecom%7c9999999999%7c%7csp537a%7c%7css354d%2cRHPFCNN%2cRCF7GC9%2c0994951%7cYNNNNNNNNNNNNNYNYYNNNNNN%7cSUKESH%7cEY1P1KA00%7c; attESg2=006c7b8GJgSNyKkI1kU5y8M9Y1Jo-cdKJrxG_zL0IK-ojzoYPWfq2FFVkNzlR7CX6cmJp44Z3FuZwDthtBgWnZ6ShxS4ZzrX7auTiUH8fCbbE1M.d0M8XyWnWzXA9blKj0AtDdrgxhZQ-dYXFvRSvC_tIoIjyzc515n_gJyxgZjGkirunNZzOBZffW89XS2maCIFXCCSwSbtwLPa9sDlLQdK7Ioj8Xu-TPm8BgyGPFTaWzKQ\r\n";

    	//String ttt=StringEscapeUtils.unescapeJava(tes1t);
    	//post.setRequestHeader("test123", ttt);
		HttpConnectionManagerParams params=new HttpConnectionManagerParams();
		params.setSoTimeout(100000);
		params.setTcpNoDelay(true);
		HttpConnectionManager manager=new SimpleHttpConnectionManager();
		manager.setParams(params);
		HttpClientParams cparams=new HttpClientParams();
		cparams.setSoTimeout(100000);
		httpClient=new HttpClient(cparams, manager);
		String response=null;
		InputStream is = new ByteArrayInputStream(request.getBytes());
		post.setRequestEntity(new InputStreamRequestEntity(is));
		
		
		
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		int result=0;
		String line;
		try {
			result = httpClient.executeMethod(post);
			
			
			br = new BufferedReader(new InputStreamReader(post.getResponseBodyAsStream()));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();

		} catch (IOException e) {
			e.printStackTrace();
		}
	
	return null;
	
	}

}
