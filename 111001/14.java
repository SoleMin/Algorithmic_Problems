import java.util.*;
import java.math.*;

class Main {
	
	static String solution(List<Point> list) {
		int numVerts = list.size();
		PriorityQueue<Edge> edges = new PriorityQueue<>();
		for (int i=0; i < numVerts; i++) {
			for (int j = i+1; j < numVerts; j++) {
				edges.add(new Edge(list.get(i), list.get(j)));
			}
		}
		
		UnionFind find = new UnionFind(numVerts);
		
		int edgeCount = 0;
		double weightCount = 0;
		while (edgeCount < numVerts-1) {
			Edge current = edges.poll();
			if (!find.isSame(current.p1.id, current.p2.id)) {
				weightCount += current.weight;
				find.union(current.p1.id, current.p2.id);
				edgeCount++;
			}
		}
		return String.format("%.2f\n", weightCount);
	}
	
	static void print(String result) {
		System.out.println(result);
	}
	
	static class Point {
		double x, y;
		int id;
		public Point(double x, double y, int id) {
			this.x = x;
			this.y = y;
			this.id = id;
		}
	}
	
	static class UnionFind {
		int[] parent;
		public UnionFind(int n) {
			parent = new int[n];
			for (int i=0; i < n; i++) parent[i] = i;
		}
		
		public int find(int x) {
			if (parent[x] == x) return x;
			return parent[x] = find(parent[x]);
		}
		
		public void union(int x, int y) {
			parent[find(x)] = find(y);
		}
		
		public boolean isSame(int x, int y) {
			return find(x) == find(y);
		}
	}
	
	static class Edge implements Comparable<Edge> {
			Point p1, p2;
		double weight;
		public Edge(Point p1, Point p2) {
			this.p1 = p1;
			this.p2 = p2;
			this.weight = Math.hypot((p1.x - p2.x), (p1.y - p2.y));
		}
		public int compareTo(Edge o) {
			if (this.weight == o.weight) return 0;
			if (this.weight > o.weight) return 1;
			return -1;
		} 
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		int tc = scanner.nextInt();
		scanner.nextLine();
		
		for (int t=0; t < tc; t++) {
			scanner.nextLine();
			
			int numVerts = Integer.parseInt(scanner.nextLine());
			int color = 0;
			List<Point> list = new ArrayList<>();
			
			for (int i=0; i < numVerts; i++) {
				String[] line = scanner.nextLine().split(" ");
				double d1 = Double.parseDouble(line[0]);
				double d2 = Double.parseDouble(line[1]);
				list.add(new Point(d1,d2,color++));
			}
			
			print(solution(list));
		}
		scanner.close();
	}
}