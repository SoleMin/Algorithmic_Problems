

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;


public class wef {
public static class FastReader {
	BufferedReader br;
	StringTokenizer st;
	//it reads the data about the specified point and divide the data about it ,it is quite fast
	//than using direct 

	public FastReader() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (Exception r) {
				r.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());//converts string to integer
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (Exception r) {
			r.printStackTrace();
		}
		return str;
	}
}
static ArrayList<String>list1=new ArrayList<String>();
static void combine(String instr, StringBuffer outstr, int index,int k)
{
	if(outstr.length()==k)
	{
		list1.add(outstr.toString());return;
	}
	if(outstr.toString().length()==0)
	outstr.append(instr.charAt(index));
    for (int i = 0; i < instr.length(); i++)
    {
        outstr.append(instr.charAt(i));
       
        combine(instr, outstr, i + 1,k);
        outstr.deleteCharAt(outstr.length() - 1);
    }
   index++;
} 
static ArrayList<ArrayList<Integer>>l=new ArrayList<>();
static void comb(int n,int k,int ind,ArrayList<Integer>list)
{
	if(k==0)
	{
		l.add(new ArrayList<>(list));

		return;
	}
	
	
	for(int i=ind;i<=n;i++)
	{
		list.add(i);
		comb(n,k-1,ind+1,list);
		
		list.remove(list.size()-1);
		
	}
	
	
	
	
	

}
static long sum(long n)
{
	long sum=0;
	while(n!=0)
	{
		sum+=n%10;
		n/=10;
	}
	return sum;
}


static boolean check(HashMap<Integer,Integer>map)
{
	for(int h:map.values())
		if(h>1)
			return false;
	return true;
}

static class Pair implements Comparable<Pair>{
    int x;int y;
    Pair(int x,int y){
        this.x=x;
        this.y=y;
      //  this.i=i;
    }
	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return x-o.x;
		
	}
}
static boolean isPrime(int n) 
{ 
    // Corner cases 
    if (n <= 1) 
        return false; 
    if (n <= 3) 
        return true; 
  
    // This is checked so  
    // that we can skip 
    // middle five numbers 
    // in below loop 
    if (n % 2 == 0 ||  
        n % 3 == 0) 
        return false; 
  
    for (int i = 5; 
             i * i <= n; i = i + 6) 
        if (n % i == 0 || 
            n % (i + 2) == 0) 
            return false; 
  
    return true; 
} 
  

static long gcd(long a, long b) 
{ 
  if (b == 0) 
    return a; 
  return gcd(b, a % b);  
} 

public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	FastReader in=new FastReader();
	HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
	ArrayList<Integer>list=new ArrayList<Integer>();
	TreeSet<Integer>set=new TreeSet<Integer>();

	int n=in.nextInt();
	for(int i=0;i<n;i++)
		set.add(in.nextInt());
	
	int ans=0;
	
	while(!set.isEmpty())
	{
		int f=set.first();
		int s=f;
		while(!set.isEmpty()&&s<=set.last())
		{
			if(set.contains(s))
			set.remove(new Integer(s));
			s+=f;
		}
		ans++;
		
	}
	out.println(ans);
	
	out.close();
	
	
		
	}
}
