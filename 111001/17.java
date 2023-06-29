import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static List<Spot> Graph;
	static boolean[] Visit;
	static double result;
	static double[][] dot = new double[100][2];
	static Spot spt;
	
	static Scanner scan = new Scanner(System.in);

	static class Spot {
		double x, y;

		public Spot(double x, double y) {
			this.x = x;
			this.y = y;
		}
		
		public double getDistance(Spot dis) {
			return Math.sqrt(Math.pow(this.x - dis.x, 2) + Math.pow(this.y - dis.y, 2));
		}
	}

	static class Edge implements Comparable<Edge> {
		int n;
		double dist;
		
		public Edge(int n, double dist) {
			this.n = n;
			this.dist = dist;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.dist, o.dist);
		}
	}

	public static void main(String[] args) throws IOException {
		int casenum = scan.nextInt();
		scan.nextLine();
		for (int q = 0; q < casenum; q++) {
			n = scan.nextInt();
			Graph = new ArrayList<>();
			Visit = new boolean[n];
			input();
			System.out.printf("%.2f", solve(0));
			System.out.println();
			System.out.println();
		}
	}

	static void input() {
		for (int i = 0; i < n; i++) {
			dot[i][0] = scan.nextDouble();
			dot[i][1] = scan.nextDouble();
			Graph.add(new Spot(dot[i][0], dot[i][1]));
		}
	}
	static double solve(int num) {
		int edgNum = 0;
		double distance;
		result = 0;
		Edge edg;
		PriorityQueue<Edge> Pque = new PriorityQueue<>();
		Queue<Integer> que = new LinkedList<>();
		que.add(num);
		while (!que.isEmpty()) {
			if (edgNum == n - 1) {
				break;
			}
			int cur = que.poll();
			Visit[cur] = true;
			spt = Graph.get(cur);
			for (int i = 0; i < n; i++) {
				if (Visit[i] == false) {
					distance = spt.getDistance(Graph.get(i));
					Pque.add(new Edge(i, distance));
				}
			}
			while (!Pque.isEmpty()) {
				edg = Pque.poll();
				if (Visit[edg.n] == false) {
					result += edg.dist;
					que.add(edg.n);
					edgNum++;
					break;
				}
			}
		}
		return result;
	}
}