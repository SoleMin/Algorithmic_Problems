import java.util.*;
import java.io.*;
public class E1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//optimizaciones que parece que solo son necesarias para java
		ArrayList<Integer>[] reps = new ArrayList[13]; //representantes de las clases
		int[][] index = new int[13][]; // mapea para cada representante un indice de 0 a |clases|-1
		int[][] eqcl = new int[13][]; //mapea para cada mask, su clase
		ArrayList<Integer>[][] nexts = new ArrayList[13][];	//para cada clase, los masks compatibles
		for(int n = 1; n <= 12; n++) {
			eqcl[n] = new int[(1 << n)];
			reps[n] = new ArrayList<Integer>();
			index[n] = new int[(1 << n)];
			int ind = 0;
			for(int mask = 0; mask < (1 << n); mask++) {
				boolean add = true;
				for(int k = 0; k < n; k++) {
					if(rot(mask, k, n) < mask) add = false;
				}
				if(add) {
					reps[n].add(mask);
					index[n][mask] = ind; ind++;
				}
			}
			nexts[n] = new ArrayList[reps[n].size()];
			for(int i = 0; i < reps[n].size(); i++) {
				int mask = reps[n].get(i);
				for(int k = 0; k < n; k++) {
					eqcl[n][rot(mask, k, n)] = i;
				}
				nexts[n][i] = new ArrayList<>();
				for(int y = 0; y < (1 << n); y++) {
					if((mask & y) == 0) {
						nexts[n][i].add(y);
					}
				}
			}
		}
		int T = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int test = 0; test < T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[][] arrt = new int[m][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					arrt[j][i] = Integer.parseInt(st.nextToken());
				}
			}
			Column[] cols = new Column[m];
			for(int j = 0; j < m; j++) {
				cols[j] = new Column(arrt[j]);
			}
			Arrays.sort(cols, Collections.reverseOrder());
			m = Integer.min(n, m);
			int[][] arr = new int[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					arr[i][j] = cols[j].arr[i];
				}
			}
			int[][] max = new int[m][reps[n].size()];
			for(int c = 0; c < m; c++) {
				for(int mask = 0; mask < (1 << n); mask++) {
					int curr = 0;
					for(int i = 0; i < n; i++) {
						if((mask & (1 << i)) > 0) curr += arr[i][c];
					}
					int cl = eqcl[n][mask];
					max[c][cl] = Integer.max(max[c][cl], curr);
				}
			}
			int[][] dp = new int[m+1][reps[n].size()];
			for(int c = 0; c < m; c++) {
				for(int i = 0; i < reps[n].size(); i++) {
					int mask = reps[n].get(i);
					for(int next: nexts[n][i]) { //opt
						int cl = eqcl[n][next];
						int dl = eqcl[n][mask | next];
						if(dp[c][i] + max[c][cl] > dp[c+1][dl]) { // el dp
							dp[c+1][dl] = dp[c][i] + max[c][cl]; 
						}
					}
				}
			}
			bw.write(dp[m][reps[n].size() - 1]+"\n");
		}
		bw.flush();
	}
	static int rot(int x, int k, int n) {
		int a = x << k;
		int b = x >> (n - k);
		return (a + b) & ((1 << n) - 1);
	}
	static class Column implements Comparable<Column>{
		int[] arr;
		int max;
		public Column(int[] arr) {
			this.arr = arr;
			max = 0;
			for(int k: arr) {
				max = Integer.max(max, k);
			}
		}
		@Override
		public int compareTo(Column col) {
			return max - col.max;
		}
	}
}
