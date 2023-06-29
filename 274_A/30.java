import java.util.*;
import java.io.*;
import java.awt.Point;
import static java.lang.Math.*;

public class P274A {
    public static int i(String s) { return Integer.parseInt(s); }
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = in.readLine().split(" ");
        int n = i(arr[0]);
        long k = i(arr[1]);
        long[] A = new long[n];
        arr = in.readLine().split(" ");
        for(int i=0; i<n; i++)
            A[i] = i(arr[i]);
        shuffle(A);
        Arrays.sort(A);

        Set<Long> BAN = new HashSet<Long>();
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(!BAN.contains(A[i])) {
                ans++;
                BAN.add(A[i]*k);
            }
        }
        System.out.println(ans);
    }
    public static void shuffle(long[] array) {
        for (int i = array.length; i > 1; i--) {
            long temp = array[i - 1];
            int randIx = (int) (Math.random() * i);
            array[i - 1] = array[randIx];
            array[randIx] = temp;
        }
    }
}
