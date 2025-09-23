package clock;

public class newMain { // 나머지 클래스 합쳐서 만든 MergeClass 사용해서 01:00 ~ 12:59 시계 출력
	public static void main(String[] args) {

		MergeClass c = new MergeClass();
		
		int count = 722;
		
		for (int i = 0; i < count * 2; i++) {
			c.setClock(i%2);
			if(i%2 == 0) {			
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				c.count();
			}
		}
		
	}

}
