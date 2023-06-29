import java.util.*;

public class House {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		ArrayList<HS> list = new ArrayList<HS>();

		for (int i = 0; i < n; i++) {
			list.add(new HS(sc.nextInt(),sc.nextInt()));
		}
		
		Collections.sort(list);
		
		int count = 0;
		
		if(n >= 1)
			count = 2;
		
		for(int i = 0; i < list.size() - 1; i++){
			double d = Math.abs(list.get(i + 1).x - list.get(i).x);
			d -= ((1.0*list.get(i).a/2.0) + (1.0*list.get(i + 1).a/2.0));
			if ((d >= t)&& ((d-t) <= 0.00000001)){
				count++;
			}
			else if(d > t){
				count+= 2;
			} 
		}
		System.out.println(count);
	}
}

class HS implements Comparable<HS> {
	public int x;
	public int a;

	public HS(int x, int a) {
		this.x = x;
		this.a = a;
	}

	public int compareTo(HS o) {
		return x - o.x;
	}

}
