import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
		Scanner sc=new Scanner();
		int N=sc.nextInt();
		int M=sc.nextInt();
		int K=sc.nextInt();
		int[] array=new int[N];
		for(int i=0;i<N;i++)
			array[i]=sc.nextInt();
		Arrays.sort(array);
		int val=K;
		int index=N - 1;
		while(index>=0 && val<M){
			val--;
			val+=array[index];
			index--;
		}
		if (val<M)
			System.out.println("-1");
		else
			System.out.println((N - 1) - index);
	}

}
