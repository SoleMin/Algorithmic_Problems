import java.io.*;
import java.util.*;
public class Main {
	final static int MAXN = 100005;
	static int n;
	static Scanner cin;
	static int[] a;
	static boolean[] used;
	public static int Query(int x) {
		System.out.print("? ");
		System.out.println(x);
		System.out.flush();
		int a = cin.nextInt();
		return a;
	}
	public static int Q(int x) {
		if(used[x]) return a[x];
		used[x] = true;
		a[x] = Query(x) - Query(x + n / 2);
		if(a[x] == 0) {
			System.out.print("! ");
			System.out.println(x);
			System.out.flush();
			cin.close();
			System.exit(0);
		}
		return a[x];
	}
	public static void main(String[] args) {
		cin = new Scanner(System.in);
		n = cin.nextInt();
		a = new int[MAXN];
		used = new boolean[MAXN];
		if(n % 4 != 0) {
			System.out.println("! -1\n");
			System.out.flush();
			cin.close();
			return;
		}
		int l = 1, r = n / 2, mid;
		while(l <= r) {
			mid = (l + r) / 2;
			int x = Q(mid);
			if(Q(l) * x < 0) {
				r = mid - 1;
			} else if(x * Q(r) < 0) {
				l = mid + 1;
			}
		}
		System.out.println("! -1\n");
		System.out.flush();
		cin.close();
	}
}
