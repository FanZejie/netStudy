package loc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * 网络爬虫的原理+模拟浏览器
 * @author Mike-laptop
 *
 */
public class SpiderTest02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        //获取URL
		URL url = new URL("https://www.dianping.com");
		//下载资源
		//InputStream is = url.openStream();//这个行不通啦~
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
	    con.setRequestMethod("GET");
	    //模拟浏览器请求，但现在好像也不好用了了解一下
	    con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:73.0) Gecko/20100101 Firefox/73.0");
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		String msgString = null;
		while ((msgString=br.readLine())!=null) {
			System.out.println(msgString);
		}
		br.close();
	}

}
