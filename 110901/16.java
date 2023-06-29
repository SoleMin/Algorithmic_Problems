import java.io.*;
import java.util.*;

class Node {
	Set<Node> connected;
	int color;
	int vertex;
	
	public Node(int vertex) {
		this.connected = new HashSet<>();
		this.color = -1;
		this.vertex = vertex;
	}

	public boolean setColor(int color) {
		if(!isPossible(color)) {
			return false;
		}
		this.color = color;
		return true;
	}
	
	private boolean isPossible(int color) {
		if(this.color == -1) {
			return true;
		}
		else {
			return ((this.color ) == (color));
		}
	}
	
	public void connect(Node node) {
		this.connected.add(node);
	}
}

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			int n = sc.nextInt();
			if(n == 0) break;
			
			Map<Integer,Node> nodes = SetNode(n);
			n = sc.nextInt();
			
			
			for(int i = 0; i < n; i++) {
				int v1 = 0;
				int v2 = 0;
				
				v1 = sc.nextInt();
				v2 = sc.nextInt();
				connect(nodes.get(v1),nodes.get(v2));
			}
			
			boolean bicolorable = isBicolor(nodes);
			
			if(bicolorable) {System.out.println("BICOLORABLE.");}
			else {System.out.println("NOT BICOLORABLE.");}
		
		}
	}
	
	public static Map<Integer,Node> SetNode(int n) {
		Map<Integer,Node> nodes = new HashMap<>();
		for(int i = 0; i < n; i++) {
			nodes.put(i,new Node(i));
		}
		return nodes;
	}
	
	public static void connect(Node v1, Node v2) {
		v1.connect(v2);
		v2.connect(v1);
	}
	
	public static boolean isBicolor(Map<Integer,Node> nodes) {
		Queue<Node> q = new LinkedList<>();
		boolean[] visited = new boolean[nodes.size()];
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		
		nodes.get(0).setColor(0);
		q.add(nodes.get(0));
		visited[0] = true;
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int color = (cur.color + 1) % 2;
	
			for(Node node : cur.connected) {
				if(!node.setColor(color)) return false;
				if(visited[node.vertex]) continue;
				q.add(node);
				visited[node.vertex] = true;
			}
		}
		
		return true;

	}
	
}