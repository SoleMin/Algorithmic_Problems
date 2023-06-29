import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		int count = 0;
		while(n != 0) {
			String[] cityName = new String[n];
			for(int i=0; i<n; i++)
				cityName[i] = input.nextLine();
			
			boolean[][] matrix = new boolean[n][n];
			int r = Integer.parseInt(input.nextLine());
			for(int i=0; i<r; i++) {
				String[] split = input.nextLine().split("\\s+");
				int a=-1, b=-1;
				for(int j=0; j<n; j++)
					if(cityName[j].equals(split[0])) {
						a = j; break;
					}
				for(int j=0; j<n; j++)
					if(cityName[j].equals(split[1])) {
						b = j; break;
					}
				
				matrix[a][b] = true;
				matrix[b][a] = true;
			}
			
			for(int i=0; i<n; i++)
				matrix[i][i] = true;
			
			ArrayList<String> camera = new ArrayList<String>();
			for(int e=0; e<n; e++) {
				boolean[][] tempMatrix = new boolean[n][n];
				for(int i=0; i<n; i++)
					for(int j=0; j<n; j++)
						tempMatrix[i][j] = matrix[i][j];
				
				for(int k=0; k<n; k++) {
					if(k == e) continue;
					for(int i=0; i<n; i++) {
						if(i == e) continue;
						for(int j=0; j<n; j++) {
							if(j == e) continue;
							if(tempMatrix[i][k] && tempMatrix[k][j])
									tempMatrix[i][j] = true;
						}
					}
				}
				
				loop:
				for(int i=0; i<n; i++) {
					if(i == e)
						continue;
					for(int j=0; j<n; j++) {
						if(j == e || i == j)
							continue;
						if(!tempMatrix[i][j]) {
							camera.add(cityName[e]);
							break loop;
						}

					}
				}
			}
			
			String[] cameraCity = new String[camera.size()];
			camera.toArray(cameraCity);
			Arrays.sort(cameraCity);
			
			if(count != 0)
				System.out.println();
			count++;
			System.out.println("City map #" + count + ": " + camera.size() + " camera(s) found");
			for(String s : cameraCity)
				System.out.println(s);
			n = Integer.parseInt(input.nextLine());
		}
		input.close();
	}
}