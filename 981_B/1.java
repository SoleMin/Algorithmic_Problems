import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class _0988BusinessmenProblems {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<Integer,Integer> store = new HashMap<>();
		
		int n=sc.nextInt();
		long cost=0;
		for(int i=0;i<n;i++) {
			int pos=sc.nextInt();
			int val=sc.nextInt();
			if(!store.containsKey(pos)) {
				store.put(pos, val);
			}
			else {
				if(store.get(pos)<val) {
					store.put(pos, val);
				}
			}
		}
		int m=sc.nextInt();
		for(int i=0;i<m;i++) {
			int pos=sc.nextInt();
			int val=sc.nextInt();
			if(!store.containsKey(pos)) {
				store.put(pos, val);
			}
			else {
				if(store.get(pos)<val) {
					store.put(pos, val);
				}
			}
		}
		Iterator<Integer> i=store.values().iterator();
		while(i.hasNext()) {
			cost+=i.next();
		}
		System.out.println(cost);
	}

}
