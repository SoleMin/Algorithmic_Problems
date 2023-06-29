import java.util.*;
import java.io.*;

public class P1 {
	public static void main(String[] args) {
		String s = null;
		// citire
		try {
//			Scanner sc = new Scanner(new File("in.txt"));
			Scanner sc = new Scanner(System.in);
			s = sc.next();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		int n = s.length();
		
		HashSet<String> h = new HashSet<String>();
		String t=null;
		boolean b;
		int lmax = 0;
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<=n; j++) {
				t = s.substring(i, j);
				b = h.add(t);
//				System.out.println(t + "	"  + b);
				if (b==false) {
					if (j-i>lmax) {
						lmax = j-i;
//						System.out.println(t);
					}
				}
			}
		}
		System.out.println(lmax);
	}
}
