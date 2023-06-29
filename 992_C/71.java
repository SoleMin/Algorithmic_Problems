import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class C {

	static long x, k;
	static long mod = 1000000007;
	public static void main(String[] args) {
		JS in = new JS();
		x = in.nextLong();
		k = in.nextLong();
		
		if(x==0) {
			System.out.println(0);
			return;
		}
		
		long c = pow(2,k);
		if(c==0) c = mod;
		long sub = c-1;
		
		long low = ((c*(x%mod))%mod - sub);
		while(low < 0) low += mod;
		long res = ((low*2)%mod + sub)%mod;
		
		System.out.println(res);
		
		
	}
	
	static long pow(long a, long p) {
		if(p==0) return 1;
		if(p==1) return a;
		if(p%2==0) {
			long res = pow(a,p/2)%mod;
			return (res*res)%mod;
		}
		else {
			return (pow(a,p-1)*a)%mod;
		}
		
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
