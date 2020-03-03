package loc.tcp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 模拟登录 单项
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端+服务器的地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author Mike-laptop
 */
public class LoginClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----client----");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入用户名");
		String uname = br.readLine();
		System.out.println("请输入密码");
		String upwd = br.readLine();
		// 1.建立连接：使用Socket创建客户端+服务器的地址和端口
		Socket client = new Socket("localhost",8888);
        // 2.操作：输入输出流操作
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		String data = "hello";
		dos.writeUTF("uname="+uname+"&"+"upwd="+upwd);
		// 3.释放资源
		dos.close();
		client.close();
	}

}
