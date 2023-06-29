import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class A {

    final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void solve() throws IOException {
		int n = readInt();
		long k = readInt();
		Long[] a = new Long[n];
		for(int i = 0; i < n; i++){
			a[i] = readLong();
		}
		Arrays.sort(a);
		TreeSet<Long> set = new TreeSet<Long>();
		for(int i = 0; i < n; i++){
			set.add(a[i]);
		}
		if(k == 1) {
			out.println(n);
			return;
		}
		int res = 0;
		TreeSet<Long> used = new TreeSet<Long>();
		for(Long cur: set){
			if(!used.contains(cur)){
				int num = 1;
				used.add(cur);
				Long temp = cur * 1;
				
				while(true){
					if(set.contains(k*temp)){
						num++;
						used.add(k*temp);
						temp *= k;
					}
					else{
						res += (num+1)/2;
						break;
					}
				}
			}
		}
		out.println(res);


    }

    void init() throws FileNotFoundException {
        if (ONLINE_JUDGE) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    int[] readArr(int n) throws IOException {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = readInt();
        }
        return res;
    }

    long[] readArrL(int n) throws IOException {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = readLong();
        }
        return res;
    }

    public static void main(String[] args) {
        new A().run();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            init();
            solve();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Exception e) {
            e.printStackTrace(System.err);
            System.exit(-1);
        }
    }
}