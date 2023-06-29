import java.io.*;
import java.util.*;

class Main {
	static int n, carlength, carlengthsum, max, top;
	static int [][] dynamic = new int [100 * 100 + 1][2];
	static int [][][] from = new int [100 * 2 + 1][100 * 100 + 1][2];
	static int [] stack = new int [100 * 2];
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			n *= 100;
			for (int j = 0; j <= n; j++) {
				dynamic[j][0] = -1;
				dynamic[j][1] = 0;
			}
			dynamic[0][0] = 0;
			carlengthsum = 0;
			max = 0;
			int cnt = 0;
			while (true) {
				cnt++;
				carlength = sc.nextInt();
				if (carlength == 0) break;
				if (carlength <= 2 * n) {
					solve(cnt);
					carlengthsum += carlength;
				}
			}
			output(i);
		}
	}
	
	public static void solve (int carnum) {
		for (int i = n; i >= carlength; i--) {
			if (dynamic[i - carlength][0] != -1 && carlengthsum - i + carlength <= n &&
					dynamic[i][0] < carnum) {
				dynamic[i][0] = carnum;
				dynamic[i][1] = carlengthsum - i + carlength;
				from[carnum][i][0] = dynamic[i - carlength][0];
				from[carnum][i][1] = carlength;
				if (dynamic[max][0] < dynamic[i][0] || (dynamic[max][0] == dynamic[i][0] &&
						Math.abs(max - dynamic[max][1]) > Math.abs(i - dynamic[i][1])))
					max = i;
			}
		}
	}
	
	public static void output (int t) {
		
		int k = top = 0;
		for (int i = dynamic[max][0], j = max; i > 0; j -= from[i][k][1], i = from[i][k][0]) {
			stack[top++] = 1;
			for (k = i - 1; k > from[i][j][0]; k--)
				stack[top++] = 0;
			k = j;
		}
	
		if (t > 0) System.out.println();
		System.out.println(dynamic[max][0]);
	/*	
		for (int i = top - 1; i >= 0; i--) {
			if (stack[i] != 0) System.out.println("port");
			else System.out.println("startboard");
		}*/
		
	}
	
	
}