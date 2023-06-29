import java.util.Scanner;


public class R025A {
	int n;
	int[] nums;
	public R025A() {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		nums = new int[n];
		for(int i=0; i<n; i++) {
			nums[i] = scanner.nextInt();
		}
	}

	private void process() {
		int[] c = new int[2];
		int[] r = new int[2];
		for(int i=0; i<n; i++) {
			c[nums[i] % 2]++;
			if(r[nums[i] %2] == 0) {
				r[nums[i] % 2] = i+1;
			}
		}
		System.out.println(r[c[0]==1 ? 0 : 1]);
	}

	public static void main(String[] args) {
		new R025A().process();
	}
}
