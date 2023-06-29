import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DivRound584ProblemA {
	static FastReader sc=new FastReader();
	
	public static void main(String args[]) throws IOException {
		int n = sc.nextInt();
		
		int a[]=new int[n];
		
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		Arrays.sort(a);
		int c=0;
		for(int i=0;i<n;i++) {
			if(a[i]<0) continue;
			c=c-1;
			for(int j=i+1;j<n;j++) {
				if(a[j]<0) continue;
				if(a[j]%a[i]==0) {
					//System.out.println(a[i]+" : "+a[j]);
					a[j]=c;
				}
			}
			//System.out.println(c);
		}
		System.out.println(Math.abs(c));
	}
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
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
