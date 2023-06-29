import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class R023A {
	String str;
	int n; 
	public R023A() {
		Scanner scanner = new Scanner(System.in);
		str = scanner.next();
		n = str.length();
	}

	private void process() {
		int length = -1;
		for(int i=1; i<n; i++) {
			Set<String> set = new HashSet<String>();
			length = n - i;
			for(int j=0; j<=i; j++) {
				String sub = str.substring(j, j+length);
				set.add(sub);
			}
			if(set.size() < i+1) {
				System.out.println(length);
				return;
			}
		}
		System.out.println(0);
	}

	public static void main(String[] args) {
		new R023A().process();
	}
}
