import java.util.*;
import java.io.*;
 
public class Main{
	
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt(), min[] = new int[n];
		boolean used[] = new boolean[n];
		HashSet<Integer> set = new HashSet<>();
		
		
		for (int i = 0; i < n; i++) {
			min[i] = scan.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
					if (min[i] > min[j]) {
						if (min[i] % min[j] == 0)
							min[i] = min[j];
					}
					else if (min[j] % min[i] == 0)
							min[j] = min[i];
				}
		}
		
		for (int i = 0; i < n; i++) {
			set.add(min[i]);
		}
		
		System.out.print(set.size());
	}
}