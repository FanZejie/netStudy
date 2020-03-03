package loc.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 * ���ն�
 * 1.0ֻ�ܽ�������
 * @author Mike-laptop
 *
 */
public class UdpTalkServer {

	public static void main(String[] args) throws Exception {
		System.out.println("���շ�������");
		//1.ʹ��DatagramSocket ָ���˿� �������ն�
		DatagramSocket server = new DatagramSocket(9999);
		//2.׼������ ��װ��DatagramPacket ����
		while (true) {
		byte[] container = new byte[1024*60];
		DatagramPacket packer = new DatagramPacket(container, 0,container.length);
		//3.����ʽ���հ���receive(DatagramPacket p)
		server.receive(packer);
		//4.��������
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
