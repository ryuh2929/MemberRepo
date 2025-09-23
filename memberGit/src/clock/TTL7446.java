package clock;

public class TTL7446 { // 0~9를 2진수로 받아서 10진수로 변환 후 디지털 숫자 화면 불빛 on/off int[7]로 출력
	int[] output = new int[7];
	
	public void setInput(int[] input) {
		int n = 0;
		for (int i = 0; i < 4; i++) {
			n += (int)input[i] * (int)Math.pow(2,i);
		}
		cnvt(n);
	}
	
	private void cnvt(int n) { // 각 배열은 불빛 넘버링 {a,b,c,d,e,f,g}를 의미
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
