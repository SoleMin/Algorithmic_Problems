import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		long[] longArr = new long[3];
		
		while(input.hasNextLine()) {
			String[] strArr = input.nextLine().split(" ");
			for(int i=0; i<2; i++) {
				long l = Long.parseLong(strArr[i]);
				longArr[i] = l;
			}
			
			if(longArr[0] > longArr[1]) {
				long temp = longArr[0];
				longArr[0] = longArr[1];
				longArr[1] = temp;
				longArr[2] = 1;
			}
			
			int maxCycle = 0;
			long l = 0;
			for(long i=longArr[0]; i<=longArr[1]; i++) {
				int cycleLength = 1;
				l = i;
				
				while(l != 1) {
					if(l%2 == 0) {
						l = l/2;
						cycleLength++;
					}
					else {
						l = l*3+1;
						cycleLength++;
					}
				}
				
				if(maxCycle < cycleLength)
					maxCycle = cycleLength;
			}
			
			if(longArr[2] == 1) {
				long temp = longArr[0];
				longArr[0] = longArr[1];
				longArr[1] = temp;
				longArr[2] = 0;
			}
			System.out.println(longArr[0] + " " + longArr[1] + " " + maxCycle);
		}
		
		input.close();
	}
}