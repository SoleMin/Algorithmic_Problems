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
		inputFile="input.txt";
        openInput(inputFile);
        PrintWriter writer=null;
		try {
			writer = new PrintWriter("output.txt");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		readNextLine();
		int N=NextInt();
		int M=NextInt();
		readNextLine();
		int K=NextInt();
		readNextLine();
		int [] [] p = new int[N][M];
		int [] [] init = new int [K][2];
		
		for(int i=0; i<K; i++)
		{
			int x=NextInt()-1;
			int y=NextInt()-1;
			p[x][y]=0;
			init[i][0]=x;
			init[i][1]=y;
		}
		
		int max=-1;
		int maxX=-1, maxY=-1;
		
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
			{
				p[i][j]=10000;
				for(int k=0; k<K; k++)
				{
					int n=Math.abs(init[k][0]-i)+Math.abs(init[k][1]-j);
					if(n<p[i][j])p[i][j]=n;
				}
				if(p[i][j]>max)
				{
					max=p[i][j];
					maxX=i+1;
					maxY=j+1;
				}
			}
		
		
	
		writer.println( maxX+" "+maxY);
		
		

		
		closeInput();
		writer.close();
	}

	
}

