package loc.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 模拟登录 多个客户端请求
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端+服务器的地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author Mike-laptop
 */
public class LoginMultiClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		/*System.out.println("----client----");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名");
		String uname = br.readLine();
		System.out.println("请输入密码");
		String upwd = br.readLine();*/
		// 1.建立连接：使用Socket创建客户端+服务器的地址和端口
		Socket client = new Socket("localhost",8888);
		// 2.操作：输入输出流操作 先请求后响应
		new send(client).write();
		new receive(client).receive();
		// 3.释放资源
		client.close();
	}
//发送

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
			System.out.println("请输入用户名");
			String uname = br.readLine();
			System.out.println("请输入密码");
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
//接收
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
