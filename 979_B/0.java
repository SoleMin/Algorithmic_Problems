import java.util.*;
import java.math.*;
import java.io.*; 
 public class B{
static int[] dx={-1,1,0,0};
static int[] dy={0,0,1,-1};
    static FastReader scan=new FastReader();
   public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
  static ArrayList<Pair>es;
  static LinkedList<Pair>edges[][];
   static boolean prime[];
   static void sieve(int n) 
    { 
        
        prime = new boolean[n+1]; 
        for(int i=0;i<n;i++) 
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
  
 public static boolean areSame(int []arr)
    {
        // Put all array elements in a HashSet
        Set<Integer>s=new HashSet<Integer>();
        for(int i=0;i<arr.length;i++)
            s.add(arr[i]);

 
        // If all elements are same, size of
        // HashSet should be 1. As HashSet contains only distinct values.
        return (s.size() == 1);
    }
   

    
     public static int lowerBound(long[] array, int length, long value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            //checks if the value is less than middle element of the array
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static int upperBound(long[] array, int length, long value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = low+(high-low) / 2;
            if ( array[mid]>value) {
                high = mid ;
            } else {
                low = mid+1;
            }
        }
        return low;
    }
static long mod(long x,long y)
    {
        if(x<0)
            x=x+(-x/y+1)*y;
        return x%y;
    }
    
    
    static boolean isPowerOfTwo(int n)
{
    if(n==0)
    return false;
 
return (int)(Math.ceil((Math.log(n) / Math.log(2)))) == 
       (int)(Math.floor(((Math.log(n) / Math.log(2)))));
}
static int CeilIndex(int A[], int l, int r, int key) 
    { 
        while (r - l > 1) { 
            int m = l + (r - l) / 2; 
            if (A[m] >= key) 
                r = m; 
            else
                l = m; 
        } 
  
        return r; 
    } 
  
    static int LongestIncreasingSubsequenceLength(int A[], int size) 
    { 
        // Add boundary case, when array size is one 
  
        int[] tailTable = new int[size]; 
        int len; // always points empty slot 
  
        tailTable[0] = A[0]; 
        len = 1; 
        for (int i = 1; i < size; i++) { 
            if (A[i] < tailTable[0]) 
                // new smallest value 
                tailTable[0] = A[i]; 
  
            else if (A[i] >= tailTable[len - 1]) 
                // A[i] wants to extend largest subsequence 
                tailTable[len++] = A[i]; 
  
            else
                // A[i] wants to be current end candidate of an existing 
                // subsequence. It will replace ceil value in tailTable 
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i]; 
        } 
  
        return len; 
    } 
static boolean isprime(long x)
           {
            for(long i=2;i*i<=x;i++)
                if(x%i==0)
                    return false;
                return true;
           }
           static long arr[];
      
        static int k;

 static boolean can(long x)
 {
    int bl=0;
    int i=0;
    for(int kas=0;i<n&&kas<k;kas++)
    {
        long hasta=arr[i];
        hasta+=x*2;
        while(i<n-1&&arr[i+1]<=hasta)i++;
        i++;
        
    }
return (i>=n);
 }
static int n,m;
static boolean vis[][];
static boolean light[][];
static boolean e(int x,int y)
{
    return (x>=0&&x<n&&y>=0&&y<n);
}
static int ans=0;
static void dfs(int x,int y)
{
    if(vis[x][y])
        return;
    vis[x][y]=true;
   //light[x][y]=true;
    for(Pair p:edges[x][y])
    {
        if(!light[p.x][p.y]){
            light[p.y][p.y]=true;
            ans++;
            dfs(p.x,p.y);
                    }
    }
    for(int i=0;i<4;i++){
    int nx=x+dx[i],ny=y+dy[i];
    if(e(nx,ny))
        dfs(nx,ny);
}

}
static int dist(int x1,int y1,int x2,int y2){
return Math.abs(x1-x2)+Math.abs(y1-y2);
}
static int x;
static int min(int y,int k)
{
    if(y==x)
        return 0;
    return Math.min(min(y+k,k++)+1,min(y-1,k)+1);
}
static boolean is(int arr[])
{
    for(int i=1;i<arr.length;i++)
        if(arr[i]<arr[i-1])
            return false;
        return true;
}
  static void reverse(int myArray[]) 
    { 
        Collections.reverse(Arrays.asList(myArray)); 
    } 
    static boolean isPerfect(long n) 
{ 
    // To store sum of divisors 
    long sum = 1; 
  
    // Find all divisors and add them 
    for (long i = 2; i * i <= n; i++) 
    { 
        if (n % i==0) 
        { 
            if(i * i != n) 
                sum = sum + i + n / i; 
            else
                sum = sum + i; 
        } 
    }  
    // If sum of divisors is equal to 
    // n, then n is a perfect number 
    if (sum == n && n != 1) 
        return true; 
  
    return false; 
} 
static char []a,b,c;
static char chose(int i)
{
char ch='a';
while(ch==a[i]||ch==b[i])
ch++;
return ch;
}
static int v1,v2,t,d;
static boolean can(int k,int l)
{
while(l>0)
{
    k-=d;
    l--;
}
if(k<=v2)
    return true;
else 
    return false;
}
public static void main(String[] args)  throws IOException 



{
//java.util.Scanner scan=new java.util.Scanner(new File("mootube.in"));
 //PrintWriter out = new PrintWriter (new FileWriter("mootube.out"));
//java.util.Scanner scan=new java.util.Scanner(new File("lightson.in"));
//PrintWriter out = new PrintWriter (new FileWriter("lightson.out"));
    long n=scan.nextLong();
    String s1=scan.next(),s2=scan.next(),s3=scan.next();
    int f=0,s=0,fs=0;
    long cnt1[]=new long[265];
    long cnt2[]=new long[265];
    long cnt3[]=new long[265];
    for(int i=0;i<s1.length();i++)
    {
        cnt1[s1.charAt(i)]++;
    }
    for(int i=0;i<s2.length();i++)
    {
        cnt2[s2.charAt(i)]++;
    }
    for(int i=0;i<s3.length();i++)
    {
        cnt3[s3.charAt(i)]++;
    }
    long max1=0,max2=0,max3=0;
    for(int i=0;i<265;i++)
        max1=Math.max(max1,cnt1[i]);
     for(int i=0;i<265;i++)
        max2=Math.max(max2,cnt2[i]);
     for(int i=0;i<265;i++)
        max3=Math.max(max3,cnt3[i]);
    long len1=(long)s1.length();
    long len2=(long)s2.length();
    long len3=(long)s3.length();
    if(len1==max1&&n==1)
        len1--;
    if(len2==max2&&n==1)
        len2--;
    if(len3==max3&&n==1)
        len3--;
  max1=Math.min(max1+n,len1);
   max2=Math.min(max2+n,len2);
    max3=Math.min(max3+n,len3);
    long maxall=Math.max(max1,Math.max(max2,max3));
    if((maxall==max2&&maxall==max3)||(maxall==max1&&maxall==max2)||(maxall==max1&&maxall==max3))
        out.println("Draw");
    else if(Math.max(max1,Math.max(max2,max3))==max1)
        out.println("Kuro");
    else if(Math.max(max1,Math.max(max2,max3))==max2)
        out.println("Shiro");
    else if(Math.max(max1,Math.max(max2,max3))==max3)
        out.println("Katie");


    



out.close();
}
static class special implements Comparable<special>{
    String c;
    int id;
    special(String c,int id)
    {
        this.id=id;
       this.c=c;
    }
    public int compareTo(special o)
    {
        if(id==o.id){
            if(c.compareTo(o.c)>0)
                return 1;
            else if(c.compareTo(o.c)<0) return -1;
                else return 0;
        }
        return o.id-id;
    }
   
}
 public static  long pow(long b, long e) {
            long r = 1;
            while (e > 0) {
                if (e % 2 == 1) r = r * b ;
                b = b * b;
                e >>= 1;
            }
            return r;
        }

private static void sort(long[] arr) {
        List<Long> list = new ArrayList<>();
        for (long object : arr) list.add(object);
        Collections.sort(list);
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
    }
 public static class FastReader {
        BufferedReader br;
        StringTokenizer root;
        
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (root == null || !root.hasMoreTokens()) {
                try {
                    root = new StringTokenizer(br.readLine());
                } catch (Exception addd) {
                    addd.printStackTrace();
                }
            }
            return root.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception addd) {
                addd.printStackTrace();
            }
            return str;
        }
         public int[] nextIntArray(int arraySize) {
            int array[] = new int[arraySize];
 
            for (int i = 0; i < arraySize; i++) {
                array[i] = nextInt();
            }
 
            return array;
        }
}
public static class Pair implements Comparable<Pair>{
         int x;
        int  y;
        int id;
        public Pair(){}
        public Pair(int x1, int y1,int id) {
            x=x1;
            y=y1;
            this.id=id;
        }
        public Pair(int x1, int y1) {
            x=x1;
            y=y1;
        
        }
        @Override
        public int hashCode() {
            return (int)(x + 31 * y);
        }
        public String toString() {
            return x + " " + y;
        }
        @Override
        public boolean equals(Object o){
            if (o == this) return true;
            if (o.getClass() != getClass()) return false;
            Pair t = (Pair)o;
            return t.x == x && t.y == y;
        }
        public  int compareTo(Pair o)
        {
            if(x==o.x)
                return y-o.y;
            return x-o.x;
        }
}

}







