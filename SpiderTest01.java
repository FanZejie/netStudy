package loc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * ���������ԭ��
 * @author Mike-laptop
 *
 */
public class SpiderTest01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        //��ȡURL
		URL url = new URL("https://www.jd.com");
		//������Դ
		InputStream is = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
		String msgString = null;
		while ((msgString=br.readLine())!=null) {
			System.out.println(msgString);
		}
		br.close();
	}

}
