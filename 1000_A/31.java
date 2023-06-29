import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class A {

	public static void main(String[] args) {
		JS in = new JS();
		int n = in.nextInt();
		int m1 = 0;
		int s1 = 0;
		int l1 = 0;
		int ss1 = 0;
		int sss1 = 0;
		int ssss1 = 0;
		int ll1 = 0;
		int lll1 = 0;
		int llll1 = 0;
		
		int m2 = 0;
		int s2 = 0;
		int l2 = 0;
		int ss2 = 0;
		int sss2 = 0;
		int ssss2 = 0;
		int ll2 = 0;
		int lll2 = 0;
		int llll2 = 0;
		for(int i = 0; i < n; i++) {
			String s = in.next();
			if(s.equals("S")) s1++;
			else if(s.equals("M"))m1++;
			else if(s.equals("L"))l1++;
			else if(s.equals("XS")) ss1++;
			else if(s.equals("XXS")) sss1++;
			else if(s.equals("XXXS")) ssss1++;
			else if(s.equals("XL")) ll1++;
			else if(s.equals("XXL")) lll1++;
			else if(s.equals("XXXL")) llll1++;
		}
		for(int i = 0; i < n; i++) {
			String s = in.next();
			if(s.equals("S")) s2++;
			else if(s.equals("M"))m2++;
			else if(s.equals("L"))l2++;
			else if(s.equals("XS")) ss2++;
			else if(s.equals("XXS")) sss2++;
			else if(s.equals("XXXS")) ssss2++;
			else if(s.equals("XL")) ll2++;
			else if(s.equals("XXL")) lll2++;
			else if(s.equals("XXXL")) llll2++;
		}
		
		int res = 0;
		int res1 = 0;

		
		res1 += Math.abs(m2-m1);
		res1 += Math.abs(s2-s1);
		res1 += Math.abs(l2-l1);
		res += res1/2;
		res1 = 0;
		
		res1 += Math.abs(ss2-ss1);
		res1 += Math.abs(ll2-ll1);
		res += res1/2;
		res1 = 0;
		
		res1 += Math.abs(sss2-sss1);
		res1 += Math.abs(lll2-lll1);
		res += res1/2;
		res1 = 0;
		
		res1 += Math.abs(ssss2-ssss1);
		res1 += Math.abs(llll2-llll1);
		res += res1/2;
		res1 = 0;
		System.out.println(res);
		
		
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
