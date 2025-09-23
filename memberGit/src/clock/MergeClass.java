package clock;

public class MergeClass {
	private TTL7490 ttl7490d;
	private TTL7490 ttl7490c;
	private TTL7490 ttl7490b;
	private TTL7490 ttl7490a;
	private TTL7446 ttl7446 = new TTL7446();
	private newFND fnd = new newFND();
	int[][] output7490 = new int[4][4];
	int[][] output7446 = new int[4][7];
	boolean[][] dispData = new boolean[5][25];
	
	MergeClass() { // ttl7490.output 형태는 {A, B, C, D}
		this.dispReset();
		ttl7490d = new TTL7490();
		this.output7490[3] = ttl7490d.output;
		ttl7490c = new TTL7490();
		this.output7490[2] = ttl7490c.output;
		ttl7490b = new TTL7490();
		this.output7490[1] = ttl7490b.output;
		ttl7490a = new TTL7490();
		this.output7490[0] = ttl7490a.output;
	}
	
//	MergeClass(int R0, int R1, int R2) {
//		this.reset();
//		ttl7490d = new TTL7490(R0, R1, R2);
//		this.output7490[3] = ttl7490d.output;
//	}
	
	public void setClock(int clk) {
		ttl7490d.setClock(clk);
		ttl7490c.setClock(this.output7490[3][3]); // D 값을 clk 로 넘겨주는 트릭
		System.out.println(ttl7490c.num);
		if (ttl7490c.output[1] == 1 && ttl7490c.output[2] == 1) {
			ttl7490c.reset(1, 0, 0);
			ttl7490b.setClock(1);
//			ttl7490c.num = 9;
//			ttl7490c.setClock(1);
//			ttl7490c.setClock(0);
		}
		ttl7490b.setClock(this.output7490[2][3]);
		ttl7490a.setClock(this.output7490[1][3]);
		if (ttl7490b.num == 2 && ttl7490a.num == 1) {
			System.out.println("ooo");
			ttl7490b.reset(1,0,0);
			ttl7490a.reset(1,0,0);
			ttl7490d.setClock(1);
//			ttl7490b.num = 9;
//			ttl7490b.setClock(1);
//			ttl7490b.setClock(0);
//			ttl7490a.num = 9;
//			ttl7490a.setClock(1);
//			ttl7490a.setClock(0);
		}
	}
	
	private void setInput() {
		ttl7446.setInput(this.output7490[3]);
		this.output7446[3] = ttl7446.output;
		ttl7446.setInput(this.output7490[2]);
		this.output7446[2] = ttl7446.output;
		ttl7446.setInput(this.output7490[1]);
		this.output7446[1] = ttl7446.output;
		ttl7446.setInput(this.output7490[0]);
		this.output7446[0] = ttl7446.output;
	}
	
	private void fndInput() {
		fnd.setInput(output7446[3]);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.dispData[i][j+20] = fnd.dispData[i][j];				
			}
		}
		fnd.setInput(output7446[2]);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.dispData[i][j+14] = fnd.dispData[i][j];				
			}
		}
		fnd.setInput(output7446[1]);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.dispData[i][j+6] = fnd.dispData[i][j];				
			}
		}
		fnd.setInput(output7446[0]);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.dispData[i][j] = fnd.dispData[i][j];				
			}
		}
	}
	
	public void count() {
		this.setInput();
		this.fndInput();
		this.dispFnd();	
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
	
	private void dispReset() { // 00:00 디스플레이 초기화
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