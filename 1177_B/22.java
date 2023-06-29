//package codeforces;
import java.util.*;
import java.math.BigInteger;
public class test_round_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BigInteger k=sc.nextBigInteger();
		
		
		BigInteger i=new BigInteger("0");
		int d=0;
		
		BigInteger a=new BigInteger("0");
		while(i.compareTo(k)!=1)
		{
			if(i.compareTo(k)==0)
			{
				break;
			}
			else
			{
				d++;
				BigInteger temp=new BigInteger("0");
				for(int j=0;j<d;j++)
				{
					temp=temp.multiply(new BigInteger("10")).add(new BigInteger("9"));
				}
				i=i.add(new BigInteger(Integer.toString(d)).multiply(temp.subtract(a)));
				//i=i+d*(temp-a);
				a=temp;
			}
			
			
			
		}
		
		//System.out.println(a) ;
		BigInteger b=a.divide(new BigInteger("10"));
		BigInteger t=b;
		BigInteger l=t;
		//System.out.println(b);
		int dig=0;
	
		if(b.equals(new BigInteger("0")))
		{
			dig=0;
		}
		else
		{
			while(b.compareTo(new BigInteger("0"))==1)
			{
				dig++;
				b=b.divide(new BigInteger("10"));
			}
		}
		
		//System.out.println(dig);
		int flag=dig+1;
		BigInteger num=new BigInteger("0");
		b=t;
		while(b.compareTo(new BigInteger("0"))==1)
		{
			//System.out.println("sun");
			BigInteger rev=b.divide(new BigInteger("10"));
			num=num.add(new BigInteger(Integer.toString(dig)).multiply(b.subtract(rev)));
			//num+=(b-rev)*dig;
			b=b.divide(new BigInteger("10"));
			dig--;
			
		}
		//System.out.println(num);
		//System.out.println(t);
		BigInteger net=k.subtract(num);
		BigInteger div=net.divide(new BigInteger(Integer.toString(flag)));
		int q;
		if(net.mod(new BigInteger(Integer.toString(flag))).equals(new BigInteger("0")))
		{
			//System.out.println("s");
			//System.out.println();
			q=0;
			t=t.add(div);
			System.out.println(t.mod(new BigInteger("10")));
		}
		else
		{
			//System.out.println(div);
			//System.out.println(flag);
			//System.out.println(net);
			BigInteger r=div.multiply(new BigInteger(Integer.toString(flag)));
			r=net.subtract(r);
			//q=Integer.toString(net%flag).length();
			
			//System.out.println(q);
			//System.out.println(t);
			//System.out.println(pig);
			//System.out.println(w);
			t=t.add(div.add(new BigInteger("1")));
			//System.out.println(r);
			l=t;
			int pig=0;
			while(t.compareTo(new BigInteger("0"))==1)
			{
				pig++;
				t=t.divide(new BigInteger("10"));
			}
			//System.out.println(pig);
			BigInteger p=new BigInteger(Integer.toString(pig));
			BigInteger rem=p.subtract(r);
			//System.out.println(l);
			while(rem.compareTo(new BigInteger("0"))==1)
			{
				l=l.divide(new BigInteger("10"));
				rem=rem.subtract(new BigInteger("1"));
			}
			//System.out.println(l);
			//System.out.println(r);
			//System.out.println(c);
			//int f=t/w;
			//System.out.println(f);
			System.out.println(l.mod(new BigInteger("10")));
		}
		
		
		

	}

}
