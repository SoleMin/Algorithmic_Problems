import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF {
	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
         int n=sc.nextInt();
         pw.print(n+n/2);
	pw.close();
	sc.close();
}
}