import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int testCase = input.nextInt();
		
		while(testCase-- > 0) {
			int n = input.nextInt();
			
			int t[] = new int[n];
			int s[] = new int[n];
			
			for(int i = 0; i < n; i++) {
				t[i] = input.nextInt();
				s[i] = input.nextInt();
			}
			
			int result[] = new int[n];
			for(int i = 0; i < n; i++)
				result[i] = i;
			
			int temp;
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < n - i; j++) {
					if(t[result[j]] * s[result[j + 1]] > t[result[j + 1]] * s[result[j]]) {
						temp = result[j];
						result[j] = result[j + 1];
						result[j + 1] = temp;
					}
				}
			}
			
			
			for(int i = 0; i < n; i++)
				System.out.print((result[i] + 1) + " ");
			if(testCase > 0)
				System.out.println();
			System.out.println();
		}
		input.close();
	}
}