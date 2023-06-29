import java.io.* ;
import java.util.* ;
import java.text.* ;
import java.math.* ;
import static java.lang.Math.min ;
import static java.lang.Math.max ;
public class Codeshefcode{
	public static void main(String[] args) throws IOException{
		Solver Machine = new Solver() ;
		Machine.Solve() ;
		Machine.Finish() ;
		// new Thread(null,new Runnable(){
		// 	public void run(){
		// 		Solver Machine = new Solver() ;
		// 		try{
		// 			Machine.Solve() ;
		// 			Machine.Finish() ;
		// 		}catch(Exception e){
		// 			e.printStackTrace() ;
		// 			System.out.flush() ;
		// 			System.exit(-1) ;
		// 		}catch(Error e){
		// 			e.printStackTrace() ;
		// 			System.out.flush() ;
		// 			System.exit(-1) ;
		// 		}
		// 	}
		// },"Solver",1l<<27).start() ;
	}
}
class Mod{
	static long mod=1000000007 ;
	static long d(long a,long b){ return (a*MI(b))%mod ; }
	static long m(long a,long b){ return (a*b)%mod ; }
	static private long MI(long a){ return pow(a,mod-2) ; }
	static long pow(long a,long b){
		if(b<0) return pow(MI(a),-b) ;
		long val=a ; long ans=1 ;
		while(b!=0){
			if((b&1)==1) ans = (ans*val)%mod ; 
			val = (val*val)%mod ; 
			b/=2 ;
		}
		return ans ;
	}	
}
class pair implements Comparable<pair>{
	int x ; int y ;  
	pair(int x,int y){ this.x=x ; this.y=y ;} 
	public int compareTo(pair p){
		return (this.x<p.x ? -1 : (this.x>p.x ? 1 : (this.y<p.y ? -1 : (this.y>p.y ? 1 : 0)))) ;
	}
}
class Solver{
	Reader ip = new Reader(System.in) ;	  
	PrintWriter op = new PrintWriter(System.out) ;
	long dp[][] ;
	public void Solve() throws IOException{
		int n = ip.i() ;
		int arr[] = new int[n] ;
		dp = new long[n][n] ;
		for(int i=0 ; i<n ; i++)
			for(int j=0 ; j<n ; j++)
				dp[i][j]=-1 ;
		for(int i=0 ; i<n ; i++){
			String s = ip.s() ;
			if(s.compareTo("s")==0) arr[i]=0 ;
			else if(s.compareTo("f")==0) arr[i]=1 ;
			else throw new IOException() ;
		}
		for(int j=0 ; j<n ; j++) dp[n-1][j] = 1 ;
		for(int i=(n-2) ; i>=0 ; i--){
			long cuml[] = new long[n] ;
			for(int j=0 ; j<n ; j++) cuml[j] = (dp[i+1][j]+(j==0 ? 0 : cuml[j-1]))%Mod.mod ;
			for(int j=0 ; j<n ; j++)
				dp[i][j] = (arr[i]==0 ? cuml[j] : (j==(n-1) ? -1 : dp[i+1][j+1])) ;
		}
		pln(dp[0][0]) ;
	}
	void Finish(){
		op.flush();
		op.close();
	}
	void p(Object o){
		op.print(o) ;
	}
	void pln(Object o){
		op.println(o) ;
	}		
}
class mylist extends ArrayList<String>{}
class myset extends TreeSet<Integer>{}
class mystack extends Stack<Integer>{}
class mymap extends TreeMap<Long,Integer>{}
class Reader {
	BufferedReader reader;
	StringTokenizer tokenizer;
	Reader(InputStream input) {
		reader = new BufferedReader(
					new InputStreamReader(input) );
		tokenizer = new StringTokenizer("") ;
	}
	String s() throws IOException {
		while (!tokenizer.hasMoreTokens()){
			tokenizer = new StringTokenizer(
			reader.readLine()) ;
		}
		return tokenizer.nextToken();
	}
	int i() throws IOException {
		return Integer.parseInt(s()) ;
	}
	long l() throws IOException{
		return Long.parseLong(s()) ;
	}
	double d() throws IOException {
		return Double.parseDouble(s()) ;
	}
}
