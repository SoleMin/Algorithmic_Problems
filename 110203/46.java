import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n; int p; int i; int count; int x; int d; 
		int md;
		int[] person;
		int ts = scan.nextInt();
		while(ts-- > 0)
		{
			n = scan.nextInt();
			p = scan.nextInt();
			count = 0;
			person = new int[p];
			
			for(int j=0; j < p; j++) person[j] = scan.nextInt();
				
			d = 0;
			while(d < n)
			{
				md = (d+1) % 7;
				if(md != 0 && md != 6)
				{
					for(int z = 0; z < p; z++) {
						if((d+1)%person[z] == 0)  {
							count++;
							break;
						}
					}
				}
				d++;
			}
			
			System.out.println(count);
		}
	}
}