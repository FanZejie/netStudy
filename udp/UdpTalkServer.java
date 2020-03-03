package loc.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 * 接收端
 * 1.0只能接收数据
 * @author Mike-laptop
 *
 */
public class UdpTalkServer {

	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中");
		//1.使用DatagramSocket 指定端口 创建接收端
		DatagramSocket server = new DatagramSocket(9999);
		//2.准备容器 封装成DatagramPacket 包裹
		while (true) {
		byte[] container = new byte[1024*60];
		DatagramPacket packer = new DatagramPacket(container, 0,container.length);
		//3.阻塞式接收包裹receive(DatagramPacket p)
		server.receive(packer);
		//4.分析数据
		//     byte[] getData()
		//            getLength()
		byte[] datas = packer.getData();
		System.out.println(new String(datas,0,datas.length));
		if (datas.equals("bye")) {
			break;
		}
		}
		server.close();
	}

}
