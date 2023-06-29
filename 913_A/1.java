

import java.util.*;
import java.io.*;
import java.math.BigInteger;

 public class Test {
    static int[] MODS = {1000000007, 998244353, 1000000009};
    static int MOD = MODS[0];

    public static void main(String[] args) {
        sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
//        int t = sc.nextInt();
//        while (t-- > 0) {
//        	
//        }
       long n=sc.nextLong();long m=sc.nextLong();
       
       if(n>27)System.out.println(m);
       else {
    	   long ans=m %(new Test().compute(2, n));
           System.out.println(ans);
       }
        
       
        out.close();
    }

    long compute(long a,long b) {
		long res=1;
		while(b>0) {
			if((b&1)==1) {
				res=res*a;
			}
			a=a*a;
			b=b>>1;
		}
		return res;
	}
    
    /*-----------------------------*/
    public static int[] sort(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void scan(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static MyScanner sc;
    public static PrintWriter out;

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

