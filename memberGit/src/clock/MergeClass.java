package clock;

public class MergeClass { // 나머지 클래스 다 합쳐서 MergeClass만 불러서 사용할 수 있게 만듬
	private TTL7490 ttl7490f;
	private TTL7490 ttl7490e;
	private TTL7490 ttl7490d;
	private TTL7490 ttl7490c;
	private TTL7490 ttl7490b;
	private TTL7490 ttl7490a;
	private TTL7446 ttl7446 = new TTL7446();
	private newFND fnd = new newFND();
	int[][] output7490 = new int[6][4];
	int[][] output7446 = new int[6][7];
	boolean[][] dispData = new boolean[5][39];
	
	MergeClass() { // ttl7490.output 형태는 {A, B, C, D}
		this.dispReset();
		ttl7490f = new TTL7490();
		this.output7490[5] = ttl7490f.output;
		ttl7490e = new TTL7490();
		this.output7490[4] = ttl7490e.output;
		ttl7490d = new TTL7490();
		this.output7490[3] = ttl7490d.output;
		ttl7490c = new TTL7490();
		this.output7490[2] = ttl7490c.output;
		ttl7490b = new TTL7490(0,1,0);
		this.output7490[1] = ttl7490b.output;
		ttl7490a = new TTL7490();
		this.output7490[0] = ttl7490a.output;
	}
	
//	MergeClass(int R0, int R1, int R2) {
//		this.reset();
//		ttl7490d = new TTL7490(R0, R1, R2);
//		this.output7490[3] = ttl7490d.output;
//	}
	
	public void setNowTime(int h0, int h1, int m0, int m1, int s0, int s1) { // int 변수들로 변환한 현재 시간을 받아와서 초기 화면에 넣어주는 메서드 (this.output7490 배열을 바꿔줌)
		ttl7490a.num = h0-1;
		ttl7490a.setClock(1);
		ttl7490a.setClock(0);
		ttl7490b.num = h1-1;
		ttl7490b.setClock(1);
		ttl7490b.setClock(0);
		ttl7490c.num = m0-1;
		ttl7490c.setClock(1);
		ttl7490c.setClock(0);
		ttl7490d.num = m1-1;
		ttl7490d.setClock(1);
		ttl7490d.setClock(0);
		ttl7490e.num = s0-1;
		ttl7490e.setClock(1);
		ttl7490e.setClock(0);
		ttl7490f.num = s1-1;
		ttl7490f.setClock(1);
		ttl7490f.setClock(0);
	}
	
	public void setClock(int clk) { // 0, 1을 반복 입력받아 시간이 흐르는 메서드
		ttl7490f.setClock(clk);
		ttl7490e.setClock(this.output7490[5][3]); // D 값을 clk 로 넘겨주는 트릭
		if (ttl7490e.output[1] == 1 && ttl7490e.output[2] == 1) {
			ttl7490e.reset(1, 0, 0);
			ttl7490d.setClock(1);
		}
		ttl7490d.setClock(this.output7490[4][3]);
		ttl7490c.setClock(this.output7490[3][3]);
		if (ttl7490c.output[1] == 1 && ttl7490c.output[2] == 1) {
			ttl7490c.reset(1, 0, 0);
			ttl7490b.setClock(1);
		}
		ttl7490b.setClock(this.output7490[2][3]);
		ttl7490a.setClock(this.output7490[1][3]);
//		System.out.println(ttl7490f.output[0]);
		if (ttl7490a.output[0] == 1 && ttl7490b.output[0] == 1 && ttl7490b.output[1] == 1) {
			ttl7490b.reset(0,1,0);
			ttl7490a.reset(1,0,0);
			ttl7490f.setClock(1);
		}
	}
	
	public void count() { // 메서드 하나만 불러서 동작할 수 있게 다 합친 메서드
		this.setInput();
		this.fndInput();
		this.dispFnd();	
	}
	
	private void setInput() { // TTL7446에 TTL7490 아웃풋 넣어서 현재 클래스 필드의 배열에 저장
		ttl7446.setInput(this.output7490[5]);
		this.output7446[5] = ttl7446.output;
		ttl7446.setInput(this.output7490[4]);
		this.output7446[4] = ttl7446.output;
		ttl7446.setInput(this.output7490[3]);
		this.output7446[3] = ttl7446.output;
		ttl7446.setInput(this.output7490[2]);
		this.output7446[2] = ttl7446.output;
		ttl7446.setInput(this.output7490[1]);
		this.output7446[1] = ttl7446.output;
		ttl7446.setInput(this.output7490[0]);
		this.output7446[0] = ttl7446.output;
	}
	
	private void fndInput() { // newFND.setInput 에 TTL7446 아웃풋 넣어서 자릿수에 따라 열이동해서 값넣기
		fnd.setInput(output7446[5]);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.dispData[i][j+34] = fnd.dispData[i][j];				
			}
		}
		fnd.setInput(output7446[4]);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				this.dispData[i][j+28] = fnd.dispData[i][j];				
			}
		}
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
	
	private void dispFnd() { // 디스플레이 출력
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 39; j++) {
				if (this.dispData[i][j]) {
					System.out.print("█");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private void dispReset() { // 00:00:00 디스플레이 초기화
		for (int i = 0; i < 5; i++) {
			if (i%2 == 1) {
				this.dispData[i][12] = true;
			}
		}
		for (int i = 0; i < 5; i++) {
			if (i%2 == 1) {
				this.dispData[i][26] = true;
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