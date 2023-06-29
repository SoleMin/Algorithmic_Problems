import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class A {
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		
		out.printf(Locale.US, "%d", n/2*3);
		
		out.close();
	}
}
