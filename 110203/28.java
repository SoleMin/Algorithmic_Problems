import java.io.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int test = sc.nextInt();
		int day, party;
		int[] close = new int[test];
		
		for (int a=0; a<test; a++) {
			day = sc.nextInt();		//기간
			if (day<7 && day>3650)
				break;
			int[] countArr = new int[day];
			for (int i=0; i<day; i++)
				countArr[i] = 0;
			
			party = sc.nextInt();	//정당 갯수
			if (party<1 && party>100)
				break;
						
			int[] arrC = new int[party];	//동맹휴업지수
			for (int b=0; b<party; b++)
				arrC[b] = sc.nextInt();
			
			close[a] = 0;
			for (int c=1; c<=day; c++) {
				//금토 제외
				if (c%7!=6 && c%7!=0) {
					for (int b=0; b<party; b++) {
						if ( c%arrC[b] == 0 ) {
							//countArr[c%arrC[b]]++;
							close[a]++;
							break;
						}
						else
							continue;
					}
				}
			}
		}
		for (int a=0; a<test; a++)
			System.out.println(close[a]);
	}
}