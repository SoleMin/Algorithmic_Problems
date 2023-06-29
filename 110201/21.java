import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			int[] seq = new int[n];
			int[] sortArr = new int[n - 1];
			boolean jolly = true;
			
			for (int i = 0; i < n; i++) {
				seq[i] = sc.nextInt();
				if (i > 0) {
					sortArr[i - 1] = Math.abs(seq[i] - seq[i - 1]);
				}
			}
			Arrays.sort(sortArr);
			
			for (int i = 0; i < n - 1; i++) {
				if (sortArr[i] != i + 1) {
					jolly = false;
				}
			}
			if (jolly) 
				System.out.println("Jolly");
			else
				System.out.println("Not jolly");
			
		}
		
	}
}