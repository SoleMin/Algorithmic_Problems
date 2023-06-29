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
     static int[] dp;
     static char[] ch,ch1;
     static long[] darr,farr;
     static char[][] mat,mat1;
     static boolean[][] vis;
     static long x,h;
     static long maxl;
     static double dec;
     static long mx = (long)1e10;
     static String s;
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
     static Map<Integer,Long> map;
     static Map<Integer,Integer> map1;
     static StringBuilder sb,sb1,sb2;
     static int index;
     static long ans;
     static int[] dx = {0,-1,0,1,-1,1,-1,1};
     static int[] dy = {-1,0,1,0,-1,-1,1,1};

     // public static void solve(){

     //    FastScanner sc = new FastScanner();
     //    // int t = sc.nextInt();
     //    int t = 1;
     //    for(int tt = 0 ; tt < t ; tt++){
     //        int n = sc.nextInt();
     //        // int m = sc.nextInt();
     //        // int prev = 0;
     //        int l = 0;
     //        int r = 0;
     //        sb = new StringBuilder();
     //        for(int i = 0 ; i < n ; i++){
     //            l = sc.nextInt();
     //            r = sc.nextInt();
     //            double ans = ((r*1.0)+1)/2;
     //            if((l*1.0) >= ans && ((r*1.0) >= ans))
     //                sb.append("YES\n");
     //            else
     //                sb.append("NO\n");
     //        }

     //        System.out.print(sb);
     //    }
        
        
     // }

     //--------------->>>>IF YOU ARE HERE FOR QUICKSORT HACK THEN SORRY NO HACK FOR YOU<<<-------------------

     public static void solve(){

        long[] dp = new long[n];
        dp[n-1] = mx;
        dp[0] = dp[n-1];
        for(int i = n-2 ; i > 0 ; i--){
            dp[i] = mx;
            for(int j = i+1 ; j < n; j++){
                if(arr[j] <= arr[i])
                    continue;
                dp[i] = Math.min(dp[i],darr[i] + darr[j]);
            }
        }
        long ans = mx*8;
        for(int i = 0 ; i < n-1 ; i++){
            long local = mx*8;
            for(int j = i+1 ; j < n-1 ; j++){
                if(arr[j] <= arr[i])
                    continue;
                local = Math.min(local,darr[i]+dp[j]);
            }
            ans = Math.min(ans,local);
        }
        if(ans >= mx){
            System.out.println(-1);
            return;
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
                // a = sc.nextLong();
                // b = sc.nextLong();
                // c = sc.nextLong();
                // d = sc.nextLong();

                // x = sc.nextLong();
                // y = sc.nextLong();
                
                // n = sc.nextLong();
                n = sc.nextInt();
                // n1 = sc.nextInt();

                // m = sc.nextInt();
                // q = sc.nextInt();

                // k = sc.nextLong();
                // s = sc.next();

                // ch = sc.next().toCharArray();
                // ch1 = sc.next().toCharArray();

                arr = new long[n];
                for(int i = 0 ; i < n ; i++){
                    arr[i] = sc.nextLong();
                }
                // x = sc.nextLong();
                // y = sc.nextLong();
                // ch = sc.next().toCharArray();
                // m = n;
                darr = new long[n];
                for(int i = 0 ; i < n ; i++){
                    darr[i] = sc.nextLong();
                }

                // farr = new int[n];
                // for(int i = 0; i < n ; i++){
                //     farr[i] = sc.nextInt();
                // }

                // mat = new int[n][n];
                // for(int i = 0 ; i < n ; i++){
                //     for(int j = 0 ;  j < n ; j++){
                //         mat[i][j] = sc.nextInt();
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
                //     nodes[i] = new Node((int)arr[i],(int)darr[i]);

                // System.out.println(solve()?"YES":"NO");
                 solve();       
                 // System.out.println(solve());
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

     public static long gcd(long a,long b){

        if(b%a == 0){
            return a;
        }
        return gcd(b%a,a);

     }

     public static void swap(int i,int j){
         char temp = ch[j];
         ch[j] = ch[i];
         ch[i] = temp;
     } 

    static final Random random=new Random();
    
    static void ruffleSort(long[] a) {
        int n=a.length;//shuffle, then sort 
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n);
            long temp=a[oi];
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