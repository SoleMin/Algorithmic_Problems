import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String target = scanner.nextLine();
		
		int[] kmp_table = new int[target.length()];
		
		int j = 0;
		for (int i = 1; i < target.length(); i++) {
			if (j > 0 && target.charAt(i) != target.charAt(j)) {
				do j = kmp_table[j - 1]; while (j > 0 && target.charAt(i) != target.charAt(j));
				
				if (target.charAt(i) == target.charAt(j)) {
					kmp_table[i] = ++j;
				} 
			}
			else {
				if (target.charAt(i) != target.charAt(j)) {
					continue;
				}
				kmp_table[i] = ++j;
			}
		}
		
		int cnt = 0;
		String result = "";
		j = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (j > 0 && input.charAt(i) != target.charAt(j)) {
				do j = kmp_table[j - 1]; while (j > 0 && input.charAt(i) != target.charAt(j));
			}
				
			if (input.charAt(i) == target.charAt(j)) {
				if (j != target.length() - 1) {
					j++;
				} else {
					cnt++;
					result += (i - target.length() + 2) + " ";
					j = kmp_table[j];
				}
			}
		}
			
		System.out.println(cnt);
		System.out.println(result);
	}
}