package loc.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * ���Ͷˣ�ʹ����������װ
 * @author Mike-laptop
 *
 */
public class TalkSend implements Runnable{
	private DatagramSocket client ;
	private BufferedReader reader ;
	private String toIp;//�Է���Ip
	private int toPort;//�Է��Ķ˿�
	/**
	 * ����˿ں�,Ŀ��ip,Ŀ��˿�
	 * @param port
	 */
	public TalkSend(int port,String toIp,int toPort) {
		this.toIp = toIp;
		this.toPort = toPort;
		try {
			client = new DatagramSocket(port);
			reader = new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
@Override
public void run() {
	while (true) {
		String dataString;
		try {
			dataString = reader.readLine();
			byte[] datas = dataString.getBytes();
			// 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
			DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIp, this.toPort));
			// 4.���Ͱ��� send(DatagramPacket p)
			client.send(packet);
			if (datas.equals("bye")) {
				break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	client.close();
}
}
