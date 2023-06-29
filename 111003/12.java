import java.math.*;
import java.util.*;

class Main {
	
	static int NO_EDGE = 1000000;
	
	static String solution(int[][] matrix, boolean[] station, int I) {
		
		for(int i=0; i < I; i++) {
			for (int j=0; j < I; j++) {
				for (int k=0; k < I; k++) {
					matrix[j][k] = Math.min(matrix[j][k], matrix[j][i] + matrix[i][k]);
				}
			}
		}
		
		int answer = 1; // No solution
		int ansMin = Integer.MAX_VALUE;
		for (int i=0; i < I; i++){
			if (!station[i]) {
				
				int before = Integer.MIN_VALUE;
				for (int src = 0; src < I; src++) {
					int dist = NO_EDGE;
					for (int dest = 0; dest < I; dest++) {
						if (station[dest]) {
							dist = Math.min(dist, matrix[src][dest]);
						}
					}
					before = Math.max(before,dist);
				}
				
				int after = Integer.MIN_VALUE;
				for (int src = 0; src < I; src++) {
					int dist = NO_EDGE;
					for (int dest = 0; dest < I; dest++) {
						if (station[dest] || dest == i) {
							dist = Math.min(dist, matrix[src][dest]);
						}
					}
					after = Math.max(after,dist);
				}
				
				if (after < before && after < ansMin) {
					ansMin = after;
					answer = i + 1;
				}
			}
		}
		
		return String.format("%d", answer);
	}
	
	static void print(String result) {
		System.out.println(result+"\n");
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		int tc = Integer.parseInt(scanner.nextLine());
		scanner.nextLine();
		
		for(int t=0; t < tc; t++) {
			
			int numStation = scanner.nextInt();
			int numIC = scanner.nextInt();
			scanner.nextLine();
			
			int[][] matrix = new int[numIC][numIC];
			for (int i=0; i < numIC; i++) {
				for (int j=0; j < numIC; j++) matrix[i][j] = (i == j) ? 0 : NO_EDGE;
			}
			
			boolean[] station = new boolean[numIC];
			for (int i=0; i < numStation; i++) {
				station[scanner.nextInt()-1] = true;
				scanner.nextLine();
			}
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line == null) break;
				StringTokenizer st = new StringTokenizer(line);
				if (st.countTokens() == 0) break;
				else if (st.countTokens() == 3) {
					int ic1 = Integer.parseInt(st.nextToken())-1;
					int ic2 = Integer.parseInt(st.nextToken())-1;
					int length = Integer.parseInt(st.nextToken());
					matrix[ic1][ic2] = length;
					matrix[ic2][ic1] = length;
				}
			}
			print(solution(matrix, station, numIC));
		}
		scanner.close();
	}
}