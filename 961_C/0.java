

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


// graph, dfs,bfs, get connected components,iscycle, isbipartite, dfs on trees



public class scratch_25 {
    static class Graph{

        public static class Vertex{
            HashMap<Integer,Integer> nb= new HashMap<>();     // for neighbours of each vertex
        }

        public static HashMap<Integer,Vertex> vt;   // for vertices(all)

        public Graph(){
            vt= new HashMap<>();
        }

        public static int numVer(){
            return vt.size();
        }

        public static boolean contVer(int ver){
            return vt.containsKey(ver);
        }

        public static void addVer(int ver){
            Vertex v= new Vertex();
            vt.put(ver,v);
        }






        public static void addEdge(int ver1, int ver2, int weight){
            if(!vt.containsKey(ver1) || !vt.containsKey(ver2)){
                return;
            }
            Vertex v1= vt.get(ver1);
            Vertex v2= vt.get(ver2);
            v1.nb.put(ver2,weight);                                 // if previously there is an edge, then this replaces that edge
            v2.nb.put(ver1,weight);
        }

        public static void delEdge(int ver1, int ver2){

            if(!vt.containsKey(ver1) || !vt.containsKey(ver2)){
                return;
            }
            vt.get(ver1).nb.remove(ver2);
            vt.get(ver2).nb.remove(ver1);
        }
        public static void delVer(int ver){
            if(!vt.containsKey(ver)){
                return;
            }
            Vertex v1= vt.get(ver);
            ArrayList<Integer> arr= new ArrayList<>(v1.nb.keySet());
            for (int i = 0; i <arr.size() ; i++) {
                int s= arr.get(i);
                vt.get(s).nb.remove(ver);
            }
            vt.remove(ver);
        }
        static boolean done[];
        static int parent[];
        static ArrayList<Integer>vals= new ArrayList<>();


        public static boolean isCycle(int i){
            Stack<Integer>stk= new Stack<>();

            stk.push(i);
            while(!stk.isEmpty()){
                int x= stk.pop();
                vals.add(x);
                //   System.out.print("current="+x+" stackinit="+stk);
                if(!done[x]){
                    done[x]=true;
                }
                else if(done[x] ){
                    return true;
                }

                ArrayList<Integer>ar= new ArrayList<>(vt.get(x).nb.keySet());
                for (int j = 0; j <ar.size() ; j++) {
                    if(parent[x]!=ar.get(j)){
                        parent[ar.get(j)]=x;
                        stk.push(ar.get(j));
                    }
                }
                // System.out.println(" stackfin="+stk);
            }
            return false;
        }

        static HashMap<Integer, Set<Integer>>map;
        static int color[];
        public static void bfs(int v){
            Queue<Integer>q= new LinkedList<>();
            q.add(v);
            while(!q.isEmpty()){
                int x= q.poll();
                done[x]=true;
                ArrayList<Integer>ar= new ArrayList<>(vt.get(x).nb.keySet());
                Set<Integer>set= new HashSet<>();
                if(!map.containsKey(color[x])){
                    set= new HashSet<>();
                    map.put(color[x],set);
                }
                else{
                    set= map.get(color[x]);
                }
                for (int i = 0; i <ar.size() ; i++) {
                    int d= ar.get(i);
                    if(color[d]!=color[x]){
                        set.add(color[d]);}
                    if(!map.containsKey(color[d])){
                        Set<Integer>s= new HashSet<>();
                        s.add(color[x]);
                        map.put(color[d],s);
                    }
                    else{
                        Set<Integer>s= map.get(color[d]);
                        if(color[d]!=color[x]){
                            s.add(color[x]);
                            map.put(color[d],s);
                        }}
                    if(!done[d]){
                        q.add(d);
                    }
                }
                map.put(color[x],set);
            }
        }
    }




    // int count=0;
    //static long count=0;
    static class Reader {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /**
         * call this method to initialize reader for InputStream
         */
        static void init(InputStream input) {
            reader = new BufferedReader(
                    new InputStreamReader(input));
            tokenizer = new StringTokenizer("");
        }

        /**
         * get next word
         */
        static String next() throws IOException {
            while (!tokenizer.hasMoreTokens()) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                        reader.readLine());
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        static double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        static long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
    static class Pair implements Comparable<Pair>{
        int h;
        int w;
        int pos;
        public Pair(int h,int w,int pos){
            this.h=h;
            this.w=w;
            this.pos=pos;
        }
        @Override
        public int compareTo(Pair o){
            return (int)this.h-(int)o.h;

        }
        @Override
        public boolean equals(Object me) {
            Pair binMe = (Pair)me;
            if(this.h==binMe.h && this.w==binMe.w)
                return true;
            else
                return false;
        }

        @Override
        public String toString() {
            return h+" "+w+" "+pos;
        }


    }



    // After writing solution, quick scan for:
    //   array out of bounds
    //   special cases e.g. n=1?
    //
    // Big numbers arithmetic bugs:
    //   int overflow
    //   sorting, or taking max, or negative after MOD

   // static HashMap<int[], Integer>map;



