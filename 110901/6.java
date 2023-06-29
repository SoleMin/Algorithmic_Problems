import java.util.*;

class Main {
	static int n;
	static int[] color = new int[200];
	static int[][] graph = new int[200][200];
	static boolean colorable;
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextLine()) {
			String str1 = input.nextLine();
			if(str1.equals("0")) break;
				
			String str2 = input.nextLine();
			n = Integer.parseInt(str1);
			int l = Integer.parseInt(str2);
				
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					graph[i][j] = 0;
			
			for(int i=0; i<l; i++) {
				String[] arr = input.nextLine().split(" ");
				int a = Integer.parseInt(arr[0]);
				int b = Integer.parseInt(arr[1]);
				graph[a][b] = 1;
				graph[b][a] = 1;
			}
			
			for(int i=0; i<n; i++)
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
		color[node] = c;
		for(int i=0; i<n && colorable; i++) {
			if(graph[node][i] == 0) continue;
			if(color[i] == 0)
				dfs(i, (c%2)+1);
			else {
				if(color[i] == c) {
					colorable = false;
					return;
				}
			}
		}
	}
}