package loc.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 * ���ն�
 * 1.ʹ��DatagramSocket ָ���˿� �������ն�
 * 2.׼������ ��װ��DatagramPacket ����
 * 3.����ʽ���հ���receive(DatagramPacket p)
 * 4.��������
 *     byte[] getData()
 *            getLength()
 * 5.�ͷ���Դ
 * @author Mike-laptop
 *
 */
public class UdpFileServer {

	public static void main(String[] args) throws Exception {
		System.out.println("���շ�������");
		//1.ʹ��DatagramSocket ָ���˿� �������ն�
		DatagramSocket server = new DatagramSocket(9999);
		//2.׼������ ��װ��DatagramPacket ����
		byte[] container = new byte[1024*60];
		DatagramPacket packer = new DatagramPacket(container, 0,container.length);
		//3.����ʽ���հ���receive(DatagramPacket p)
		server.receive(packer);
		//4.��������
		//     byte[] getData()
		//            getLength()
		byte[] datas = packer.getData();
		IOUtils.byteArrayToFile(datas, "fzj2.jpg");
		System.out.println(new String(datas,0,datas.length));
		//5.�ͷ���Դ
	}

}
