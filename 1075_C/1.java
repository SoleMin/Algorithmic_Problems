import java.util.*;
import java.math.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

     //--------------->>>>IF YOU ARE HERE FOR QUICKSORT HACK THEN SORRY NO HACK FOR YOU<<<-------------------

public class a{ 
     static long[] count,count1,count2;
     static boolean[] prime;
     static int[] spf;
     static Node[] nodes,nodes1,nodes2;
     static NodeInt[] nodesInt,nodesInt1;
     static long[] arr;
     static long[][] cost;
     static int[] arrInt,darrInt,farrInt;
     static long[][] dp;
     static char[] ch,ch1;
     static long[] darr,farr;
     static long[][] mat,mat1;
     static boolean[] vis;
     static long x,h;
     static long maxl;
     static double dec;
     static long mx = (long)1e7;
     static long inf = (long)1e15;
     static String s,s1,s2,s3,s4;
     static long minl;   
     static long mod = ((long)(1e9))+7;
     // static int minl = -1;
     // static long n;
     static int n,n1,n2,q,r1,c1,r2,c2;
     static int arr_size = (int)2e5+10;
     static long a;
     static long b;
     static long c;
     static long d;
     static long y,z;
     static int m;
     static int ans;
     static int k;
     static FastScanner sc;
     static String[] str,str1;
     static Set<Integer> set,set1,set2;
     static SortedSet<Long> ss;
     static List<Integer> list,list1,list2,list3;
     static PriorityQueue<Node> pq,pq1;
     static LinkedList<Node> ll,ll1,ll2;
     static Map<Integer,List<Integer>> map1;
     static Map<Integer,List<Integer>> map;
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

     //        m = sc.nextInt();

     //        // int k = sc.nextInt();

     //        // sb = new StringBuilder();

     //        map = new HashMap<>();
     //        map1 = new HashMap<>();

     //        // q = sc.nextInt();
     //        // sb = new StringBuilder();
     //        // long k = sc.nextLong();

     //        // ch = sc.next().toCharArray();

     //        // count = new int[200002];
           
     //        // m = sc.nextInt();

     //        for(int o = 0 ; o < m ; o++){

     //            int l = sc.nextInt()-1;
     //            int r = sc.nextInt()-1;

     //        }

     //    }
        
     // }

     //--------------->>>>IF YOU ARE HERE FOR QUICKSORT HACK THEN SORRY NO HACK FOR YOU<<<-------------------

