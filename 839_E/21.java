import java.util.*;
import java.io.*;

public class MotherOfDragons {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner();
        PrintWriter out = new PrintWriter(System.out, false);
        int n = scanner.nextInt();
        double k = scanner.nextInt();
        long[] graph = new long[n];
        for(int i = 0; i < n; i++) {
            for(int j =0; j < n; j++) {
                int val = scanner.nextInt();
                if (val == 1 || i == j) graph[i] |= 1L << j;
            }
        }
        //meet in the middle approach
        int szLeft = n/2;
        int szRight = n - szLeft;
        //max size of clique
        int[] dp = new int[1 << szLeft];
        int maxMask = 1 << szLeft;
        //iterate over every left mask
        for(int mask = 1; mask <maxMask; mask++) {
            int curMask = mask;
            //go over every bit in the mask
            for(int j = 0; j < szLeft; j++) {
                if (((1 << j) & mask) > 0) {
                    //update the union of reachability
                    curMask &= graph[j + szRight] >> szRight;
                    //can also attempt to pull from prev mask for max size
                    //will not be optimal if end update happens, but otherwise is useful for dp
                    dp[mask] = Math.max(dp[mask], dp[mask ^ (1 << j)]);
                }
            }
            //if the union of connectedness is the starting mask then we have a clique
            if (mask == curMask) {
                dp[mask] = Math.max(dp[mask],Integer.bitCount(mask));
            }
        }
        int ans = 0;
        int rmaxMask = 1 << szRight;
        for(int mask = 0; mask < rmaxMask; mask++) {
            //mask to track if the current creates its own clique
            int curMask = mask;
            //mask to track the connection between the halves
            int oMask = maxMask -1;
            for(int j = 0; j < szRight; j++) {
                if (((1 << j) & mask) > 0) {
                    //need to mask out the left side bits
                    curMask &= (graph[j] & (rmaxMask-1));
                    //update corresp avail in the left side
                    oMask &= graph[j] >> szRight;
                }
            }
            //not a clique portion
            if (curMask != mask) continue;
            //update answer
            ans = Math.max(ans, Integer.bitCount(mask) + dp[oMask]);
        }
        k/=ans;
        out.println(k * k * (ans * (ans-1))/2);
        out.flush();
    }
    
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        
        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }
        
        public FastScanner() {
            this(new InputStreamReader(System.in));
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
        
        String readNextLine() {
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