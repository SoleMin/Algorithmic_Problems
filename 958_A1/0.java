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
     static int[][] space;
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
     static Map<Integer,List<Integer>> map;
     static Map<Integer,Integer> map1;
     static StringBuilder sb,sb1,sb2;
     static int index;
     static long ans;
     static long[] sum;
     static int[] dx = {0,-1,0,1,-1,1,-1,1};
     static int[] dy = {-1,0,1,0,-1,-1,1,1};

     // public static void solve(){

     //    FastScanner sc = new FastScanner();
     //    // int t = sc.nextInt();
     //    int t = 1;
     //    for(int tt = 0 ; tt < t ; tt++){
     //        // n = sc.nextInt();
     //        m = sc.nextInt();
     //        // sb = new StringBuilder();
     //        // map = new HashMap<>();
     //        q = sc.nextInt();
     //        // ch = sc.next().toCharArray();
     //        boolean ans = false;
     //        for(int j = 0 ; j < q ; j++){

     //            n = sc.nextInt();
     //            set = new HashSet<>();
     //            arr = new long[n];
     //            boolean flag = false;

     //            for(int i = 0 ; i < n ; i++){
     //                arr[i] = Math.abs(sc.nextLong());
     //                if(set.contains(arr[i]))
     //                    flag = true;
     //                else
     //                    set.add(arr[i]);
     //            }

     //            if(!flag)
     //                ans = true;
          
     //        }

     //        if(ans){
     //            System.out.println("YES");
     //        }
     //        else
     //            System.out.println("NO");
     //    }
        
        
     // }

     //--------------->>>>IF YOU ARE HERE FOR QUICKSORT HACK THEN SORRY NO HACK FOR YOU<<<-------------------


     public static void solve(){

        boolean flag = true;
        int r = 0;
        int c = 0;

        for(int i = 0; i < n ; i++,r++){
            for(int j = 0 ; j < n ; j++,c++){
                c %= n;
                if(mat[i][j] != mat1[r][c]){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }

        if(flag){
            System.out.println("Yes");
            return;
        }

        r = 0;
        flag = true;
        c = 0;

        for(int i = 0; i < n ; i++,r++){
            for(int j = n-1 ; j > -1 ; j--,c++){
                c %= n;
                if(mat[i][j] != mat1[r][c]){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }

        if(flag){
            System.out.println("Yes");
            return;
        }

        r = 0;
        flag = true;
        c = 0;
        
        for(int j = n-1 ; j > -1 ; j--,r++){
            for(int i = 0 ; i < n ; i++,c++){
                c %= n;
                if(mat[i][j] != mat1[r][c]){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }

        if(flag){
            System.out.println("Yes");
            return;
        }
        r = 0;
        flag = true;
        c = 0;

        for(int j = n-1 ; j > -1 ; j--,r++){
            for(int i = n-1 ; i > -1 ; i--,c++){
                // System.out.println(i+" " + j + " " + r +" " + c);
                c %= n;
                if(mat[i][j] != mat1[r][c]){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }

        if(flag){
            System.out.println("Yes");
            return;
        }

        r = 0;
        flag = true;
        c = 0;

        for(int i = n-1 ; i > -1 ; i--,r++){
            for(int j = 0 ; j < n ; j++,c++){
                c %= n;
                if(mat[i][j] != mat1[r][c]){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }

        if(flag){
            System.out.println("Yes");
            return;
        }

        r = 0;
        flag = true;
        c = 0;

        for(int i = n-1 ; i > -1 ; i--,r++){
            for(int j = n-1 ; j > -1 ; j--,c++){
                c %= n;
                if(mat[i][j] != mat1[r][c]){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }

        if(flag){
            System.out.println("Yes");
            return;
        }

        r = 0;
        flag = true;
        c = 0;

        for(int j = 0 ; j < n ; j++,r++){
            for(int i = 0 ; i < n ; i++,c++){
                c %= n;
                if(mat[i][j] != mat1[r][c]){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }

        if(flag){
            System.out.println("Yes");
            return;
        }

        r = 0;
        flag = true;
        c = 0;

        for(int j = 0 ; j < n ; j++,r++){
            for(int i = n-1 ; i > -1 ; i-- ,c++){
                c %= n;
                if(mat[i][j] != mat1[r][c]){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                break;
        }

        if(flag){
            System.out.println("Yes");
            return;
        }

        System.out.println("No");

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

                // arr = new long[n];
                // for(int i = 0 ; i < n ; i++){
                //     arr[i] = sc.nextLong();
                // }
                // x = sc.nextLong();
                // y = sc.nextLong();
                // ch = sc.next().toCharArray();
                // m = n;
                // darr = new long[m];
                // for(int i = 0 ; i < m ; i++){
                //     darr[i] = sc.nextLong();
                // }

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

                m = n;
                mat = new char[n][m];
                for(int i = 0 ; i < n ; i++){
                    String s = sc.next();
                    for(int j = 0 ; j < m ; j++){
                        mat[i][j] = s.charAt(j);
                    }
                }

                m = n;
                mat1 = new char[n][m];
                for(int i = 0 ; i < n ; i++){
                    String s = sc.next();
                    for(int j = 0 ; j < m ; j++){
                        mat1[i][j] = s.charAt(j);
                    }
                }

                // str = new String[n];
                // for(int i = 0 ; i < n ; i++)
                //     str[i] = sc.next();

                // nodes = new Node[n];
                // for(int i = 0 ; i < n ;i++)
                //     nodes[i] = new Node(sc.nextInt(),(i));

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
    
    static void ruffleSort(char[] a) {
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