package clock;

public class TTL7446 {
	int[] output = new int[7];
	
	public void setInput(int[] input) {
		int n = 0;
		for (int i = 0; i < 4; i++) {
			n += (int)input[i] * (int)Math.pow(2,i);
		}
		cnvt(n);
	}
	
	private void cnvt(int n) {
		int[][] cnvtArr= {
				{1,1,1,1,1,1,0},
				{0,1,1,0,0,0,0},
				{1,1,0,1,1,0,1},
				{1,1,1,1,0,0,1},
				{0,1,1,0,0,1,1},
				{1,0,1,1,0,1,1},
				{1,0,1,1,1,1,1},
				{1,1,1,0,0,1,0},
				{1,1,1,1,1,1,1},
				{1,1,1,1,0,1,1}
				};
		output = cnvtArr[n];
	}
	
	public int[] getOutput() {
		return output;
	}

}
