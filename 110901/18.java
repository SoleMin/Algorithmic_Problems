import java.io.*;
import java.util.Scanner;
import java.util.stream.Stream;
/**배열로 그래프 표현 해야 하는듯**/
/**0과 1로만 **/


class Main {
	static int vertex;
	static int edge;
	static int[][] graph = new int[200][200];
	static boolean colorable;
	static int[] color = new int[200];
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(input.hasNext()) {
			String s = input.nextLine();
			if(s.equals("0")) {
				break;
			}
			edge = Integer.parseInt(s);
			vertex = Integer.parseInt(input.nextLine());
			
			for (int h = 0; h < edge; h++) {
			for (int t = 0; t < edge; t++) {
					graph[h][t] = 0;
			  }
			}
			
			for(int i = 0 ; i<vertex; i++) {
				int[] ver = Stream.of(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				graph[ver[0]][ver[1]]= 1;
				graph[ver[1]][ver[0]] = 1;
			}
			
			for (int j = 0; j < edge; j++)
				color[j] = 0;

			colorable = true;
			dfs(0, 1);
			if (colorable == false)
				System.out.println("NOT BICOLORABLE.");
			else
				System.out.println("BICOLORABLE.");
		}
	}
	
	public static void dfs(int node, int c) {
	
			
		color[node] = c;
		for (int i = 0; (i < edge) && (colorable); i++) {
			if (graph[node][i] == 0) continue;
			if (color[i] == 0)
				dfs(i, c%2 + 1);
			else {
				if (color[i] == c)
				{
					colorable = false;
					return;
				}
			}
		}

	}
}