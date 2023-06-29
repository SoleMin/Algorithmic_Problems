import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinarySearchAdv {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s[];
		s = br.readLine().split(" ");
		long n = Long.parseLong(s[0]);
	long b = Long.parseLong(s[1]);
	
	long ans = binarySearch(1,n,b);
	System.out.println(ans<0?0:(n-ans)+1);
	}

	private static long binarySearch(long start,long end,long comp) {
		long index=-1;
		while(start<=end) {
		long mid = (start+end)/2;	

			if(countDiff(mid,comp))
			{
				index=mid;
				end=mid-1;
			}
			else {
				start=mid+1;
			}
		}
		return index;
		
	}

	private static boolean countDiff(long mid,long comp) {
		long sum=0;
		long n=mid;
		while(n>0) {
			sum +=n%10;
			n/=10;
		}
		if(mid-sum>=comp)
			return true;
		else
			return false;
	}
	
	
// 1 4 5 6 10	
}