import java.util.*;
class Main {
		public static void main(String[] args){

		Scanner input = new Scanner(System.in);		
		int scenario = Integer.parseInt(input.nextLine());


		for(int sc=0; sc<scenario; sc++) {
			String X = input.nextLine();
			String Z = input.nextLine();

			String[] x = X.split("");
			String[] z = Z.split("");

			long[][] D = new long[z.length+1][x.length+1];
			
			for(int j=0; j<x.length; j++) {
				D[0][j] = 1;
			}
			
			for(int i=1; i<z.length+1; i++) {
				for(int j=1; j<x.length+1; j++) {
					if(z[i-1].equals(x[j-1])) {
						D[i][j] = D[i-1][j-1] + D[i][j-1];
					}
					else{
						D[i][j] = D[i][j-1];
					}
				}
			}
			
//			for(int i=0; i<z.length+1; i++) {
//				for(int j=0; j<x.length+1; j++) {
//					System.out.print(D[i][j] + " ");
//				}
//				System.out.println();
//			}
			System.out.println(D[z.length][x.length]);

		}
		input.close();
	}
}