import java.util.*;
import java.math.*;
import java.io.*; 
 public class A{

static FastReader scan=new FastReader();
 public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
  static LinkedList<Edge>edges[];
  static boolean stdin = true;
    static String filein = "input";
    static String fileout = "output";
static int dx[] = { -1, 0, 1, 0 };
static int dy[] = { 0, 1, 0, -1 };
int dx_8[]={1,1,1,0,0,-1,-1,-1};
int dy_8[]={-1,0,1,-1,1,-1,0,1};
static char sts[]={'U','R','D','L'};
static boolean prime[];
static long LCM(long a,long b){
    return (Math.abs(a*b))/gcd(a,b);
   }
   static long gcd(long a, long b) {
    if(a!=0&&b!=0)
        while((a%=b)!=0&&(b%=a)!=0);
    return a^b;
}
static int countSetBits(int n) 
    { 
        int count = 0; 
        while (n > 0) { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
 static void sieve(long n) 
    { 
        
        prime = new boolean[(int)n+1]; 
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
  
 
 
           static boolean isprime(long x)
           {
            for(long i=2;i*i<=x;i++)
                if(x%i==0)
                    return false;
                return true;
           }
           static int perm=0,FOR=0;
           
     

static boolean flag=false;
static int len=100000000;

static ArrayList<Pair>inters=new ArrayList<Pair>();





static StringBuilder sb;
static void swap(int i,int j,StringBuilder st)
{
    char tmp=st.charAt(i);
    st.setCharAt(i,st.charAt(j));
    st.setCharAt(j,tmp);
}


 private static int next(int[] arr, int target)  
    {  
        int start = 0, end = arr.length - 1;  
    
        int ans = -1;  
        while (start <= end) {  
            int mid = (start + end) / 2;  
    
            // Move to right side if target is  
            // greater.  
            if(arr[mid]==target)
                return mid;
            if (arr[mid] <target) {  
                start = mid + 1;  
            }  
    
            // Move left side.  
            else {  
                ans = mid;  
                end = mid - 1;  
            }  
        }  
        return ans;  
    }  
//static boolean vis[][];
    static long solve(int h,long n,int cur)
    {
        if(h==0)
            return 0;
        long half=1L<<(h-1);
        if(n<=half)
        {
            if((cur^1)==0)
                return 1+solve(h-1,n,0);
            else 
                return 2*half+solve(h-1,n,0);
        }
        else 
        {
              if((cur^1)==0)
             return 2*half+solve(h-1,n-half,1);
            else 
                return 1+solve(h-1,n-half,1);
        }
    }
static int dist[][];
public static String removeLeadingZeroes(String str) {
      String strPattern = "^0+(?!$)";
      str = str.replaceAll(strPattern, "");
      return str;
   }

    static String gcd(String str1, String str2)
    {
        // If str1 length is less than
        // that of str2 then recur
        // with gcd(str2, str1)
        if (str1.length() < str2.length()) {
            return gcd(str2, str1);
        }
 
        // If str1 is not the
        // concatenation of str2
        else if (!str1.startsWith(str2)) {
            return "";
        }
 
        else if (str2.isEmpty()) {
 
            // GCD string is found
            return str1;
        }
        else {
 
            // Cut off the common prefix
            // part of str1 & then recur
            return gcd(str1.substring(str2.length()),
                       str2);
        }
    }
   static ArrayList<Long>luckies=new ArrayList<Long>();
static void d(long x)
{
    if(x>=(long)1e10)
        return;
    luckies.add(x);
    d(x*10+4);
    d(x*10+7);
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
    
  
static long find(int x,int y)
{
    if(x>y)
        return 1;
    long l=find(x+1,y);
    out.println(l);
     //ans=pow(arr[x],l);
    return 0;
}
static int sum(int x)
{
    int res=0;
    while(x>0)
    {
        res+=(x%10);
        x/=10;
    }
    return res;
}


static boolean vis[]=new boolean[101];
static int n,m;
static ArrayList<Pair>res=new ArrayList<Pair>();
static String arr[];
static void swap(int i,int j)
{
    String tmp=arr[i];
    arr[i]=arr[j];
    arr[j]=tmp;
}
static void sort()
{
    int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j].length() >arr[j+1].length()) 
                {  
                    swap(j+1,j);
                } 

}
public static class comp1 implements Comparator<Pair>{  
public int compare(Pair o1,Pair o2){  
return (o2.x-o2.y)-(o1.x-o1.y);  
}  }

public static void main(String[] args)  throws Exception 
{
//SUCK IT UP AND DO IT ALRIGHT
//scan=new FastReader("input.txt");
//out = new PrintWriter ("output.txt");
   // System.out.println(pow((long)1e9,(long)1e9));
    int arr[]=new int[14];
    
  for(int i=0;i<14;i++)
    arr[i]=scan.nextInt();
long max=0;
for(int i=0;i<14;i++)
{
    int tmp[]=new int[14];
   
    for(int j=0;j<14;j++)
        tmp[j]=arr[j];
    int ok=tmp[i];
    tmp[i]=0;
    for(int l=0;l<14;l++)
        tmp[l]+=(ok/14);
    ok%=14; 
    int k=i+1;
    while(ok-->0)
    { 
        if(k==14)
            k=0;
            
            tmp[k++]++;
    }
    long cur=0;
    for(int l=0;l<14;l++)
    {
        if(tmp[l]%2==0)
            cur+=tmp[l];
    }
    max=Math.max(cur,max);
}

out.println(max);
out.close();

//SEE UP 

}
static long binexp(long a,long n)
{
    if(n==0)
        return 1;
    long res=binexp(a,n/2);
    if(n%2==1)
        return res*res*a;
    else 
        return res*res;
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
static double dis(double x1,double y1,double x2,double y2)
{
    return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
}
static long mod(long x,long y)
    {
        if(x<0)
            x=x+(-x/y+1)*y;
        return x%y;
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
        FastReader(String filename)throws Exception
        {

            br=new BufferedReader(new FileReader(filename));
        }

        boolean hasNext(){
            String line;
            while(root.hasMoreTokens())
                return true;
            return false;
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
 static class Pair implements Comparable<Pair>{
        public int x, y;
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
public int compareTo(Pair o)
{
    return (x-o.x);

    }

static class pair{
    int i;
    int j;
pair(int i,int j){
    this.i=i;
    this.j=j;
}}}
 static class tuple{
        int x,y,z;
        tuple(int a,int b,int c){
            x=a;
            y=b;
            z=c;
        }
    }
    static class Edge{
        int d,w;
        Edge(int d,int w)
        {
            this.d=d;
            this.w=w;
        }
    }
}









