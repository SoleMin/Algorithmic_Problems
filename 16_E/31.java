/*
	Author	:	Imran Khan
	Language:	Java
	
*/

import java.io.*;
import java.util.*;
public class Main
{
	public class BasicInputOutput
	{

		private StringTokenizer strtoken;
		private BufferedReader bufferReader;
		private BufferedWriter bufferWriter;
		private String delim = " \t\n\r\f";
		BasicInputOutput()
		{
			delim = " \t\n\r\f";
			initialize();
		}
		BasicInputOutput( String s )
		{
			delim = s;
			initialize();
		}
		private void initialize()
		{
			bufferReader = new BufferedReader( new InputStreamReader( System.in ));
			bufferWriter = new BufferedWriter( new PrintWriter( System.out ));
			strtoken = null;
		}
		private void checkStringTokenizer()throws IOException
		{
			if ( strtoken == null || strtoken.hasMoreTokens() == false )
				strtoken = new StringTokenizer( bufferReader.readLine(), delim );
		}
		public int getNextInt()throws IOException
		{
			checkStringTokenizer();
			return Integer.parseInt( strtoken.nextToken());
		}

		public long getNextLong()throws IOException
		{
			checkStringTokenizer();
			return Long.parseLong( strtoken.nextToken());
		}

		public double getNextDouble()throws IOException
		{
			checkStringTokenizer();
			return Double.parseDouble( strtoken.nextToken());
		}

		public float getNextFloat()throws IOException
		{
			checkStringTokenizer();
			return Float.parseFloat( strtoken.nextToken());
		}

		public String getNextString()throws IOException
		{
			checkStringTokenizer();
			return strtoken.nextToken();
		}

		public String getNextLine()throws IOException
		{
			checkStringTokenizer();
			return bufferReader.readLine();
		}

		public void skipCurrentLine()throws IOException
		{
			checkStringTokenizer();
			strtoken = null;
		}
		public void write( String var )throws IOException
		{
			bufferWriter.write( var );
		}

		public < T > void write( char sep, T... var )throws IOException
		{
			if ( var.length == 0 )
				return ;
			bufferWriter.write( var[0].toString());
			for ( int i = 1; i < var.length; i++ )
				bufferWriter.write( sep + var[i].toString());
		}

		public void flush()throws IOException
		{
			bufferWriter.flush();
		}
	}

	public static void main(String[] args)
	{
		try
		{
			new Main().run();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	private BasicInputOutput iohandler;
	private int n;
	private double[][] mat;
	private double[][] sum;
	private double[] dp;
	private int tolive;
	private void run()throws Exception
	{
		initialize();
		solve();
	}
	private void initialize() throws Exception
	{
		iohandler=new BasicInputOutput();
		n=iohandler.getNextInt();
		mat=new double[n][n];
		sum=new double[(1<<n)+10][n];
		dp=new double[1<<n];
		for(int i=0;i<n;i++) for(int j=0;j<n;j++)
		{
			mat[i][j]=iohandler.getNextDouble();
		}
	}
	private int bitCount(int mask)
	{
		int ret=0;
		while(mask>0) {
			ret++;
			mask&=(mask-1);
		}
		return ret;
	}
	private void solve() throws Exception
	{
		double[] ans=new double[n];
		int ub=1<<n;
		for(int i=1;i<ub;i++) {
			for(int j=0;j<n;j++) {
				sum[i][j]=0;
				for(int k=0;k<n;k++) if ((i&(1<<k))!=0) sum[i][j]+=mat[k][j];
				int cntbit=bitCount(i);
				if (cntbit>1)
				sum[i][j]/=((double)cntbit*(cntbit-1.))/2.;
			}
		}
		for(int i=0;i<n;i++)
		{
			for(int mask=1;mask<ub;mask++) {
				dp[mask]=0;
				if ((mask&(1<<i))==0) continue;
				if (bitCount(mask)==1)
				{
					dp[mask]=1.;
				} else
				for(int k=0;k<n;k++) {
					if ((mask&(1<<k))==0) continue;
					if (i==k) continue;
					dp[mask]+=sum[mask][k]*dp[mask-(1<<k)];
				}
			}
			ans[i]=dp[ub-1];
		}
		iohandler.write(ans[0]+"");
		for(int i=1;i<n;i++) iohandler.write(" "+ans[i]);
		iohandler.write("\n");
		iohandler.flush();
	}
}
