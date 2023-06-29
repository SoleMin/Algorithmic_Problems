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
		int odd = 0;
		int even = 0;
		int lastOdd = 0;
		int lastEven = 0;
		for(int i=0; i<n; i++) {
			if(nums[i] % 2 == 0) {
				even++;
				lastEven = i+1;
			} else {
				odd++;
				lastOdd = i+ 1;
			}
		}
		if(odd == 1) System.out.println(lastOdd);
		else System.out.println(lastEven);
	}

	public static void main(String[] args) {
		new R025A().process();
	}
}
