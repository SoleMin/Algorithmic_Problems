import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CF125A {

	private void work() throws IOException {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int n = sc.nextInt();
		System.out.printf("%d %d %d\n", 0, 0, n);
		System.out.close();
	}

	public static void main(String[] args) throws IOException {
		new CF125A().work();
	}

}
