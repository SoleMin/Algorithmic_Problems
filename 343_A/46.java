import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class A {

	public static void main(String[] args) throws Exception {
		new A().doit();
	}
	
	private void doit() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long ans = 0;
		while(a > 0 && b > 0) {
			if (a > b) {
				ans += a / b;
				a %= b;
			} else {
				ans += b / a;
				b %= a;
			}
		}
		
		System.out.println(ans);
	}
	
	
}
