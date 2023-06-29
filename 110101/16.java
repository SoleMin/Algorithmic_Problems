import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(input.hasNextLine()) {
			String str = input.nextLine();
			String[] s = (str.split(" "));
		
			int num1 = Integer.parseInt(s[0]);
			int num2 = Integer.parseInt(s[1]);
		
			if(num1 > num2) {
				int temp = num2;
				num2 = num1;
				num1 = temp;
			}
		
			long best =0;
			long j;
			
			for(long i = num1; i<=num2; i++) {
				j = i;
				long num = 1;
				while (j != 1) {
					if((j & 1) == 1) {
						j = (j*3) +1;
						num++;
					}
					while((j & 1) == 0) {
						j >>= 1;
						num++;
					}
				}
				if(num > best) {
					best = num;
				}
			}
			System.out.println(s[0] + " " + s[1] + " " + best);
		}
	}
}