import java.io.* ;
import java.util.* ;
import java.text.* ;
import java.math.* ;
import static java.lang.Math.min ;
import static java.lang.Math.max ;
public class Codeshefcode{
	public static void main(String[] args) throws IOException{
		// Solver Machine = new Solver() ;
		// Machine.Solve() ;
		// Machine.Finish() ;
		new Thread(null,new Runnable(){
			public void run(){
				Solver Machine = new Solver() ;
				try{
					Machine.Solve() ;
					Machine.Finish() ;
				}catch(Exception e){
					e.printStackTrace() ;
					System.out.flush() ;
					System.exit(-1) ;
				}catch(Error e){
					e.printStackTrace() ;
					System.out.flush() ;
					System.exit(-1) ;
				}
			}
		},"Solver",1l<<27).start() ;
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
	public void Solve() throws IOException{
		int n = ip.i() ;
		int a[] = new int[n] ;
		for(int i=0 ; i<n ; i++) a[i] = ip.i() ;
		int num=0 ;
		for(int i=0 ; i<n ; i++)
			for(int j=(i+1) ; j<n ; j++)
				if(a[i]>a[j])
					num++ ;
		num%=2 ;
		int m = ip.i() ;
		while(m--!=0){
			int l = ip.i() ;
			int r = ip.i() ;
			int d = (r-l+1) ;
			int mod = d%4 ;
			int bit ;
			if(mod<=1) bit=0 ; else bit=1 ;
			num+=bit ;
			num%=2 ;
			pln(num==1 ? "odd" : "even") ;
		}
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
class mylist extends ArrayList<Integer>{}
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
