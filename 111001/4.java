import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			br.readLine();
			int n = Integer.parseInt(br.readLine());
			Point[] p = new Point[n];
			ArrayList<Node>[] list = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				double x = Double.parseDouble(st.nextToken());
				double y = Double.parseDouble(st.nextToken());
				p[i] = new Point(x, y);
				list[i] = new ArrayList<>();
			}
			for (int i =0; i<n; i++) {
				Point curr = p[i];
				for(int j = i +1; j<n; j++) {
					Point next = p[j];
					double dist = distance(curr, next);
					list[i].add(new Node(j, dist));
					list[j].add(new Node(i, dist));
				}
			}
			double min = prim(list, n);
			System.out.println(String.format("%.2f\n", min));
		}
	}
	
	private static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}
	
	private static double prim(ArrayList<Node>[] list, int n) {
		double result = 0;
		int count = 0;
		boolean[] visited = new boolean[n];
		 PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			count++;
			if(visited[curr.v])
				continue;
			result += curr.weight;
			visited[curr.v] = true;
			if(count == n)
				return result;
			for(int i = 0; i<list[curr.v].size(); i++) {
				Node next = list[curr.v].get(i);
				if(visited[next.v])
					continue;
				q.add(next);
			}
		}
		return result;
		
	}
}

class Point {
	double x;
	double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;

	}
}

class Node implements Comparable<Node>{
	int v;
	double weight;

	public Node(int v, double weight) {
		this.v = v;
		this.weight = weight;
	}

	public int compareTo(Node o) {
		return Double.compare(this.weight, o.weight);
	}
}