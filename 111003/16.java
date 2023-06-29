import java.io.*;
import java.util.*;

public class Main {

	static final int INF = 99999999;

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		int casenum = scan.nextInt();
		scan.nextLine();
		while (casenum-- > 0) {
			int N = 0;
			int f = scan.nextInt();
			int n = scan.nextInt();
			int exi[] = new int[n];
			for (int w = 0; w < f; w++) {
				exi[scan.nextInt()-1] = 1;
			}
			int[][] D = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(i == j) {
						D[i][j] = 0;	
					} else {
						D[i][j] = INF;		
					}
				}
			}
			for (int p = 0; p < n; p++) {
				int a = scan.nextInt() - 1;
				int b = scan.nextInt() - 1;
				int c = scan.nextInt();
				D[a][b] = c;
				D[b][a] = c;
				N++;
			}
			for (int k = 0; k < N; k++) { 
	            for (int i = 0; i < N; i++) {  
	                if (i == k) continue; 
	                for (int j = 0; j < N; j++) { 
	                    if (j == i || j == k) continue; 
	                    D[i][j] = Math.min(D[i][k] + D[k][j], D[i][j]); 
	                }
	            }
	        }
			int[] dis = new int[n];
			Arrays.fill(dis, INF);
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(exi[j] != 0)	
						dis[i] = Math.min(dis[i], D[i][j]);
				}
			}
			int fin =0;
			int max =INF;
			for (int i = 0; i < n; i++) {
				int ind = 0;
				for (int j = 0; j < n; j++) {
					ind = Math.max(ind,Math.min(dis[j], D[i][j]));
				}
				if(ind < max) {
					max = ind;
					fin = i+1;
				}
			}
			System.out.println(fin);
			System.out.println();
			scan.nextLine();
		}
	}
}