package loc.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * ���նˣ�
 * @author Mike-laptop
 */
public class TalkReceive implements Runnable{
	DatagramSocket server;
	private String from;
	public TalkReceive(int port,String from) {
		this.from =from;
		 try {
			server = new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {
			byte[] container = new byte[1024*60];
			DatagramPacket packer = new DatagramPacket(container, 0,container.length);
			//3.����ʽ���հ���receive(DatagramPacket p)
			try {
				server.receive(packer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//4.��������
			//     byte[] getData()
			//            getLength()
			byte[] datas = packer.getData();
			System.out.println(from+": "+new String(datas,0,datas.length));
			if (datas.equals("bye")) {
				System.out.println("����");
				break;
			}
			}
		server.close();
		
	}

}
