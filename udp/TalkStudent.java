package loc.udp;

/**
 * ������̣߳�ʵ��˫���� ģ��������ѯ
 * ѧ����
 * @author Mike-laptop
 *
 */
public class TalkStudent {

	public static void main(String[] args) {
		System.out.println("ѧ����");
		new Thread(new TalkSend(7777,"localhost",9999)).start();//����
		
		new Thread(new TalkReceive(8888,"tt")).start();//����
	}

}
