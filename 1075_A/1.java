import java.util.*;
import java.io.*;
import java.lang.*;
 
public class MainClass {
	
    private static BufferedReader br = null;
	private static StringTokenizer st = null;
	
	static {	
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	
	private static String str() throws IOException {
		return br.readLine();
	}
	
	private static int ints() throws IOException {
		return Integer.parseInt(br.readLine());
	}
	
	private static int[] ints(int N) throws IOException {
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for(int i = 0; i < N; i += 1) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		return nums;
	}
	
	public static void main(String[] args) throws IOException {
		long N = Long.parseLong(br.readLine());
		String[] arr = br.readLine().split(" ");
		long x = Long.parseLong(arr[0]), y = Long.parseLong(arr[1]);
		Solution obj = new Solution();
	    System.out.println(obj.whoIsWinner(x, y, N));
		br.close();
    }
}
 
class Solution {
    public String whoIsWinner(long x, long y, long N) {
		if(x == 1 && y == 1) return "White";
		if(x == N && y == N) return "Black";
		return Math.max(N - x, N - y) < Math.max(x - 1, y - 1) ? "Black" : "White";
    }
}