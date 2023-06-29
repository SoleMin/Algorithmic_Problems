import java.util.*;
import java.math.*;
import java.io.*; 
 public class B{
static int[] dx={-1,1,0,0};
static int[] dy={0,0,1,-1};
    static FastReader scan=new FastReader();
   public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
  static ArrayList<Pair>es;
  static LinkedList<Integer>edges[];
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

  
   
static boolean isprime(long x)
           {
            for(long i=2;i*i<=x;i++)
                if(x%i==0)
                    return false;
                return true;
           }


static int dist(int x1,int y1,int x2,int y2){
return Math.abs(x1-x2)+Math.abs(y1-y2);
}


    static long cuberoot(long x)
    {
        long lo = 0, hi = 1000005;
        while(lo<hi)
        {
            long m = (lo+hi+1)/2;
            if(m*m*m>x)
                hi = m-1;
            else
                lo = m;
        }
        return lo;
    }
     public static int log2(int N) 
    { 
  
        // calculate log2 N indirectly 
        // using log() method 
        int result = (int)(Math.log(N) / Math.log(2)); 
  
        return result; 
    } 
  
    
   
       static int gcd(int a, int b) {
    if(a!=0&&b!=0)
        while((a%=b)!=0&&(b%=a)!=0);
    return a^b;
}
    static int LCM(int a,int b){
    return (Math.abs(a*b))/gcd(a,b);
   }
   public static class comp1 implements Comparator<Integer>{  
public int compare(Integer o1,Integer o2){
return Math.abs(o1)-Math.abs(o2);
}
  }
  static int n,k;
  static int arr[];
  static boolean ok(int x)
{
    int cnt=0;
    for(int i=0;i<n;i++)
    {
        if(arr[i]<=x)
            cnt++;
        
    }
    if(cnt==k)
        return true;
    else return false;
}
static boolean isSubSequence(String str1,  
                    String str2, int m, int n) 
    { 
        int j = 0; 
          
        // Traverse str2 and str1, and compare  
        // current character of str2 with first 
        // unmatched char of str1, if matched  
        // then move ahead in str1 
        for (int i = 0; i < n && j < m; i++) 
            if (str1.charAt(j) == str2.charAt(i)) 
                j++; 
  
        // If all characters of str1 were found 
        // in str2 
        return (j == m);  
    } 
    static int goal[],init[];
    static Set<Integer>sol;
    static boolean vis[];

    static void dfs1(int x,int cur,int count,int level)
    {
        vis[x]=true;
        if(cur!=goal[x])
        {
            if(level%2==1)
                count++;
            sol.add(x);
        }
        for(int i:edges[x])
        {
            if(!vis[i])
            {
                if(level%2==1)
                dfs1(i,(count+init[i])%2,count,level+1);
            }
        }
    }
    static void dfs2(int x,int cur,int count,int level)
    {
        vis[x]=true;
        out.println("FUCK");
        if(cur!=goal[x])
        {
            if(level%2==1)
                count++;
            sol.add(x);
        }
        for(int i:edges[x])
        {
            if(!vis[i])
            {
                if(level%2==0)
                dfs2(i,(count+init[i])%2,count,level+1);
            }
        }
    }
    static boolean canMake(int n, int ar[]) 
{ 
    // Base Case 
    if (n == 1) 
        return true; 
    else 
    { 
  
        // First subarray is 
        // stricly increasing 
        if (ar[0] < ar[1])  
        { 
  
            int i = 1; 
  
            // Check for strictly 
            // increasing condition 
            // & find the break point 
            while (i < n && ar[i - 1] < ar[i])  
            { 
                i++; 
            } 
  
            // Check for strictly 
            // decreasing condition 
            // & find the break point 
            while (i + 1 < n && ar[i] > ar[i + 1]) 
            { 
                i++; 
            } 
  
            // If i is equal to 
            // length of array 
            if (i >= n - 1) 
                return true; 
            else
                return false; 
        } 
  
        // First subarray is 
        // strictly Decreasing 
        else if (ar[0] > ar[1])  
        { 
            int i = 1; 
  
            // Check for strictly 
            // increasing condition 
            // & find the break point 
            while (i < n && ar[i - 1] > ar[i])  
            { 
                i++; 
            } 
  
            // Check for strictly 
            // increasing condition 
            // & find the break point 
            while (i + 1 < n && ar[i] < ar[i + 1])  
            { 
                i++; 
            } 
  
            // If i is equal to 
            // length of array - 1 
            if (i >= n - 1) 
                return true; 
            else
                return false; 
        } 
  
        // Condition if ar[0] == ar[1] 
        else 
        { 
            for (int i = 2; i < n; i++) 
            { 
                if (ar[i - 1] <= ar[i]) 
                    return false; 
            } 
            return true; 
        } 
    } 
} 
public static void main(String[] args)  throws Exception 
{
//java.util.Scanner scan=new java.util.Scanner(new File("mootube.in"));
 //PrintWriter out = new PrintWriter (new FileWriter("mootube.out"));
 //scan=new FastReader("input.txt");
 //out = new PrintWriter ("output.txt");
 //System.out.println(~-1);
//System.out.println(2<<5);
    //System.out.println(0^1023);
//System.out.println(gcd(672,840));

  int tt=1;

//tt=scan.nextInt();
 outer:while(tt-->0)
 {
    int n=scan.nextInt();
    int arr[]=new int[n];
  int sum=0;
   for(int i=0;i<n;i++){
    arr[i]=scan.nextInt();
sum+=arr[i];
}
int cur=0;
if(sum%2!=0)
{
    sum=sum/2;
    sum++;
}
else
sum=sum/2;
for(int i=0;i<n;i++)
{
    if(cur+arr[i]>=sum)
    {
        out.println((i+1));
        out.close();
        return;
    }
    cur+=arr[i];
}
  
    

    
  }

out.close();
    
}
static class dsu{
    static int id[]=new int[5001];
    dsu()
    {
        for(int i=0;i<1000+5;i++)
            id[i]=i;
    }
    static int find(int x)
    {
        if(x==id[x])
            return x;
        return find(id[x]);
    }
    static void connect(int x,int y)
    {
        int p=find(x);
        int q=find(y);
        id[p]=q;
        //id[q]=p;
    }
    static boolean is(int x,int y)
    {
        int p=find(x);
        int q=find(y);
        if(p==q)
            return true;
        else return false;
    }}
static long binexp(long a,long n,long mod)
{
    if(n==0)
        return 1;
    long res=binexp(a,n/2,mod)%mod;
    res=res*res;
    if(n%2==1)
        return (res*a)%mod;
    else 
        return res%mod;
}
static class special implements Comparable<special>{
    int x;
    char id;
    special(int x,char id)
    {
        this.id=id;
       this.x=x;
    }
    public int compareTo(special o)
    {
        
        return x-o.x;
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

private static void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int object : arr) list.add(object);
        Collections.sort(list);
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
    }
 public static class FastReader {
        BufferedReader br;
        StringTokenizer root;
        
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        FastReader(String filename)throws Exception
        {

            br=new BufferedReader(new FileReader(filename));
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
         int y;
        
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







