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
 * 熟悉流程
 * 创建客户端
 * 1.建立连接：使用Socket创建客户端+服务器的地址和端口
 * 2.操作：输入输出流操作
 * 3.释放资源
 * @author Mike-laptop
 */
public class FileClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("----client----");
		// 1.建立连接：使用Socket创建客户端+服务器的地址和端口
		Socket client = new Socket("localhost",8888);
        // 2.操作：拷贝
		InputStream is = new BufferedInputStream(new FileInputStream("fzj.jpg"));
		OutputStream os = new BufferedOutputStream(client.getOutputStream());
		byte[] flush = new byte[1024];
		int len =-1;
		while ((len = is.read(flush))!=-1) {
			os.write(flush,0,len);
		}
		// 3.释放资源
		os.close();
		is.close();
		client.close();
	}

}
