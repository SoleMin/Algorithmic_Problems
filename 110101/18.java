import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int max = 0; 
		int count; long k;
		
		while(scan.hasNextInt())
		{
			int start = scan.nextInt();
			int end = scan.nextInt();
			int i = start;
			int j = end;
			if(j < i)
			{
				int dump = j;
				j = i;
				i = dump;
			}
			
			max = 0;
			for(int n = i; n <= j; n++)
			{
				k = n;
				count = 1;
				while(k > 1)
				{
					if(k%2 !=  0)
					{
						k = k*3 + 1;
						count++;
					}
					while(k%2 == 0)
					{
						k >>= 1;
						count++;
					}
				}
				if(count > max) max = count;
			}
			System.out.println(start + " " + end + " " + max);
		}
		
		scan.close();
	}
}