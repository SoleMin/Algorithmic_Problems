import java.util.*;


public class A {
	
	public static double EPS = .001;
	
	public class House implements Comparable<House> {
		int x;
		int a;
		
		public House(int mx, int ma) {
			x = mx;
			a = ma;
		}

		public int compareTo(House o) {
			return x - o.x;
		}
		
		public double right() {
			return (double)x + ((double)a)/2.0;
		}
		
		public double left() {
			return (double)x - ((double)a)/2.0;
		}
	}
	
	public static void main(String[] args) {
		new A().solve();
	}
	
	
	public void solve() {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int t = in.nextInt();
		
		ArrayList<House> houses = new ArrayList<House>();
		
		for(int i=0;i<n;i++) {
			int x = in.nextInt();
			int a = in.nextInt();
			houses.add(new House(x,a));
		}
		
		Collections.sort(houses);
		
		
		int total = 2;
		
		for(int i=0;i<houses.size()-1;i++) {
			House me = houses.get(i);
			House next = houses.get(i+1);
			double meright = me.right();
			double nextleft = next.left();
			double diff = nextleft - meright;
			if(diff-EPS > ((double)t)) {
				total += 2;
			}
			else if(diff+EPS > ((double)t)) {
				total += 1;
			}
		}
		
		System.out.println(total);
	}
	
}
 