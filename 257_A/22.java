
import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class Main {
       
    static InputReader in;
    
    public static void main(String[] args) throws IOException{        
        
        File file = new File("input.txt");
        if(file.exists())in = new InputReader( new FileInputStream(file) );
        else in = new InputReader( System.in );
        
        int n=in.nextInt(), m=in.nextInt(), k=in.nextInt();
        int a[]=new int[n];
        for( int i=0; i<n; i++ ) a[i]=in.nextInt();
        Arrays.sort( a );
        int i=n-1, ans=0;
        while( k<m && i>=0 ) {
            k+=a[i]-1;
            i--;
            ans++;
        }
        if( m<=k ) System.out.println( ans );
        else System.out.println("-1");
    } 
    
    // IO utilities:
    
    static void out(Object ...o){ 
        System.out.println(Arrays.deepToString(o)); 
    } 
    
    static class InputReader {
        
        private BufferedInputStream inp;
	private int offset;
	private final int size=5120000;
        private byte buff[];
 
        InputReader( InputStream in ) throws IOException {
		inp = new BufferedInputStream( in );
                buff=new byte[size];
                offset=0;
		inp.read( buff, 0, size );
	}
 
	int nextInt() throws IOException {
            
            int parsedInt=0;
            int i=offset;
            if( buff[i]==0 ) throw new IOException(); //EOF
            // skip any non digits
            while ( i<size && ( buff[i]<'0' || buff[i]>'9' ) ) i++;
            // read digits and parse number
            while( i<size && buff[i]>='0' && buff[i]<='9') {
                parsedInt*=10;
                parsedInt+=buff[i]-'0';
                i++;
            }
            // check if we reached end of buffer
            if ( i==size ) {
                // copy leftovers to buffer start
		int j = 0;
		for ( ; offset<buff.length; j++, offset++ ) 
                        buff[j] = buff[offset];
		// and now fill the buffer
		inp.read( buff, j, size - j );
		// and attempt to parse int again
		offset = 0;
		parsedInt = nextInt();
            } else offset=i;
            return parsedInt;
	}
        
        long nextLong() throws IOException{
            
            long parsedLong=0;
            int i=offset;
            if( buff[i]==0 ) throw new IOException(); //EOF
            // skip any non digits
            while( i<size && ( buff[i]<'0' || buff[i]>'9' ) ) i++;
            // read digits and parse number
            while( i<size && buff[i]>='0' && buff[i]<='9') {
                parsedLong*=10L;
                parsedLong+=buff[i]-'0';
                i++;
            }
            // check if we reached end of buffer
            if ( i==size ) {
                // copy leftovers to buffer start
		int j = 0;
		for ( ; offset<buff.length; j++, offset++ ) 
                        buff[j] = buff[offset];
		// and now fill the buffer
		inp.read( buff, j, size - j );
		// and attempt to parse int again
		offset = 0;
		parsedLong = nextLong();
            } else offset=i;
            return parsedLong;
        }
        
        String next() throws IOException {
            
            StringBuilder token=new StringBuilder();
            int i=offset;
            if( buff[i]==0 ) throw new IOException(); //EOF
            // skip any non chars
            while( i<size && ( buff[i]=='\n' || buff[i]==' ' || buff[i]=='\r' ||
                    buff[i]=='\t' ) ) i++;
            // read chars
            while( i<size && buff[i]!='\n' && buff[i]!=' ' && buff[i]!='\r' &&
                    buff[i]!='\t' && buff[i]!=0 ) {
                token.append( (char)buff[i] );
                i++;
            }
            // check if we reached end of buffer
            if ( i==size ) {
                // copy leftovers to buffer start
		int j = 0;
		for ( ; offset<buff.length; j++, offset++ ) 
                        buff[j] = buff[offset];
		// and now fill the buffer
		inp.read( buff, j, size - j );
		// and attempt to parse int again
		offset = 0;
		return next();
            } else offset=i;
            return token.toString();
        }
        
        String nextLine() throws IOException {
            
            StringBuilder line=new StringBuilder();
            int i=offset;
            if( buff[i]==0 ) throw new IOException(); //EOF
            // read chars
            while( i<size && buff[i]!='\n' && buff[i]!=0 ) {
                line.append( (char)buff[i] );
                i++;
            }
            if( i<size && buff[i]=='\n' ) i++;
            // check if we reached end of buffer
            if ( i==size ) {
                // copy leftovers to buffer start
		int j = 0;
		for ( ; offset<buff.length; j++, offset++ ) 
                        buff[j] = buff[offset];
		// and now fill the buffer
		inp.read( buff, j, size - j );
		// and attempt to parse int again
		offset = 0;
		return nextLine();
            } else offset=i;
            line.deleteCharAt( line.length()-1 );
            return line.toString();
        }
        
    }
}