package zero10_socketTransfer;

import java.io.*;
import java.net.*;

public class ServerSocketThread extends Thread {
	private Socket s1;
	private ChatServer st;
	private PrintWriter pw;
	private BufferedReader br;
	private String name;
	private String threadName = "Thread";

	public ServerSocketThread(ChatServer st, Socket s1) {
		this.s1 = s1;
		this.st = st;
		threadName = getName();
		System.out.println(s1.getInetAddress() + " 님이 입장하였습니다.");
		System.out.println("Thread Name: " + threadName);
	}

	public void sendMessage(String str) {
		pw.println(str);
	}

	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			pw = new PrintWriter(s1.getOutputStream(), true);
			sendMessage("대화자 이름을 넣으세요:");
			name = br.readLine();
			st.broadCasting("[" + name + "]" + "님이 입장 하셨습니다.");
			while (true) {
				String strin = br.readLine();
				st.broadCasting("[" + name + ": ]" + strin);
			}
		} catch (Exception e) {
			System.out.println(threadName + " 퇴장했습니다.");
			st.removeClient(this);
		} finally {
			try {
				s1.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}