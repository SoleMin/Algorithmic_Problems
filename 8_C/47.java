import java.util.Scanner;


public class Round8_C {

	/**
	 * @param args
	 */
	
	int n ;
	int[] X, Y ;
	
	public Round8_C() {
		info_in() ;
		process() ;
	}
	
	void info_in()
	{
		Scanner input = new Scanner(System.in) ;
		int dx = input.nextInt() ;
		int dy = input.nextInt() ;
		
		n = input.nextInt() ;
		X = new int[n] ;
		Y = new int[n] ;
		
		for( int i=0;i<n;i++) {
			X[i] = input.nextInt() - dx ;
			Y[i] = input.nextInt() - dy ;
		}
	}
	
	int[] d  ;
	int[] trace ;
	
	public static int distance( int x1, int y1, int x2, int y2 )
	{
		return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) ;
	}
	
	void process()
	{
		int gh = 1<<n ;
		d = new int[gh] ;
		trace = new int[gh] ;
		
		d[0] = 0 ;
		for( int i=1;i<gh;i++) {
			d[i] = Integer.MAX_VALUE ;
			for( int j=0;j<n;j++)
				if ( (i & (1<<j)) > 0 ) {
					int val = d[i^(1<<j)] + ( distance( X[j], Y[j], 0, 0 ) << 1 ) ;
					if ( val < d[i] ) {
						d[i] = val ;
						trace[i] = j+1 ;
					}
					
					int state = i ^ (1<<j) ;
					for( int p=j+1;p<n;p++)
						if ( (i & (1<<p)) > 0) {
							val = d[state^(1<<p)] + distance( X[j], Y[j], 0, 0 ) + distance( X[j], Y[j], X[p], Y[p] ) + distance( X[p], Y[p], 0, 0 ) ;
							if ( val < d[i] ) {
								d[i] = val ;
								trace[i] = (j+1) * 100 + (p+1) ; 
							}
						}
					break ;
				}
		}
		
		System.out.println( d[gh-1] ) ;
		gh-- ;
		while ( gh > 0 ) {
			int v1 = trace[gh] / 100 - 1 ;
			int v2 = trace[gh] % 100 - 1 ;
			System.out.print(0 + " ") ;
			if ( v1 != -1 ) {
				System.out.print((v1+1) + " " ) ;
				gh -= 1 << v1 ;
			}
			System.out.print( (v2+1) + " " ) ;
			gh -= 1 << v2 ;
		}
		System.out.println(0) ;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Round8_C() ;
	}

}
