package clock;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class newMain {
	public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
		System.out.println(now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
//		MergeClass minute0 = new MergeClass();
//		MergeClass minute1 = new MergeClass();
//		MergeClass hour0 = new MergeClass();
//		MergeClass hour1 = new MergeClass();
//		
//		Scanner s = new Scanner(System.in);
//		
//		int m0 = s.nextInt();
//		int h0 = s.nextInt();
//		
//		while() {
////			1초 재는 로직
//			Thread.sleep(null);
//			
//			if(t/60 == 0 )
//			{
//				
//			}
//			
//			if(t/3600 ==0 )
//			{
//				
//			}
//		}
//		
//		for (int i = 0; i < m0; i++) minute0.count();
//		for (int i = 0; i < m1; i++) minute1.count();
//		for (int i = 0; i < h0; i++) hour0.count();
//		for (int i = 0; i < h1; i++) hour1.count();
		
	}

}
