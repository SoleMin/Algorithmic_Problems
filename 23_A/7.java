import java.io.BufferedReader;
import java.io.InputStreamReader;


public class YouAreGivenAString {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s=r.readLine();
		int max=0;
		for(int i=1;i<s.length();i++){
			for (int j = 0; j <= s.length()-i; j++) {
				String sub=s.substring(j,j+i);
				if(count(s,sub)>=2)
				max=Math.max(max, i);
			}
		}
		System.out.println(max);
	}

	private static int count(String s, String sub) {
		int l=sub.length();
		int c=0;
		for(int i=0;i<=s.length()-l;i++){
			if(s.substring(i,i+l).equals(sub))
				c++;
		}
		return c;
	}
}
