import java.util.*;
import java.io.*;


public class cp{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner();

		int n = sc.nextInt();

		int ar[] = new int[n];
		for(int i=0;i<n;i++)
			ar[i] = sc.nextInt();

		HashSet<Integer> h = new HashSet<>();
		int index = 0;

		for(int i=0;i<n;i++)
		{
			int x = sc.nextInt();
			if(h.contains(x))
				out.print("0 ");
			else{int count=1;
				while(ar[index]!=x)
				{
					h.add(ar[index]);
					count++;
					index++;
				}index++;
				out.print(count+" ");
			}
		}

		out.close();
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
		double nextDouble() {
			return Double.parseDouble(nextLine());
		}
		long nextLong() {
			return Long.parseLong(nextLine());
		}
	}



}

//21+35=56
//56+36=92