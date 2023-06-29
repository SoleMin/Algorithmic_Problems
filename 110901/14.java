import java.util.Scanner;

public class Main {

	static final int SMAX = 200;
	static int[][] graph = new int[SMAX][SMAX];
	static int[] color = new int[SMAX];
	static boolean colorable;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		
		while(input(sc)) {
			for(i=0; i < n; i++)
				color[i] = 0;
			
			colorable = true;
			
			dfs(0, 1);
			
			if(colorable)
				System.out.println("BICOLORABLE.");
			else
				System.out.println("NOT BICOLORABLE.");
		}
		sc.close();
	}
	
	static void dfs(int node, int c) {
		int i;
		
		color[node] = c;
		for(i=0; i < n && colorable; i++) {
			if(graph[node][i] == 0) continue;
			
			if(color[i] == 0)
				dfs(i, c%2 + 1);
			else
				if(color[i] == c) {
					colorable = false;
					return;
				}
		}
		
	}
	
	static boolean input(Scanner sc) {
		int i, j, l, a, b;
		
		n = sc.nextInt();
		if(n==0) 
			return false;
		
		for(i=0; i < n; i++)
			for(j=0; j < n; j++)
				graph[i][j] = 0;
		l = sc.nextInt();
		
		for(i=0; i < l; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			
			graph[a][b] = graph[b][a] = 1;
		}
		
		return true;
	}
}
