import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		ArrayList<Integer> output = new ArrayList<>();
		int[] h = new int[1000]; //
		
		int t = input.nextInt();
		while(t-->0) {
			int x = 0; //휴업일
			int n = input.nextInt(); //날짜수. 기간
			int p = input.nextInt(); //정당 개수
			
			for(int i = 0; i < p; i++) {
				h[i] = input.nextInt(); //정당마다 휴업일이 며칠인지
			}
			//x표시(휴업일 구하기)
			for(int day = 1; day <= n; day++) {
				if((day-1) % 7 < 5) { //금요일or토요일 휴업일에서 제외
					for(int i = 0; i < p; i++) {
						if(day % h[i] == 0) {
							x++;
							break;
						}
					}
				}
			}	output.add(x);
		}	
		for(int i = 0; i < output.size(); i++) {
				System.out.println(output.get(i));
			}
		input.close();
	}
}