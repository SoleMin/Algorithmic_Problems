import java.util.*;

public class LearnMath {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		scan.close();
		
		if ((N%2) == 0) {
			System.out.println(4 + " " + (N-4));
		}
		else {
			if (N > 18) {
				System.out.println(9 + " " + (N-9));
			}
			else {
				System.out.println((N-9) + " " + 9);
			}
		}

	}

}
