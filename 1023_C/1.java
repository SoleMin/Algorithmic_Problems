import java.io.BufferedInputStream;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(new BufferedInputStream(System.in))) {
			final int n = sc.nextInt();
			final int k = sc.nextInt();
			sc.nextLine();
			
			final String sequence = sc.nextLine();
			final ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
			final BitSet printable = new BitSet(n);
			
			int count = 0;
			
			for (int i = 0; i < sequence.length() && count < k; ++i) {
				if (sequence.charAt(i) == '(') {
					stack.addFirst(i);
				} else if (!stack.isEmpty()) {
					printable.set(stack.pollFirst());
					printable.set(i);
					count += 2;
				}
			}
			
			final StringBuilder sb = new StringBuilder();
			for (int i = 0; i < n; ++i) {
				if (printable.get(i)) {
					sb.append(sequence.charAt(i));
				}
			}
			
			System.out.println(sb.toString());
		}
	}
	
}