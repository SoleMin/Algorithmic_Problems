import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt();
		int workOut, buf;
		input.nextLine();
		for (int t = 0; t < testCase; t++)
		{
			workOut = input.nextInt();
			int [] time = new int [workOut];
			int [] penalty = new int [workOut];
			int [] result = new int [workOut];
			for (int i = 0; i < workOut; i++)
			{
				time[i] = input.nextInt();
				penalty[i] = input.nextInt();
				result[i] = i;
			}
			for (int i = 1; i < workOut; i++)
				for (int j = 0; j < workOut - 1; j++)
					if(time[result[j]] * penalty[result[j+1]] > time[result[j+1]] * penalty[result[j]])
					{
						buf = result[j];
						result[j] = result[j+1];
						result[j+1] =buf;
					}
			
			if (t > 0)
				System.out.println();
			for (int i =0 ; i < workOut -1; i++)
				System.out.print((result [i] +1) + " ");
			System.out.println((result[workOut-1]) + 1);
		}

	}
}