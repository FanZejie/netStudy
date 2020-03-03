package loc.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * ģ���¼ ����
 * ����������
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.�������������������
 * 4.�ͷ���Դ
 * @author Mike-laptop
 */
public class LoginServer {

	public static void main(String[] args) throws IOException {
		System.out.println("----Server----");
		// 1.ָ���˿� ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(8888);
		// 2.����ʽ�ȴ�����accept
		Socket client = server.accept();
		System.out.println("һ���ͻ��˽���������");
		// 3.�������������������
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String datas = dis.readUTF();
		System.out.println(datas);
		//��������
		String [] dataArray = datas.split("&");
		for (String string : dataArray) {
			String[] userInfo = string.split("=");
			System.out.println(userInfo[0]+"-->"+userInfo[1]);
			if (userInfo[0].equals("uname")) {
				System.out.println("����û���Ϊ��"+userInfo[1]);
				
			}else if(userInfo[1].equals("upwd")){
				System.out.println("�������Ϊ��"+userInfo[1]);
			
			}
		}
		
	}

}
