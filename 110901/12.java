import java.util.*;
import java.io.*;

class Main {
	static int n;
	static int [][] graph = new int [200][200];
	static int [] color = new int [200];
	static int colorable;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		while (true) {
			if (n == 0) break;
			
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j < n; j++) {
					graph[i][j] = 0;
				}
			}
			int l = sc.nextInt();
			
			for (int i = 0; i < l; i ++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				graph[a][b] = graph[b][a] = 1;
				
			}
				for (int i = 0; i < n; i++)
					color[i] = 0;
				
				colorable = 1;
				dfs(0, 1);
				
				if (colorable == 0)
					System.out.println("NOT BICOLORABLE.");
				else
					System.out.println("BICOLORABLE.");
				n = sc.nextInt();
		}	
	}
	
	public static void dfs(int node, int c) {
			color[node] = c;
			for (int i = 0; i < n && colorable == 1; i++) {
				if (graph[node][i] == 0) continue;
				if (color[i] == 0)
					dfs(i, c%2 + 1);
				else {
					if (color[i] == c) {
						colorable = 0;
						return;
					}
				}
			}
		}
}