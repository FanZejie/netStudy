package loc.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * ģ���¼ ����ͻ�������
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
 * 2.�������������������
 * 3.�ͷ���Դ
 * @author Mike-laptop
 */
public class LoginMultiClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		/*System.out.println("----client----");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û���");
		String uname = br.readLine();
		System.out.println("����������");
		String upwd = br.readLine();*/
		// 1.�������ӣ�ʹ��Socket�����ͻ���+�������ĵ�ַ�Ͷ˿�
		Socket client = new Socket("localhost",8888);
		// 2.������������������� ���������Ӧ
		new send(client).write();
		new receive(client).receive();
		// 3.�ͷ���Դ
		client.close();
	}
//����

static class send{
	private DataOutputStream dos;
	private Socket client;
	private BufferedReader br;
	private String msg;
	public send(Socket client) {
		this.client = client;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			dos = new DataOutputStream(client.getOutputStream());
			this.msg = init();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String init() {
		System.out.println("----client----");
		try {
			System.out.println("�������û���");
			String uname = br.readLine();
			System.out.println("����������");
			String upwd = br.readLine();
			return "uname="+uname+"&"+"upwd="+upwd;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}
	public void write() {
	try {
		dos.writeUTF(msg);
		dos.flush();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
//����
static class receive{
	private DataInputStream dis;
	private Socket client;
	public receive(Socket client) {
		this.client = client;
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void receive() {
		String data;
		try {
			data = dis.readUTF();
			System.out.println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
}
