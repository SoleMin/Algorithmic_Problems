import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	int work(int x){
		if(x%2==0)return x+1;
		else return x-1;
	}
	static int N = 200050;
	class Node implements Comparable <Node>{
		int x, id;
		Node(int x, int id){
			this.x = x; this.id = id;
		}
		public int compareTo(Node o){
			return Integer.compare(x, o.x);
		}
		public String toString(){
			return id + "=" + x;
		}
	}
	class Edge{
		int from, to, nex;
		Edge (int from, int to, int nex){
			this.from = from;
			this.to = to;
			this.nex = nex;
		}
	}
	Edge[] edge = new Edge[N*10];
	int[] head = new int[N];
	int edgenum;  
	void addedge(int u, int v){  
	    Edge E = new Edge(u, v, head[u]);  
	    edge[edgenum] = E;  
	    head[u] = edgenum ++;  
	}  
	
	int n;
	int[] p = new int[N], ans = new int[N];
	int a, b, max;
    Map<Integer, Integer> map = new HashMap();
    boolean match(int x, int y, int col){
    	int P = map.get(x);
    	if(map.containsKey(y-x) == false)
    		return false;
    	int Q = map.get(y - x);
    	if(ans[Q] == -1 || x * 2 == y){
    		ans[Q] = ans[P] = col;
    	}
    	else {
    		if(match(a+b-2*y+x, y, col))
    			ans[Q] = ans[P] = col; 		
    		else return false;
    	}
    	return true;
    }
    boolean solve(){
    	if(max >= a && max >= b)return false;
    	for(int i = 1; i <= n; i++)
    		if(ans[i] == -1)
    		{
    			if(match(p[i], a, 0)==false && match(p[i], b, 1) == false)
    				return false;
    		}    	
    	return true;
    }
	void init(){
		n = cin.nextInt();
		a = cin.nextInt(); b = cin.nextInt();
		max = 0;
		for(int i = 1; i <= n; i++){
			ans[i] = -1;
			p[i] = cin.nextInt();
			map.put(p[i], i);
			if(p[i] > max) max = p[i];
		}
	}
	public void work(){
		init();
		if(solve()){
			out.println("YES");
			for(int i = 1; i <= n; i++)out.print(ans[i]+" "); out.println();
		}
		else 
			out.println("NO");
	}
	Main() {
        cin = new Scanner(System.in);  
        out = new PrintWriter(System.out);
    }  
    public static void main(String[] args) {
        Main e = new Main();  
        e.work();
        out.close();
    }
    public Scanner cin;
    public static PrintWriter out;
}
		  	 		   	 	    	 		  	   		