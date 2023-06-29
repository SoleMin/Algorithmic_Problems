import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class Main {
	
	static int n;
	static int a;
	static int b;
	static int g;
	static int ref;
	static int refg;
	static HashSet<Integer> cgroup;
	static HashMap<Integer,Integer> indexmap;
	static HashSet<Integer> nums;
	static HashSet<Integer> used;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		a = scan.nextInt();
		b = scan.nextInt();
		
		boolean[] where = new boolean[n];
		indexmap = new HashMap<Integer,Integer>();
		used = new HashSet<Integer>();
		nums = new HashSet<Integer>();
		
		if (a==b)
			b = 0;
		
		for (int i = 0; i<n; i++) {
			int x = scan.nextInt();
			nums.add(x);
			indexmap.put(x,i);
		}
		scan.close();
		
		for (int x : nums) {
			if (used.contains(x))
				continue;
			cgroup = new HashSet<Integer>();
			cgroup.add(x);
			g = -1;
			refg = -1;
			ref = -1;
			used.add(x);
			if (!spawn(x,a,b) || !spawn(x,b,a)) {
				System.out.println("NO");
				return;
			}
			if (cgroup.size()%2==1 && ref == -1) {
				System.out.println("NO");
				return;
			} else {
				boolean w = true;
				if (g == a)
					w = false;
				for (int k : cgroup) {
					where[indexmap.get(k)] = w;
				}
			}
		}
		
		System.out.println("YES");
		for (int i = 0; i<where.length; i++)
			if (where[i])
				System.out.print("1 ");
			else
				System.out.print("0 ");
		
	}

	private static boolean spawn(int x, int ab, int abo) {
		int xab = ab-x;
		if (xab == x) {
			ref = x;
			refg = ab;
		} else {
			if (nums.contains(xab)) {
				cgroup.add(xab);
				used.add(xab);
				spawn(xab,abo,ab);
			} else {
				if (g == -1)
					g = abo;
				else if (g != abo) {
					return false;
				}
			}
		}
		return true;
	}

}