import java.util.*;
import java.io.*;

/*

*/

public class e1 {

	static int n;
	static int m;
	static int[][] mat;

	public static void main(String[] args){
		JS scan = new JS();
		PrintWriter out = new PrintWriter(System.out);
		int t = scan.nextInt();
		for(int q = 1; q <= t; q++){
			ans = 0;
			n = scan.nextInt();
			m = scan.nextInt();
			mat = new int[n][m];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					mat[i][j] = scan.nextInt();
				}
			}
			int[] max = new int[m];
			PriorityQueue<Item> pq = new PriorityQueue<Item>();
			for(int i = 0; i < m; i++){
				for(int j = 0; j < n; j++){
					max[i] = Math.max(max[i], mat[j][i]);
				}
				pq.add(new Item(i, max[i]));
			}
			ArrayList<Item> guys = new ArrayList<Item>();
			while(!pq.isEmpty() && guys.size() < 8){
				Item tt = pq.poll();
				guys.add(tt);
			}
			perm(guys, 0, new int[guys.size()]);
			out.println(ans);
		}
		out.flush();
	}

	static int ans = 0;

	static void perm(ArrayList<Item> guys, int me, int[] shift){
		if(me == guys.size()){
			// System.out.println(Arrays.toString(shift));
			int res = 0;
			int[] best = new int[n];
			for(int j = 0; j < guys.size(); j++){
				Item g = guys.get(j);
				int pp = g.a;
				for(int i = 0; i < n; i++){
					best[(i+shift[j])%n] = Math.max(best[(i+shift[j])%n], mat[i][pp]);
				}
			}
			for(int i = 0; i < n; i++) res += best[i];
			ans = Math.max(res, ans);
			return;
		}
		for(int i = 0; i < n; i++){
			shift[me] = i;
			perm(guys, me+1, shift);
		}
	}

	static class Item implements Comparable<Item>{

		int a;
		int b;

		public Item(int a, int b){
			this.a = a;
			this.b = b;
		}

		public int compareTo(Item o){
			return o.b-this.b;
		}
	}

	static class JS{
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;
 
		public JS() {
			in = new BufferedInputStream(System.in, BS);
		}
 
		public JS(String s) throws FileNotFoundException {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
		}
 
		public char nextChar(){
			while(bId==size) {
				try {
					size = in.read(buf);
				}catch(Exception e) {
					return NC;
				}				
				if(size==-1)return NC;
				bId=0;
			}
			return (char)buf[bId++];
		}
 
		public int nextInt() {
			return (int)nextLong();
		}
 
		public long nextLong() {
			num=1;
			boolean neg = false;
			if(c==NC)c=nextChar();
			for(;(c<'0' || c>'9'); c = nextChar()) {
				if(c=='-')neg=true;
			}
			long res = 0;
			for(; c>='0' && c <='9'; c=nextChar()) {
				res = (res<<3)+(res<<1)+c-'0';
				num*=10;
			}
			return neg?-res:res;
		}
 
		public double nextDouble() {
			double cur = nextLong();
			return c!='.' ? cur:cur+nextLong()/num;
		}
 
		public String next() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c>32) {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}
 
		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c!='\n') {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}
 
		public boolean hasNext() {
			if(c>32)return true;
			while(true) {
				c=nextChar();
				if(c==NC)return false;
				else if(c>32)return true;
			}
		}
	}
}