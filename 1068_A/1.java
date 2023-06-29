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
     static boolean isPowerOfTwo(long n) 
    { 
        if (n == 0) 
            return false; 
  
        while (n != 1) { 
            if (n % 2 != 0) 
                return false; 
            n = n / 2; 
        } 
        return true; 
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
  
    
   
       static long gcd(long a, long b) {
    if(a!=0&&b!=0)
        while((a%=b)!=0&&(b%=a)!=0);
    return a^b;
}
    static long LCM(long a,long b){
    return (Math.abs(a*b))/gcd(a,b);
   }
   public static class comp1 implements Comparator<Pair>{  
public int compare(Pair o1,Pair o2){
   if(o2.x==o1.x)
    return (o2.y-o1.y)>0?1:-1;
return (o2.x-o1.x)>0?1:-1;
}
  }
     public static class comp2 implements Comparator<Pair>{  
public int compare(Pair o1,Pair o2){
 
return (o2.ab-o1.ab)>0?1:-1;
}
  }
 static boolean can(int m,int s)
 {
    return (s>=0&&s<=m*9);
 }
   static boolean collinear(long x1, long y1, long x2,  
                          long y2, long x3, long y3) 
{
    long a = x1 * (y2 - y3) +  
                x2 * (y3 - y1) +  
                x3 * (y1 - y2); 
                if(a==0)
                    return true;
                return false;
}
static boolean vis[]=new boolean[51];
static int cnt=0;
static void dfs(int x)
{
    vis[x]=true;
    cnt++;
    for(int k:edges[x])
    {
        if(!vis[k])
            dfs(k);
                }

}
public static void main(String[] args)  throws Exception 
{
//java.util.Scanner scan=new java.util.Scanner(new File("mootube.in"));
 //PrintWriter out = new PrintWriter (new FileWriter("mootube.out"));
//scan=new FastReader("equal.in");
//out = new PrintWriter ("output.txt");
//System.out.println(3^2);
//System.out.println(19%4);
   //StringBuilder news=new StringBuilder("ab");
   //news.deleteCharAt(1);
   //news.insert(0,'c');
   //news.deleteCharAt(0);
   //System.out.println(news);
   //System.out.println(can(2,15));
    //System.out.println(LCM(2,2));
  // System.out.println(31^15);
 //System.out.println("bbabbbabbbabbbabbbabbbabbbabbbabbbabbbab".length());
int tt=1;
//tt=scan.nextInt();
//System.out.println(gcd(519,437));
  outer:while(tt-->0)
 {
    long n=scan.nextLong(),m=scan.nextLong(),l=scan.nextLong(),k=scan.nextLong();
    long res=0;
    if((l+k)%m!=0)
        res=((l+k)/m)+1;
    else res=(l+k)/m;
    if(m*res<=n)
        out.println(res);
    else out.println(-1);
    
  

}

out.close();
}    



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
static class special implements Comparable<special> {
    char x;
    int id;
    special(char x,int id)
    {
        this.id=id;
       this.x=x;
    }
    public int compareTo(special o)
    {
        return o.id-id;
    }
   
}
static long powMod(long base, long exp, long mod) {
       if (base == 0 || base == 1) return base;
       if (exp == 0) return 1;
       if (exp == 1) return base % mod;
       long R = powMod(base, exp/2, mod) % mod;
       R *= R;
       R %= mod;
       if ((exp & 1) == 1) {
           return base * R % mod;
       }
       else return R % mod;
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
         long ab;
        
        int z;
        public Pair(){}
        public Pair(int x1, int y1,int z) {
            x=x1;
            y=y1;
            this.z=z;
        }
        public Pair(int x1, int y1) {
            x=x1;
            y=y1;
            this.ab=x+y;
        
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
            return (int) (o.x-x);    
        }
}

}







