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
 * ���Ͷ� 1.ʹ��DatagramSocket ָ���˿� �������Ͷ� 
 * 2.׼������ һ��ת���ֽ�����
 * 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ� 
 * 4.���Ͱ��� send(DatagramPacket p) 
 * 5.�ͷ���Դ
 * 
 * @author Mike-laptop
 *
 */
public class UdpObjectClient {

	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������");
		// 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		// 2.׼������ һ��ת���ֽ�����
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		/*DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));*/
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
		   //������������+����
		/*dos.writeUTF("���Ϊһ���м�ֵ����");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();*/
		//��������
		//oos.writeUTF("oos->�ú�ѧϰ");
		oos.writeObject("��");
		oos.writeObject(new Date());
		oos.writeObject(new Employee("�����",5000));
		oos.flush();
		byte[] datas = baos.toByteArray();

		// 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		
		// 4.���Ͱ��� send(DatagramPacket p)
		client.send(packet);
		// 5.�ͷ���Դ
		client.close();
	}

}
class Employee implements Serializable{
	private transient String name;//���������ݾͲ������л�
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
