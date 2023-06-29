import java.io.*;
import java.util.*;
class Elephant {
	int seq,w,iq;
	
	public Elephant(int seq,int w, int iq) {
		this.seq = seq;
		this.w = w;
		this.iq = iq;
	}
}

class Main {
	static int[] path;
	static ArrayList<Integer>[] res;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int seq = 1;
		List<Elephant> e_l = new LinkedList<>();
		while(sc.hasNextInt()) {
			int w = sc.nextInt();
			int iq = (sc.nextInt());
			e_l.add(new Elephant(seq,w,iq));
			seq++;
		}
		int[] dp = new int[seq];
		path = new int[seq];
		res = new ArrayList[seq];
		int max = 0;
		for(int i = 0; i < seq; i++) {
			dp[i] = 1;
			path[i] = 0;
			res[i] = new ArrayList<>();
		}
		
		e_l.sort(new Comparator<Elephant>() {
			public int compare(Elephant o1, Elephant o2) {
				return o1.w - o2.w;
			}
		});
		
		for(int i = 0; i < e_l.size(); i++) {
			Elephant cur = e_l.get(i);
			for(int j = 0; j < i; j++) {
				Elephant last = e_l.get(j);
				if(last.w < cur.w && last.iq > cur.iq && dp[cur.seq] < dp[last.seq] + 1) {
					dp[cur.seq] = dp[last.seq] + 1;
					path[cur.seq] = last.seq;
				}
				if(dp[cur.seq] > max) {
					max = dp[cur.seq];
				}
					
				if(last.w < cur.w && last.iq > cur.iq && (last.seq < path[cur.seq] | path[cur.seq] == 0) && dp[last.seq] + 1 == dp[cur.seq]) {
					path[cur.seq] = last.seq;
				}
				
			
			}
		} 

		
		
		for(int i = 1; i < seq; i++) {
				if(dp[i] == max) {
					graph(i);
				}
		}
		System.out.println(max);
		print(0);
	}
	
	public static void graph(int p) {
		if(path[p] == 0) {
			res[0].add(p);
			return;
		}
		res[path[p]].add(p);
		graph(path[p]);
	}
	
	public static void print(int parent){
		int min = 9999;
		if(res[parent].isEmpty()) return;
		for(int i = 0; i < res[parent].size(); i++) {
			if(min > res[parent].get(i))
				min = res[parent].get(i);
		}
		System.out.println(min);
		print(min);
	}
}