import java.io.*;
import java.util.*;

public class Problem1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n < 0) {
			
			int first = n / 10;
			int second = (n / 100)*10 + (n % 10);
			if (first > second)
				System.out.println(first);
			else
				System.out.println(second);
		} else {
			System.out.println(n);
		}
	}

}
