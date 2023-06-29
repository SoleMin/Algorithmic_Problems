import java.io.*;
import java.math.BigInteger;
import java.util.*;
	
public 	class a {
		public static void main(String args[])throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		OutputStream out=new BufferedOutputStream(System.out);
		String s[]=br.readLine().trim().split("\\ ");
		BigInteger a1=new BigInteger(s[0]);
		BigInteger a=new BigInteger(s[0]);
		String q=a.toString();
		String q1=q.substring(q.length()-1, q.length());
		a=a.subtract(new BigInteger(q1));
		//System.out.println(a.toString());
		BigInteger c=new BigInteger("1");
		BigInteger b=new BigInteger(s[1]);
		int z=check(a,a.toString(),b);
		if(z==1)
		{
			out.write("0".getBytes());
			out.flush();
			//System.out.println("jwefcyuwe");
			return;
		}
		while(a.compareTo(c)>0)
		{
			BigInteger d=a;
			if(d.subtract(c).compareTo(new BigInteger("9"))==-1)
			{
				break;
			}
			else
			{
				BigInteger mid=a;
				mid=mid.add(c);
				mid=mid.divide(new BigInteger("2"));
				//System.out.println(mid.toString());
				if(check(mid,mid.toString(),b)==1)
				{
					c=mid;
					c=c.add(new BigInteger("1"));
				}
				else
				{
					a=mid;
					
					//System.out.println(a.toString());
				}
					
			}
			
		}
		 q=a.toString();
		 q1=q.substring(q.length()-1, q.length());
		a=a.subtract(new BigInteger(q1));
		BigInteger ans=a1.subtract(a);
		ans=ans.add(new BigInteger("1"));
		out.write(ans.toString().getBytes());
		//System.out.print("sfvlksfv");
		
		
		out.flush();
	}
		
		static int check(BigInteger a,String s,BigInteger b)
		{
			int l=s.length();
			long z=0;
			for(int i=0;i<l;i++)
			{
				z+=Long.parseLong(s.substring(i,i+1));
			}
			BigInteger c=a.subtract(new BigInteger(Long.toString(z)));
			//System.out.println(c.toString());
			return -1*c.compareTo(b);
		}
	}