     public static void solve(){

        List<Long> vertical = new ArrayList<>();
        List<Long> horizontol = new ArrayList<>();

        for(int i = 0; i < n ;i++){
            vertical.add(sc.nextLong());
        }
        vertical.add((long)(1e9));

        Collections.sort(vertical);

        int prev = 1;
        for(int i = 0 ; i < m ;i++){
            long x1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y = sc.nextLong();
            if(x1 == 1){
                horizontol.add(x2);
                // System.out.println(x2);
            }
                
        }

        Collections.sort(horizontol);
// 
        long ans = inf;
        int curr = 0;
        for(int i = 0 ; i < vertical.size() ; i++){

            long reach = vertical.get(i);
            int index = Collections.binarySearch(horizontol,reach);
            // System.out.println(index);
            if(index < 0){
                index *= -1;
                index -= 1;
            }
            // System.out.println(index + " " + reach);
            ans = min(ans,max(0,curr + horizontol.size() - index));

            curr += 1;

        }

        System.out.println(ans);

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

                n = sc.nextInt();

                // n1 = sc.nextInt();

                m = sc.nextInt();
                // q = sc.nextInt();

                // a = sc.nextLong();
                // b = sc.nextLong();

                // k = sc.nextInt();

                // x = sc.nextLong();
                // d = sc.nextLong();

                // s = sc.next();

                // ch = sc.next().toCharArray();
                // ch1 = sc.next().toCharArray();

                // m = sc.nextInt();
                // n = 6;

                // arr = new long[n];
                // for(int i = 0 ; i < n ; i++){
                //     arr[i] = sc.nextLong();
                // }

                // arrInt = new int[n+1];
                // for(int i = 1 ; i <= n ; i++){
                //     arrInt[i] = sc.nextInt();
                // }
                // x = sc.nextLong();
                // y = sc.nextLong();
                // ch = sc.next().toCharArray();
                // m = n;
                // m = sc.nextInt();
                // darr = new long[m];
                // for(int i = 0 ; i < m ; i++){
                //     darr[i] = sc.nextLong();
                // }
                // k = sc.nextLong();
                // m = n;
                // darrInt = new int[n];
                // for(int i = 0 ; i < n ; i++){
                //     darrInt[i] = sc.nextInt();
                // }

                // farrInt = new int[m];
                // for(int i = 0; i < m ; i++){
                //     farrInt[i] = sc.nextInt();
                // }

                // m = n;
                // mat = new long[n+1][m+1];
                // for(int i = 1 ; i <= n ; i++){
                //     for(int j = 1 ; j <= m ; j++){
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

                // str = new String[n];
                // for(int i = 0 ; i < n ; i++)
                //     str[i] = sc.next();

                // nodes = new Node[n];
                // for(int i = 0 ; i < n ;i++)
                //     nodes[i] = new Node(sc.nextLong(),sc.nextLong());

                // nodesInt = new NodeInt[n];
                // for(int i = 0 ; i < n ;i++)
                //     nodesInt[i] = new NodeInt(sc.nextInt(),sc.nextInt(),i);

                 solve();       
                 t -= 1;
            }

     }

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

    public static void SpecialSieve(int MAXN) 
    { 
        spf[1] = 1; 
        for (int i=2; i<MAXN; i++) 
       
            // marking smallest prime factor for every 
            // number to be itself. 
            spf[i] = i; 
       
        // separately marking spf for every even 
        // number as 2 
        for (int i=4; i<MAXN; i+=2) 
            spf[i] = 2; 
       
        for (int i=3; i*i<MAXN; i++) 
        { 
            // checking if i is prime 
            if (spf[i] == i) 
            { 
                // marking SPF for all numbers divisible by i 
                for (int j=i*i; j<MAXN; j+=i) 
       
                    // marking spf[j] if it is not  
                    // previously marked 
                    if (spf[j]==j) 
                        spf[j] = i; 
            } 
        } 
    } 

    public static ArrayList<Integer> getFactorization(int x) 
    { 
        ArrayList<Integer> ret = new ArrayList<Integer>(); 
        while (x != 1) 
        { 
            ret.add(spf[x]); 
            x = x / spf[x]; 
        } 
        return ret; 
    } 


    public static long gcd(long a, long b)
    {
      if (b == 0)
        return a;
      return gcd(b, a % b); 
    }

    public static long lcm(long a, long b)
    {
      return (b/gcd(b, a % b)) * a; 
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

     public static void swap(long[] curr,int i,int j){
         long temp = curr[j];
         curr[j] = curr[i];
         curr[i] = temp;
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

    static long binomialCoeff(long n, long k){ 

        long res = 1; 
  
        // Since C(n, k) = C(n, n-k) 
        if (k > n - k) 
            k = n - k; 
  
        // Calculate value of 
        // [n * (n-1) *---* (n-k+1)] / [k * (k-1) *----* 1] 
        for (long i = 0; i < k; ++i) { 
            res = (res*(n - i)); 
            res = (res/(i + 1)); 
        } 

        return res; 
    } 

    static long[] fact;

    public static long inv(long n){
        return power(n, mod-2);
    }

    public static void fact(int n){
        fact = new long[n+1];
        fact[0] = 1;
        for(int j = 1;j<=n;j++)
            fact[j] = (fact[j-1]*(long)j)%mod;               
    }

    public static long binom(int n, int k){
        fact(n+1);
        long prod = fact[n];
        prod*=inv(fact[n-k]);
        prod%=mod;
        prod*=inv(fact[k]);
        prod%=mod;
        return prod;    
    }

    static long power(long x, long y){
        if (y == 0)
            return 1;
        if (y%2 == 1)
            return (x*power(x, y-1))%mod;
        return power((x*x)%mod, y/2)%mod;
    }

    public static long pow(long n,long p,long m){
     long  result = 1;
      if(p==0)
        return 1;
          
    while(p!=0)
    {
        if(p%2==1)
            result *= n;
        if(result>=m)
        result%=m;
        p >>=1;
        n*=n;
        if(n>=m)
        n%=m;
    }
    return result;
    }

    static void sieve(int n){ 

        prime = new boolean[n+1]; 
        for(int i=2;i<n;i++) 
            prime[i] = true; 
          
        for(int p = 2; p*p <=n; p++) 
        { 
            if(prime[p] == true) 
            { 
                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 

    }

    static class Node{
        int first;
        int second;
        int third;
        Node(int f,int s,int t){
            this.first = f;
            this.second = s;
            this.third = t;
        }
    }

    static class NodeInt{
        int first;
        int second;
        int third;
        NodeInt(int f,int s,int third){
            this.first = f;
            this.second = s;
            this.third = third;
        }
    }

    static long abs(long a){
        return Math.abs(a);
    }

    static int abs(int a){
        return Math.abs(a);
    }

    static int max(int a,int b){
    if(a>b)
            return a;
    else
            return b;
    }
 
    static int min(int a,int b){
    if(a>b)
            return b;
    else 
            return a;
    }
 
    static long max(long a,long b){
    if(a>b)
            return a;
    else
            return b;
    }
 
    static long min(long a,long b){
    if(a>b)
            return b;
    else 
            return a;
    }

    static long sq(long num){
        return num*num;
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