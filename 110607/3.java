import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
	static List<Integer> sequence = new ArrayList<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(scanner.hasNext()) {
			String input = scanner.nextLine();
			int n = Integer.parseInt(input);
			sequence.add(0);
			sequence.add(1);
			sequence.add(2);
			if (n==0)
				break;
			else if (n==1)
				System.out.println(sequence.get(1));
			else if (n<=3)
				System.out.println(sequence.get(2));
			else {
				int start = 2;
				int sum = 3;
				int j = 3;
				int i;
				for (i=3; i<=2000000000; i++) {
					sequence.add(start);
					sum += start;
					if (sum >= n)
						break;
					if (i==j) {
						start++;
						j += sequence.get(start);
					}
				}
				System.out.println(i);
			}
			sequence.clear();
		}
	}
}