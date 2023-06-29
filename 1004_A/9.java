//package contests.CF495;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class A {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]+d);
            set.add(arr[i]-d);
        }

        int cnt = 0;
        for (int loc: set) {
            int minDist = (int)2e9;
            for (int i = 0; i < n; i++) {
                minDist = Math.min(minDist, Math.abs(arr[i]-loc));
            }

            if(minDist == d)
                cnt++;
        }

        pw.println(cnt);

        pw.flush();
        pw.close();
    }



    static int[][] packD(int n, int[] from, int[] to) {
        int[][] g = new int[n][];
        int[] p = new int[n];
        for (int f : from) if(f != -1) p[f]++;
        for (int i = 0; i < n; i++) g[i] = new int[p[i]];
        for (int i = 0; i < from.length; i++) if(from[i] != -1) {g[from[i]][--p[from[i]]] = to[i];}
        return g;
    }

    static void shuffle(int[] a)
    {
        int n = a.length;
        for(int i = 0; i < n; i++)
        {
            int r = i + (int)(Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }

    static class Scanner
    {
        StringTokenizer st; BufferedReader br;
        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
        public Scanner(String s) throws FileNotFoundException {	br = new BufferedReader(new FileReader(new File(s)));}
        public String next() throws IOException {while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());return st.nextToken();}
        public int nextInt() throws IOException {return Integer.parseInt(next());}
        public long nextLong() throws IOException {return Long.parseLong(next());}
        public String nextLine() throws IOException {return br.readLine();}
        public boolean ready() throws IOException {return br.ready();}
    }
}
