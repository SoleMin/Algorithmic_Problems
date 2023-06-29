import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n, a, b, diff;
		while(input.hasNextLine()) {
			String s = input.nextLine();
			Scanner cutter = new Scanner(s);
			n = cutter.nextInt();
			
			boolean[] differ = new boolean[n];
			boolean jolly = true;
			a = cutter.nextInt();
			
			for(int i=1; i<n; i++) {
				b = cutter.nextInt();
				diff = Math.abs(a - b);
				if(diff==0 || diff>=n) {
					jolly = false;
					break;
				}
				
				if(differ[diff] == true) {
					jolly = false;
					break;
				}
				else
					differ[diff] = true;
				
				a = b;
			}
			
			cutter.close();
			if(jolly)
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
		}
	}
}