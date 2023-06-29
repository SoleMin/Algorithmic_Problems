import java.util.*;
import java.math.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

     //--------------->>>>IF YOU ARE HERE FOR QUICKSORT HACK THEN SORRY NO HACK FOR YOU<<<-------------------

public class a{ 
     static int[] count,count1,count2;
     static Node[] nodes;
     static long[] arr;
     static int[] dp,arrInt,darrInt;
     static char[] ch,ch1;
     static long[] darr,farr;
     static char[][] mat,mat1;
     static int[][] space;
     static boolean[][] vis;
     static long x,h;
     static long maxl;
     static double dec;
     static long mx = (long)1e10;
     static String s,s1,s2,s3,s4;
     static long minl;
     static int start_row;
     static int start_col;     
     static int end_row;     
     static int end_col;     
     static long mod = 998244353;
     // static int minl = -1;
     // static long n;
     static int n,n1,n2,q,r1,c1,r2,c2;
     static long a;
     static long b;
     static long c;
     static long d;
     static long y,z;
     static int m;
     static long k;
     static FastScanner sc;
     static String[] str,str1;
     static Set<Long> set,set1,set2;
     static SortedSet<Long> ss;
     static List<Long> list,list1,list2,list3;
     static PriorityQueue<Integer> pq,pq1;
     static LinkedList<Node> ll;
     static Map<Integer,List<Integer>> map1;
     static Map<Long,Integer> map;
     static StringBuilder sb,sb1,sb2;
     static int index;
     static long[] sum;
     static int[] dx = {0,-1,0,1,-1,1,-1,1};
     static int[] dy = {-1,0,1,0,-1,-1,1,1};

     // public static void solve(){

     //    FastScanner sc = new FastScanner();
     //    // int t = sc.nextInt();
     //    int t = 1;
     //    for(int tt = 0 ; tt < t ; tt++){

     //        // s = sc.next();
     //        // s1 = sc.next();

     //        n = sc.nextInt();
     //        // m = sc.nextInt();
     //        sb = new StringBuilder();
     //        // map = new HashMap<>();
     //        // q = sc.nextInt();
     //        // k = sc.nextLong();
     //        // ch = sc.next().toCharArray();
     //        // boolean ans = false;
     //        // int charge = n;
     //        // int prev = 0;

     //        count = new int[7];
           
     //        // m = sc.nextInt();
     //        // long ans = 0;
     //        // long added = 0;
     //        for(int j = 0 ; j < n ; j++){


     //        }

     //    }
        
     // }

     //--------------->>>>IF YOU ARE HERE FOR QUICKSORT HACK THEN SORRY NO HACK FOR YOU<<<-------------------

     public static void solve(){

        int zeros = 0;
        int pos = -1;
        for(int i = 0 ; i < n ; i++){
            if(ch[i] == '0'){
                zeros += 1;
            }
            else if(pos == -1){
                pos = i;
            }
        }

        if(pos == -1){
            System.out.println("0");
            return;
        }

        sb = new StringBuilder();
        sb.append("1");

        for(int i = pos+1 ; i <= pos+zeros ; i++){
            sb.append("0");
        }
        System.out.println(sb);

     }
        
