package loc;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ip地址是用于区分电脑的
 * InetAddress:多个静态方法
 * 1.getLocalHost:本机
 * 2.getByName:根据域名DNS | ip地址-->IP
 * 
 * 两个成员方法
 * 1.getHostAddress:返回地址
 * 2.getHostName:返回计算机名
 * @author Mike-laptop
 *
 */
public class IpTest {

	public static void main(String[] args) throws UnknownHostException {
		//使用getLocalHost方法创建InetAddress对象 本机
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
        
		//根据域名得到netAddress对象
		address = InetAddress.getByName("www.163.com");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
	    //根据ip得到netAddress对象
		address = InetAddress.getByName("117.156.18.136");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());//注意这里返回的不是ip而是域名，如果这个ip地址不存在或dns服务器不允许ip进行ip地址的域名的映射
	}

}
