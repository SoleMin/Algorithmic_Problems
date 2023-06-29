import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);

		while(true) {
			int n = Integer.parseInt(input.nextLine());
			if(n == 0)
				break;

			boolean[][] matrix = new boolean[n][n]; 
			int l = Integer.parseInt(input.nextLine());
			for(int i=0; i<l; i++) {
				String[] split = input.nextLine().split("\\s+");
				int a = Integer.parseInt(split[0]);
				int b = Integer.parseInt(split[1]);
				matrix[a][b] = true;
				matrix[b][a] = true;
			}

			int[] colorTable = new int[n];
			colorTable[0] = 1;	// 색깔은 1과 2 두가지.
			if(isBicolorable(matrix, colorTable))
				System.out.println("BICOLORABLE.");
			else
				System.out.println("NOT BICOLORABLE.");
		}
	}
	
	public static boolean isBicolorable(boolean[][] matrix, int[] colorTable) {
		int n = matrix.length;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);

		while(!q.isEmpty()) {
			int currentNode = q.poll();
			int currentColor = colorTable[currentNode];
			for(int i=0; i<n; i++)
				if(i != currentNode) 
					if(matrix[currentNode][i]){
						if(colorTable[i] == currentColor)
							return false;
						else if(colorTable[i] == 0) {
							if(currentColor == 1)
								colorTable[i] = 2;
							else
								colorTable[i] = 1;
							q.add(i);
						}
					}
		}
		
		return true;
	}
}