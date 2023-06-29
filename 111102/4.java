import java.math.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		int numTestCase = scanner.nextInt();
		scanner.nextLine();
		
		for (int t=0; t < numTestCase; t++) {
			String X = scanner.nextLine();
			String Z = scanner.nextLine();
			
			int xlen = X.length();
			int zlen = Z.length();
			
			BigInteger[][] matrix = new BigInteger[zlen+1][xlen+1];
			
			for (int i=0; i <= zlen; i++) {
				matrix[i][0] = BigInteger.ZERO;
			}
			for (int i=0; i <= xlen; i++) {
				matrix[0][i] = BigInteger.ONE;
			}
			
			for (int i=1; i <= zlen; i++) {
				for (int j=1; j <= xlen; j++) {
					matrix[i][j] = matrix[i][j-1];
					if (Z.charAt(i-1) == X.charAt(j-1)) {
						matrix[i][j] = matrix[i][j].add(matrix[i-1][j-1]);
					}
				}
			}
			
			System.out.println(matrix[zlen][xlen]);
		}
	}
}