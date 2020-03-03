package loc.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 发送端 1.使用DatagramSocket 指定端口 创建发送端 
 * 2.准备数据 一定转成字节数组
 * 3.封装成DatagramPacket包裹，需要指定目的地 
 * 4.发送包裹 send(DatagramPacket p) 
 * 5.释放资源
 * 
 * @author Mike-laptop
 *
 */
public class UdpTalkClient {

	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中");
		// 1.使用DatagramSocket 指定端口 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		// 2.准备数据 一定转成字节数组
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			
			
		
		String dataString = reader.readLine();
		byte[] datas = dataString.getBytes();
		// 3.封装成DatagramPacket包裹，需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		// 4.发送包裹 send(DatagramPacket p)
		client.send(packet);
		if (datas.equals("bye")) {
			break;
		}
		}
		// 5.释放资源
		client.close();
	}

}
