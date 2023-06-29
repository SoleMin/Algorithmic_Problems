import java.util.Scanner;


public class D {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int[] a = new int[n];
		for(int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}
		int ans = 0;	
		for(int i = 0; i < n; ++i) {
			for(int j = i+1; j < n; ++j) {
				if(a[i] > a[j]) ans++;
			}
		}
		
		int m = in.nextInt();
		
		for(int i = 0; i < m; ++i) {
			int l = in.nextInt();
			int r = in.nextInt();
			
			int size = r-l + 1;
			
			int x = size * size - size;
			x = x >> 1;
		
			ans = ans^x;
			if(ans%2 == 0) System.out.println("even");
			else System.out.println("odd");
			
		}
	}
	
	

}
