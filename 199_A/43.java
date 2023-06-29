import java.util.Scanner;
public class Fibonacci {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long num =0;
		num = input.nextLong();
		while (num<0 || num>Math.pow(10,9))
		{
			System.out.println("Invalid");
			num = input.nextLong();
		}
		System.out.println("0 0 "+num);
	}
}