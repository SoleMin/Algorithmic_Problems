import java.io.*;
import java.util.*;

/*

 */
public class A {
	static FastReader sc=null;
	
	public static void main(String[] args) {
		sc=new FastReader();
		int n=sc.nextInt();
		char line[]=sc.next().toCharArray();
		int sum=0;
		for(char e:line)sum+=(e-'0');
		boolean po=false;
		outer:for(int i=1;i<=sum;i++) {
			if(sum%i==0) {
				int ans=sum/i;
				int j=0,curr=0,c=0;
				//System.out.println("ans "+ans);
				while(j<n) {
					curr+=line[j]-'0';
					if(curr==ans) {
						curr=0;
						c++;
					}
					else if(curr>ans)continue outer;
					j++;
				}
				//System.out.println("curr "+curr);
				if(curr==0 && c>1) {
					po=true;
					break;
				}
				
			}
		}
		System.out.println((po || (sum==0 && line.length>1))?"YES":"NO");
		
		
		
	}
	
	
	
	

	
	
	
	
	
	
	static int[] reverse(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al,Collections.reverseOrder());
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
		return a;
	}
	static int gcd(int a,int b) {
		if(b==0)return a;
		else return gcd(b,a%b);
	}
	static long gcd(long a,long b) {
		if(b==0)return a;
		else return gcd(b,a%b);
	}
	
	static void ruffleSort(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al);
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
	}
	
	
	static void print(long a[]) {
		for(long e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	static void print(char a[]) {
		for(char e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	
	static void print(int a[]) {
		for(int e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	static void print(double a[]) {
		for(double e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
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
        int[] readArray(int n) {
    		int a[]=new int [n];
    		for(int i=0;i<n;i++) {
    			a[i]=sc.nextInt();
    		}
    		return a;
    	}
    } 
}






