import java.util.Scanner;

public class J472A {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int a = scan.nextInt();
		if(a % 2 == 0) {
			System.out.println(4 + " " + (a - 4));//ż���4
		} else {
			System.out.println(9 + " " + (a - 9));//������
		}
	}
}
