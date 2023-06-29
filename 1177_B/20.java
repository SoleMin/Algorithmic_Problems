import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import static java.lang.Long.bitCount;

public class Main {

    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        long []a = new long[16];
        a[0] = 0;
        for(int i=1; i<16; ++i)
            a[i] = a[i-1]+((9*(long)Math.pow(10, i-1))*i);
        long N = in.nextLong();
        int pos = 0;
        for(int i=0; i<16; ++i){
            if(N<=a[i]){
                pos = i;
                break;
            }
        }
        if(pos==1){
            System.out.println(N);
            System.exit(0);
        }
        long prev = a[pos-1];
        long curr = N;
        long rem = curr - prev;
        long ans = 0;
        for(int i=1; i<pos; ++i){
            ans = ans*10 + 9;
        }
        long g = (rem+(pos-1))/pos;
        long take = (rem+(pos-1))%pos;
        long number = ans + g;
        String str = Long.toString(number);
        System.out.println(str.charAt((int)take));
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
