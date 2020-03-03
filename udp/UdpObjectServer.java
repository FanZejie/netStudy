package loc.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Date;


/**
 * 接收端
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.准备容器 封装成DatagramPacket 包裹
 * 3.阻塞式接收包裹receive(DatagramPacket p)
 * 4.分析数据
 *     byte[] getData()
 *            getLength()
 * 5.释放资源
 * @author Mike-laptop
 *
 */
public class UdpObjectServer {

	public static void main(String[] args) throws Exception {
		System.out.println("接收方启动中");
		//1.使用DatagramSocket 指定端口 创建接收端
		DatagramSocket server = new DatagramSocket(9999);
		//2.准备容器 封装成DatagramPacket 包裹
		byte[] container = new byte[1024*60];
		DatagramPacket packer = new DatagramPacket(container, 0,container.length);
		//3.阻塞式接收包裹receive(DatagramPacket p)
		server.receive(packer);
		//4.分析数据
		//     byte[] getData()
		//            getLength()
		byte[] datas = packer.getData();
		int len = packer.getLength();
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//System.out.println(ois.readUTF());
		Object str = ois.readObject();
		Object date = ois.readObject();
		Object empObject = ois.readObject();
		
		if (str instanceof String) {
			String strObj = (String) str;
			System.out.println(strObj);
		}
		if (date instanceof Date) {
			Date dateObj = (Date) date;
			System.out.println(dateObj);
		}
		if (empObject instanceof Employee) {
			Employee empObj = (Employee) empObject;
			System.out.println(empObj.getName()+"-------->"+empObj.getSalary());
		}
		//5.释放资源
		server.close();
	}

}
