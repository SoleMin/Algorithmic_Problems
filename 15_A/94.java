import java.util.*;

public class A {
	Scanner in = new Scanner(System.in);
	
	public class Houses implements Comparable<Houses>{
		double x;
		double a;
		
		public Houses(double xVal, double aVal){
			x = xVal-aVal/2;
			a = aVal;
		}

		@Override
		public int compareTo(Houses o) {
			return (int) (x - o.x);
		}	
	}
	
	public void solve2(ArrayList<Houses> list,int t){
		Collections.sort(list);
		int count = 2; //beginning and end
		
		for(int f = 0; f < list.size()-1; f++){

			if(list.get(f+1).x-list.get(f).x-list.get(f).a > t){
				count+=2;
			}
			else if(list.get(f+1).x-list.get(f).x-list.get(f).a == t){
				count++;
			}
			
		}
		
		System.out.println(count);
	}
	
	public void solve(){
		ArrayList<Houses> list = new ArrayList<Houses>();
		int n = in.nextInt();
		int t = in.nextInt();
		for(int i = 0; i < n; i++){
			list.add(new Houses(in.nextDouble(),in.nextDouble()));
		}
		
		solve2(list,t);
	}
	
	public static void main(String[] args){
		A p = new A();
		p.solve();
	}
}
 