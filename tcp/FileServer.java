package loc.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��Ϥ����
 * ����������
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.�������������������
 * 4.�ͷ���Դ
 * @author Mike-laptop
 */
public class FileServer {

	public static void main(String[] args) throws IOException {
		System.out.println("----Server----");
		// 1.ָ���˿� ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(8888);
		// 2.����ʽ�ȴ�����accept
		Socket client = server.accept();
		System.out.println("һ���ͻ��˽���������");
		// 2.����������
		InputStream is = new BufferedInputStream(client.getInputStream());
		OutputStream os = new BufferedOutputStream(new FileOutputStream("ttt.jpg"));
		byte[] flush = new byte[1024];
		int len =-1;
		while ((len = is.read(flush))!=-1) {
			os.write(flush,0,len);
		}
		// 3.�ͷ���Դ
		os.close();
		is.close();
	}

}