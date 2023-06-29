import java.io.*;
import java.util.*;


public class B {
    public static void main(String[] args) throws Exception {
        new B().solve();
    }
    
    void solve() throws IOException {
        BufferedReader in = new BufferedReader(new
                InputStreamReader(System.in));
        // Scanner sc = new Scanner(System.in);
        
        String[] sp = in.readLine().split(" ");
        
        int n = Integer.parseInt(sp[0]);
        int k = Integer.parseInt(sp[1]);
        int[] a = new int[n];
        sp = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(sp[i]);
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int r = 0;
        map.put(a[r], 1);
        while (map.size() < k) {
            r++;
            if (r == n) {
                // ng
                System.out.println("-1 -1");
                return;
            }
            if (map.containsKey(a[r])) {
                map.put(a[r], map.get(a[r]) + 1);
            } else {
                map.put(a[r], 1);
            }
        }
        int l = 0;
        while (map.get(a[l]) > 1) {
            map.put(a[l], map.get(a[l]) - 1);
            l++;
        }
        System.out.println((l + 1) + " " + (r + 1));
    }
}




//
