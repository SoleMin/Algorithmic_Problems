import java.util.*;
import java.util.Scanner;
import java.io.*;
import javax.lang.model.util.ElementScanner6; 
import static java.lang.System.out;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class B913
{

   
    
    public static void main(String args[])
    {  

        FastReader in=new FastReader();
        PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int tc=1;
     
        //tc=in.nextInt();
        while(tc-->0)
        {
            
        	int n=in.nextInt();
			int parent[]=new int[n+1];
			int deg[]=new int[n+1];
			boolean isNonLeaf[]=new boolean[n+1];
			for(int i=1;i<n;i++)
			{
				parent[i+1]=in.nextInt();
				isNonLeaf[parent[i+1]]=true;
				deg[parent[i+1]]++;
			}
			
			for(int i=2;i<=n;i++)
			{
				if(isNonLeaf[i])
				{
					deg[parent[i]]--;
				}
			}
			boolean flag=true;
			for(int i=1;i<=n;i++)
			{
				if(isNonLeaf[i]&&deg[i]<3)
				{
					flag=false;
					break;
				}
			}
			
			if(flag)pr.println("YES");
			else pr.println("NO");
			
			
        



        }
        pr.flush();
    }


    

    static void sort(long[] a) {
		ArrayList<Long> l = new ArrayList<>();
		for (long i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
	}
    
    
	static void sort(int[] a) {
		ArrayList<Integer> l = new ArrayList<>();
		for (int i : a)
			l.add(i);
		Collections.sort(l);
		for (int i = 0; i < a.length; i++)
			a[i] = l.get(i);
    }

    
    static class FastReader
    { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 

        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 

        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 

        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 

        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
        
        int[] readIntArray(int n)
        {
		int a[]=new int[n];
		for(int i=0;i<n;i++)a[i]=nextInt();
		return a;
	}
		
	long[] readLongArray(int n)
	{
		long a[]=new long[n];
		for(int i=0;i<n;i++)a[i]=nextLong();
		return a;
	}
	
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
}


