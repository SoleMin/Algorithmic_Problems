import java.util.*;
class Main {
	
	static Scanner input = new Scanner(System.in);
	static int MAXN = 100;
	static double[][] dot = new double[MAXN][2];
	static double[] minval = new double[MAXN];
	static double result;
	static int[] check = new int[MAXN];
	static int n;
	
	public static void input() {
		int i;
		
		n = input.nextInt();
		for(i = 0; i < n; i++) {
			dot[i][0] = input.nextDouble();
			dot[i][1] = input.nextDouble();
		}
	}
	
	public static double dist(int a, int b) {
		return Math.sqrt(Math.pow(dot[a][0] - dot[b][0], 2) + Math.pow(dot[a][1] - dot[b][1], 2));
	}
	
	public static void solve() {
		int i, j, a;
		
		result = 0;
		for(i = 0; i < n; i++) 
			check[i] = 0;
		
		check[0] = 1;
		for(i = 1; i < n; i++)
			minval[i] = dist(0, i);
		
		for(i = 0; i < n-1; i++) {
			a = -1;
			for(j = 0; j < n; j++) {
				if(check[j] == 1) 
					continue;
				if(a == -1 || minval[a] > minval[j])
					a = j;
			}
			
			result += minval[a];
			check[a] = 1;
			for(j = 0; j < n; j++) {
				if(check[j] == 1)
					continue;
				if(minval[j] > dist(a, j))
					minval[j] = dist(a, j);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		int i, t;
		
		t = input.nextInt();
		for(i = 0; i < t; i++) {
			input();
			solve();
			if(i > 0)
				System.out.println();
			System.out.printf("%.2f\n", result);
		}
	}
}