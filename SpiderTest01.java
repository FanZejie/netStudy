package loc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 网络爬虫的原理
 * @author Mike-laptop
 *
 */
public class SpiderTest01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        //获取URL
		URL url = new URL("https://www.jd.com");
		//下载资源
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String msgString = null;
		while ((msgString=br.readLine())!=null) {
			System.out.println(msgString);
		}
		br.close();
	}

}
