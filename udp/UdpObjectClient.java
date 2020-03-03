package loc.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Date;


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
public class UdpObjectClient {

	public static void main(String[] args) throws Exception {
		System.out.println("发送方启动中");
		// 1.使用DatagramSocket 指定端口 创建发送端
		DatagramSocket client = new DatagramSocket(8888);
		// 2.准备数据 一定转成字节数组
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		/*DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));*/
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
		   //操作数据类型+数据
		/*dos.writeUTF("想成为一个有价值的人");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();*/
		//操作對象
		//oos.writeUTF("oos->好好学习");
		oos.writeObject("冲");
		oos.writeObject(new Date());
		oos.writeObject(new Employee("范泽杰",5000));
		oos.flush();
		byte[] datas = baos.toByteArray();

		// 3.封装成DatagramPacket包裹，需要指定目的地
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		
		// 4.发送包裹 send(DatagramPacket p)
		client.send(packet);
		// 5.释放资源
		client.close();
	}

}
class Employee implements Serializable{
	private transient String name;//这样该数据就不会序列化
	private double salary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
