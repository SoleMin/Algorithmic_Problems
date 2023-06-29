import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scan = new Scanner(System.in);
        // PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        // int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        int ans = 2;
        for(int i=0; i<n-1; i++) {
          int diff = a[i+1]-a[i];
          if(diff == 2*d) ans++;
          else if(diff > 2*d) ans += 2;

        }
        System.out.println(ans);
        // int n = scan.nextInt();

        // out.close(); System.exit(0);
    }
}
