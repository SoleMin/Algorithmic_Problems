import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = input.nextInt();
		for(int r=0; r<repeat; r++) {
			int day = input.nextInt();
			boolean[] days = new boolean[day+1];
			
			int n = input.nextInt();
			for(int i=0; i<n; i++) {
				int h = input.nextInt();
				for(int j=1; j*h<=day; j++)
					days[j*h] = true;
			}
			for(int i=1; i*7<=day; i++)
				days[i*7] = false;
			for(int i=1; i*7-1<=day; i++)
				days[i*7-1] = false;
			
			int count = 0;
			for(int i=1; i<=day; i++)
				if(days[i])
					count++;
			System.out.println(count);
		}
		input.close();
	}
}