import java.util.*;
class Main {
	
	static int n, carlength, carlengthsum, max, top, MAXL = 100;
	static int[][][] from = new int[MAXL * 2 + 1][MAXL * 100 + 1][2];
	static int[][] dynamic = new int[MAXL * 100 + 1][2];
	
	public static void solve(int carnum) {
		int i;

		for(i = n; i >= carlength; i--) {
			if(dynamic[i - carlength][0] != -1 
					&& carlengthsum - i + carlength <= n 
					&& dynamic[i][0] < carnum) {
				dynamic[i][0] = carnum;
				dynamic[i][1] = carlengthsum - i + carlength;
				from[carnum][i][0] = dynamic[i - carlength][0];
				from[carnum][i][1] = carlength;
				if(dynamic[max][0] < dynamic[i][0] 
						|| (dynamic[max][0] == dynamic[i][0] 
							&& Math.abs(max - dynamic[max][1]) > Math.abs(i - dynamic[i][1])))
					max = i;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int i, j, t;
	
		t = input.nextInt();
		for(i = 0; i < t; i++) {
			n = input.nextInt();
			n *= 100;
			for(j = 0; j <= n; j++) {
				dynamic[j][0] = -1;
				dynamic[j][1] = 0;
			}
			
			dynamic[0][0] = 0;
			carlengthsum = 0;
			max = 0;
			
			j = 0;
			carlength = input.nextInt();
			while(carlength != 0) {
				if(carlengthsum <= 2 * n) {
					solve(j + 1);
					carlengthsum += carlength;
				}
				carlength = input.nextInt();
				j++;
			}
			
			System.out.println(dynamic[max][0]);
			if(t > 0)
				System.out.println();
		}
	}
}