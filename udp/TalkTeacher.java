package loc.udp;
/**
 * ������̣߳�ʵ��˫���� ģ��������ѯ
 * ��ʦ��
 * @author Mike-laptop
 *
 */
public class TalkTeacher {

	public static void main(String[] args) {
		System.out.println("��ʦ��");
		// TODO Auto-generated method stub
        new Thread(new TalkReceive(9999,"fzj")).start();//����
        
        new Thread(new TalkSend(5555,"localhost",8888)).start();//����
	}

}
