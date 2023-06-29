import java.io.*;
import java.util.*;
public class z3 {
	public static boolean divch(int i,int a)
	{ if (a>1000) return false; if ((a>0)&&(i%a==0)) return true; return (divch(i,a*10+4)||divch(i,a*10+7)); }
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println(divch(in.nextInt(),0)?"YES":"NO");
	}
}