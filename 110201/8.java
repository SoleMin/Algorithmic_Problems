import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		final int  MAX_N = 3000;
		
		int[] present = new int[MAX_N];
		
		int n, i, prev, curr, diff;
		boolean jolly;
	
		while(sc.hasNextInt())
		{			
			n = sc.nextInt();
			jolly = true;
			for(i = 1; i < n; i++)
				present[i] = 0;
			
			prev = sc.nextInt();
			for(i = 1; i < n; i++)
			{
				curr = sc.nextInt();
				diff = Math.abs(curr - prev);
				if(diff <= 0 || diff >= n || present[diff] == 1)
				{					
					jolly = false;
					break;
				}
				present[diff] = 1;
				prev = curr;
			}
			sc.nextLine();
			System.out.println(jolly ? "Jolly" : "Not jolly");
		}		
		
		sc.close();
	}
	
}