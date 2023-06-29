import java.util.*;

class Main {    
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		sc.nextLine();
		for (int j = 0; j < n; j++) {
			sc.nextLine();
			int len = sc.nextInt();
			sc.nextLine();
			set_priority(len);
		}
	}
	
	public static void set_priority(int len) { 
		int[] row = new int[len];
		int[] col = new int[len];
		int[] priority = new int[len];
		sorting(row, col, priority, len);
	}    
	
	public static void sorting(int[] row, int[] col, int[] priority, int len) {
		for (int i = 0; i < len; i++) {
			row[i] = sc.nextInt();
			col[i] = sc.nextInt();
			priority[i] = i;
		}
		
		for (int x = 1; x < len; x++) {            
			for (int y = 0; y < len - x; y++) {                
				if (row[priority[y]] * col[priority[y + 1]] > row[priority[y + 1]] * col[priority[y]]) {
					int tmp = priority[y];
					priority[y] = priority[y + 1];
					priority[y + 1] = tmp;
				}
			}
		}
		print_priority(len, priority);    
	}    
	
	public static void print_priority(int len, int[] priority) {
		for (int i = 0; i < len; i++) {
			System.out.print((priority[i] + 1) + " ");
		}
		System.out.println();
		System.out.println();
	}
}