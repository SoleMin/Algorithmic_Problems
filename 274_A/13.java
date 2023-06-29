import java.util.*;
import java.math.*;
import java.io.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class  test{
	
	// ArrayList<Integer> lis = new ArrayList<Integer>();
	// ArrayList<String> lis = new ArrayList<String>();
	//  PriorityQueue<P> que = new PriorityQueue<P>();
	// PriorityQueue<Integer> que = new PriorityQueue<Integer>();
	//  Stack<Integer> que = new Stack<Integer>();
    //	static long sum=0;
	// 1000000007 (10^9+7)
	static int mod = 1000000007;
	//static int mod = 1000000009,r=0;
   // static int dx[]={1,-1,0,0};
//	static int dy[]={0,0,1,-1};
//	static int dx[]={1,-1,0,0,1,1,-1,-1};
//  static int dy[]={0,0,1,-1,1,-1,1,-1};
	//static long H,L;
	//static Set<Integer> set = new HashSet<Integer>();
public  static void main(String[] args)   throws Exception, IOException{
   //String line=""; throws Exception, IOException
   //(line=br.readLine())!=null
	//Scanner sc =new Scanner(System.in);
	// !!caution!! int long //  
	Reader sc = new Reader(System.in);
  // while( ){
	  // int  n=sc.nextInt(),m=sc.nextInt();//a[]=new int[n],b[]=new int[n];
	int  n=sc.nextInt(),r=0;long k=sc.nextInt();
    Integer x[]=new Integer[n];
	 boolean b[]=new boolean[n];
   
   for(int i=0;i<n;i++){
	   x[i]=sc.nextInt();
  }
   if( k==1 ){System.out.println(n); return;}
   sort(x);
   
   for(int i=0;i<n;i++){
	 if( b[i] )continue;
	 r++;
	 long p=x[i],pr=x[i];
	 while( p*k<=x[n-1] ) {p*=k;
	 
	 int up=n,dw=0,mid=(up+dw)/2;
	 boolean f=false;
	 while( up-dw!=1 ){
		 //db(p,x[mid]);
		 if( x[mid]==p ){f=true;break;}
		 if( p<x[mid] ){ up=mid; mid=(up+dw)/2; }
		 else { dw=mid; mid=(up+dw)/2; }
	 }
	  if( f ){ if(pr*k!=p){r++; pr=p;}   b[mid]=true;  } 
	  }
	
	 
  }

    System.out.println(r);
	   
}

static void db(Object... os){
    System.err.println(Arrays.deepToString(os));

}


}

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

/*

class P implements Comparable<P>{
	int x,y;
	P(int x,int y){ this.x=x; this.y=y;  }
	
	public int compareTo(P z) {
	 if( x-z.x!=0)   return  x-z.x ;  //ascend 
	 else return  y-z.y ; 
	}
}
//*/
