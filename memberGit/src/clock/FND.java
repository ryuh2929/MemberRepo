package clock;

public class FND {
	int[] data = new int[7];
	
	public void setInput(int[] data) {
		this.data = data;
	}
	
	public void dispFnd() {
		if (data[0] == 1) {
			System.out.println("#####");
		} else {
			if (data[5] == 1) {
				System.out.print("#");
			} else {
				System.out.print(" ");				
			}
			System.out.print("   ");
			if (data[1] == 1) {
				System.out.println("#");
			} else {
				System.out.println(" ");
			}
		}
		if (data[5] == 1) {
			System.out.print("#  ");
		} else {
			System.out.print("   ");
		}
		if (data[1] == 1) {
			System.out.println(" #");
		} else {
			System.out.println("  ");
		}
		if (data[6] == 1) {
			System.out.println("#####");
		} else {
			if (data[4] == 1 || data[5] == 1) {
				System.out.print("#");
			} else {
				System.out.print(" ");
			}
			System.out.print("   ");
			if (data[1] == 1 || data[2] == 1) {
				System.out.println("#");
			} else {
				System.out.println(" ");
			}
		}
		if (data[4] == 1) {
			System.out.print("#  ");
		} else {
			System.out.print("   ");
		}
		if (data[2] == 1) {
			System.out.println(" #");
		} else {
			System.out.println("  ");
		}
		if (data[3] == 1) {
			System.out.println("#####");
		} else {
			if (data[4] == 1) {
				System.out.print("#");
			} else {
				System.out.print(" ");
			}
			System.out.print("   ");
			if (data[2] == 1) {
				System.out.println("#");
			} else {
				System.out.println(" ");
			}
		}
	}

}
