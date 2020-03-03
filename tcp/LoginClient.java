package loc.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * ģ���¼ ����
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author Mike-laptop
 */
public class LoginClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----client----");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û���");
		String uname = br.readLine();
		System.out.println("����������");
		String upwd = br.readLine();
		// 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
		Socket client = new Socket("localhost",8888);
        // 2.�������������������
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String data = "hello";
		dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
		// 3.�ͷ���Դ
		dos.close();
		client.close();
	}

}
