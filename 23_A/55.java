import java.util.*;

public class a{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		int max = 0;
		for(int i=0; i<str.length(); i++) {
			for(int j=i+1; j<=str.length(); j++) {
				String first = str.substring(i,j);
				for(int k=i+1; k<=str.length()-first.length(); k++) {
					if(str.substring(k,k+first.length()).equals(first))
						max = Math.max(max,first.length());
				}
			}
		}
		System.out.println(max);
	}
}
