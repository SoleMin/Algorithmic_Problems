import java.io.*;
import java.util.*;

public class A
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
		A a = new A(filePath);
	}
	
	public A(String inputFile)
	{
		openInput(inputFile);
		
		readNextLine();
		String s=line;
		int ret=0;
		for(int i=0; i<s.length(); i++)
		{
			for(int j=i+1; j<s.length()+1; j++)
			{
				String a=s.substring(i,	j);
				if(s.indexOf(a, i+1)>-1)ret=Math.max(ret, a.length());
				
			}
		}
		System.out.println(ret);
	}
	
}

