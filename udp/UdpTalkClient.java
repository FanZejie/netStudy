package loc.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

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
public class UdpTalkClient {

	public static void main(String[] args) throws Exception {
		System.out.println("���ͷ�������");
		// 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
		DatagramSocket client = new DatagramSocket(8888);
		// 2.׼������ һ��ת���ֽ�����
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			
			
		
		String dataString = reader.readLine();
		byte[] datas = dataString.getBytes();
		// 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
		DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
		// 4.���Ͱ��� send(DatagramPacket p)
		client.send(packet);
		if (datas.equals("bye")) {
			break;
		}
		}
		// 5.�ͷ���Դ
		client.close();
	}

}
