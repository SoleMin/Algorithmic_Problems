import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
		String[] splitted = reader.readLine().split(" ");
		int n = Integer.parseInt(splitted[0]);
		int m = Integer.parseInt(splitted[1]);
		int k = Integer.parseInt(splitted[2]);
		PriorityQueue<Integer> queue = new PriorityQueue<Integer> (1000, Collections.reverseOrder());
		splitted = reader.readLine().split(" ");
		for (int ii = 0; ii < splitted.length; ii++) {
			queue.add(Integer.parseInt(splitted[ii]));
		}
		
		int counter = 0;
		int spot = k;
		while (spot < m && !queue.isEmpty()) {
			spot = spot + queue.poll() - 1;
			counter++;
		}
		if (spot < m) {
			System.out.println("-1");
		} else {
			System.out.println(counter);
		}
	}
}