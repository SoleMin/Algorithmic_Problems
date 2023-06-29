import java.io.*;
import java.util.*;
 

public class Main {
	
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader kek = new BufferedReader(new InputStreamReader(System.in));
		//Scanner skek = new Scanner(System.in);
		PrintWriter outkek = new PrintWriter(System.out);

		int N = Integer.parseInt(kek.readLine());
		double[][] lake = new double[N][N];
		
		for(int i = 0; i < N; i++){
			String[] input = kek.readLine().split(" ");
			for(int j = 0; j < N; j++){
				lake[i][j] = Double.parseDouble(input[j]);
			}
		}
		
		int pow = (int)Math.pow(2, N);
		double[] res = new double[pow];
		res[pow - 1] = 1.0;
		
		for(int i = pow - 1; i >= 0; i--){
			int ones = Integer.bitCount(i); // So this is apparently a thing
			int possibleCombos = ones * (ones - 1) /2;
			
			for(int j = 0; j < N; j++){
				if((i >> j) % 2 == 0){ // (X >> Y) literally does the same thing as divis func. Bit operators are weird.
					continue;
				}
				for(int k = j + 1; k < N; k++){
					if((i >> k) % 2 == 0){
						continue;
					}
					res[i ^ (1 << k)] += res[i] * lake[j][k]/possibleCombos;
					res[i ^ (1 << j)] += res[i] * lake[k][j]/possibleCombos;
				}
			}
			
		}
		
		for(int i = 0; i < N; i++){
			outkek.print(res[1 << i] + " ");
		}
		
		kek.close();
		outkek.close();
	}	
	
	/*static int divis(int n, int a){
		for(int i = 0; i < a; i++){
			n /= 2;
		}
		return n;
	}*/
		
}
