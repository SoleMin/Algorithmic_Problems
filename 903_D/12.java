import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import java.util.*;
import java.math.*;
import java.io.*;

public class Main implements Runnable {
    
	boolean TEST = System.getProperty("ONLINE_JUDGE") == null;
    
    void solve() throws IOException {
    	int n = nextInt();
    	Pair[] ps = new Pair[n];
    	for (int i = 0; i < n; i++) {
    		ps[i] = new Pair(nextInt(), i + 1);
    	}
    	sort(ps, new Comparator<Pair>() {
    		public int compare(Pair a, Pair b) {
    			return a.x - b.x;
    		}
    	});
    	BigInteger res = find(ps, n);
    	for (int i = 0; i * 2 < n; i++) {
    		Pair t = ps[i];
    		ps[i] = ps[n - i - 1];
    		ps[n - i - 1] = t;
    	}
    	res = res.add(find(ps, n));
    	out.println(res);
    }
    
    BigInteger find(Pair[] ps, int n) {
    	BigInteger res = ZERO;
    	int i = 0;
    	FenwickTree ft = new FenwickTree(n + 1);
    	boolean[] added = new boolean[n + 1];
    	for (int j = 0; j < n; j++) {
    		if (abs(ps[j].x - ps[i].x) <= 1) continue;
    		while (abs(ps[j].x - ps[i].x) > 1) {
    			if (!added[ps[i].i]) ft.add(ps[i].i, 1);
    			added[ps[i].i] = true;
    			i++;
    		}
    		i--;
    		long total = ft.sum(n);
    		long left = ft.sum(ps[j].i - 1);
    		long right = total - left;
    		res = res.add(valueOf(ps[j].x).multiply(valueOf(left)));
    		res = res.add(valueOf(-ps[j].x).multiply(valueOf(right)));
    	}
    	return res;
    }
    
    class Pair implements Comparable<Pair> {
    	int x, i;
    	
    	Pair(int x, int i) {
    		this.x = x;
    		this.i = i;
    	}
    	
    	public int compareTo(Pair p) {
    		return x - p.x;
    	}
    	
    	public String toString() {
    		return "(" + x + ", " + i + ")";
    	}
    }
    
    class FenwickTree {
    	int n;
    	int[] tree;
    			
    	public FenwickTree(int n) {
    		this.n = n;
    		tree = new int[n];
    	}
    			
    	public int sum(int id) {
    		int res = 0;
    		while (id > 0) {
    			res += tree[id];
    			id -= id & -id;
    		}
    		return res;
    	}
    			
    	public void add(int id, int v) {
    		while (id < n) {
    			tree[id] += v;
    			id += id & -id;
    		}
    	}

    	int findkth(int k) {
    		int low = 1, high = n;
    		while (low < high) {
    			int mid = (low + high) / 2;
    			int val = sum(mid);
    			if(val < k) low = mid + 1;
    			else high = mid;
    		}
    		return low;
    	}
    }

    
    String next() throws IOException {
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(input.readLine());
        return st.nextToken();
    }
    
    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    
    long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    
    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    
    void debug(Object... o) {
        System.out.println(deepToString(o));
    }
    
    void gcj(Object o) {
        String s = String.valueOf(o);
        out.println("Case #" + test + ": " + s);
        System.out.println("Case #" + test + ": " + s);
    }
    
    BufferedReader input;
    PrintWriter out;
    StringTokenizer st;
    int test;
    
    void init() throws IOException {
        if (TEST) input = new BufferedReader(new FileReader("input.in")); 
        else input = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new BufferedOutputStream(System.out));
        //out = new PrintWriter(new BufferedWriter(new FileWriter("output.out")));
    }
    
    public static void main(String[] args) throws IOException {
        new Thread(null, new Main(), "", 1 << 20).start();
    }
    
    public void run() {
        try {
            init();
            if (TEST) {
                int runs = nextInt();
                for(int i = 0; i < runs; i++) solve();
            } else solve();
            out.close();        
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}