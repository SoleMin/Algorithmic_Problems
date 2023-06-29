import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();

		sc.hasNextLine();
		sc.hasNextLine();

		for(int l = 0; l < cases; l++)
		{
			int n = sc.nextInt();
			int[] data = new int[n];
			for(int i = 0; i < n; i++)			
				data[i] = sc.nextInt();
			Arrays.sort(data);


			int t = 0;

			while(n > 3)
			{
				int A = data[0];
				int B = data[1];
				int C = data[n-2];
				int D = data[n-1];

				if(B+A+D+B <= C+A+D+A)				
					t += B+A+D+B;			
				else				
					t += C+A+D+A;				
				
				n -= 2;
			}

			if(n == 3)
			{
				t += data[2] + data[0];
				n--;
			}
		
			t += data[n-1];		

			System.out.println(t);
			if(l < cases -1)
				System.out.println();

		}


		sc.close();
	}
}