import java.io.*;
import java.util.*;
import java.math.*;

public class TaskA {
	void Run() throws IOException {
		int n=ReadInt();
		int[] arr=new int[n];
		for(int i=0;i<n;++i)
			arr[i]=ReadInt();
		Arrays.sort(arr);
		boolean one=true;
		for(int x : arr)
			if(x!=1) {
				one=false;
				break;
			}
		if(one) {
			for(int i=1;i<n;++i)
				output.print("1 ");
			output.print("2");
			return;
		}
		int prev=1;
		for(int x : arr)
			if(x==prev) {
				output.print(prev);
				output.print(" ");
			} else {
				output.print(prev);
				output.print(" ");
				prev=x;
			}
	}

	public static void main(String[] args) throws IOException {
		boolean oj = System.getProperty("ONLINE_JUDGE") != null;
		Reader reader;
		reader=oj ? new InputStreamReader(System.in) : new FileReader("input.txt");
		input=new BufferedReader(reader);
		Writer writer=new OutputStreamWriter(System.out);
		writer=new BufferedWriter(writer);
		output=new PrintWriter(writer);
		new TaskA().Run();
		output.close();
	}
	
	static int ReadInt() throws IOException {
		return Integer.parseInt(ReadString());
	}
	
	static long ReadLong() throws IOException {
		return Long.parseLong(ReadString());
	}
	
	static String ReadString() throws IOException {
		while(tokenizer==null || !tokenizer.hasMoreTokens())
			tokenizer=new StringTokenizer(input.readLine());
		return tokenizer.nextToken();
	}
	
	static StringTokenizer tokenizer;
	static BufferedReader input;
	static PrintWriter output;
}
