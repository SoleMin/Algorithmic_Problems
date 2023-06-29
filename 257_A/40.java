import java.io.*;
import java.util.*;

public class A {
	int n, m, k;
	int[] a;
	
	void run()throws IOException{
//		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		a = new int[n];
		for(int i=0;i<n; i++) a[i] = sc.nextInt();
		Arrays.sort(a);
		
		if(m<=k){
			System.out.println(0);
			return;
		}
		
		int cnt = k;
		int ind = a.length-1;
		int ret = 0;
		while(cnt<m && ind>=0){
			cnt += a[ind]-1;
			--ind;
			ret++;
			
		}
		
		if(cnt>=m) System.out.println(ret);
		else System.out.println(-1);
	}

	public static void main(String[] args)throws IOException {
		new A().run();
	}
}
