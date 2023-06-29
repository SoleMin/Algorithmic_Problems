import java.io.*;
import java.util.*;

public class Rhombus {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());

		solve(n);
	}

	public static void solve(int n) {
		System.out.println(2 * n * n - (2 * n - 1));
	}
}