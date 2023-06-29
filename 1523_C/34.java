import java.io.*;
import java.util.*;
import java.math.*;

public class C {
	public static void main(String[] args) throws IOException {

		/**/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/c.in"))));
		/**/
		
		int t = sc.nextInt();
		for (int z = 0; z < t; ++z) {
			int n = sc.nextInt();
			ArrayList<Integer> al = new ArrayList<>();
			for (int i = 0; i < n; ++i) {
				int x = sc.nextInt();
				if (x==1) {
					al.add(x);
				} else {
					while (al.get(al.size()-1)!=x-1) {
						al.remove(al.size()-1);
					}
					al.remove(al.size()-1);
					al.add(x);
				}
				StringBuilder pr = new StringBuilder();
				String d = "";
				for (int xx : al) {
					pr.append(d+xx);
					d = ".";
				}
				System.out.println(pr);
			}
		}
	}
}