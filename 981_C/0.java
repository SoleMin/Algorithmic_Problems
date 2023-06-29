//    A Computer is Like a mischievous genie.
//    It will give you exactly what you ask for,
//    but not always what you want
//    A code by Rahul Verma


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {


    static class Clock {

        protected long start, stop;

        public void start() {
            start = System.currentTimeMillis();
        }

        public void stop() {
            stop = System.currentTimeMillis();
        }

        public String getTime() {
            return ((stop - start) + " ms");
        }
    }


    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String[] nextSArray() {
            String sr[] = null;
            try {
                sr = br.readLine().trim().split(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sr;
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }
    }


    static long powmodulo(long a, long p) {
        if (p == 0) {
            return 1 % mod;
        }
        if (p == 1) {
            return a % mod;
        }
        long ans = 1;
        while (p > 0) {
            if ((p & 1) > 0) {
                ans = (ans * a) % mod;
            }
            a = (a * a) % mod;
            p = p >> 1;
        }
        return ans % mod;
    }


    static long mod = 1000000007;

    static long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    static long fast_powerNumbers(long a, long n) {
        if (n == 1) {
            return a;
        }
        long ans = fast_powerNumbers(a, n / 2);
        if (n % 2 == 0) {
            return (ans * ans);
        } else {
            return ((ans * ans) * (a));
        }
    }


    static void dfs_helper(int[][] arr, int i, int j, int team, int n, int m) {
        arr[i][j] = team;
        if (i - 1 >= 0 && arr[i - 1][j] == 1) {
            dfs(arr, i - 1, j, team, n, m);
        }
        if (j - 1 >= 0 && arr[i][j - 1] == 1) {
            dfs(arr, i, j - 1, team, n, m);
        }
        if (i + 1 < n && arr[i + 1][j] == 1) {
            dfs(arr, i + 1, j, team, n, m);
        }
        if (j + 1 < m && arr[i][j + 1] == 1) {
            dfs(arr, i, j + 1, team, n, m);
        }

    }

    static void dfs(int[][] arr, int i, int j, int team, int n, int m) {
        dfs_helper(arr, i, j, team, n, m);

    }

    static int parent[];
    static int rank[];

    static int find(int i) {
        if (parent[i] == -1) {
            parent[i] = i;
            return i;
        }

        if (parent[i] == i) {
            return i;
        } else {
            parent[i] = find(parent[i]);
        }
        return parent[i];

    }

    static void unite(int s1, int s2) {

        if (rank[s1] > rank[s2]) {
            parent[s2] = s1;
            rank[s1] += rank[s2];
        } else {
            parent[s1] = s2;
            rank[s2] += rank[s1];
        }
    }


    public static long arr[];

//    static void seive(int n) {
//        arr = new int[n + 1];
//        arr[0] = arr[1] = 1;
//        for (int i = 4; i <= n; i = i + 2) {
//            arr[i] = 1;
//        }
//        for (int i = 3; i * i <= n; i = i + 2) {
//            if (arr[i] == 0) {
//                for (int j = i * i; j <= n; j = j + i) {
//                    arr[j] = 1;
//                }
//
//            }
//        }
//    }

    static HashMap<Integer,ArrayList<Integer>>hm2;


    public static void main(String[] args) throws Exception {
        FastReader sc = new FastReader();

        Clock clock = new Clock();
        clock.start();
//        int t1 =sc.nextInt();
//
//        for (int t = 0; t <t1; t++) {
//
//
//        }
//        out.close();
        int n=sc.nextInt();
       Gaph gp=new Gaph(n);
       hm2=new HashMap<>();
       hm2 = gp.hm;

        for (int i = 0; i < n-1; i++) {
            gp.addEdge(sc.nextInt()-1,sc.nextInt()-1,false);
        }
       // System.out.println(hm2);
        int  c =0;
        int god=0;
        int godd=0;
        ArrayList<Integer>al=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(hm2.get(i).size()==1)
                al.add(i);
            if(hm2.get(i).size()>2)
                ++c;
            if(godd< hm2.get(i).size())
            {
                godd = hm2.get(i).size();
                god = i;
            }

        }

        if(c>1)
        {
            System.out.println("No");
            return;
        }
        else
        {
            out.println("Yes");
            out.println(hm2.get(god).size());
            ++god;
            for(Integer last : al)
            {
                if(last+1!=god)
                out.println(god+" "+(last+1));
            }
        }
        out.close();

}}

class trio{
    long rs;int egg;int choco;
    trio(long rs,int egg,int choco)
    {
        this.rs=rs;
        this.egg=egg;
        this.choco=choco;
    }
}

class Pair{

    int a,b;
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class DSU
{
    int parent[];
    int rank[];
    long arr[] = Main.arr;
    long sum[] ;
    DSU(int n)
    {
        this.parent=new int[n];
        this.rank=new int[n];
        sum=new long[n];
        Arrays.fill(parent,-1);
        Arrays.fill(rank,1);
        for (int i = 0; i <n ; i++) {
            sum[i]=arr[i];
        }
    }

    int find(int s1)
    {
        if(parent[s1]==-1)
            return s1;
        return parent[s1]=find(parent[s1]);
    }

    void unite(int s1,int s2)
    {
        int p1=this.find(s1);
        int p2=this.find(s2);
        if(p1==p2)
            return;
        if(rank[p1]>rank[p2])
        {
            parent[p2]=p1;
            rank[p1]+=rank[p2];
           // System.out.println(arr[p2]);

            sum[p1]+=sum[p2];
            //sum[p2]+=sum[p1];

        }
        else
        {
            parent[p1]=p2;
            rank[p2]+=rank[p1];
            //System.out.println(arr[p1]);
            sum[p2]+=sum[p1];
            //sum[p1]+=sum[p2];
        }
    }


}

 class Gaph {

    HashMap<Integer, ArrayList<Integer>> hm;

    Gaph() {
        hm = new HashMap<>();
    }

    Gaph(int n) {

        hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(i, new ArrayList<Integer>());
        }
    }

    // function for adding an edge.................................................
    public void addEdge(int a, int b, boolean isDir) {
        if (isDir) {
            if (hm.containsKey(a)) {
                hm.get(a).add(b);
            } else {
                hm.put(a, new ArrayList<>(Arrays.asList(b)));
            }
        } else {
            if (hm.containsKey(a)) {
                hm.get(a).add(b);
            } else if (!hm.containsKey(a)) {
                hm.put(a, new ArrayList<>(Arrays.asList(b)));
            }

            if (hm.containsKey(b)) {
                hm.get(b).add(a);
            } else if (!hm.containsKey(b)) {
                hm.put(b, new ArrayList<>(Arrays.asList(a)));
            }
        }
    }


}

// out.println(al.toString().replaceAll("[\\[|\\]|,]",""));

