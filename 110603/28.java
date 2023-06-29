import java.util.Scanner;
import java.math.BigInteger;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		BigInteger dy[] = new BigInteger[1000];
		dy[0] = BigInteger.ZERO;
		dy[1] = BigInteger.valueOf(2);
		dy[2] = BigInteger.valueOf(5);
		dy[3] = BigInteger.valueOf(13);
		
		while (sc.hasNextInt()) {
			
			int num = sc.nextInt();
			
			if (num < 4) {
				System.out.println(dy[num]);
			} else {
				if (dy[num] != null) {
					System.out.println(dy[num]);
				} else {
					for (int i = 4; i <= num; i++) {
						dy[i] = ((dy[i-1].multiply(dy[1])).add(dy[i - 2])).add(dy[i - 3]);
					}
					System.out.println(dy[num]);
				}
			}
		}
	}
}