import java.util.*;
import java.io.*;
import java.math.*;

public class C{
	
	static long mod=1000000007;
	static int n;
	static long w[][];
	static void MainMethod()throws Exception{
		n=reader.nextInt();
		w=new long[n+2][n+2];
		for (int i=0;i<=(n+1);i++)
			Arrays.fill(w[i], 0);
		w[1][0]=1;
		String prev,next;
		prev=reader.next();
		long s[]=new long[n+2];
		for (int i=2;i<=n;i++) {
			next=reader.next();
			if (prev.equals("f"))
				for (int lv=0;lv<=n;lv++) 
					w[i][lv+1]=w[i-1][lv];
			else
				for (int lv=n;lv>=0;lv--){
					w[i][lv]=(w[i-1][lv]+w[i][lv+1])%mod;
				}
			prev=next;
		}
		long res=0;
		for (int i=0;i<=n;i++)
			res=(res+w[n][i])%mod;
		printer.print(res);
	}
	public static void main(String[] args)throws Exception{
		MainMethod();
		printer.close();
	}
	static void halt(){
		printer.close();
		System.exit(0);
	}
	static PrintWriter printer=new PrintWriter(new OutputStreamWriter(System.out));
	static class reader{
		static BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer token=new StringTokenizer("");
		static String readNextLine() throws Exception{
			return bReader.readLine();
		}
		static String next() throws Exception{
			while (token.hasMoreTokens()==false){
				token=new StringTokenizer(bReader.readLine());
			}
			return token.nextToken();
		}
		static int nextInt()throws Exception{
			while (token.hasMoreTokens()==false){
				token=new StringTokenizer(bReader.readLine());
			}
			return Integer.parseInt(token.nextToken());
		}
		static long nextLong()throws Exception{
			while (token.hasMoreTokens()==false){
				token=new StringTokenizer(bReader.readLine());
			}
			return Long.parseLong(token.nextToken());
		}
		static double nextDouble()throws Exception{
			while (token.hasMoreTokens()==false){
				token=new StringTokenizer(bReader.readLine());
			}
			return Double.parseDouble(token.nextToken());
		}
	}
	static class MyMathCompute{
		static long [][] MatrixMultiplyMatrix(long [][] A, long [][] B, long mod) throws Exception{
			int n=A.length, m=B[0].length; 
			int p=A[0].length;
			int i,j,k;
			if (B.length!=p) throw new Exception("invalid matrix input");
			long [][] res=new long [n][m];
			for (i=0;i<n;i++) for (j=0;j<m;j++){
				if (A[i].length!=p) throw new Exception("invalid matrix input");
				res[i][j]=0;
				for (k=0;k<p;k++)
					res[i][j]=(res[i][j]+((A[i][k]*B[k][j])% mod))% mod;
			}
			return res;
		}
		static double [][] MatrixMultiplyMatrix(double [][] A, double [][] B ) throws Exception{
			int n=A.length, m=B[0].length; 
			int p=A[0].length;
			int i,j,k;
			if (B.length!=p) throw new Exception("invalid matrix input");
			double [][] res=new double [n][m];
			for (i=0;i<n;i++) for (j=0;j<m;j++){
				if (A[i].length!=p) throw new Exception("invalid matrix input");
				res[i][j]=0;
				for (k=0;k<p;k++)
					res[i][j]=res[i][j]+(A[i][k]*B[k][j]);
			}
			return res;
		}
		static long [][] MatrixPow(long [][] A,long n, long mod) throws Exception{
			if (n==1) return A;
			long [][] res=MatrixPow(A, n/2, mod);
			res=MatrixMultiplyMatrix(res, res, mod);
			if ((n % 2) == 1) res=MatrixMultiplyMatrix(A,res, mod);		
			return res;
		}
		static double [][] MatrixPow(double [][] A,long n) throws Exception{
			if (n==1) return A;
			double[][] res=MatrixPow(A, n/2);
			res=MatrixMultiplyMatrix(res, res);
			if ((n % 2) == 1) res=MatrixMultiplyMatrix(A,res);		
			return res;
		}
		static long pow(long a,long n,long mod){
			a= a % mod;
			if (n==0) return 1;
			long k=pow(a,n/2,mod);
			if ((n % 2)==0) return ((k*k)%mod);
			else return (((k*k) % mod)*a) % mod;
		}
		static double pow(double a,long n){
			if (n==0) return 1;
			double k=pow(a,n/2);
			if ((n % 2)==0) return (k*k);
			else return (((k*k) )*a) ;
		}
	}
}
