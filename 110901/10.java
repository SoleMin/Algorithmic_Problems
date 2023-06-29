import java.util.*;
class Main {
	static boolean colorable = true;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while(true) {
			String vertaxsT = input.nextLine();
			
			if(vertaxsT.equals("0")) {
				break;
			}
			int num = Integer.parseInt(vertaxsT);
			String edgesT = input.nextLine();
			int edges = Integer.parseInt(edgesT);

			int[][] GraphMatrix = new int[num][num];
			for(int i=0; i<edges; i++) {
				String edgeT = input.nextLine();
				String[] edge = edgeT.split(" ");
				int start = Integer.parseInt(edge[0]);
				int end = Integer.parseInt(edge[1]);

				GraphMatrix[start][end] = 1;
				GraphMatrix[end][start] = 1;
			}
			int[] color = new int[num];
			colorable = true;
			
			DFS(color, GraphMatrix, 0, 1);
			
			if(colorable == true) {
				System.out.println("BICOLORABLE.");
			}
			else {
				System.out.println("NOT BICOLORABLE.");
			}
		}
		
		input.close();
	}
	
	public static void DFS(int[] color, int[][] GraphMatrix, int node, int c) {
		color[node] = c;
	
		for(int i=0; i<color.length; i++) {
			if(colorable == true) {
				if(GraphMatrix[node][i] == 0)
					continue;
				
				if(color[i] == 0)
					DFS(color,GraphMatrix, i, c%2+1);
				
				else {
					if(color[i] == c) {
						colorable = false;
						return;
					}
				}
			}
		}
	}
}