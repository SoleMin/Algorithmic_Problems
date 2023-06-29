import java.io.BufferedInputStream;
import java.util.Scanner;

public class HamstersAndTigers { //Round #XX - Hamsters and Tigers
	public static void main(String[] args) {
		Scanner sc = new Scanner(new BufferedInputStream(System.in));

		int numAnimals = sc.nextInt();
		String positions = sc.next();

		int numTigers = 0;
		int numHamsters = 0;
		for(int i = 0; i < positions.length(); i++) {
			if(positions.charAt(i) == 'T') {
				numTigers++;
			} else {
				numHamsters++;
			}
		}

		int minDifference = Integer.MAX_VALUE;

		StringBuilder tigerChars = new StringBuilder(1000);
		StringBuilder hamsterChars = new StringBuilder(1000);
		for(int i = 0; i < numHamsters; i++) {
			hamsterChars.append('H');
		}
		StringBuilder remainingTigerChars = new StringBuilder(1000);
		for(int i = 0; i < numTigers; i++) {
			remainingTigerChars.append('T');
		}

		for(int i = 0; i <= numTigers; i++) {
			StringBuilder generated = new StringBuilder();
			generated.append(tigerChars);
			generated.append(hamsterChars);
			generated.append(remainingTigerChars);
			
			//System.out.println(generated);

			if(remainingTigerChars.length() >= 1) {
				remainingTigerChars.deleteCharAt(remainingTigerChars.length() - 1);
			}
			tigerChars.append('T');

			int diffCount = stringDiffCount(positions, generated.toString());
			if(diffCount < minDifference) {
				minDifference = diffCount;
			}
		}

		//System.out.println("");

		hamsterChars = new StringBuilder(1000);
		tigerChars = new StringBuilder(1000);
		for(int i = 0; i < numTigers; i++) {
			tigerChars.append('T');
		}
		StringBuilder remainingHamsterChars = new StringBuilder(1000);
		for(int i = 0; i < numHamsters; i++) {
			remainingHamsterChars.append('H');
		}

		for(int i = 0; i <= numHamsters; i++) {
			StringBuilder generated = new StringBuilder();
			generated.append(hamsterChars);
			generated.append(tigerChars);
			generated.append(remainingHamsterChars);

			//System.out.println(generated);

			if(remainingHamsterChars.length() >= 1) {
				remainingHamsterChars.deleteCharAt(remainingHamsterChars.length() - 1);
			}
			hamsterChars.append('H');

			int diffCount = stringDiffCount(positions, generated.toString());
			if(diffCount < minDifference) {
				minDifference = diffCount;
			}
		}

		System.out.println(minDifference / 2);
	}

	private static int stringDiffCount(String strOne, String strTwo) {
		int diffCount = 0;
		for(int i = 0; i < strOne.length(); i++) {
			if(strOne.charAt(i) != strTwo.charAt(i)) {
				diffCount++;
			}
		}
		return diffCount;
	}
}
