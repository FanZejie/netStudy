package loc;

import java.net.InetSocketAddress;

/**
 * �˿�
 * 1.�������
 * 2.2���ֽ� 0-65536 UDP TCP
 * 3.ͬһ��Э��˿ڲ��ܳ�ͻ
 * 4.����Խ��Խ��
 * InetSocketAddress ʵ����
 * getPort() ��ȡ�˿ں�
 * @author Mike-laptop
 *
 */
public class PortTest {

	public static void main(String[] args) {
		//�����˿�
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1",8080);
		System.out.println(isa.getHostName());
		System.out.println(isa.getPort());
	}

}
