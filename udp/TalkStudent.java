package loc.udp;

/**
 * 加入多线程，实现双向交流 模拟在线咨询
 * 学生端
 * @author Mike-laptop
 *
 */
public class TalkStudent {

	public static void main(String[] args) {
		System.out.println("学生端");
		new Thread(new TalkSend(7777,"localhost",9999)).start();//发送
		
		new Thread(new TalkReceive(8888,"tt")).start();//接收
	}

}
