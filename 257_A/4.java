import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class A
{
	String line;
	StringTokenizer inputParser;
	BufferedReader is;
	FileInputStream fstream;
	DataInputStream in;
	String FInput="";
	
	void openInput(String file)
	{

		if(file==null)is = new BufferedReader(new InputStreamReader(System.in));//stdin
		else
		{
			try{
		
				
			fstream = new FileInputStream(file);
			in = new DataInputStream(fstream);
			is = new BufferedReader(new InputStreamReader(in));
			}catch(Exception e)
			{
				System.err.println(e);
			}
		}

	}
	
	void readNextLine()
	{
		try {
			line = is.readLine();
			inputParser = new StringTokenizer(line, " ");
			//System.err.println("Input: " + line);
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}	
		catch (NullPointerException e)
		{
			line=null;
			
		}
		
	}
	
	int NextInt()
	{
		String n = inputParser.nextToken();
		int val = Integer.parseInt(n);
		
		//System.out.println("I read this number: " + val);
		return val;
	}
	
	long NextLong()
	{
		String n = inputParser.nextToken();
		long val = Long.parseLong(n);
		
		//System.out.println("I read this number: " + val);
		return val;
	}
	
	String NextString()
	{
		String n = inputParser.nextToken();
		return n;
	}
	
	void closeInput()
	{
		try {
			is.close();
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}
			
	}
	
	
	public static void main(String [] argv)
	{
		//String filePath="input.txt";
		//String filePath="D:\\_d\\learn\\coursera\\algorithms and design II\\data\\knapsack2.txt";
        String filePath=null;
		if(argv.length>0)filePath=argv[0];
		new A(filePath);
	}
	
	public void readFInput()
	{
		for(;;)
		{
			try
			{
				readNextLine();
				FInput+=line+" ";
			}
			catch(Exception e)
			{
				break;
			}
		}
		inputParser = new StringTokenizer(FInput, " ");
	}
	 
	public A(String inputFile)
	{
		openInput(inputFile);
		readNextLine();
		int N=NextInt(), M=NextInt(), K=NextInt();
		int [] v = new int[N];
		readNextLine();
		for(int i=0; i<N; i++)
		{
			
			v[i]=NextInt();
			
		}
		Arrays.sort(v);
		M-=(K-1);
		int id=N-1;
		int ret=0;
		while(M>1&&id>=0)
		{
			M++;
			M-=v[id--];
			ret++;
		}
		if(id<0&&M>1)ret=-1;
		System.out.println(ret);
		closeInput();			
	}
	

	public static void out(Object s)
	{
		try
		{
		    FileWriter fstream = new FileWriter("output.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(s.toString());
			out.close();
		}catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
	

}
