import java.io.*;
import java.util.*;

public class C
{
	String line;
	StringTokenizer inputParser;
	BufferedReader is;
	FileInputStream fstream;
	DataInputStream in;
	
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
		
	}
	
	int NextInt()
	{
		String n = inputParser.nextToken();
		int val = Integer.parseInt(n);
		
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
		C c = new C(filePath);
	}
	
	public C(String inputFile)
	{
        openInput(inputFile);
        
		readNextLine();
		int N=NextInt();
		boolean [] p = new boolean[N];
		readNextLine();
		int h=0;
		for(int i=0; i<N; i++)
		{
			p[i]=line.charAt(i)=='H';
			if(p[i])h++;
		}
		
		
		int ret=N;
		
		for(int i=0; i<N; i++)
		{
			int m=0;
			for(int j=i; j<i+h; j++)
			{
				int n=j%N;
				if(!p[n])m++;
			}
			ret=Math.min(ret, m);
		}
		
		System.out.println(ret);
		closeInput();
	}

	
	
}

