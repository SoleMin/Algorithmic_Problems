import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while (t > 0) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			int[] h = new int[p];
			for (int i = 0; i < p; i++) {
				h[i] = sc.nextInt();
			}
			int cnt = 0;
			
			for (int i = 1; i <= n; i++) {
				if (i % 7 == 6 || i % 7 == 0) {
					continue;
				}
				for (int j = 0; j < h.length; j++) {
					if (i % h[j] == 0) {
						cnt++;
						break;
					}
				}
			}
			System.out.println(cnt);
			t--;
		}
	}
}