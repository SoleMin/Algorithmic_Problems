import java.util.*;
import java.math.*;
import java.io.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class  test{
	
	// ArrayList<Integer> lis = new ArrayList<Integer>();
	// ArrayList<String> lis = new ArrayList<String>();
	//
    //	static long sum=0;
	// int a,b,c;
	// 1000000007 (10^9+7)
	//static int mod = 1000000007;
    //static int dx[]={1,-1,0,0};
	//static int dy[]={0,0,1,-1};
    //static long H,L;
	
public  static void main(String[] args)   throws Exception, IOException{
   //String line=""; throws Exception, IOException
   //(line=br.readLine())!=null
	//Scanner sc =new Scanner(System.in);
	Reader sc = new Reader(System.in);
  // while( ){
	   int  n=sc.nextInt(),m=sc.nextInt(),a[]=new int[n];
	   int b[]=new int[100000+1], r=n+1;
	for(int i=0;i<n;i++)a[i]=sc.nextInt(); 
		// db(a);
		int s=0,t=-1, sum=0;
		int as=0,at=0;
	for(;;){
		while(t<n-1 && sum<m){
			t++;
			if( b[ a[t] ]<1 ){sum++; }
			 b[a[t]]++;
	}
		db(s,t,sum);
		if( sum<m )break;
		as=s;at=t;
		r=min(r,t-s+1);
		if( b[ a[s] ]==1 ){sum--; }
	//	if(t==n-1)break;
		 b[a[s]]--;
		 s++;
	}
	
	if( n<r )System.out.println("-1 -1");
	else System.out.println(as+1+" "+(at+1));
}

static void db(Object... os){
    System.err.println(Arrays.deepToString(os));

}

}


/*
class P implements Comparable<P>{
//	implements Comparable<P>
    
	int x;
	boolean b;
	P(int x,boolean b){
		this.x=x;
		this.b=b;
	} 

	   public int compareTo(P y){
         
		  return  x-y.x;
		   
		   }	
	
}
//*/
class Reader
{
	private BufferedReader x;
	private StringTokenizer st;
	
	public Reader(InputStream in)
	{
		x = new BufferedReader(new InputStreamReader(in));
		st = null;
	}
	public String nextString() throws IOException
	{
		while( st==null || !st.hasMoreTokens() )
			st = new StringTokenizer(x.readLine());
		return st.nextToken();
	}
	public int nextInt() throws IOException
	{
		return Integer.parseInt(nextString());
	}
	public long nextLong() throws IOException
	{
		return Long.parseLong(nextString());
	}
	public double nextDouble() throws IOException
	{
		return Double.parseDouble(nextString());
	}
}
