package loc.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 模拟登录 双向
 * 创建服务器
 * 1.指定端口 使用ServerSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作：输入输出流操作
 * 4.释放资源
 * @author Mike-laptop
 */
public class LoginTwoWayServer {

	public static void main(String[] args) throws IOException {
		System.out.println("----Server----");
		// 1.指定端口 使用ServerSocket创建服务器
		ServerSocket server = new ServerSocket(8888);
		// 2.阻塞式等待连接accept
		Socket client = server.accept();
		System.out.println("一个客户端建立了连接");
		// 3.操作：输入输出流操作
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String data = dis.readUTF();
		System.out.println(data);
		String uname = "";
		String upwd = "";
		//分析数据
		String [] dataArray = data.split("&");
		for (String string : dataArray) {
			String[] userInfo = string.split("=");
			System.out.println(userInfo[0]+"-->"+userInfo[1]);
			if (userInfo[0].equals("uname")) {
				System.out.println("你的用户名为："+userInfo[1]);
				uname = userInfo[1];
			}else if(userInfo[0].equals("upwd")){
				System.out.println("你的密码为："+userInfo[1]);
				upwd = userInfo[1];
			}
		}
		//输出
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		
		
		if (uname.equals("fzj")&&upwd.equals("111")) {
			//成功
			dos.writeUTF("登录成功");
		}else {
			//失败
			dos.writeUTF("登陆失败");
		}
		// 4.释放资源
        dis.close();
		// 4.释放资源
        dis.close();
	}

}
