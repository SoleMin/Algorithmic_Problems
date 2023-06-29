import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		String text = sc.nextLine();
		String pattern = sc.nextLine();
		
		kmp(text, pattern);
		
		sc.close();
	}
	
	static void kmp(String text, String pattern) {
		long n = text.length();
		long m = pattern.length();
		
		int next[] = compute_next(pattern);
		int index = 0;
		
		int count = 0, h = 0;
		int where[] = new int[(int) n];
		
		for(int i=0; i<n; i++) {
			while(index>0 && pattern.charAt(index)!=text.charAt(i)) {
				index = next[index - 1];
			}
			if(text.charAt(i)==pattern.charAt(index)) {
				if(index == m-1) {
					index = next[index];
					count++; where[h++] = (int)(i-m+2);
				}
				else
					index++;
			}
		}
		
		System.out.println(count);
		h = 0;
		while(true) {
			if(where[h] == 0) { System.out.println(); break; }
			System.out.print(where[h++] + " ");
		}
	}
	
	static int[] compute_next(String pattern) {
		int m = pattern.length();
		char p[] = pattern.toCharArray();
		int table[] = new int[m];
		int index = 0;
		
		for(int i=1; i<m; i++) {
			while(index>0 && p[i]!=p[index])
				index = table[index - 1];
			if(p[i] == p[index]) {
				index++;
				table[i] = index;
			}
		}
		
		return table;
	}
}