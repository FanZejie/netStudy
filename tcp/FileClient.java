package loc.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * ��Ϥ����
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author Mike-laptop
 */
public class FileClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----client----");
		// 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
		Socket client = new Socket("localhost",8888);
        // 2.����������
		InputStream is = new BufferedInputStream(new FileInputStream("fzj.jpg"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		byte[] flush = new byte[1024];
		int len =-1;
		while ((len = is.read(flush))!=-1) {
			os.write(flush,0,len);
		}
		// 3.�ͷ���Դ
		os.close();
		is.close();
		client.close();
	}

}
