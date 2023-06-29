import java.util.Arrays;
import java.util.Scanner;


public class A {

	public static void main(String[] args) {
		new A().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		Arrays.sort(a);
		int i = 0;
		while (i < n && a[i] == a[0])
			i++;
		if (i < n)
			System.out.println(a[i]);
		else
			System.out.println("NO");
		sc.close();
	}


}
