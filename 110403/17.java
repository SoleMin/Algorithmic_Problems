import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int i = 0; i < t; i++) {
			LinkedList<Integer> start = new LinkedList<Integer>();
			LinkedList<Integer> dest = new LinkedList<Integer>();
			int n;
			int count = 0;
			input.nextLine();
			input.nextLine();
			// System.out.print("n = ");
			n = input.nextInt();
			for(int j = 0; j < n; j++) {
				start.add(input.nextInt());
			}
			Collections.sort(start);
			while(start.size() > 2) {
				int first = start.removeFirst();
				if(dest.isEmpty()) {
					int second = start.removeFirst();
					dest.add(second);
					start.addFirst(first);
					count += (first + second);
				}
				else {
					int lastest = start.removeLast();
					int last = start.removeLast();
					if(lastest + (dest.getFirst() << 1)
						 > lastest + last + first) {
						start.add(last);
						start.add(lastest);
						int second = start.removeFirst();
						dest.add(second);
						start.addFirst(first);
						count += (first + second);
					}
					else {
						int last2 = dest.removeFirst();
						start.addFirst(first);
						start.add(last2);
						dest.add(last);
						dest.add(lastest);
						count += (lastest + last2);
					}
				}
				Collections.sort(start);
				Collections.sort(dest);
			}
			if(start.size() == 2) {
				count += start.get(1);
			}
			else {
				if(start.size() == 1) {
					count += start.get(0);
				}
			}
			System.out.println(count);
			if(t > 0) {
				System.out.println();
			}
		}
		input.close();
	}
}