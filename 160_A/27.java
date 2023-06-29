import java.util.*;

public class A {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++) a[i] = s.nextInt();
		int r = 0, an = 0;
		Arrays.sort(a);
		int t = 0;
		for(int z : a) t += z;
		for(int i=a.length-1;i>=0;i--){
			r += a[i];
			an++;
			if (r > t - r) break;
		}
		System.out.println(an);
	}
}