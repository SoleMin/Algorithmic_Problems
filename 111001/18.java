import java.io.*;
import java.util.*;

class Freckle {
	double x;
	double y;
	double weight;
	int n;
	
	
	public Freckle(double x, double y,int n) {
		this.x = x;
		this.y = y;
		this.n = n;
		this.weight = 0;
	}
	
	public Freckle(Freckle f ,double weight) {
		this.x = f.x;
		this.y = f.y;
		this.weight = weight;
		this.n = f.n;
	}
	
}

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		for(int i = 0; i < testcase; i++) {
			int n = sc.nextInt();
			Map<Integer,Freckle> freckles = new HashMap<>();
			for(int j = 0; j < n; j++) {
				double x = sc.nextDouble();
				double y = sc.nextDouble();
				freckles.put(j,new Freckle(x,y,j));
			}
			mst(freckles);
		}
	}
	
	public static void mst(Map<Integer,Freckle> freckles) {
		Map<Integer,Integer> visited = new HashMap<>();
		PriorityQueue<Freckle> pq = new PriorityQueue<>(new Comparator<> () {
			@Override      
			public int compare(Freckle o1, Freckle o2) {
				if(o1.weight == o2.weight) return (o1.n - o2.n);
				return Double.compare(o1.weight,o2.weight);
			}
		});
		
		double res = 0;
		pq.add(freckles.get(0));
		while(!pq.isEmpty()) {
			Freckle cur = pq.poll();
			if(visited.containsKey(cur.n)) continue;
			double cur_x = cur.x;
			double cur_y = cur.y;
			int n = cur.n;
			res += cur.weight;
			visited.put(cur.n,1);
			
			for(int i = 1; i < freckles.size(); i++) {
				if(visited.containsKey(freckles.get(i).n)) continue;
				double d = Math.sqrt(Math.pow(cur_x-freckles.get(i).x,2) + Math.pow(cur_y-freckles.get(i).y,2));
				pq.add(new Freckle(freckles.get(i),d));
			}
		}

		System.out.println(String.format("%.2f",res));
		System.out.println();
		
	}
}