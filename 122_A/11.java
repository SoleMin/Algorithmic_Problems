import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Son-Huy TRAN
 * 
 */
public class P122A_LuckyDivision {

	private static boolean isLuckyNumber(int number) {
		while (number > 0) {
			int digit = number % 10;

			if (digit != 4 && digit != 7) {
				return false;
			}

			number /= 10;
		}

		return true;
	}

	private static boolean isAlmostLuckyNumber(int number) {
		int max = (int) Math.sqrt(number);
		int i = 1;

		while (i <= max) {
			if (number % i == 0
					&& (isLuckyNumber(i) || isLuckyNumber(number / i))) {
				return true;
			}

			i++;
		}

		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// begin reading inputs
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(isr);

			// reading inputs
			int input = Integer.parseInt(reader.readLine());

			reader.close();
			isr.close();
			// end reading inputs

			boolean result = isAlmostLuckyNumber(input);
			System.out.println(result ? "YES" : "NO");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
