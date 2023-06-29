import java.io.*;
import java.util.*;

public class Main {

	static HashMap<String, ArrayList<Node>> map;
	static String[] cities;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int casenum = scan.nextInt();

		Main m = new Main();

		for (int q = 0; q < casenum; q++) {
			int linenum = scan.nextInt();

			map = new HashMap<String, ArrayList<Node>>();
			HashSet<String> hash = new HashSet<String>();

			for (int i = 0; i < linenum; i++) {
				String name1 = scan.next();
				String name2 = scan.next();
				int t1 = scan.nextInt();
				int t2 = scan.nextInt();

				if ((t1 >= 6 && t1 < 18) || (t1 < 6 && t2 > 6 - t1) || (t1 >= 18 && t2 > 30 - t1)) {
					continue;
				}

				if (!hash.contains(name1)) {
					hash.add(name1);
				}
				if (!hash.contains(name2)) {
					hash.add(name2);
				}

				t1 = convert(t1);

				Node n = m.new Node(t1, t2, name2);

				if (!map.containsKey(name1)) {
					ArrayList<Node> v = new ArrayList<Node>(5);
					map.put(name1, v);
				}
				map.get(name1).add(n);
			}

			int size = hash.size();
			cities = new String[size];
			Object[] obj = hash.toArray();
			for (int i = 0; i < size; i++) {
				cities[i] = (String) obj[i];
			}

			String name1 = scan.next();
			String name2 = scan.next();

			int blood = bfs(cities, name1, name2);
			System.out.println("Test Case " + (q + 1) + ".");
			if (blood > 10) {
				System.out.println("There is no route Vladimir can take.");
			} else {
				System.out.println("Vladimir needs " + blood + " litre(s) of blood.");
			}
		}
	}
	public class Node {
		public String city;
		public int time;
		public int total;

		public Node(int t1, int t2, String name2) {
			time = t1;
			total = t2;
			city = name2;
		}
	}
	static int convert(int time) {
		if (time <= 6) {
			return time + 6;
		}

		if (time == 24) {
			return 6;
		}

		return (time - 18);
	}

	static int bfs(String[] cities, String name1, String name2) {
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		int time[] = new int[cities.length];
		for (int i = 0; i < cities.length; i++) {
			hash.put(cities[i], i);
		}
		Arrays.fill(time, 10000);

		if (name1.equals(name2)) {
			return 0;
		}

		if (!hash.containsKey(name1) || !hash.containsKey(name2)) {
			return 11;
		}

		int indexname1 = hash.get(name1);
		time[indexname1] = 0;

		Queue<Integer> que = new LinkedList<Integer>();
		que.add(indexname1);

		while (!que.isEmpty()) {
			int n = que.poll();
			ArrayList<Node> v = map.get(cities[n]);
			if (v == null) {
				continue;
			}

			int size = v.size();
			for (int i = 0; i < size; i++) {
				int index = hash.get(v.get(i).city);
				int time2 = time2(v.get(i), time[n]);
				if (time2 < time[index]) {
					time[index] = time2;
					que.add(index);
				}
			}
		}

		int indexname2 = hash.get(name2);
		return (time[indexname2] - 1) / 12;
	}

	static int time2(Node node, int best) {
		if (node.time >= (best % 12)) {
			return (best / 12) * 12 + node.time + node.total;
		}
		return (best / 12) * 12 + node.time + node.total + 12;
	}
}