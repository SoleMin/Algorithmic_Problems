import java.util.*;
import java.lang.*;
import java.io.*;
public class Codechef
{   
     static class FastScanner {
        BufferedReader br;
        StringTokenizer stok;
        FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }
        String next() throws IOException {
            while (stok == null || !stok.hasMoreTokens()) {
                String s = br.readLine();
                if (s == null) {
                    return null;
                }
                stok = new StringTokenizer(s);
            }
            return stok.nextToken();
        }
        int ni() throws IOException {
            return Integer.parseInt(next());
        }
        long nl() throws IOException {
            return Long.parseLong(next());
        }
        double nd() throws IOException {
            return Double.parseDouble(next());
        }
        char nc() throws IOException {
            return (char) (br.read());
        }
        String nextLine() throws IOException {
            return br.readLine();
        }
        
        int[] niArray(int n) throws IOException{
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        long[] nlArray(int n) throws IOException {
            long a[] = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nl();
            return a;
        }
        
        double[] ndArray(int n)throws IOException {
            double a[] = new double[n];
            for (int i = 0; i < n; i++)
                a[i] = nd();
            return a;
        }
    }
    
    
    
        
    
	
	
	static long mod=Long.MAX_VALUE;
	static PrintWriter out=new PrintWriter(System.out);
	static FastScanner in = new FastScanner(System.in);
	public static void main (String[] args) throws java.lang.Exception
	{   int i,j;
		long flag,flag1,flag2,temp,temp2,temp1,count,counter,l;
		HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
		/*
		    if(hm.containsKey(z))
		        hm.put(z,hm.get(z)+1);
		    else
		        hm.put(z,1);
		 */       
        ArrayList<Integer> arr=new ArrayList<Integer>();
        HashSet<Integer> set=new HashSet<Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        
        
       //for(i=1;i<200;i++)
       //{
        long k=in.nl();
		temp=9;l=1;temp2=0;
		while(true)
		{   if(k<=temp2+temp*l)
		        {k-=temp2;break;}
		    else
		    {   temp2+=temp*l;
		        temp*=10;
		        l++;
		    }      
		}
		long z=((k-1)/l);
		//out.println(i+":- "+l+" "+((k-1)/l)+"  "+(k%l==0?l:k%l));
		long no=(long)Math.pow(10,(l-1))+z;
		//out.println(no);
		int index=(int)(k%l==0?l:k%l)-1;
		String p=Long.toString(no);
		//out.println(p+" "+index);
		out.println(p.charAt(index));
       //}
		out.close();
	}
	static long gcd(long a,long b)
	{   if(b==0)
	        return a;
	    return gcd(b,a%b);    
	}
	static long exponent(long a,long n)
	{   long ans=1;
	    while(n!=0)
	    {   if(n%2==0)
	            ans=(ans*a)%mod;
	       a=(a*a)%mod;
	       n=n>>1;
	    }
	    return ans;
	}
	static int binarySearch(int a[], int item, int low, int high) 
    {   if (high <= low) 
            return (item > a[low])?  (low + 1): low; 
        int mid = (low + high)/2; 
        if(item == a[mid]) 
            return mid+1; 
        if(item > a[mid]) 
            return binarySearch(a, item, mid+1, high); 
        return binarySearch(a, item, low, mid-1); 
    } 
}