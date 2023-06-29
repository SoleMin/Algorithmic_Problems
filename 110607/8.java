import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(true) {
			int n = Integer.parseInt(input.nextLine());
			if(n == 0)
				break;
			else if(n == 1) {
				System.out.println(1);
				continue;
			}
			else if(n==2 || n==3) {
				System.out.println(2);
				continue;
			}
			
			int[] f = new int[700000];
			f[1] = 1; f[2] = 3;
			int result;
			int i = 2;
			for(result = 3; result<f.length; result++) {
				for(; i<=result; i++)
					if(f[i] >= result) 
						break;
				f[result] = f[result-1] + i;
				if(f[result] >= n) {
					System.out.println(result);
					break;
				}
			}
		}
		input.close();
	}
}