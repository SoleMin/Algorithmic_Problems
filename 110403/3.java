import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());

		for(int r=0; r<repeat; r++) {
			input.nextLine();
			int m = Integer.parseInt(input.nextLine());
			
			int[] data = new int[m];
			for(int i=0; i<m; i++)
				data[i] = Integer.parseInt(input.nextLine());
			Arrays.sort(data);
			
			if(r>0)
				System.out.println();
			System.out.println(time(m, data));
		}
		input.close();
	}
	
	// n은 1 이상의 정수
	public static int time(int n, int[] data) {
		if(n == 1)
			return data[0];
		else if(n == 2)
			return data[1];
		else if(n == 3)
			return data[0] + data[1] + data[2];
		else
			return data[n-1] + data[0] + Math.min(2*data[1], data[n-2] + data[0]) + time(n-2, data);
	}
}