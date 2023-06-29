import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);

		while(true) {

			int n = input.nextInt();
			int k = input.nextInt();
			if(n == 0 && k == 0) break;

			long ans = Bishop(n, k); 
			list.add(ans);


		}
		input.close();


		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	} 
	static long Bishop(int n, int k) { 
		long result = 0; 
		int[][] m = new int[2*n][k+1]; 
		
	
		m[1][1] = 1; 
		for(int i = 0; i < m.length; i++) {
			m[i][0] = 1; 
		}
		
		int a = 0;
		for(int i = 2; i < m.length; i++) { 
			for(int j = 1; j <= k; j++) {
				if ((i&1) == 1) 
					a = (i/4 * 2) + 1; 
				else
					a = ((i-1)/4 * 2) + 2; 
				m[i][j] = m[i-2][j] + m[i-2][j-1] * (a-j+1); 
			}
		} 

		for(int i = 0; i <= k; i++) { 
			result += m[n*2-1][i] * m[n*2-2][k-i]; 
		} 
		return result; 
	} 
}
