package clock;

public class TTL7490 {
	int num;
	int[] output = new int[4];
	int oldclock;
	int minutecount;
	int hourcount;
	
	TTL7490() {
		oldclock = 0;
		reset(1, 0, 0);
	}
	
	TTL7490(int R0, int R1, int R2) {
		oldclock = 0;
		reset(R0, R1, R2);
	}
	
	private void cnvt() {
		int n = num;
		for (int i = 0; i < 4; i++) {
			output[i] = n%2;
			n = (int)(n/2);
		}
	}
	
	public void setClock(int clk) {
		if(clk == 0 && oldclock == 1) {
			if(++num == 10) {
				if(++minutecount == 60) {
					if(++hourcount == 24) {
						hourcount = 0;
					}
					minutecount = 0;
				}
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
