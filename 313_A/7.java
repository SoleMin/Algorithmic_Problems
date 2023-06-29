import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A {
	
	static class Scanner{
		BufferedReader br=null;
		StringTokenizer tk=null;
		public Scanner(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}
		public String next() throws IOException{
			while(tk==null || !tk.hasMoreTokens())
				tk=new StringTokenizer(br.readLine());
			return tk.nextToken();
		}
		public int nextInt() throws NumberFormatException, IOException{
			return Integer.valueOf(next());
		}
		public double nextDouble() throws NumberFormatException, IOException{
			return Double.valueOf(next());
		}
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		Scanner sc = new Scanner();
		int T = sc.nextInt();
		if ( T > 0)
			System.out.println(T);
		else{
			String cad = (T + "");
			int min = Math.min(cad.charAt(cad.length() - 1) - '0', cad.charAt(cad.length() - 2) - '0');
			if (min == 0 && cad.length() == 3)
				System.out.println(0);
			else
				System.out.println(cad.substring(0, cad.length() - 2) + "" + min);
		}
	}

	
}
