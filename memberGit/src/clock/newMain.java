package clock;

public class newMain {
	public static void main(String[] args) {

		MergeClass c = new MergeClass();
		
//		int count = 722;
		int count = 1442;
		
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
