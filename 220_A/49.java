import java.util.*;
import java.io.*;
import java.awt.Point;
import static java.lang.Math.*;

public class CF220A {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] A = new int[n];
        Integer[] B = new Integer[n];
        for(int i=0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = A[i];
        }
        Collections.sort(Arrays.asList(B));

        int cnt = 0;
        for(int i=0; i<n; i++)
            if(A[i] != B[i])
                cnt++;
        System.out.println(cnt <= 2 ? "YES" : "NO");
    }
}
