package loc.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟登录 多个客户端请求 创建服务器 
 * 1.指定端口 使用ServerSocket创建服务器 
 * 2.阻塞式等待连接accept 
 * 3.操作：输入输出流操作
 * 4.释放资源
 * 
 * @author Mike-laptop
 */
public class LoginMultiServer {

	public static void main(String[] args) throws IOException {
		System.out.println("----Server----");
		// 1.指定端口 使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		// 2.阻塞式等待连接accept
		boolean isRunning = true;
		while (isRunning) {
			Socket client = server.accept();
			System.out.println("一个客户端建立了连接");
			new Thread(new Channel(client)).start();
		}
		server.close();
	}
}

class Channel implements Runnable {
	private Socket client;
	private DataOutputStream dos;
	// 输入流封装
	private DataInputStream dis;

	public Channel(Socket client) {
		this.client = client;
		try {
			// 输入流
			dis = new DataInputStream(client.getInputStream());
			// 输出流
			dos = new DataOutputStream(client.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			release();
		}

	}

	@Override
	public void run() {
		// 3.操作：输入输出流操作
		String uname = "";
		String upwd = "";
		// 分析数据
		String[] dataArray = receive().split("&");
		for (String string : dataArray) {
			String[] userInfo = string.split("=");
			if (userInfo[0].equals("uname")) {
				System.out.println("你的用户名为：" + userInfo[1]);
				uname = userInfo[1];
			} else if (userInfo[0].equals("upwd")) {
				System.out.println("你的密码为：" + userInfo[1]);
				upwd = userInfo[1];
			}
		}

		if (uname.equals("fzj") && upwd.equals("111")) {
			// 成功
			send("登陆成功，欢迎回来");
		} else {
			// 失败
			send("用户名或密码错误");
		}
		// 4.释放资源
		release();

	}

//接收数据用的
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

//发送数据用的
	private void send(String msg) {
		try {
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//释放资源
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
