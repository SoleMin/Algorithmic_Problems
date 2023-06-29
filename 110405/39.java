import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int i , n , temp;
		int[] ti = new int[1000];
		int[] si = new int[1000];
		int[] result = new int[1000];
		
		int case_num = scan.nextInt();
		scan.nextLine();
		while(case_num-- > 0){
			n = scan.nextInt();
			for(int j = 0 ; j < n ; j++){
				ti[j] = scan.nextInt();
				si[j] = scan.nextInt();
			}
			for(int k = 0; k < n; k++)
				result[k] = k;
			for(int l = 1; l < n ; l++){
				for(int q = 0; q < n-1; q++){
					if(ti[result[q]] * si[result[q+1]] > ti[result[q+1]] * si[result[q]]){
						temp = result[q];
						result[q] = result[q+1];
						result[q+1] = temp;
					}
				}
			}
			for(int j = 0; j < n -1; j++)
				System.out.print(result[j] + 1 + " ");
				System.out.print(result[n-1] + 1 + " ");
			System.out.println();
			System.out.println();
		}
		
	}
}