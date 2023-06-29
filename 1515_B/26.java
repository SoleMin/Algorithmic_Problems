//package sept;
 
import java.io.*;
import java.util.*;
 
public class TimePass {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    //boolean codechef=true;
    // String prodKey = "Av#/lL{OyEKiLR+/Ce%(w]^J65;XZe8FVb]]<931_=80E[BVnU^@4xu*J%KG3,CRqIZrUN~JJ+*6QC*CyBd>'$;>O"onO.bQ%{L}";
    boolean codechef=true;
    
    void solve()
    {
        int t=ni();
        while(t-->0) {
            int n=ni();
            int root=(int)Math.sqrt(n/2);
            int rootn = (int)Math.sqrt(n);
            if (n==1 || n%2!=0) {
                out.println("NO");
                continue;
            }
            if (root*root == n/2 || (rootn*rootn == n && rootn%2==0)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }
    
    static int comp(int a,int b){
        return a+1097*b;
    }
    
    static long printNcR(int n, int r)
    {
 
        // p holds the value of n*(n-1)*(n-2)...,
        // k holds the value of r*(r-1)...
        long p = 1, k = 1;
 
        // C(n, r) == C(n, n-r),
        // choosing the smaller value
        if (n - r < r) {
            r = n - r;
        }
 
        if (r != 0) {
            while (r > 0) {
                p *= n;
                k *= r;
 
                // gcd of p, k
                long m = __gcd(p, k);
 
                // dividing by gcd, to simplify
                // product division by their gcd
                // saves from the overflow
                p /= m;
                k /= m;
 
                n--;
                r--;
            }
 
            // k should be simplified to 1
            // as C(n, r) is a natural number
            // (denominator should be 1 ) .
        }
        else {
            p = 1;
        }
 
        // if our approach is correct p = ans and k =1
        return p;
    }
 
    static long __gcd(long n1, long n2)
    {
        long gcd = 1;
 
        for (int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is factor of both integers
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
    static long[][] dp;
    
    static long desc(int[] a,int l,int r) {
        if (l==r) return 0;
        if (dp[l][r]!=-1) return dp[l][r];
        dp[l][r] = a[r]-a[l] + Math.min(desc(a,l+1,r),desc(a,l,r-1));
        return dp[l][r];
    }
    
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
 
    static int MAX=1500;
    
    static int prime[], countdiv[]; 
    
    static int[] getDivisorsArray() {
        int n=20000005;
        int[] mind = new int[n];
        Arrays.fill(mind, -1);
        for(int i=2;i<n;i++){
            if (mind[i]==-1){
                for(int j=i;j<n;j+=i){
                    if (mind[j]==-1){
                        mind[j]=i;
                    }
                }
            }
        }
        // int[] nod = new int[n];
        // for(int i=2;i<n;i++){
        //     int prod = i/mind[i];
        //     if (mind[i] != mind[prod]) {
        //         nod[i] = nod[prod] + 1;
        //     } else {
        //         nod[i] = nod[prod];
        //     }
        // }
        return mind;
    }
      
    // Simple sieve to find smallest prime factors of numbers 
    // smaller than MAX 
    void SieveOfEratosthenes() 
    { 
        for (int i = 2; i * i < MAX; ++i) 
        { 
            if (prime[i]==0) 
                for (int j = i * i; j < MAX; j += i) 
                    prime[j] = i; 
        } 
      
        // Prime number will have same divisor 
        for (int i = 1; i < MAX; ++i) 
            if (prime[i]==0) 
                prime[i] = i; 
    } 
      
    // Returns length of the largest subsequence 
    // with GCD more than 1. 
    int largestGCDSubsequence(int arr[], int n) 
    { 
        int ans = 0; 
        for (int i=0; i < n; ++i) 
        { 
            int element = arr[i]; 
      
            // Fetch total unique prime divisor of element 
            while (element > 1) 
            { 
                int div = prime[element]; 
      
                // Increment count[] of Every unique divisor 
                // we get till now 
                ++countdiv[div]; 
      
                // Find maximum frequency of divisor 
                ans = Math.max(ans, countdiv[div]); 
      
                while (element % div==0) 
                    element /= div; 
            } 
        } 
      
        return ans; 
    } 
      
    
    static boolean check(int x)
    {
        char[] a=(""+x).toCharArray();
        int s=0;
        for(int i=0;i<a.length;i++)
        {
            s+=a[i]-'0';
            s%=3;
        }
        if(s==0)return true;
        return false;
    }
    
    
    static int[][] packD(int n,int[] from,int[] to)
    {
        int[][] g=new int[n][];
        int[] p=new int[n];
        for(int f:from)
        {
            p[f]++;
        }
        int m=from.length;
        for(int i=0;i<n;i++)
        {
            g[i]=new int[p[i]];
        }
        for(int i=0;i<m;i++)
        {
            g[from[i]][--p[from[i]]]=to[i];
        }
        return g;
    }
    
    static class Pair3
    {
        int a,b,c;
        public Pair3(int a,int b,int c)
        {
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
        
    static class Pair
    {
        int a,b;
        public Pair(int a,int b)
        {
            this.a=a;
            this.b=b;
        }
    }
    
    static long lcm(long a,long b)
    {
        long val=a;
        val*=b;
        return (val/gcd(a,b));
    }
    
    static long gcd(long a,long b)
    {
        if(a==0)return b;
        return gcd(b%a,a);
    }
    
    static int pow(int a, int b, int p)
    {
        long ans = 1, base = a;
        while (b!=0)
        {
            if ((b & 1)!=0)
            {
                ans *= base;
                ans%= p;
            }
            base *= base;
            base%= p;
            b >>= 1;
        }
        return (int)ans;
    }
 
    static int inv(int x, int p)
    {
        return pow(x, p - 2, p);
    }
 
    
    void run() throws Exception
    {
        if(codechef)oj=true;
        is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);
        
        long s = System.currentTimeMillis();
        solve();
        out.flush();
        tr(System.currentTimeMillis()-s+"ms");
    }
    
    public static void main(String[] args) throws Exception {new TimePass().run();}
    
    private byte[] inbuf = new byte[1024];
    public int lenbuf = 0, ptrbuf = 0;
    
    private int readByte()
    {
        if(lenbuf == -1)throw new InputMismatchException();
        if(ptrbuf >= lenbuf){
            ptrbuf = 0;
            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }
            if(lenbuf <= 0)return -1;
        }
        return inbuf[ptrbuf++];
    }
    
    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }
    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }
    
    private double nd() { return Double.parseDouble(ns()); }
    private char nc() { return (char)skip(); }
    
    private String ns()
    {
        int b = skip();
        StringBuilder sb = new StringBuilder();
        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }
    
    private char[] ns(int n)
    {
        char[] buf = new char[n];
        int b = skip(), p = 0;
        while(p < n && !(isSpaceChar(b))){
            buf[p++] = (char)b;
            b = readByte();
        }
        return n == p ? buf : Arrays.copyOf(buf, p);
    }
    
    private char[][] nm(int n, int m)
    {
        char[][] map = new char[n][];
        for(int i = 0;i < n;i++)map[i] = ns(m);
        return map;
    }
    
    private int[] na(int n)
    {
        int[] a = new int[n];
        for(int i = 0;i < n;i++)a[i] = ni();
        return a;
    }
    
    private int ni()
    {
        int num = 0, b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
    private long nl()
    {
        long num = 0;
        int b;
        boolean minus = false;
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
        if(b == '-'){
            minus = true;
            b = readByte();
        }
        
        while(true){
            if(b >= '0' && b <= '9'){
                num = num * 10 + (b - '0');
            }else{
                return minus ? -num : num;
            }
            b = readByte();
        }
    }
    
    private boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    private void tr(Object... o) { if(!oj)System.out.println(Arrays.deepToString(o)); }
}
