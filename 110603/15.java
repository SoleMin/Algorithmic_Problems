import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		int size = 400;
		int[][] gustavo = new int[1001][size];
		gustavo[0][0] = 1;
		gustavo[1][0] = 2;
		gustavo[2][0] = 5;
		for(int i=3; i<1001; i++) {
			add(gustavo[i], gustavo[i-1], gustavo[i-1]);
			add(gustavo[i], gustavo[i], gustavo[i-2]);
			add(gustavo[i], gustavo[i], gustavo[i-3]);
		}
		
		Scanner input = new Scanner(System.in);
		int n;
		while(input.hasNextLine()) {
			n = Integer.parseInt(input.nextLine());
			boolean print = false;
			for(int i = gustavo[n].length-1; i >= 0; i--) {
				if(!print) {
					if(gustavo[n][i] != 0) {
						print = true;
						System.out.print(gustavo[n][i]);
					}
				}	
				else {
					String s = gustavo[n][i] + "";
					int zero = 8 - s.length();
					for(int j=0; j<zero; j++) 
						s = "0" + s;
					System.out.print(s);
				}
			}
			System.out.println();
		}
		input.close();
	}
	
	public static void add(int[] result, int[] n1, int[] n2) {
		int carry=0, sum;
		for(int i=0; i<n1.length; i++) {
			sum = n1[i] + n2[i] + carry;
			if(sum > 99999999) {
				result[i] = sum - 100000000;
				carry = 1;
			}
			else {
				result[i] = sum;
				carry = 0;
			}
		}

		if(carry == 1)	// 오버플로우 검사
			result[result.length - 1] = -1;
	}

	// 왼쪽이 크면 1, 오른쪽이 크면 -1.
	public static int compare(int[] n1, int[] n2) {
		for(int i=n1.length-1; i>=0; i--) {
			if(n1[i] > n2[i])
				return 1;
			else if(n1[i] < n2[i])
				return -1;
		}
		return 0;
	}
}