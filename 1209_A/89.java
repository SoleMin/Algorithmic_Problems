import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());

        int counter = 0;
        TreeSet<Integer> val = new TreeSet<Integer>();
        for(int i : a) val.add(i);
        while(!val.isEmpty()) {
          int min = val.first();
          Set<Integer> toRemove = new HashSet<Integer>();
          for(int i : val) if(i % min == 0) toRemove.add(i);
          for(int i : toRemove) val.remove(i);
          counter++;
        }
        out.println(counter);
        // int n = Integer.parseInt(st.nextToken());

        out.close(); System.exit(0);
    }
}
