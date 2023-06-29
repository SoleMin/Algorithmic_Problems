
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Scanner scan = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n  = Integer.parseInt(st.nextToken());
		int k  = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		for(int i = 0 ; i  <n;i++)
			a[i] = Integer.parseInt(st.nextToken());
		
		int l = 0, r = 0;
		int[] t = new int[100001];
		int kk = 0;
		int min = 1 << 25 , ll =-1 , rr = -1;
		while(r < n)
		{
			int x = a[r++];
			t[x]++;
			if(t[x] == 1)
				kk++;
			while(r < n && kk < k)
			{
				x = a[r++];
				t[x]++;
				if(t[x] == 1)
					kk++;
			}
			while(kk == k && l < r)
			{
				x = a[l];
				if(t[x] == 1)
					break;
				t[x]--;
				l++;
			}
			if(kk == k)
			{
				int m = r-l+1;
				if(m < min)
				{
					ll = l+1;
					rr = r;
					min = m;
				}
			}
		}
		System.out.println(ll +" "+rr);
	}

}