     public static void main(String[] args) {

            sc = new FastScanner();
            // Scanner sc = new Scanner(System.in);
            // int t = sc.nextInt();
            int t = 1;
            // int l = 1;
            while(t > 0){
                
                // n = sc.nextInt();
                // n = sc.nextLong();
                // k = sc.nextLong();
                // x = sc.nextLong();
                // y = sc.nextLong();
                // z = sc.nextLong();

                // a = sc.nextLong();
                // b = sc.nextLong();
                // c = sc.nextLong();
                // d = sc.nextLong();

                // x = sc.nextLong();
                // y = sc.nextLong();
                // z = sc.nextLong();
                // d = sc.nextLong();
                // n = sc.nextLong();

                n = sc.nextInt();

                // n = 3;
                // n1 = sc.nextInt();

                // m = sc.nextInt();
                // q = sc.nextInt();

                // k = sc.nextLong();
                // d = sc.nextLong();
                // s = sc.next();

                ch = sc.next().toCharArray();
                // ch1 = sc.next().toCharArray();

                // n = 3;
                // arr = new long[n];
                // for(int i = 0 ; i < n ; i++){
                //     arr[i] = sc.nextLong();
                // }

                // arrInt = new int[n];
                // for(int i = 0 ; i < n ; i++){
                //     arrInt[i] = sc.nextInt();
                // }
                // x = sc.nextLong();
                // y = sc.nextLong();
                // ch = sc.next().toCharArray();
                // m = n;
                // darr = new long[m];
                // for(int i = 0 ; i < m ; i++){
                //     darr[i] = sc.nextLong();
                // }

                // m = n;
                // darrInt = new int[m];
                // for(int i = 0 ; i < m ; i++){
                //     darrInt[i] = sc.nextInt();
                // }

                // farr = new int[n];
                // for(int i = 0; i < n ; i++){
                //     farr[i] = sc.nextInt();
                // }

                // mat = new long[n][m];
                // for(int i = 0 ; i < n ; i++){
                //     for(int j = 0 ; j < m ; j++){
                //         mat[i][j] = sc.nextLong();
                //     }
                // }

                // m = n;
                // mat = new char[n][m];
                // for(int i = 0 ; i < n ; i++){
                //     String s = sc.next();
                //     for(int j = 0 ; j < m ; j++){
                //         mat[i][j] = s.charAt(j);
                //     }
                // }

                // m = n;
                // mat1 = new char[n][m];
                // for(int i = 0 ; i < n ; i++){
                //     String s = sc.next();
                //     for(int j = 0 ; j < m ; j++){
                //         mat1[i][j] = s.charAt(j);
                //     }
                // }

                // n= 5 ;
                // str = new String[n];
                // for(int i = 0 ; i < n ; i++)
                //     str[i] = sc.next();

                // nodes = new Node[n];
                // for(int i = 0 ; i < n ;i++)
                //     nodes[i] = new Node(sc.nextInt(),(i+1));

                // m = sc.nextInt();

                // System.out.println(solve()?"YES":"NO");
                 solve();       
                 // System.out.println(solve());
                 t -= 1;
            }

     }

     // public static dfs(int i){

     //    if(count[i] == 1)
     //        return;
     //    list = map.get(i);
     //    for(Integer j : list){
     //        if(j == i)
     //            continue;
     //        dfs(j);
     //    }
     // }

    public static int log(long n,long base){

         if(n == 0 || n == 1)
             return 0;

         if(n == base)
             return 1;

         double num = Math.log(n);
         double den = Math.log(base);

         if(den == 0)
             return 0;

         return (int)(num/den);
     }

    public static boolean isPrime(long n) { 
    // Corner cases 
        if (n <= 1)  
            return false; 

        if (n <= 3)  
            return true; 
      
        // This is checked so that we can skip  
        // middle five numbers in below loop 
        if (n%2 == 0 || n%3 == 0) 
            return false; 
      
        for (int i=5; i*i<=n; i=i+6) 
            if (n%i == 0 || n%(i+2) == 0) 
               return false; 
      
        return true; 
    } 

    public static long gcd(long a, long b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b); 
    }

     public static long mod_inverse(long a,long mod){
        long x1=1,x2=0;
        long p=mod,q,t;
        while(a%p!=0){
          q = a/p;
          t = x1-q*x2;
          x1=x2; x2=t;
          t=a%p;
          a=p; p=t;
        }
        return x2<0 ? x2+mod : x2;
    }

     public static void swap(int i,int j){
         long temp = arr[j];
         arr[j] = arr[i];
         arr[i] = temp;
     } 

    static final Random random=new Random();

    static void ruffleSortLong(long[] a) {
        int n=a.length;//shuffle, then sort 
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n);
            long temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }

    static void ruffleSortInt(int[] a) {
        int n=a.length;//shuffle, then sort 
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n);
            int temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }
    
    static void ruffleSortChar(char[] a) {
        int n=a.length;//shuffle, then sort 
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n);
            char temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }

    static class Node{
        Integer first;
        Integer second;
        Node(Integer f,Integer s){
            this.first = f;
            this.second = s;
        }
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
        }

}