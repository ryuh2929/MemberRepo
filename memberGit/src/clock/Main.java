package clock;

public class Main {
	public static void main(String[] args) {

		TTL7490 ttl7490 = new TTL7490();
		TTL7446 ttl7446 = new TTL7446();
		newFND fnd = new newFND();
		
		for(int i = 0; i < 20; i++) {
			ttl7490.setClock(i%2);
			ttl7446.setInput(ttl7490.getOutput());
			if (i%2 == 0) {
//				for(int j = 0; j < 4; j++) {
//					System.out.print(ttl7490.getOutput()[3-j]);
//				}
//				System.out.print(" : ");
//				for(int j = 0; j < 7; j++) {
//					System.out.print(ttl7446.getOutput()[j]);
//				}
//				System.out.println();
				fnd.setInput(ttl7446.getOutput());
				fnd.dispFnd();
			}
		}
	}

}
