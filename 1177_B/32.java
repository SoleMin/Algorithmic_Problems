import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class B1177 {

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("F:/books/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long n = Long.parseLong(br.readLine());
		long[] p = new long[15];
		int i;
		p[0]=1;
		for(i=1;i<15;p[i]=p[i-1]*10,i++);
		for(i=1;i*p[i-1]*9L<n;n-=i*p[i-1]*9L,i++);
		n--;
		int v = (int) (n%i);
		n/=i;
		n+=p[i-1];
		String s = n.toString();
		System.out.println(s.charAt(v));
	}

}
