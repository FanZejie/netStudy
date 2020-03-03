package loc.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���¼ ����ͻ������� ���������� 
 * 1.ָ���˿� ʹ��ServerSocket���������� 
 * 2.����ʽ�ȴ�����accept 
 * 3.�������������������
 * 4.�ͷ���Դ
 * 
 * @author Mike-laptop
 */
public class LoginMultiServer {

	public static void main(String[] args) throws IOException {
		System.out.println("----Server----");
		// 1.ָ���˿� ʹ��ServerSocket����������
		ServerSocket server = new ServerSocket(8888);
		// 2.����ʽ�ȴ�����accept
		boolean isRunning = true;
		while (isRunning) {
			Socket client = server.accept();
			System.out.println("һ���ͻ��˽���������");
			new Thread(new Channel(client)).start();
		}
		server.close();
	}
}

class Channel implements Runnable {
	private Socket client;
	private DataOutputStream dos;
	// ��������װ
	private DataInputStream dis;

	public Channel(Socket client) {
		this.client = client;
		try {
			// ������
			dis = new DataInputStream(client.getInputStream());
			// �����
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			release();
		}

	}

	@Override
	public void run() {
		// 3.�������������������
		String uname = "";
		String upwd = "";
		// ��������
		String[] dataArray = receive().split("&");
		for (String string : dataArray) {
			String[] userInfo = string.split("=");
			if (userInfo[0].equals("uname")) {
				System.out.println("����û���Ϊ��" + userInfo[1]);
				uname = userInfo[1];
			} else if (userInfo[0].equals("upwd")) {
				System.out.println("�������Ϊ��" + userInfo[1]);
				upwd = userInfo[1];
			}
		}

		if (uname.equals("fzj") && upwd.equals("111")) {
			// �ɹ�
			send("��½�ɹ�����ӭ����");
		} else {
			// ʧ��
			send("�û������������");
		}
		// 4.�ͷ���Դ
		release();

	}

//���������õ�
	private String receive() {
		String datas = "";
		try {
			datas = dis.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datas;
	}

//���������õ�
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//�ͷ���Դ
	private void release() {
		try {
			if (dos != null) {
				dos.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (dis != null) {
				dis.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (client != null) {
				client.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
