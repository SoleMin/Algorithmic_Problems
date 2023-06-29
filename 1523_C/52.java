import java.util.*;
import java.io.*;

import static java.lang.Math.*;

public class Main
{
    static MyScanner scan;
    static PrintWriter pw;
    static long MOD = 1_000_000_007;
    static long INF = 2_000_000_000_000_000_000L;
    static long inf = 2_000_000_000;
    public static void main(String[] args) {
        new Thread(null, null, "_", 1 << 27) {
            public void run() {
                try {
                    solve();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }.start();
    }

    static void solve() throws java.lang.Exception {
        //initIo(true, "");
        initIo(false, "");
        StringBuilder sb = new StringBuilder();

        int t = ni();
        while (t-->0) {
            int n = ni();
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> prev = new ArrayList<>();
            prev.add(1);
            ni();
            for(int i=1;i<n;i++) {
                int x = ni();
                ans.add(prev);
                ArrayList<Integer> next = new ArrayList<>();
                int idx = -1;
                for(int j=prev.size()-1;j>=0;--j) {
                    if(prev.get(j)==x-1) {
                        for(int k=0;k<j;++k) {
                            next.add(prev.get(k));
                        }
                        next.add(x);
                        idx = j;
                        break;
                    }
                }

                if(idx==-1) {
                    assert_in_range("x", x, 1, 1);
                    for(int e : prev) {
                        next.add(e);
                    }
                    next.add(1);
                }
                prev = next;
            }

            ans.add(prev);
            for(ArrayList<Integer> list: ans) {
                print(list);
            }
        }

        pw.flush();
        pw.close();
    }

    static void print(ArrayList<Integer> list) {
        for(int i=0;i<list.size();i++) {
            pw.print(list.get(i));
            if(i==list.size()-1) {
                continue;
            }
            pw.print(".");
        }
        pl();
    }

    static void assert_in_range(String varName, int n, int l, int r) {
        if (n >=l && n<=r) return;
        System.out.println(varName + " is not in range. Actual: "+n+" l : "+l+" r: "+r);
        System.exit(1);
    }
    static void assert_in_range(String varName, long n, long l, long r) {
        if (n>=l && n<=r) return;
        System.out.println(varName + " is not in range. Actual: "+n+" l : "+l+" r: "+r);
        System.exit(1);
    }

    static void initIo(boolean isFileIO, String suffix) throws IOException {
        scan = new MyScanner(isFileIO, suffix);
        if(isFileIO) {
            pw = new PrintWriter("/Users/dsds/Desktop/output"+suffix+".txt");
        }
        else {
            pw = new PrintWriter(System.out, true);
        }
    }
    static int ni() throws IOException
    {
        return scan.nextInt();
    }
    static long nl() throws IOException
    {
        return scan.nextLong();
    }
    static double nd() throws IOException
    {
        return scan.nextDouble();
    }
    static String ne() throws IOException
    {
        return scan.next();
    }
    static String nel() throws IOException
    {
        return scan.nextLine();
    }
    static void pl()
    {
        pw.println();
    }
    static void p(Object o)
    {
        pw.print(o+" ");
    }
    static void pl(Object o)
    {
        pw.println(o);
    }
    static void psb(StringBuilder sb)
    {
        pw.print(sb);
    }
    static void pa(String arrayName, Object arr[])
    {
        pl(arrayName+" : ");
        for(Object o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, int arr[])
    {
        pl(arrayName+" : ");
        for(int o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, long arr[])
    {
        pl(arrayName+" : ");
        for(long o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, double arr[])
    {
        pl(arrayName+" : ");
        for(double o : arr)
            p(o);
        pl();
    }
    static void pa(String arrayName, char arr[])
    {
        pl(arrayName+" : ");
        for(char o : arr)
            p(o);
        pl();
    }

    static void pa(String arrayName, TreeSet<Integer> set)
    {
        pl(arrayName+" : ");
        for(Object o : set)
            p(o);
        pl();
    }

    static void pa(String arrayName, boolean arr[])
    {
        pl(arrayName+" : ");
        for(boolean o : arr)
            p(o);
        pl();
    }
    static void pa(String listName, List list)
    {
        pl(listName+" : ");
        for(Object o : list)
            p(o);
        pl();
    }
    static void pa(String arrayName, Object[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(Object o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, int[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(int o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, long[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(long o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, char[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(char o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, double[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(double o : arr[i])
                p(o);
            pl();
        }
    }
    static void pa(String arrayName, boolean[][] arr) {
        pl(arrayName+" : ");
        for(int i=0;i<arr.length;++i) {
            for(boolean o : arr[i])
                p(o);
            pl();
        }
    }
    static class MyScanner
    {
        BufferedReader br;
        StringTokenizer st;
        MyScanner(boolean readingFromFile, String suffix) throws IOException
        {
            if(readingFromFile) {
                br = new BufferedReader(new FileReader("/Users/ddfds/Desktop/input"+suffix+".txt"));
            }
            else {
                br = new BufferedReader(new InputStreamReader(System.in));
            }
        }
        String nextLine()throws IOException
        {
            return br.readLine();
        }
        String next() throws IOException
        {
            if(st==null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException
        {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException
        {
            return Long.parseLong(next());
        }
        double nextDouble() throws IOException
        {
            return Double.parseDouble(next());
        }
    }
}