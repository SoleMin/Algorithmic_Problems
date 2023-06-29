import java.io.* ;
import java.util.* ;
import java.text.* ;
import java.math.* ;
import static java.lang.Math.min ;
import static java.lang.Math.max ;
import static java.lang.Math.sqrt ;
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
	public void Solve() throws IOException{
		int n = ip.i() ; int r = ip.i() ;
		double x[] = new double[n] ;
		double y[] = new double[n] ;
		for(int i=0 ; i<n ; i++) x[i] = ip.i() ;
		for(int i=0 ; i<n ; i++){
			double my = 0 ;
			for(int j=0 ; j<i ; j++)
				my = max(my,func(x[j],y[j],r,x[i])) ;
			y[i] = my ;
		}
		for(int i=0 ; i<n ; i++) p((y[i]+r)+" ") ;
		pln("") ; 
	}
	double abd(double x,double y){
		return x>y ? x-y : y-x ;
	}
	double func(double x1,double y1,double r,double x2){
		if(abd(x1,x2)>(2*r)) return 0 ;
		if(abd(x1,x2)==(2*r)) return y1 ;
		double dx = x1-x2 ; 
		double dx2 = dx*dx ; 
		double val = sqrt(4*r*r-dx2) ;
		return y1+val ;
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
class Reader{
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
