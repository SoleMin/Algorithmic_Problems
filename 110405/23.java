import java.util.*;

class Main {
	final static int N_MAX = 1000;
	
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int n, temp;
		int[] t = new int[N_MAX];
		int[] s = new int[N_MAX];
		int[] result = new int[N_MAX];
		
		
		int test = input.nextInt();
		for(int i = 0; i < test; i++){
			for(int j = 0; j < N_MAX; j++){
				t[j] = 2000;
				s[j] = 20000;
			}
			n = input.nextInt();
			for(int j = 0; j < n; j++){
				t[j] = input.nextInt();
				s[j] = input.nextInt();
				result[j] = j;
			}
			
			for(int j = 1; j < n; j++){
				for(int k = 0; k < n-1; k++){
					if((s[result[k+1]]*1.0)/t[result[k+1]] > (s[result[k]]*1.0)/t[result[k]]){
						temp = result[k];
						result[k] = result[k+1];
						result[k+1] = temp;
					}
				}
			}
			if (i > 0)
				System.out.println();
			for(int j = 0; j < n; j++){
				System.out.print(result[j] + 1);
				if(j != n-1)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}