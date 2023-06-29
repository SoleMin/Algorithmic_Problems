import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());
		for(int r=0; r<repeat; r++) {
			input.nextLine();
			int n = Integer.parseInt(input.nextLine());
			Node[] nodes = new Node[n];
			double[][] matrix = new double[n][n];
			for(int i=0; i<n; i++) {
				String[] split = input.nextLine().split("\\s+");
				nodes[i] = new Node(Double.parseDouble(split[0]), Double.parseDouble(split[1]));
				for(int j=0; j<i; j++)
					matrix[j][i] = distance(nodes[j], nodes[i]);
			}

			double sum = 0;
			boolean[] visited = new boolean[n];
			visited[0] = true;
			while(!allVisited(visited)) {
				double min = -1;
				int minNode = 0;

				for(int i=0; i<visited.length; i++)
					if(visited[i]) 
						for(int j=0; j<visited.length; j++)
							if(!visited[j]) {
								if(i < j) {
									if(min == -1 || min > matrix[i][j]) {
										min = matrix[i][j];
										minNode = j;
									}
								} else {
									if(min == -1 || min > matrix[j][i]) {
										min = matrix[j][i];
										minNode = j;
									}
								}
							}
				sum += min;
				visited[minNode] = true;
			}
			
			if(r>0)
				System.out.println();
			System.out.println(String.format("%.2f", sum));
		}
		input.close();
	}

	public static class Node{
		double x, y;
		Node(double x, double y){
			this.x = x;
			this.y = y;
		}
	}

	public static double distance(Node a, Node b){
		double x = Math.abs(a.x - b.x);
		double y = Math.abs(a.y - b.y);
		return Math.sqrt(x*x + y*y);
	}

	public static boolean allVisited(boolean[] visited) {
		for(int i=0; i<visited.length; i++)
			if(!visited[i])
				return false;
		return true;
	}
}