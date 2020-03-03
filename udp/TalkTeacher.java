package loc.udp;
/**
 * 加入多线程，实现双向交流 模拟在线咨询
 * 教师端
 * @author Mike-laptop
 *
 */
public class TalkTeacher {

	public static void main(String[] args) {
		System.out.println("教师端");
		// TODO Auto-generated method stub
        new Thread(new TalkReceive(9999,"fzj")).start();//接收
        
        new Thread(new TalkSend(5555,"localhost",8888)).start();//发送
	}

}
