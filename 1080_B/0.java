import java.util.*;
import java.io.*;

public class cp{


	public static void main(String[] args) {
		Scanner sc = new Scanner();


		int n = sc.nextInt();

		for(int i=0;i<n;i++)
		{
			int a = sc.nextInt();
			int b  = sc.nextInt();

			out.println(find(b)-find(a-1));
		}
		out.close();
 
	}

	static int find(int a)
	{
		if(a%2==0)
			return a/2;
		else return a/2-a;
	}


	static	PrintWriter out=new PrintWriter(System.out);
	static class Scanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String nextLine() {
			while (!st.hasMoreTokens())
				try { 
                                        st=new StringTokenizer(br.readLine());				               
                                } catch (IOException e) {}
			return st.nextToken();
		}
		char nextChar() {
			char c = '$';
				try { 
                                        c = (char)br.read();			               
                                } catch (IOException e) {}
			return c;
		}		
		int nextInt() {
			return Integer.parseInt(nextLine());
		}
		Double nextDouble() {
			return Double.parseDouble(nextLine());
		}
		long nextLong() {
			return Long.parseLong(nextLine());
		}
	}
}