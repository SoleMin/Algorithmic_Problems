import java.util.*;
import java.math.*;
import java.io.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

public class Main{
	
	// ArrayList<Integer> lis = new ArrayList<Integer>();
	// ArrayList<String> lis = new ArrayList<String>();
	//  PriorityQueue<P> que = new PriorityQueue<P>();
	// PriorityQueue<Integer> que = new PriorityQueue<Integer>();
	//  Stack<Integer> que = new Stack<Integer>();
	//HashMap<Long,Long> map = new HashMap<Long,Long>();
    //	static long sum=0;
	// 1000000007 (10^9+7)
	static int mod = 1000000007;
	//static int mod = 1000000009,r=0; ArrayList<Integer> l[]= new ArrayList[n];
   // static int dx[]={1,-1,0,0};
//	static int dy[]={0,0,1,-1};
//	static int dx[]={1,-1,0,0,1,1,-1,-1};
//  static int dy[]={0,0,1,-1,1,-1,1,-1};
	//static Set<Integer> set = new HashSet<Integer>();p
	
	static ArrayList<Integer> cd[];
	static int K=0;
	
public  static void main(String[] args)   throws Exception, IOException{
   //String line=""; throws Exception, IOException
   //(line=br.readLine())!=null
	//Scanner sc =new Scanner(System.in);
	// !!caution!! int long //  
	Reader sc = new Reader(System.in);


 //,a=sc.nextInt(),b=sc.nextInt();
 	// int n=sc.nextInt(),p[]=new int[n],q[]=new int[n];
	//int n=sc.nextInt(),a[]=new int[n],b[]=new int[n];
 // int n=sc.nextInt(),m=sc.nextInt(),a=sc.nextInt(),b=sc.nextInt();
	// int r=1<<28;
	
	int n=sc.nextInt();//,k=sc.nextInt();
    int a=sc.nextInt(),b=sc.nextInt(),d[]=new int[n];
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    ArrayList<Integer> A = new ArrayList<Integer>();
    
    
    for (int i = 0; i < n ; i++) {
    
    	d[i]=sc.nextInt();
    	map.put(d[i],i );
    	
    }
    
    int c=1;
	 if( a>b ){c--; int x=a; a=b; b=x;}
	 
	 int r[]=new int[n];
	 
	 if(a==b){
		
		  for (int i = 0; i < n; i++) {
			  if(d[i]>a || !map.containsKey(a-d[i]) ){System.out.println("NO"); return;}
		  }
System.out.println("YES");
		  for (int i = 0; i < n; i++) {System.out.print("1 ");}
		  System.out.println();
		 return;
	 }
	 
       sort(d);

    for (int j = 0; j < n; j++) {
         int i=n-j-1;
    	int id=map.get(d[i]),idd=-1;
    	if(  id<0)continue;
    	
    //	db(id,d[i]);
    	
    	if( d[i]<=a ){
    		 if( map.containsKey(a-d[i]) && 0<=(idd=map.get(a-d[i]))  ){   
    		r[id]=r[idd]=(c+1)%2;  
    		map.put(a-d[i], -1);
    		 }
    		 else if( map.containsKey(b-d[i]) && 0<=(idd=map.get(b-d[i])) ){ 
    	    		r[id]=r[idd]=c;
    	    		map.put(b-d[i], -1); }
    		else{ System.out.println("NO"); return; }
    		 
    	}
     
    	else{
    		
    		if( map.containsKey(b-d[i]) && 0<=(idd=map.get(b-d[i]))   ){ 
    			r[id]=r[idd]=c;
    		map.put(b-d[i], -1); }
    		else{ System.out.println("NO"); return; }
    		
    	}
    	map.put(d[i], -1);
		
    
    }
    	System.out.println("YES");
         for (int j = 0; j < n; j++) {
			System.out.print(r[j]+" ");
		}
    	System.out.println();
    
    
    
    
    
}


  static class P implements Comparable<P>{
//	implements Comparable<Pair>
	int id; long  d; ;
	P(int id,long d){
		this.id=id;
		this.d=d;
	} 
	
	public int compareTo(P x){
		return  (-x.d+d)>=0?1:-1  ; // ascend long
	//	return   -x.d+d  ; // ascend
	//	 return   x.d-d  ; //descend
	   }
 
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