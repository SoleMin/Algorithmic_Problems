import java.util.*;
import java.io.*;

public class a {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int len = s.length();
		for(int i=len-1; i>=1; --i) {
			for(int j=0; j<=len - i; ++j) {
				String ss = s.substring(j, j+i);

				if(s.substring(j+1).indexOf(ss)!=-1) {
					System.out.println(ss.length());
					return;
				} 
			}
		}
		System.out.println(0);
	}
}
