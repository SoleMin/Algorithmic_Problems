import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner (System.in);
		
		int number;
		
		while (true) {
			number = input.nextInt();
			if (number == 0)
				break;
			
			int golomb [] = new int [number + 1];
			
			golomb [1] = 1;
			
			for (int i = 1; i < number; i++)
				golomb[i + 1] = 1 + golomb[i + 1 - golomb[golomb[i]]];
			
			System.out.println(golomb[number]);
			
		}
	}
}