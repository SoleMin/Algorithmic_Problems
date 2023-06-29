import java.util.*;
class Main {
	
	static int[][] graph = new int[200][200];
	static int[] color = new int[200];
	static int n;
	static boolean colorable;
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int i, j, l, a, b;
		
		while(true) {
			n = input.nextInt();
			if(n == 0) break;
			
			for (i = 0; i < n; i++)
				for (j = 0; j < n; j++)
					graph[i][j] = 0;
			
			l = input.nextInt();
			for(i = 0; i < l; i++) {
				a = input.nextInt();
				b = input.nextInt();
				graph[a][b] = graph[b][a] = 1;
			}
			
			for(i = 0; i < n; i++) 
				color[i] = 0;
			colorable = true;
			
			dfs(0, 1);
			if(colorable)
				System.out.println("BICOLORABLE.");
			else
				System.out.println("NOT BICOLORABLE.");
		}
	}
	
	static void dfs(int node, int c) {
		int i;
		
		color[node] = c;
		for(i = 0; i < n && colorable; i++) {
			if(graph[node][i] == 0) continue;
			
			if(color[i] == 0)
				dfs(i, c % 2+1);
			else {
				if(color[i] == c) {
					colorable = false;
					return;
				}
			}
		}
	}
	
}