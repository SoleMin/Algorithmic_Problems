import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = new String(in.readLine());
		int len=s.length();
		int ans=0;
		for (int i=0;i<len-1;i++) {
			for (int j=i+1;j<len;j++) {
				int score=0;
				boolean flag=true;
				for (int k=0;k+j<len && flag;k++) {
					if (s.charAt(i+k)==s.charAt(j+k)) {
						score++;
					} else {
						flag=false;
					}
				}
				if (score>ans) {
					ans=score;
				}
			}
		}
		System.out.println(ans);
	}
}
