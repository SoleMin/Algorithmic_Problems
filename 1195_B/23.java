import java.util.*;
import java.io.*;

public class R574B
{

	public static void main(String[] args)
	{
		JS scan = new JS();
		long n = scan.nextInt();
		long put = 1;
		long k = scan.nextInt();
		long have = 0;
		long moves = 0;
		while(have < k) {
			have += put;
			put++;
			moves++;
		}
		
		long ans = 0;
		moves += have-k;
		ans += have-k;
		long lo = 0;
		long hi = n-moves;
		long bs = 0;
		while(lo <= hi) {
			//could she have eaten mid candies?
			long mid = (lo+hi)/2;
			long left = (n-moves)-mid+put-1;
			long rr = tri(left)-tri(put);
			
			if(rr <= mid) {
				bs = mid;
				hi = mid-1;
			}
			else {
				lo = mid+1;
			}
		}
		System.out.println(ans+bs);
	}
	
	static long tri(long n) {
		return n*(n-1)/2;
	}
	
	static class JS{
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;

		public JS() {
			in = new BufferedInputStream(System.in, BS);
		}

		public JS(String s) throws FileNotFoundException {
			in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
		}

		public char nextChar(){
			while(bId==size) {
				try {
					size = in.read(buf);
				}catch(Exception e) {
					return NC;
				}				
				if(size==-1)return NC;
				bId=0;
			}
			return (char)buf[bId++];
		}

		public int nextInt() {
			return (int)nextLong();
		}

		public long nextLong() {
			num=1;
			boolean neg = false;
			if(c==NC)c=nextChar();
			for(;(c<'0' || c>'9'); c = nextChar()) {
				if(c=='-')neg=true;
			}
			long res = 0;
			for(; c>='0' && c <='9'; c=nextChar()) {
				res = (res<<3)+(res<<1)+c-'0';
				num*=10;
			}
			return neg?-res:res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c!='.' ? cur:cur+nextLong()/num;
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c>32) {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c!='\n') {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if(c>32)return true;
			while(true) {
				c=nextChar();
				if(c==NC)return false;
				else if(c>32)return true;
			}
		}
	}
}
