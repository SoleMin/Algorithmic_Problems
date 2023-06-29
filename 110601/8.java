import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		while(true) {
			String[] split = input.nextLine().split("\\s+");
			if(split[0].equals("0") && split[1].equals("0"))
				break;
			
			int[] a = new int[101];
			int[] b = new int[101];
			int lengtha = split[0].length();
			int lengthb = split[1].length();
			
			if(split[0].charAt(0) != '-')
				for(int i=0; i<lengtha; i++)
					a[i] = split[0].charAt(lengtha-1-i) - 48;
			if(split[1].charAt(0) != '-')
				for(int i=0; i<lengthb; i++)
					b[i] = split[1].charAt(lengthb-1-i) - 48;
			
			int[][] fib = new int[3][101];
			fib[0][0] = 1;
			fib[1][0] = 1;
			
			int i = 1, result;
			for(; compare(fib[i%3], a) == -1; i++) {
				add(fib[(i+1)%3], fib[i%3], fib[(i-1)%3]);
			}
			result = i;
			for(; compare(fib[i%3], b) != 1; i++) {
				add(fib[(i+1)%3], fib[i%3], fib[(i-1)%3]);
			}
			result = i - result;
			System.out.println(result);
		}
		input.close();
	}
	
	public static void add(int[] result, int[] n1, int[] n2) {
		int carry=0, sum;
		for(int i=0; i<101; i++) {
			sum = n1[i] + n2[i] + carry;
			if(sum > 9) {
				result[i] = sum - 10;
				carry = 1;
			}
			else {
				result[i] = sum;
				carry = 0;
			}
		}
	}

	public static int compare(int[] n1, int[] n2) {
		for(int i=100; i>=0; i--) {
			if(n1[i] > n2[i])
				return 1;
			else if(n1[i] < n2[i])
				return -1;
		}
		return 0;
	}
}