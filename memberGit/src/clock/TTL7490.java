package clock;

public class TTL7490 { // 0,1을 반복 입력받아 0~9를 2진수로 바꿔 자릿수 역순 배열로 output
	int num;
	int[] output = new int[4];
	int oldclock;
	
	TTL7490() {
		oldclock = 0;
		reset(1, 0, 0);
	}
	
	TTL7490(int R0, int R1, int R2) {
		oldclock = 0;
		reset(R0, R1, R2);
	}
	
	private void cnvt() { // 2진수 컨버팅
		int n = num;
		for (int i = 0; i < 4; i++) {
			output[i] = n%2;
			n = (int)(n/2);
		}
	}
	
	public void setClock(int clk) { // 0,1 을 반복적으로 clk 에 넣어줘서 num 증가 & 2진수 컨버팅
		if(clk == 0 && oldclock == 1) {
			if(++num == 10) {
				num = 0;
			}
			
			cnvt();
		}
		oldclock = clk;
	}

	public void reset(int R0, int R1, int R2) {
		if(R0 == 1) num = 0;
		else if(R1 == 1) num = 1;
		else if(R2 == 1) num = 2;
		
		cnvt();		
	}
	
	public int[] getOutput() {
		return output;
	}

}
