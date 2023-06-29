import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
class Main {
	static InputReader reader;
	static OutputWriter writer;
	public static void main(String[] args) {
		reader = new InputReader(System.in);
		writer = new OutputWriter(System.out);
		int n = reader.nextInt();
		reader.nextLine();
		Parti[] parti;
		String submi, s[];
		int contestant, t, que;
		while(n-->0){
			parti = new Parti[100];
			for(int i=0; i<parti.length; i++){
				parti[i] = new Parti(i+1);
			}
			while((submi=reader.nextLine()) != null && submi.length()>0){
			 	s = submi.split(" ");
				contestant = Integer.parseInt(s[0]);
				que = Integer.parseInt(s[1]);
				t = Integer.parseInt(s[2]);
				parti[contestant-1].submit(que, t, s[3]);
			}
			Arrays.sort(parti);
			for(int i=0; i<parti.length; i++){
				if(parti[i].submitted){
					writer.println("%d %d %d", parti[i].num, parti[i].cor, parti[i].penalty);
				}
			}
			if(n>0) writer.println();
		}
		writer.flush();
	}
	static class Parti implements Comparable<Parti>{
		public int penalty, cor, num;
		public boolean[] ans;
		public int[] wrongC;
		public boolean submitted;
	
	public Parti(int num){
		this.num = num;
		penalty = cor = 0;
		ans = new boolean[10];
		for(int i=0; i<10; i++)
			ans[i]=false;
		wrongC= new int[10];
		submitted = false;
	}
	public void submit(int que, int t, String s){
		submitted = true;
		if(s.equals("I")){
			if(!ans[que]){
				wrongC[que]++;
			}
		}else if(s.equals("C")){
			if(!ans[que]){
				ans[que] = true;
				cor++;
				penalty += t+wrongC[que]*20;
			}
		}
	}
	public int compareTo(Parti t){
		if(cor != t.cor)
			return t.cor - cor;
		if(penalty != t.penalty)
			return penalty - t.penalty;
		return num - t.num;
	}
	}
	static class InputReader{
		public BufferedReader reader;
		public StringTokenizer token;
		
		public InputReader(InputStream stream){
			reader = new BufferedReader(new InputStreamReader(stream));
			token = null;
		}
	
	public String x(){
		while(token==null || !token.hasMoreTokens()){
			try{
				token = new StringTokenizer(reader.readLine());
			}catch(Exception e){
				return null;
			}
		}
		return token.nextToken();
	}
		public String nextLine(){
			if(token != null && token.hasMoreTokens()){
				StringBuilder sb = new StringBuilder(token.nextToken());
				while(token.hasMoreTokens()){
					sb.append(" ").append(token.nextToken());
				}
				return sb.toString();
			}else{
				try{
					return reader.readLine();
				}catch(Exception e){
					return null;
				}
			}
			
		}
			public int nextInt(){
				return Integer.parseInt(nextLine());
			}
		public double nextDouble(){
			return Double.parseDouble(nextLine());
		}
		public long nextLong(){
			return Long.parseLong(nextLine());
		
	}
}


static class OutputWriter{
	public BufferedWriter writer;
	
	OutputWriter(OutputStream stream){
		writer = new BufferedWriter(new OutputStreamWriter(stream));
	}

	public void print(String s){
		try {
			writer.write(s, 0, s.length());
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		public void print(char c){
			try{
				writer.write(c);
			}catch(Exception e){
				e.printStackTrace();
			}
			}
			public void print(String format, Object... args){
				try{
					String s = String.format(format, args);
					writer.write(s, 0, s.length());
				}catch(Exception e){
					e.printStackTrace();
				}
			}
				public void print(int x){
					try{
						String s = String.format("%d", x);
						writer.write(s, 0, s.length());
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				public void print(double x){
					try{
						int a =(int) (x*100 + 1e-6);
						String s = String.format("%d.%02d",a,a%100);
						writer.write(s, 0, s.length());
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				public void println(String s){
					print(s);
					newline();
				}
				public void println(char c){
					print(c);
					newline();
				}
				public void println(String format, Object... args){
					print(format, args);
					newline();
				}
				public void println(int x){
					print(x);
					newline();
				}
				public void println(long x){
					print(x);
					newline();
				}
				public void println(double x){
					print(x);
					newline();
				}
				public void println(){
					newline();
				}
				private void newline(){
					try{
						writer.newLine();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				private void flush(){
					try{
						writer.flush();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
	

	
	
	
	
	
	
	
	
	
	
