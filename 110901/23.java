import java.util.*;

public class Main {

	static int MAXN = 200;

	static int N;
	static int graph[][] = new int[MAXN][MAXN];
	static int color[] = new int[MAXN];
	static boolean colorable;
	static Scanner scanner = new Scanner(System.in);
	
	public static boolean input() {

		
		 N = scanner.nextInt();
		if(N == 0) 
		{return false;}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				graph[i][j] = 0;
			}
		}
		int length = scanner.nextInt();

		for(int i = 0; i < length; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			graph[a][b] =graph[b][a] = 1;

		}
		return true;

	}

	public static void dfs(int node, int c) {

		int i;

		color[node] = c;
		for(i = 0; i < N && colorable; i++) {
			if(graph[node][i] == 0) continue;

			if(color[i] == 0) {
				dfs(i, c%2 +1); 
			}
			else {
				if (color[i] == c) {
					colorable = false;
					return;
				}
			}
		}

	}



	public static void main(String[] args) throws Exception {
		
		int i;

		while(input()) {
			for(i=0; i < N; i++) {
				color[i] = 0;

			}
			colorable = true;


			dfs(0,1);

			if(colorable == false) {
				System.out.println("NOT BICOLORABLE.");
			}
			else {
				System.out.println("BICOLORABLE.");
			}
		}
	}
}

