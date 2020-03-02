package loc;

import java.net.InetSocketAddress;

/**
 * 端口
 * 1.区分软件
 * 2.2个字节 0-65536 UDP TCP
 * 3.同一个协议端口不能冲突
 * 4.定义越大越好
 * InetSocketAddress 实现类
 * getPort() 获取端口号
 * @author Mike-laptop
 *
 */
public class PortTest {

	public static void main(String[] args) {
		//包含端口
		InetSocketAddress isa = new InetSocketAddress("127.0.0.1",8080);
		System.out.println(isa.getHostName());
		System.out.println(isa.getPort());
	}

}
