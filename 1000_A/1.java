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
  static int n;
  static long cnt=0;
static void d(long x)
{
    if(String.valueOf(x).length()>n)
        return;
    cnt++;
    luckies.add(x);
     d(x*10+7);
     d(x*10+8);
}

public static class comp1 implements Comparator<String>{  
public int compare(String o1,String o2){
return o1.length()-o2.length(); 
}
  }
  public static class comp2 implements Comparator<String>{  
public int compare(String o1,String o2){
return o1.compareTo(o2); 
}
  }

public static void main(String[] args)  throws Exception 
{
//SUCK IT UP AND DO IT ALRIGHT
//scan=new FastReader("input.txt");
//out = new PrintWriter ("output.txt");
   // System.out.println(pow((long)1e9,(long)1e9));
    //int elem[]={1,2,3,4,5};
  //  System.out.println(upperBound(elem,elem.length,5));
int tt=1;
//tt=scan.nextInt();
outer:while(tt-->0)
{
int n=scan.nextInt();
String orig[]=new String[n];
String sorted[]=new String[n];
Map<String,Integer>map=new HashMap<String,Integer>();
Map<String,Integer>map2=new HashMap<String,Integer>();
for(int i=0;i<n;i++){
orig[i]=scan.next();
map.put(orig[i],map.getOrDefault(orig[i],0)+1);
}
for(int i=0;i<n;i++){
sorted[i]=scan.next();
map2.put(sorted[i],map.getOrDefault(orig[i],0)+1);
}
int cnt=0;

   for (String s:sorted)  
         {
            if(map.containsKey(s)&&map.get(s)>0)
            {
              map.put(s,map.getOrDefault(s,0)-1);
            }
            else{
             cnt++;
             //map2.put(entry.getKey(),map2.getOrDefault(entry.getKey(),0)+1);
            }
         }
         out.println(cnt);
}
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









