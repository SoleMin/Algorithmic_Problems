import java.util.*;

class Main {
	static int n;
	static boolean edge[];
	static double res;
	static double point[][], min[];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t, i;
		t = in.nextInt();
		while(t-->0) {
			n = in.nextInt();
			edge = new boolean[n];
			point = new double[n][2];
			min = new double[n];
			for(i=0; i<n; i++) {
				point[i][0] = in.nextDouble();
				point[i][1] = in.nextDouble();
			}
			solve();
			System.out.printf("%.2f\n", res);
			if(t>0) {
				System.out.println();
			}
		}
		in.close();
	}

	public static double dist(int x, int y) {
		return Math.sqrt(Math.pow(point[x][0]-point[y][0], 2)+Math.pow(point[x][1]-point[y][1], 2));
	}

	public static void solve() {
		int i, j, x;
		double temp;
		
		res = 0;
		for(i=0; i<n; i++) {
			edge[i] = false;
		}
		edge[0] = true;
		for(i=1; i<n; i++) {
			min[i] = dist(0, i);
		}
		for(i=0; i<n-1; i++) {
			x = -1;
			for(j=0; j<n; j++) {
				if(edge[j]) {
					continue;
				}
				if(x==-1 || min[x]>min[j]) {
					x = j;
				}
			}
			res += min[x];
			edge[x] = true;
			for(j=0; j<n; j++) {
				if(edge[j]) {
					continue;
				}
				temp = dist(x, j);
				if(min[j]>temp) {
					min[j] = temp;
				}
			}
		}
	}
}