import java.io.*;
import java.util.*;
 

public class Main {
		
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader kek = new BufferedReader(new InputStreamReader(System.in));
		//Scanner skek = new Scanner(System.in);
		PrintWriter outkek = new PrintWriter(System.out);

		String[] input = kek.readLine().split(" ");
		int X0 = Integer.parseInt(input[0]), Y0 = Integer.parseInt(input[1]), N = Integer.parseInt(kek.readLine());
		
		int[] xCoords = new int[N + 1];
		int[] yCoords = new int[N + 1];
		int[][] distances = new int[N + 1][N + 1]; 
		xCoords[N] = X0;
		yCoords[N] = Y0;
		
		for(int i = 0; i < N; i++){
			input = kek.readLine().split(" ");
			xCoords[i] = Integer.parseInt(input[0]);
			yCoords[i] = Integer.parseInt(input[1]);
		}
		
		for(int i = 0; i <= N; i++){
			for(int j = i + 1; j <= N; j++){
				int temp = xCoords[i] - xCoords[j];
				int temp2 = yCoords[i] - yCoords[j];
				distances[i][j] = (temp * temp) + (temp2 * temp2);
			}
		}
		
		int[] aa = new int[1 << N];
		int[] bb = new int[1 << N];
		
		for(int i = 1; i < 1 << N; i++){
			int a = -1;
			for(int j = 0; j < N; j++){
				if((i & 1 << j) > 0){
					a = j;
					break;
				}
			}
			
			int l = i ^ 1 << a;
			int dist = distances[a][N] + distances[a][N];
			aa[i] = aa[l] + dist;
			bb[i] = l;
			
			for(int k = a + 1; k < N; k++){
				if((i & 1 << k) > 0) {
					l = i ^ 1 << a ^ 1 << k;
					dist = distances[a][N] + distances[k][N] + distances[a][k];
					if(aa[l] + dist < aa[i]){
						aa[i] = aa[l] + dist;
						bb[i] = l;
					}
				}
			}
		}
		
		int fin = (1 << N) - 1;
		outkek.println(aa[fin]);
		outkek.print('0');
		while (fin != 0){
			int temp1 = bb[fin];
			int temp2 = fin ^ temp1;
			for(int i = 0; i < N; i++){
				if((temp2 & 1 << i) > 0){
					outkek.print(" " + (i + 1));
				}
			}
			outkek.print(" 0");
			fin = temp1;
		}
		kek.close();
		outkek.close();
	}	
	
}
