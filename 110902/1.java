import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());

		repeat:
		for(int r=0; r<repeat; r++) {
			input.nextLine();
			int start = readNextStringToInt(input);
			int end = readNextStringToInt(input);
			int banned = Integer.parseInt(input.nextLine());
			if(start == end) {
				System.out.println(0);
				continue;
			}

			int[] distance = new int[10000];
			for(int i=0; i<10000; i++)
				distance[i] = -999;	// 항목이 비어있음을 의미.
			for(int i=0; i<banned; i++)
				distance[readNextStringToInt(input)] = -1;	// 항목이 금지되었음을 의미.

			distance[start] = 0;
			int count = 1;
			int checkedCount = -1;
			while(checkedCount != 0) {
				checkedCount = 0;
				for(int i=0; i<10000; i++) 
					if(distance[i] == count-1) {
						int[] checkList = getCheckList(i);
						for(int j=0; j<checkList.length; j++) {
							if(checkList[j] == end) {
								System.out.println(count);
								continue repeat;
							}
							if(distance[checkList[j]] == -999 || distance[checkList[j]] > count) {
								distance[checkList[j]] = count;
								checkedCount++;
							}
						}
					}
				count++;
			}
			
			System.out.println("-1");
		}

		input.close();
	}
	
	public static int readNextStringToInt(Scanner input) {
		String[] s = input.nextLine().split("\\s+");
		int sum = 0;
		sum += 1000 * Integer.parseInt(s[0]);
		sum += 100 * Integer.parseInt(s[1]);
		sum += 10 * Integer.parseInt(s[2]);
		sum += Integer.parseInt(s[3]);

		return sum;
	}
	
	public static int[] getCheckList(int currentNumber) {
		int[] checkList = new int[8];
		int temp = currentNumber;
		if(temp%10 == 0) checkList[0] = currentNumber + 9;
		else checkList[0] = currentNumber - 1;
		if(temp%10 == 9) checkList[1] = currentNumber - 9;
		else checkList[1] = currentNumber + 1;

		temp /= 10;
		if(temp%10 == 0) checkList[2] = currentNumber + 90;
		else checkList[2] = currentNumber - 10;
		if(temp%10 == 9) checkList[3] = currentNumber - 90;
		else checkList[3] = currentNumber + 10;

		temp /= 10;
		if(temp%10 == 0) checkList[4] = currentNumber + 900;
		else checkList[4] = currentNumber - 100;
		if(temp%10 == 9) checkList[5] = currentNumber - 900;
		else checkList[5] = currentNumber + 100;

		temp /= 10;
		if(temp == 0) checkList[6] = currentNumber + 9000;
		else checkList[6] = currentNumber - 1000;
		if(temp == 9) checkList[7] = currentNumber - 9000;
		else checkList[7] = currentNumber + 1000;

		return checkList;
	}
}