import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Tests {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long inputNum = 0;
		String finalResult = "";

		inputNum = scanner.nextLong();
		long upperLimitResult = 0;
		long lowerLimitResult = 0;
		int multiplier = 0;
		do {
			multiplier++;
			lowerLimitResult = upperLimitResult;
			upperLimitResult += 9 * Math.pow(10, multiplier - 1) * (multiplier);
		} while (inputNum > upperLimitResult);
		long remainderFromLowerRange = inputNum - lowerLimitResult;
		long repititions = 0;
		if (multiplier > 1)
			repititions = (remainderFromLowerRange - 1 > 0 ? remainderFromLowerRange - 1 : 0) / multiplier;
		long currentNumber = (long) (Math.pow(10, multiplier - 1) + repititions);
		remainderFromLowerRange = remainderFromLowerRange - repititions * multiplier;
		long digitIndex = remainderFromLowerRange < multiplier ? multiplier - remainderFromLowerRange
				: remainderFromLowerRange % multiplier;

		if (multiplier == 1) {
			finalResult = (remainderFromLowerRange % 10) + "";
		} else {
			int charToGet = (int) ((multiplier - 1) - digitIndex);
			finalResult = (currentNumber + "").charAt(charToGet) + "";
		}
		System.out.print(finalResult);
		scanner.close();
	}

}
