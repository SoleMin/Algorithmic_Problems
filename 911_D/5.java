import java.util.*;
public class A {
	public static void main(String args[]) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int a[] = new int[n+1];
		for(int i=1 ; i<=n ; i++) a[i] = sc.nextInt();
		int cnt = 0;
		for(int i=1 ; i<=n ; i++) {
			for(int j=i-1 ; j>=1 ; j--) {
				if(a[i]<a[j])
					++cnt;
			}
		}
		//System.out.println(cnt);
		int q = sc.nextInt();
		cnt = cnt % 2; 
		while(q-->0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int r = y-x+1;
			long ok = (r*(r-1))/2;
			if(ok%2==0) {
				
			}
			else {
				cnt ^= 1 ; 
			}
			System.out.println(cnt==0?"even":"odd");
		}
	}
}
