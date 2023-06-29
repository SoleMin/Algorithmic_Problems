//package contests.CF1019;

import java.io.*;
import java.util.StringTokenizer;

public class B {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int half = n/2;
        pw.println("? 1");
        pw.flush();
        int a = sc.nextInt();
        pw.println("? " + (1+half));
        pw.flush();
        int b = sc.nextInt();
        if(a - b == 0){
            pw.println("! 1");
        }
        else
        if((a - b)%2 != 0)
        {
            pw.println("! -1");
        }else{
            boolean greater = a > b;
            int lo = 1;
            int hi = half;

            boolean ans = false;
            while(lo <= hi){
                int mid = (lo + hi) /2;
                pw.println("? " + mid);
                pw.flush();
                a = sc.nextInt();
                pw.println("? " + (mid+half));
                pw.flush();
                b = sc.nextInt();

                if(a == b){
                    pw.println("! " + mid);
                    ans = true;
                    break;
                }

                if(a > b != greater){
                    hi = mid-1;
                }else{
                    lo = mid+1;
                    greater = a>b;
                }
            }

            if(!ans){
                pw.println("! -1");
            }

        }

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
