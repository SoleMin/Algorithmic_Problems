import java.io.*;
import java.util.*;

public class Main {
	
	static HashSet<String> hash = new HashSet<String>();
	static int[] start = new int[4];
	static int[] end = new int[4];
	static int[] temp = new int[4];

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int n;
		int casenum = scan.nextInt();
		for (int i = 0; i < casenum; i++) {
			hash.clear();
			if (i != 0)
				scan.nextLine();
			for (int j = 0; j < 4; j++) {
				start[j] = scan.nextInt();
			}
			for (int j = 0; j < 4; j++) {
				end[j] = scan.nextInt();
			}
			n = scan.nextInt();
			for (int l = 0; l < n; l++) {
				for (int m = 0; m < 4; m++) {
					temp[m] = scan.nextInt();
				}
				hash.add(Arrays.toString(temp));
			}
			System.out.println(bfs(start, end));
		}
	}
	static class Node {
		int[] arr;
		int dist;
	}
	static int bfs(int[] first, int[] end) {
		Queue<Node> que = new LinkedList<Node>();
		String dest = Arrays.toString(end);
		hash.add(Arrays.toString(first));
		Node start = new Node();
		start.arr = new int[4];
		for (int i = 0; i < 4; i++) {
			start.arr[i] = first[i];
		}
		start.dist = 0;
		que.add(start);
		while (true) {
			if(que.isEmpty()) break;
			Node po = que.poll();
			int[] arr = po.arr;
			if (dest.equals(Arrays.toString(arr)))
				return po.dist;
			for (int i = 0; i < 4; i++) {
				int[] a = new int[4];
				int[] b = new int[4];
				for (int j = 0; j < 4; j++) {
					if (i == j) {
						a[j] = (arr[j] + 1) % 10;
						b[j] = (arr[j] + 9) % 10;
					} else {
						a[j] = b[j] = arr[j];
					}
				}
				String s1 = Arrays.toString(a);
				String s2 = Arrays.toString(b);
				if (!hash.contains(s1)) {
					hash.add(s1);
					Node n = new Node();
					n.arr = a;
					n.dist = po.dist + 1;
					que.add(n);
				}
				if (!hash.contains(s2)) {
					hash.add(s2);
					Node n = new Node();
					n.arr = b;
					n.dist = po.dist + 1;
					que.add(n);
				}
			}
		}
		return -1;
	}
}