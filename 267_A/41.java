import java.util.*;

public class Subtractions {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		int tests = scan.nextInt();

		while (tests > 0) {

			tests--;

			int first = scan.nextInt();
			int second = scan.nextInt();

			int count = 0;
			while (first > 0 && second > 0) {
				
				if (first < second) {

					count += second / first;
					second = second % first;
				} else {
					
					count += first / second;
					first = first % second;
				}
			}
			
			System.out.println(count);
		}
	}
}
