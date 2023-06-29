import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C
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
	
	long NextLong()
    {
            String n = inputParser.nextToken();
            
            long val = Long.parseLong(n);
            
            return val;
    }
	
	public static void main(String [] argv)
	{
		//String filePath="input.txt";
        String filePath=null;
        if(argv.length>0)filePath=argv[0];
		new C(filePath);
	}
	final int MOD = 1000000009;
	public C(String inputFile)
	{
		openInput(inputFile);
		StringBuilder sb = new StringBuilder();
		readNextLine();
    	int N=NextInt(), M=NextInt(), K=NextInt();
    	
    	if((N/K)<=(N-M))
    	{
    		sb.append(M);
    	}
    	else
    	{
    		int x=(N/K)-(N-M);
    		long ret=(pow(2, x) -1 );
    		
    		
    		ret *=K;
    		ret%=MOD;
    		ret *= 2;
    		ret%=MOD;
    		/*
    		ret+=pow(K, x+1);
    		ret%=MOD;*/
    		ret+=(M-x*K);
    		ret%=MOD;
    		sb.append(ret+"\n");
    		
    		
    	}
		
    	System.out.println(sb);
		closeInput();		
	}

	long pow(long b, long exponent)
	{
	    long ret = 1;
	    while(exponent > 0)
	    {
	        if (exponent%2 == 1)
	           ret = (ret * b) % MOD;
	        exponent = exponent >> 1;
	        b = (b * b) % MOD;
	    }
	    return ret;
	}

	
}

