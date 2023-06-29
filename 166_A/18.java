import java.io.*;
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
		int n=NextInt();
    	int k=NextInt()-1;
		int ret=0;
		Team [] t = new Team[n];
		for(int i=0; i<n; i++)
		{
			readNextLine();
			t[i]=new Team(NextInt(), NextInt());
		}
		Arrays.sort(t);
		int ti=t[k].t, p=t[k].p;
		
		for(int i=0; i<n; i++)
			if(t[i].t==ti&&t[i].p==p)ret++;
		
		
		
		
		System.out.print(ret);
        closeInput();		
	}
	
	private class Team implements Comparable<Team>
	{
		int p,t;
		Team(int p, int t)
		{
			this.p=p;
			this.t=t;
		}
		
		public int compareTo(Team d)
		{
			return 10000*(d.p-p)+t-d.t;
		}
	}

}
