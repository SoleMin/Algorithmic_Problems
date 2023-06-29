import java.io.*;
import java.util.*;
 

public class Main {
	
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader kek = new BufferedReader(new InputStreamReader(System.in));
		//Scanner skek = new Scanner(System.in);
		PrintWriter outkek = new PrintWriter(System.out);
		
		String[] input = kek.readLine().split(" ");
		int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
		boolean[][] connected = new boolean[N + 1][N];
		long[][] walks = new long[1 << N][N];
		long res = 0;
		
		for(int i = 0; i < M; i++){
			input = kek.readLine().split(" ");
			int A = Integer.parseInt(input[0]) - 1, B = Integer.parseInt(input[1]) - 1;
			connected[A][B] = connected[B][A] = true;
		}
		
		for(int i = 0; i < N; i++){
			walks[1 << i][i] = 1;
		}
		
		for(int i = 1; i < 1 << N; i++){
			int temp = (int) (Math.log(i & -(i)) / 0.6931471805599453);
			for(int j = 0; j < N; j++){
				if(((1 << j) & i) > 0 && j != temp){
					for(int k = 0; k < N; k++){
						if(connected[k][j]){
							walks[i][j] += walks[i ^ (1 << j)][k];
						}
					}
					
					int count = 0, track = i;
					while(track > 0){
						if(track % 2 == 1){
							count++;
						}
						track /= 2;
					}
					
					
					if(count >= 3 && connected[temp][j]){
						res += walks[i][j];
					}
				}
			}
		}
		
		outkek.println(res / 2);
		kek.close();
		outkek.close();
	}	
	
}
