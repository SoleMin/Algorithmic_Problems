import java.util.Scanner;

public class Main {

	static int[][] graph;
	static int[] color;
	static int n, colorable;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while(true) {
			n=input.nextInt();
			if(n==0)
				break;

			graph= new int[n][n];
			color=new int[n];

			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					graph[i][j]=0;
				}
			}

			int l=input.nextInt();
			for(int i=0; i<l; i++) {
				int a=input.nextInt();
				int b=input.nextInt();

				graph[a][b]=graph[b][a]=1;
			}

			for(int i=0; i<n; i++) {
				color[i]=0;
			}

			colorable = 1;

			dfs(0,1);

			if(colorable==0)
				System.out.println("NOT BICOLORABLE.");
			else
				System.out.println("BICOLORABLE.");
		}
		
		input.close();
	}

	public static void dfs(int node, int c) {
		color[node]=c;
		for (int i = 0; i < n && colorable!=0; i++) {
			if (graph[node][i] == 0) continue;
			if (color[i] == 0)
				dfs(i, c%2 + 1);
			else {
				if (color[i] == c)
				{
					colorable = 0;
					return;
				}
			}
		}

	}

}
