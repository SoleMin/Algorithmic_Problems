import java.util.Scanner;

public class Probram3 {

	public static int get(long n) {
		int sum = 0;
		while(n != 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long s = scanner.nextLong();
		long l = 1;
		long r = Long.MAX_VALUE;
		long index = 0;
		while(l <= r) {
			long mid = (l + r) / 2;
			if(mid - get(mid) >= s) {
				index = mid;
				r = mid - 1;
			}else{
				l = mid + 1;
			}
		}
		System.out.println(Math.max(0, n-index+1));
	}
}