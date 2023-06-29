import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
	
		int caseNumber = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < caseNumber; i++) {
			String distances[] = br.readLine().split(" ");
			int distance[] = new int[distances.length - 1];
			
			for( int j =1; j < distances.length; j++) {
				distance[j - 1] = Integer.parseInt(distances[j]);
				
			}
			
			Arrays.sort(distance);
			
			int address = distance[distance.length / 2];
			
			int result = 0;
			
			for (int j = 0; j < distance.length; j++) {
				result = result + Math.abs(distance[j] - address);
			}
			System.out.println(result);
		}
	}
}