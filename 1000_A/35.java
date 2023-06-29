import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // Scanner scan = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        ArrayList<String> s1 = new ArrayList<String>();
        ArrayList<String> s2 = new ArrayList<String>();
        for(int i=0; i<n; i++) s1.add(bf.readLine());
        for(int i=0; i<n; i++) s2.add(bf.readLine());

        Map<String, Integer> mp1 = new HashMap<String, Integer>();
        Map<String, Integer> mp2 = new HashMap<String, Integer>();
        for(String s : s1) mp1.put(s, 0);
        for(String s : s1) mp1.put(s, mp1.get(s)+1);
        for(String s : s2) mp2.put(s, 0);
        for(String s : s2) mp2.put(s, mp2.get(s)+1);
        for(String s : mp1.keySet()) {
          while(mp1.get(s) > 0) {
            if(mp2.containsKey(s)) {

              if(mp2.get(s) > 0) {
                mp1.put(s, mp1.get(s)-1);
                mp2.put(s, mp2.get(s)-1);
              }
              else break;
            }
            else break;
          }

        }
        for(String s : mp2.keySet()) {
          while(mp2.get(s) > 0) {
            if(mp1.containsKey(s)) {

              if(mp1.get(s) > 0) {
                mp2.put(s, mp2.get(s)-1);
                mp1.put(s, mp1.get(s)-1);
              }
              else break;
            }
            else break;
          }

        }
        long sum = 0;
        for(String s : mp1.keySet()) sum += mp1.get(s);
        out.println(sum);
        //out.println(mp1.keySet().size());
      //  out.close();

        // StringTokenizer st = new StringTokenizer(bf.readLine());
        // int[] a = new int[n]; for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
        // int n = Integer.parseInt(st.nextToken());
        // int n = scan.nextInt();

        out.close(); System.exit(0);
    }
}
