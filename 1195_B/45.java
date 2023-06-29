import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Main {
	static StreamTokenizer st = new StreamTokenizer(new BufferedInputStream(System.in));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedOutputStream(System.out));
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws NumberFormatException, IOException {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int i = 0;
		int cont = 0;
		while(cont<b) {
			i++;
			cont+=i;
		}
		
		if(i+cont-b==a) {
			System.out.println(cont-b);
		}else {
			while(i+cont-b!=a) {
				i++;
				cont+=i;
			}
			System.out.println(cont-b);
		}
	}

	private static int nextInt() {
		try {
			st.nextToken();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (int) st.nval;
	}
}
