package clock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class newMain { // 나머지 클래스 합쳐서 만든 MergeClass 사용해서 01:00:00 ~ 12:59:59 시계 출력
	public static void main(String[] args) {
			
			MergeClass c = new MergeClass();
			
			LocalDateTime time = LocalDateTime.now();
			String timeStr = time.format(DateTimeFormatter.ofPattern("hhmmss"));
			
			int h0 = timeStr.charAt(0) - '0';
			int h1 = timeStr.charAt(1) - '0';
			int m0 = timeStr.charAt(2) - '0';
			int m1 = timeStr.charAt(3) - '0';
			int s0 = timeStr.charAt(4) - '0';
			int s1 = timeStr.charAt(5) - '0';
			
//			c.setNowTime(h0, h1, m0, m1, s0, s1);
			
//		int count = 3600*12*2 + 2;
			int count = 10;
			
			for (int i = 0; i < count * 2; i++) {
				c.setClock(i%2);
				if(i%2 == 0) {	
					c.count();		
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

	}
	
}
