import java.util.*;
import java.io.*;

public class Sol{

static class Pair implements Comparable<Pair>{
        int x;int y;int value;
        public Pair(int x,int y,int value) {
         
          this.x=x;
          this.y=y;
          this.value=value;
        }
        @Override
        public int compareTo(Pair p){return Long.compare(y,p.y); }
       
   }

public static void main(String []args){

int t=1;

while(t-->0){
int n=ni();mod=nl();
precomp();
long dp[][]=new long[405][405];dp[0][0]=1l;
for(int i=0;i<n;i++){
    for(int j=0;j<=i;j++){
       for(int k=1;k+i<=n;k++){ 
          
          dp[i+k+1][j+k]+=((dp[i][j]*p2[k-1])%mod)*Comb[k+j][k];
          dp[i+k+1][j+k]%=mod;
      }
   }
 }

long sum=0l;
for(int i=0;i<=n;i++)sum=(sum+dp[n+1][i])%mod;
out.println(sum);

}out.close();}

//-----------------Utility--------------------------------------------

static long Comb[][]=new long[405][405];
static long p2[]=new long[405];
static long inv[]=new long[405];
static long factorial[]=new long[405];
static void precomp(){

inv[0]=1;factorial[0]=1l;

for(long i=1;i<405;i++){factorial[(int)i]=i*factorial[(int)i-1];factorial[(int)i]%=mod;}

for(int i=1;i<405;i++){ inv[i]=power(factorial[i],mod-2);}

for(int i=0;i<405;i++){
 
   for(int j=0;j<=i;j++){
     Comb[i][j]=(((factorial[i]*inv[j])%mod)*inv[i-j])%mod;
   }
 }

for(int i=0;i<405;i++)p2[i]=power(2,i);

}

static int Max=Integer.MAX_VALUE; static long mod=1000000007;
static int v(char c){return (int)(c-'a')+1;}
public static long power(long x, long y )
    {
        //0^0 = 1
        long res = 1L;
        x = x%mod;
        while(y > 0)
        {
            if((y&1)==1)
                res = (res*x)%mod;
            y >>= 1;
            x = (x*x)%mod;
        }
        return res;
    }
//--------------------------------------------------------------------

static InputStream inputStream = System.in;
static OutputStream outputStream = System.out;
static FastReader in=new FastReader(inputStream);
static PrintWriter out=new PrintWriter(outputStream);

static class FastReader 
{ 
  BufferedReader br; 
  StringTokenizer st; 
 
        FastReader(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }
 
  public String next() 
  { 
      while (st == null || !st.hasMoreElements()) 
      { 
          try
          { 
              st = new StringTokenizer(br.readLine()); 
          } 
          catch (IOException  e) 
          { 
              e.printStackTrace(); 
          } 
      } 
      return st.nextToken(); 
  } 
 
  public int nextInt() 
  { 
      return Integer.parseInt(next()); 
  } 
 
  public long nextLong() 
  { 
      return Long.parseLong(next()); 
  } 
 
 public  double nextDouble() 
  { 
      return Double.parseDouble(next()); 
  } 
 
 
  String nextLine() 
  { 
      String str = ""; 
      try
      { 
          str = br.readLine(); 
      } 
      catch (IOException e) 
      { 
          e.printStackTrace(); 
      } 
      return str; 
  } 
}
static int ni(){return in.nextInt();}
static long nl(){return in.nextLong();}
static String ns(){return in.nextLine();}
static int[] na(int n){int a[]=new int[n];for(int i=0;i<n;i++){a[i]=ni();} return a;}

}