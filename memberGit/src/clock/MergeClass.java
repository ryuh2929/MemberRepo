package clock;

public class MergeClass {
	private TTL7490 ttl7490;
	private TTL7446 ttl7446 = new TTL7446();
	private newFND fnd = new newFND();
	int num;
	int[] output7490 = new int[4];
	int oldclock;
	int[] output7446 = new int[7];
	boolean[][] dispData = new boolean[5][5];
	
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
	
	public void setClock(int clk) {
		ttl7490.setClock(clk);
		this.oldclock = ttl7490.oldclock;
		this.output7490 = ttl7490.output;
	}
	
	public void setInput() {
		ttl7446.setInput(output7490);
		this.output7446 = ttl7446.output;
	}
	
	public void fndInput() {
		fnd.setInput(output7446);
		this.dispData = fnd.dispData;
	}
	
	public void dispFnd() {
		fnd.dispFnd();
	}
	
	public void count(int count) {
		for (int i = 0; i < count * 2; i++) {
			this.setClock(i%2);
			if(i%2 == 0) {
				this.setInput();
				this.fndInput();
				this.dispFnd();				
			}
		}
	}
}