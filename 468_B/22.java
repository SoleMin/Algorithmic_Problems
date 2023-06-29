import java.text.DecimalFormat;
import java.io.*;
import java.util.*;
import java.lang.reflect.Array;

/**
 * @author Mukesh Singh
 *
 */


public class AB {

    private InputStream input;
    private PrintStream output;
    private Scanner inputSc;

    public AB(InputStream input, PrintStream output) {
        this.input = input;
        this.output = output;
        init();
    }

    private void init() {
        inputSc = new Scanner(input);
    }

    static int lineToInt(String line) {
        return Integer.parseInt(line);
    }

    static long lineToLong(String line) {
        return Long.parseLong(line);
    }
    static double lineToDouble(String line) {
        return Double.parseDouble(line);
    }


    public void solve() 
	{
            solveTestCase();
    }

/**
 * @define global / instance variables 
 */

	HashMap<Integer,Integer> mat ;
	long dist[] ;
	int vec[] ;
	int ar[] ;
	Set<Integer> st ;
	boolean isDone[] ;
	final long INF = 100000000000000000L ;
/**
 * @solve test case 
 */
@SuppressWarnings("unchecked")
   private void solveTestCase() 
	{
		int i , j  , k , n , m , d , l ,b  , p , q , r;
		long N , M, K;
		int x1 , y1 , x2 , y2 ,x;
		int a1,a2,b1,b2,a ;
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
        String str = inputSc.nextLine();
        String delims = "[ ]+";
		String tokens[] = str.split(delims);
		n = lineToInt(tokens[0]);
		a = lineToInt(tokens[1]);
		b = lineToInt(tokens[2]);
		mat = new HashMap<Integer,Integer>() ;
		st = new TreeSet<Integer>();
		ar = new int[n+4] ;
		vec = new int[n+4] ;
		str = inputSc.nextLine();
		tokens = str.split(delims);
		for( i = 1 ; i <= n ; i++ )
		{
			ar[i] = lineToInt(tokens[i-1]);
			mat.put(ar[i],i) ;
			st.add(ar[i]);
			vec[i] = i ;
		}
		vec[n+1] = n+1 ;
		vec[n+2] = n+2 ;
		for( i = 1 ; i <= n ; i++ )
		{
			x= ar[i];
		
			if(st.contains(a-x))
			{
				Bing(mat.get(x),mat.get(a-x));
			}
			else
				Bing(n+1 , mat.get(x));
			if(st.contains(b-x))
			{
				Bing(mat.get(x),mat.get(b-x));
			}
			else
				Bing(n+2 , mat.get(x));
		} 
		if(find(n+1)==find(n+2))
		{
			output.println("NO");
			return ;
		}
		output.println("YES");
		for( i =1 ;  i<= n  ; i ++ )
		{
			if(find(i)==find(n+1))
				output.print("1 ");
			else 
				output.print("0 ");
		}
		output.println();
		
	}
	int find(int x)
{
	if(x==vec[x]) return x;
	return vec[x]=find(vec[x]);
}

void Bing(int a,int b)
{
	int A=find(a);int B=find(b);
	if(A==B) return ;
	vec[B]=A;
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
	{
		FileInputStream in = null;
      	FileOutputStream out = null;
		PrintStream ps = null ;
		InputStream is = null ;
		try 
		{
         	is = new FileInputStream("file.in");
         	out = new FileOutputStream("file.out");
			ps = new PrintStream(out);
        }
		catch ( Exception e )
		{}

        AB sd = new AB(System.in, System.out);
        sd.solve();
		try
		{
        if (is != null) 
		{
	      is.close();
	    }
       	if (out != null) {
           	out.close();
       	}
		if (ps != null) {
           	ps.close();
         }
      	}catch (Exception e){}

		//SquareDetector sd = new SquareDetector(System.in, System.out);
        //sd.solve();
    }
}
   

