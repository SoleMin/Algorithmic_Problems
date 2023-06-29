
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter result = new PrintWriter(System.out);
		
		boolean first = true;
		int t = Integer.parseInt(br.readLine().trim());
		
		br.readLine();
		while(t --> 0) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(s.nextToken());
			int n = Integer.parseInt(s.nextToken());

			int[][] array = new int[n][n];
			for (int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) { 
					array[i][j] = 9999;
				}
			}
			boolean[] check = new boolean[n];
			for(int i = 0; i < t1; i++) {
				int index = Integer.parseInt(br.readLine())-1;
				check[index] = true;
			}
			
			while(br.ready()) {
				s = new StringTokenizer(br.readLine());
				if(s.countTokens() == 0) break;
				
				int i = Integer.parseInt(s.nextToken())-1;
				int j = Integer.parseInt(s.nextToken())-1;
				int k = Integer.parseInt(s.nextToken());
				array[i][j] = k;
				array[j][i] = k;				
			}
			fillArray(array);
			
			int[] path = new int[n];
			for (int i = 0; i < path.length; i++) {
				path[i] = 9999;
				for(int j = 0; j < path.length; j++) {
					if(check[j] == true) {
						path[i] = Math.min(path[i], array[i][j]);
					}
				}
			}
			int max = Integer.MAX_VALUE;
			int an = 0;
			for(int i = 0; i < n; i++) {
				int c = 0;
				for(int j = 0; j < n; j++) 
					c = Math.max(c, Math.min(path[j], array[i][j]));
				if(c < max) {
					an = i+1;
					max = c;
				}
			}
			if(first == false)
				result.append("\n");
			
			first = false;
			result.append(an+"\n");
		}
		result.flush();

	}
	public static void fillArray(int[][] array) {
		for(int i = 0; i < array.length; i++) {
			array[i][i] = 0;
		}
		for(int k = 0; k < array.length; k++) {
			for(int i = 0; i < array.length; i++) { 
				for(int j = 0; j < array.length; j++) { 
					array[i][j] = Math.min(array[i][j], array[i][k] + array[k][j]);
				}
			}
		}
	}
}