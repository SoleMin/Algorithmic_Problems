import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ns = sc.next();
		sc.close();
		
		int n1 = Integer.parseInt(ns);
		int n2 = Integer.parseInt(ns.substring(0, ns.length() - 1));
		int n3 = Integer.parseInt(ns.substring(0, ns.length() - 2) + ns.substring(ns.length() - 1));
		
		int max = n1;
		max = (n2 > max) ? (n2) : (max);
		max = (n3 > max) ? (n3) : (max);
		
		System.out.println(max);		
	}
}