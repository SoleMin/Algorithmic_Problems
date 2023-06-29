import java.io.*;
import java.util.*;
 
 
public class Main {
 
 
	public static void main(String[] args) throws Exception{
		BufferedReader  jk =  new BufferedReader(new InputStreamReader( System.in))  ; 
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)) ; 
		StringTokenizer ana = new StringTokenizer(jk.readLine()) ;
		int n = Integer.parseInt(ana.nextToken()) ; 
		
		int t[]= new int[101] ; 
		ArrayList<Integer> v = new ArrayList<>() ; 
		ana = new StringTokenizer(jk.readLine()) ;
		for(int i=0 ; i<n ;i++)
		{
			
			int y = Integer.parseInt(ana.nextToken()) ;
			t[y]=1 ; 
			v.add(y) ; 
		}
		Collections.sort(v);
		int c= 0; 
		for(int ele : v)
		{
			if(t[ele]==1)
			{
				
				for(int i=ele ; i<=100 ; i+=ele)
				{
					t[i]=2 ; 
				}
				c++ ; 
			}
		
		}
		out.println(c);
		
 
 
 
 
 
 
 
 
		out.flush();
	}
}