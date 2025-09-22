package clock;

public class newFND {
	boolean[][] dispData = new boolean[5][5];
	
	public void setInput(int[] data) {
		this.reset();

		if(data[0] == 1) for(int i = 0; i < 5; i++) dispData[0][i] = true;
		if(data[1] == 1) for(int i = 0; i < 3; i++) dispData[i][4] = true; 
		if(data[2] == 1) for(int i = 0; i < 3; i++) dispData[2+i][4] = true;
		if(data[3] == 1) for(int i = 0; i < 5; i++) dispData[4][i] = true;
		if(data[4] == 1) for(int i = 0; i < 3; i++) dispData[2+i][0] = true;
		if(data[5] == 1) for(int i = 0; i < 3; i++) dispData[i][0] = true;
		if(data[6] == 1) for(int i = 0; i < 5; i++) dispData[2][i] = true;
	}
	
	public void dispFnd() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (dispData[i][j]) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private void reset() {
		for (int i = 0; i < 5; i++) {for (int j = 0; j < 5; j++) {dispData[i][j] = false;}}
	}

}
