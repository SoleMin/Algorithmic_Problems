import java.util.*;
import java.math.*;
import java.io.*;

public class Main
	{
	public static void main(String args[]) throws IOException
		{
		BufferedReader c=new BufferedReader(new InputStreamReader(System.in));
		String S[]=c.readLine().split(" ");
		int N=Integer.parseInt(S[0]);
		int K=Integer.parseInt(S[1]);
		int A[]=parseArray(c.readLine(),N);
		shuffle(A);
		Arrays.sort(A);
		
		TreeMap<Long,Long> T=new TreeMap<Long, Long>();
		int ans=0;
		for(int i=0;i<N;i++)
			T.put((long)A[i],1L);
		//System.out.println(Arrays.toString(A));
		if(K==1)
			{
			System.out.println(N);
			return;
			}
		else
			{
			for(int i=0;i<N;i++)
				{
				if(A[i]%K==0&&T.containsKey((long)A[i]/K))		//A[i] is not start of a chain
					continue;
				//System.out.println("considering "+A[i]);
				int chainSize=0;
				long init=A[i];
				while(T.containsKey(init))
					{
					chainSize++;
					init=init*K;
					}
				//System.out.println("\t"+chainSize);
				ans+=(chainSize+1)/2;
				}
			}
		System.out.println(ans);
		}
	/** 
	 * Knuth's shuffle. Generate a random permutation of an array
	 */
	public static int[] shuffle(int A[])
		{
		int N=A.length;
		for(int i=1;i<N;i++)
			{
			int j=(int) (Math.random()*100000)%(i+1); // 0<=j<=i;
			int temp=A[i];
			A[i]=A[j];
			A[j]=temp;
			}
		return A;
		}
	// Parse an integer array of size N from a string s
	public static int[] parseArray(String s,int N)
		{
		int A[]=new int[N];
		StringTokenizer st=new StringTokenizer(s);
		for(int i=0;i<N;i++)
			A[i]=Integer.parseInt(st.nextToken());
		return A;
		}
	}