    public static void main(String[] args)  throws IOException {
        Reader.init(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int n= Reader.nextInt();
        int min= Integer.MAX_VALUE;
        char arr[][][]= new char[4][n][n];
        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <n ; j++) {
                arr[i][j]= Reader.next().toCharArray();
            }

        }
//        for (int i = 0; i <4 ; i++) {
//            for (int j = 0; j <n ; j++) {
//                System.out.println(Arrays.toString(arr[i][j]));
//            }
//            System.out.println();
//        }

        for (int i = 0; i <4 ; i++) {
            for (int j = 0; j <4 ; j++) {
                if(i!=j){
                    for (int k = 0; k <4 ; k++) {
                        for (int l = 0; l <4 ; l++) {
                            if(i!=j && j!=k && k!=l && i!=k && i!=l && j!=l){
                                char chess[][]= new char[2*n][2*n];
                                char chess1[][]= new char[2*n][2*n];
                                char chess2[][]= new char[2*n][2*n];


                                for (int m = 0; m <n ; m++) {
                                    for (int o = 0; o <n ; o++) {
                                        chess[m][o]=arr[i][m][o];
                                        chess[m+n][o+n]=arr[j][m][o];
                                    }
                                }

                                for (int m = 0; m <n ; m++) {
                                    for (int o = 0; o <n ; o++) {
                                        chess[m+n][o]=arr[k][m][o];
                                        chess[m][o+n]=arr[l][m][o];
                                    }
                                }

                                for (int m = 0; m <2*n ; m++) {
                                    for (int o = 0; o <2*n ; o++) {
                                        if((m+o)%2==0){
                                            chess1[m][o]='0';
                                            chess2[m][o]='1';
                                        }
                                        else{
                                            chess1[m][o]='1';
                                            chess2[m][o]='0';
                                        }
                                    }
                                }
//                                System.out.println("chess1=");
//                                for (int m = 0; m <2*n ; m++) {
//                                    System.out.println(Arrays.toString(chess1[m]));
//                                }
//                                System.out.println("chess2=");
//                                for (int m = 0; m <2*n ; m++) {
//                                    System.out.println(Arrays.toString(chess2[m]));
//                                }
//
//                                System.out.println("chess==");
//                                for (int m = 0; m <2*n ; m++) {
//                                    System.out.println(Arrays.toString(chess[m]));
//                                }

                                int count1=0;
                                int count2=0;
                                for (int m = 0; m <2*n ; m++) {
                                    for (int o = 0; o <2*n ; o++) {
                                        if(chess[m][o]!=chess1[m][o]){
                                            count1++;
                                        }
                                        if(chess[m][o]!=chess2[m][o]){
                                            count2++;
                                        }
                                    }
                                }

                                min=Math.min(min,count1);
                                min= Math.min(min,count2);




                            }




                        }
                    }





                }




            }
        }
        out.append(min+"\n");




        out.flush();
        out.close();

    }


    public static long calc(long vals[], String s){
        int x= vals.length;
        long ans=0;
        for (int i = x-1; i >=1 ; i--) {
            int ind= s.length()-(x-i);
            if(ind<s.length() && s.charAt(ind)=='1'){
                ans+=vals[i];
            }
        }
        long val= Long.parseLong(s,2);
       // System.out.println("val="+val);
        ans+=((val)/(power(2,x-1,(long)1e18)))*vals[0];
        return ans;











    }


    public static String convert(String s,int n){
        if(s.length()==n){
            return s;
        }
        else{
            int x= s.length();
            int v=n-x;
            String str="";
            for (int i = 0; i <v ; i++) {
                str+='0';
            }
            str+=s;
            return str;

        }
    }

    static long modExp(long a, long b, long mod) {
        //System.out.println("a is " + a + " and b is " + b);
        if (a==1) return 1;
        long ans = 1;
        while (b!=0) {
            if (b%2==1) {
                ans = (ans*a)%mod;
            }
            a = (a*a)%mod;
            b/=2;
        }
        return ans;
    }


    public static long modmul(long a, long b, long mod) {
        return b == 0 ? 0 : ((modmul(a, b >> 1, mod) << 1) % mod + a * (b & 1)) % mod;
    }

    static long sum(long n){
        //   System.out.println("lol="+ (n*(n-1))/2);
        return (n*(n+1))/2;
    }






    public static ArrayList<Integer> Sieve(int n) {
        boolean arr[]= new boolean [n+1];
        Arrays.fill(arr,true);
        arr[0]=false;
        arr[1]=false;
        for (int i = 2; i*i <=n ; i++) {
            if(arr[i]){
                for (int j = 2; j <=n/i ; j++) {
                    int u= i*j;
                    arr[u]=false;
                }}
        }
        ArrayList<Integer> ans= new ArrayList<>();
        for (int i = 0; i <n+1 ; i++) {
            if(arr[i]){
                ans.add(i);
            }
        }
        return ans;
    }




    static long power( long x, long y, long p)
    {

        long res = 1;


        x = x % p;

        if (x == 0) return 0;

        while (y > 0)
        {

            if((y & 1)==1)
                res = (res * x) % p;


            y = y >> 1;
            x = (x * x) % p;
        }
        return res;
    }

    public static long ceil_div(long a, long b){
        return (a+b-1)/b;
    }

    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static long lcm(long a, long b)
    {
        return (a*b)/gcd(a, b);
    }

}