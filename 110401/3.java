import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());

		for(int r=0; r<repeat; r++) {
			String[] s = input.nextLine().split("\\s+");
			int n = Integer.parseInt(s[0]);

			int[] data = new int[n];
			for(int i=0; i<n; i++)
				data[i] = Integer.parseInt(s[i+1]);

			Arrays.sort(data);
			
			

			int sum = 0;
			int min = data[n/2];
			for(int m : data)
				sum += Math.abs(m - min);

			System.out.println(sum);
		}
		input.close();
	}
}