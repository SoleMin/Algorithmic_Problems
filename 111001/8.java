import java.util.Scanner;

public class Main {

	static int n;
	static int[] check;
	static double[][] dot;
	static double[] minval;
	static double result;

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int t=input.nextInt();

		for(int i=0; i<t; i++) {
			n=input.nextInt();
			dot = new double[n][2];
			check=new int[n];
			minval=new double[n];

			for(int j=0; j<n; j++) {
				dot[j][0]= input.nextDouble();
				dot[j][1]= input.nextDouble();
			}

			solve();

			if(i>0)
				System.out.println();
			System.out.printf("%.2f\n",result);
		}

		input.close();

	}

	public static void solve() {
		result=0;
		check[0] = 1;
		for (int i = 1; i < n; i++) {
			minval[i] = dist(0, i);
		}

		for (int i = 0; i < n - 1; i++) {
			int minnum =0;
			boolean start=true;
			for (int j = 1; j <n; j++) {
				if (check[j]==0 &&(start || minval[minnum]>minval[j])) {
					minnum=j;
					start=false;
				}
			}

			result+=minval[minnum];
			check[minnum]=1;

			for(int j=1; j<n; j++) {
				if(check[j]==0 && minval[j]>dist(minnum, j)) {
					minval[j]=dist(minnum, j);
				}
			}

		}
	}


	public static double dist(int a, int b) {
		return Math.sqrt(Math.pow(dot[a][0]-dot[b][0], 2) + Math.pow(dot[a][1]-dot[b][1], 2));
	}

}
