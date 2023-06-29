//package GoodBye2017;

import java.io.*;
import java.util.*;

public class c {
	public static void main(String[] args) throws Exception{ new c(new Reader()); }
	public c(Reader rr) throws IOException{
		int n=rr.ni();
		double r=rr.nd();
		HashMap<Integer, Double> disk=new HashMap<Integer, Double>();
		for(int i=0; i<n; i++){
			int next=rr.ni();
			if(disk.isEmpty()){
				disk.put(next, r);
				System.out.print(r+" ");
			}
			else{
				double high=r;
				for(Map.Entry<Integer, Double> it: disk.entrySet()){
					if(2*r<next-it.getKey()) continue;
					double tempHigh=pyth(Math.abs(next-it.getKey()),r*2)+it.getValue();
					if(tempHigh>high){
						high=tempHigh;
					}
				}
				disk.put(next, high);
				System.out.print(high+" ");
			}
		}
	}
	public double pyth(double a, double c){
		return Math.sqrt(Math.pow(c, 2)-Math.pow(a, 2));
	}
	static class Reader{
		private DataInputStream din;
		private byte[] buffer=new byte[1024];
		private int bufP, bytR;
		public Reader() throws IOException{
			din=new DataInputStream(System.in);
			bufP=bytR=0;
		}
		public Reader(String file) throws IOException{
			din=new DataInputStream(new FileInputStream(file));
			bufP=bytR=0;
		}
		private String rl() throws IOException{
			byte[] buf=new byte[1024];
			int cnt=0, c;
			while((c=read())!=-1){
				if(c=='\n') break;
				buf[cnt++]=(byte)c;
			}
			return new String(buf, 0, cnt);
		}
		private int ni() throws IOException{
			int num=0;
			byte c=read();
			while(c<=' ') c=read();
			boolean neg=(c=='-');
			if(neg) c=read();
			do{
				num=num*10+c-'0';
			} while((c=read())>='0'&&c<='9');
			if(neg) return -num;
			return num;
		}
		private long nl() throws IOException{
			long num=0;
			byte c=read();
			while(c<=' ') c=read();
			boolean neg=(c=='-');
			if(neg) c=read();
			do{
				num=num*10+c-'0';
			} while((c=read())>='0'&&c<='9');
			if(neg) return -num;
			return num;
		}
		private double nd() throws IOException{ return Double.parseDouble(ns()); }
		private char nc() throws IOException{ return (char)next(); }
		private String ns() throws IOException{
			int c=next();
			StringBuilder sb=new StringBuilder();
			while(!(isChar(c))){
				sb.appendCodePoint(c);
				c=read();
			}
			return sb.toString();
		}
		private char[] ns(int n) throws IOException{
			char[] buf=new char[n];
			int c=next(), r=0;
			while(r<n&&!(isChar(c))){
				buf[r++]=(char)c;
				c=next();
			}
			return n==r?buf:Arrays.copyOf(buf, r);
		}
		private char[][] nm(int n, int m) throws IOException{
			char[][] map=new char[n][];
			for(int i=0; i<n; i++) map[i]=ns(m);
			return map;
		}
		private int[] na(int n) throws IOException{
			int[] a=new int[n];
			for(int i=0; i<n; i++) a[i]=ni();
			return a;
		}
		private boolean isChar(int c) throws IOException{ return !(c>=33&&c<=126); }
		private int next() throws IOException{ int c; while((c=read())!=-1&&isChar(c)); return c; }
		private byte read() throws IOException{
			if(bufP==bytR){
				bytR=din.read(buffer, bufP=0, 1024);
				if(bytR==-1) buffer[0]=-1;
			}
			return buffer[bufP++];
		}
		public void close() throws IOException{
			if(din==null) return;
			din.close();
		}
	}
}
