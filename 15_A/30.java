import java.io.*;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author camoroh13
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
 //       Scanner sc = new Scanner(new FileInputStream("/home/camoroh13/NetBeansProjects/JavaApplication1/src/input.txt"));
        int n = sc.nextInt();
        int t = sc.nextInt();
//        int[][] h = new int[n][2];
        TreeMap<Integer, Integer> h = new TreeMap<Integer, Integer>();
        for (int i=0; i < n; i++) {
            int key = sc.nextInt();
            h.put(key, sc.nextInt());
        }

        int ans = 2;
        Integer lastKey = h.firstKey();
        Integer last = h.get(lastKey);
        h.remove(lastKey);
        for (int i=1; i < n; i++) {
            int key = h.firstKey();
            int val = h.get(key);
            //System.out.println(Math.abs(key-val*1.0/2 - (lastKey + last*1.0/2)) + "-" + key + "-"+val);
            if (Math.abs(key-val*1.0/2 - (lastKey + last*1.0/2)) == t) {
                ans++;
            } else if (Math.abs(key-val*1.0/2 - (lastKey + last*1.0/2))  > t) {
                ans += 2;
            }
            lastKey = key;
            last = val;
            h.remove(lastKey);
        }

        System.out.println(ans);
        
        sc.close();
    }


}
