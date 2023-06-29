import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int tcNum = scan.nextInt();
		int day;
		int party;
		int[] holi;
		int result;
		
		for(int i = 0; i < tcNum; i++) {
			result = 0;
			day = scan.nextInt();
			party = scan.nextInt();
			holi = new int[party];
			for(int j = 0; j <holi.length; j++) {
				holi[j] = scan.nextInt();
			}
			
			for(int j = 1; j <= day; j++) {
				if(j % 7 == 0 || j % 7 == 6)
					continue;
				for(int k = 0; k < party; k ++) {
					if(j % holi[k] == 0) {
						result++;
						break;
					}
				}
			}
			System.out.println(result);
		}
	}
}