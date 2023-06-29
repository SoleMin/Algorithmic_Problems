import java.io.*;
import java.util.Scanner;
import java.lang.Math;

class Main {
	static int num;
	static boolean check[] = new boolean[100];
	static double [][]position = new double[100][2];
	static double[] minval = new double[100];

	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		for (int i=0; i<n; i++) {
			String grabage = input.nextLine();
			num = Integer.parseInt(input.nextLine());
			for (int j =0;  j<num; j++) {
				String[] temp = input.nextLine().split(" ");
				position[j][0] = Double.valueOf(temp[0]);
				position[j][1] = Double.valueOf(temp[1]);
			}
			double result = solve();
			if (i > 0)
				System.out.println("");
			System.out.printf("%.2f\n", result);
		}
	}
	
	public static double solve() {
		
		double result;
		
		
		result = 0.0;
		for (int i = 0; i < num; i++) {
		check[i] = false;
		}
		check[0] = true;
		for (int i = 1; i < num; i++) {
			minval[i] = dist(0, i);
		}
		
		int v;
		for (int i = 0; i < num ; i++) {
			v = 0;
			for(int j =0; j<num; j++) {
				if(check[j] == true) {
					continue;
				}
				if(v==0 || (check[j] ==  false)&&(minval[j] < minval[v])) {
					v = j;
				}
			}

			check[v] = true;
			result += minval[v];
			for(int p =0; p<num; p++) {
				if(check[p] == true) {
					continue;
				}
				if(minval[p] > dist(v,p)) {
					minval[p] = dist(v,p);
				}
			}
			
		}
		return result;
	}
	
	public static double dist(int a, int b) {
		return Math.sqrt(Math.pow(position[a][0] - position[b][0], 2) + Math.pow(position[a][1] - position[b][1], 2));
	}
	
}