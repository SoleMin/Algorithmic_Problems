import java.util.Arrays;
import java.util.Scanner;


public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []a = new int [n];
		boolean []used = new boolean[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int ans = 0;
		for (int i = 0; i < used.length; i++) {
			if (!used[i]){
				ans++;
			  for (int j = i; j < used.length; j++) {
				if (a[j]%a[i] == 0){
					used[j] = true;
				}
			  }
			}
		}
		System.out.print(ans);
	}

}
