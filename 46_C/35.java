import java.io.PrintWriter;
import java.util.*;


public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		// 1 = H, 0 = T
		
		int n = in.nextInt();
		String line = in.next();
		int h = 0;
		for (int i = 0; i < line.length(); i++) {
			if(line.charAt(i)=='H') h++;
		}
		line = line + line;
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int ans = 0;
			for (int j = i; j < i+h; j++) {
				if(line.charAt(j)!='H') ans++;
			}
			if(min>ans) min = ans;
		}
		
		out.print(min);
		
		
		
		
		in.close();
		out.close();
	}

}
