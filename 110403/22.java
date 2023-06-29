import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		// String casetemp = input.nextLine();
		// int cases = Integer.parseInt(casetemp);
		int cases = input.nextInt();
		// int count;
		// int [] time;
		
		// input.nextLine();
		
		for (int i = 0; i < cases; i++){
// 			count = 0;
// 			temparray = new int [1000];
			
// 			input.nextLine();
// 			while (input.hasNextLine()) {
// 				String temp = input.nextLine();
// 				if (temp.equals(""))
// 					break;
// 				temparray[count] = Integer.parseInt(temp);
// 				count++;
// 			}
			
// 		//	System.out.println("count : " + count);
			
// 			time = new int [count];
			
// 			for (int j = 0; j < count; j++) {
// 				time[j] = temparray[j];
// 			}
// 			count--;
			
			int count = input.nextInt();
			
			int [] time = new int[count];
			
			for (int j = 0; j < count; j++){
				time[j] = input.nextInt();
			}
			
			Arrays.sort(time);
			
			 
			int sum1 = 0, sum2 = 0;
			int sum = 0;
			
			if (count == 1) {
				System.out.println(time[0]);
			}
			
			else if (count == 2) {
				System.out.println(time[1]);
			}
			
			
			else if(count % 2 != 0) {
				for (int j = count - 1; j > 2; j -= 2){
					sum1 = 0; sum2 = 0;
					
					// System.out.println("홀수 count" + count);
					
					sum1 += time[1];
					sum1 += time[0];
					sum1 += time[j];
					sum1 += time[1];
					
					
					sum2 += time[j];
					sum2 += time[0];
					sum2 += time[j - 1];
					sum2 += time[0];
					
					if (sum1 < sum2)
						sum += sum1;
					else
						sum += sum2;
					
				}
				
				sum += time[0];
				sum += time[1];
				sum += time[2];
			}
			
			else {
				for (int j = count - 1; j > 1; j -= 2) {
					
					sum1 = 0; sum2 = 0;
					
					sum1 += time[1];
					sum1 += time[0];
					sum1 += time[j];
					sum1 += time[1];
					
					sum2 += time[j];
					sum2 += time[0];
					sum2 += time[j - 1];
					sum2 += time[0];
					
					// System.out.println(sum1 + " , " + sum2);
					if (sum1 < sum2)
						sum += sum1;
					else
						sum += sum2;
					
				}
				
				sum += time[1];
			}
			
			
			System.out.println(sum);
			
			
			
			
// 			else if (count % 2 == 1) {
				
// 			}
			
			System.out.println();
			
		}
	}
	
	
	
}