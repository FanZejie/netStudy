package loc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ip��ַ���������ֵ��Ե�
 * InetAddress:�����̬����
 * 1.getLocalHost:����
 * 2.getByName:��������DNS | ip��ַ-->IP
 * 
 * ������Ա����
 * 1.getHostAddress:���ص�ַ
 * 2.getHostName:���ؼ������
 * @author Mike-laptop
 *
 */
public class IpTest {

	public static void main(String[] args) throws UnknownHostException {
		//ʹ��getLocalHost��������InetAddress���� ����
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
        
		//���������õ�netAddress����
		address = InetAddress.getByName("www.163.com");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
	    //����ip�õ�netAddress����
		address = InetAddress.getByName("117.156.18.136");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());//ע�����ﷵ�صĲ���ip����������������ip��ַ�����ڻ�dns������������ip����ip��ַ��������ӳ��
	}

}
