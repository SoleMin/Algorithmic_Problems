import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n; int pre; int cur; int dif; boolean end; int checker; long li; String wa;
		while(scan.hasNextInt())
		{
			checker = 0;
			end = true;
			
			n = scan.nextInt();
			pre = scan.nextInt();
			for(int i = 0; i < n-1; i++)
			{
				cur = scan.nextInt();
				dif = Math.abs(pre - cur);
				if((checker & (1<<dif)) > 0) {
					end = false;
					break;
				}
				checker |= (1<<dif);
				pre = cur;
			}
			li = (long)Math.pow(2, n) - 1;
			if(((checker & 1) == 1) || (checker > li) || ((checker & (~0)) >= li)) end = false;

			if(end) System.out.println("Jolly");
			else System.out.println("Not jolly");
			wa = scan.nextLine();
		}
	}
}