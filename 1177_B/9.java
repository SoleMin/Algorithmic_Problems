import java.util.Scanner;

public class P1177A {
		
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			
			long k = sc.nextLong();
			int pow = 1;
			
			while ((long) ((Math.pow(10, pow) - Math.pow(10, pow - 1)) * pow) < k) {
				k -= (long) ((Math.pow(10, pow) - Math.pow(10, pow - 1)) * pow);
				pow++;
			}
			// System.out.println(k + " " + pow);
			
			k--;
			long n = (long) Math.pow(10, pow - 1) + k / pow;
			k %= pow;
			// System.out.println(k + " " + n);
			
			System.out.println(String.valueOf(n).charAt((int) k));
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}