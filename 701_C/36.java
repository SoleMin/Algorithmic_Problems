import java.io.* ;
import java.util.* ;
public class Codeshefcode {
	final static long r = 1000000007 ;
	static FasterScanner ip = new FasterScanner() ;
	static PrintWriter op = new PrintWriter(System.out) ;
	public static void main(String[] args) throws IOException{
	    int n = ip.i() ;
	    TreeMap<Character,Integer> map = new TreeMap<Character,Integer>() ;
	    TreeSet<Character> set = new TreeSet<Character>() ;
	    char c[] = ip.S().toCharArray() ;
	    for(char t : c)
	    	set.add(t) ;
	    int size = set.size() ;
	    for(int i=0 ; i<size ; i++)
	    	map.put(set.pollFirst(),i) ;
	    int a[] = new int[n] ;
	    for(int i=0 ; i<n ; i++)
	    	a[i]=map.get(c[i]) ;
	    int erl[][] = new int[size][n] ;
	    for(int i=0 ; i<size ; i++)
	    	for(int j=n-1 ; j>=0 ; j--)
	    		erl[i][j]=(a[j]==i) ? j : (j==n-1 ? -1 : erl[i][j+1]) ;
	    long min = Long.MAX_VALUE ;
	    for(int i=0 ; i<n ; i++){
	    	long maxt = Long.MIN_VALUE ;
	    	for(int j=0 ; j<size ; j++)		
	    		if(erl[j][i]!=-1)
	    			maxt = Long.max(maxt,(erl[j][i]-i+1)) ;
	    		else{
	    			maxt = Long.MAX_VALUE ;
	    			break ;
	    		}
	    	min = Long.min(min,maxt) ;	    	
	    }
	    op.print(min) ;
		Finish() ;
	}
	static void Finish(){
	   op.flush(); 
	   op.close();
    }	
}
@SuppressWarnings("serial") 
class MyList extends ArrayList<Long>{
	
}
class pair {
	private int x  ;
	private int y ;
	pair(int a,int b){
		x=a ;
		y=b ;		
	}
	public int x(){
		return x ;
	}
	public int y(){
		return y ;
	}
}
class FasterScanner { 
    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars; 
    public FasterScanner() {
        this(System.in);
    } 
    public FasterScanner(InputStream is) {
        mIs = is;
    } 
    public int read() {
        if (numChars == -1) 
            throw new InputMismatchException();    
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = mIs.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) 
                return -1;            
        }
        return buf[curChar++];
    } 
    public String nextLine(){
        int c = read();
        while (isSpaceChar(c)) 
            c = read();        
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    } 
    public String S(){
        int c = read();
        while (isSpaceChar(c)) 
            c = read();        
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        }while (!isSpaceChar(c));
        return res.toString();
    } 
    public long l(){
        int c = read();
        while (isSpaceChar(c)) 
            c = read();        
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do{
           if (c < '0' || c > '9') 
               throw new InputMismatchException();            
           res *= 10;
           res += c - '0';
           c = read();
        }while(!isSpaceChar(c));
        return res * sgn;
    } 
    public int i(){
        int c = read();
        while (isSpaceChar(c))
            c = read();        
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do{
            if (c < '0' || c > '9') 
                throw new InputMismatchException();            
            res *= 10;
            res += c - '0';
            c = read();
        }while (!isSpaceChar(c));
        return res * sgn;
    } 
    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    } 
    public boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    } 
} 