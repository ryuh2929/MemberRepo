package clock;

public class Main { // TTL7490 > TTL7446 > newFND 사용해서 0~9 표기하는 실행 클래스
	public static void main(String[] args) {

		TTL7490 ttl7490 = new TTL7490();
		TTL7446 ttl7446 = new TTL7446();
		newFND fnd = new newFND();
		
		for(int i = 0; i < 20; i++) {
			ttl7490.setClock(i%2);
			ttl7446.setInput(ttl7490.getOutput());
			if (i%2 == 0) {
//				for(int j = 0; j < 4; j

				fnd.setInput(ttl7446.getOutput());
				fnd.dispFnd();
			}
		}
	}

}
