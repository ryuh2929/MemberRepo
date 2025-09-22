package clock;

public class MergeClass {
	private TTL7490 ttl7490;
	private TTL7446 ttl7446 = new TTL7446();
	private newFND fnd = new newFND();
	int[] output7490 = new int[4];
	int oldclock;
	int minutecount;
	int hourcount;
	int[][] output7446 = new int[4][7];
	boolean[][] dispData = new boolean[5][25];
	
	MergeClass() {
		ttl7490 = new TTL7490();
		this.oldclock = ttl7490.oldclock;
		this.output7490 = ttl7490.output;
	}
	
	MergeClass(int R0, int R1, int R2) {
		ttl7490 = new TTL7490(R0, R1, R2);
		this.oldclock = ttl7490.oldclock;
		this.output7490 = ttl7490.output;
	}
	
	private void setClock(int clk) {
		ttl7490.setClock(clk);
		this.oldclock = ttl7490.oldclock;
		this.output7490 = ttl7490.output;
	}
	
	private void setInput() {
		ttl7446.setInput(output7490);
		this.output7446[3] = ttl7446.output;
	}
	
	private void fndInput() {
		fnd.setInput(output7446[3]);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.dispData[i][j+20] = fnd.dispData[i][j];				
			}
		}
	}
	
	public void count(int count) {
		this.reset();
		for (int i = 0; i < count * 2; i++) {
			this.setClock(i%2);
			if(i%2 == 0) {
				this.setInput();
				this.fndInput();
				this.dispFnd();				
			}
		}
	}
	
	private void dispFnd() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 25; j++) {
				if (this.dispData[i][j]) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private void reset() {
		for (int i = 0; i < 5; i++) {
			if (i%2 == 1) {
				this.dispData[i][12] = true;
			}
		}
		fnd.setInput(new int[] {1,1,1,1,1,1,0});
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.dispData[i][j] = fnd.dispData[i][j];				
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.dispData[i][j+6] = fnd.dispData[i][j];				
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.dispData[i][j+14] = fnd.dispData[i][j];				
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.dispData[i][j+20] = fnd.dispData[i][j];				
			}
		}
	}
}