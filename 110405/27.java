import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int test_case, n;
		int[] ti = new int[1000];
		int[] si = new int[1000];
		int[] result = new int[1000];
		
		test_case = sc.nextInt();
		sc.nextLine();
		
		while(test_case-- > 0){
			
			n = sc.nextInt();
			for(int i = 0 ; i < n; i++){
				ti[i] = sc.nextInt();
				si[i] = sc.nextInt();
			}
			
			for(int i = 0 ; i < n; i++){
				result[i] = i;
			}
			
			for(int i = 1 ; i < n ; i++){
				for(int j = 0; j < n - i; j++){
					if (ti[result[j]] * si[result[j+1]] > ti[result[j+1]] * si[result[j]]){
						int temp = result[j];
						result[j] = result[j+1];
						result[j+1] = temp;
					}
				}
			}
			for(int i = 0 ; i < n ; i++){
				System.out.print(result[i] + 1 + " ");
			}
			System.out.println();
			if(test_case >= 0)
				System.out.println();
		}
	}
}