import java.io.* ;
import java.util.*;

import static java.lang.Math.* ;
import static java.util.Arrays.* ;

public class A {
	
	public static void main(String[] args) throws IOException {
		
		new A().solveProblem();
		
		out.close();
	}

	static Scanner in = new Scanner(new InputStreamReader(System.in));
	//static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static PrintStream out = new PrintStream(new BufferedOutputStream(System.out));
	
	
	public void solveProblem() {		

		int n = in.nextInt() ;
		E[] get = new E[n] ;
		for( int i = 0 ; i < n ; i++ ){
			get[i] = new E(i,in.nextInt()) ;
		}
		
		sort(get) ;
		
	
		if( get[n-1].g == 1){
			get[n-1].g = 2 ;
		}else{
			get[n-1].g = 1 ;
			
		}
		sort(get) ;
		for( int i = 0 ; i < n - 1 ; i++ )
			out.print(get[i].g  +" " ) ;
		out.println(get[n-1].g) ;
		
	}
	
	class E implements Comparable<E>{
		int g ;
		int index ;
		
		public E( int index, int g){
			this.g = g ;
			this.index = index ;
		}
		
		public int compareTo( E e){
			return g - e.g ;
		}
	}

	static int[] readGet( int n ){
	  	int[] get = new int[n] ;
	  	for( int i = 0 ; i < n ; i++ )
	  		get[i] = in.nextInt();
	  	return get ;
	}
	
       
}