import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int loopCount = input.nextInt();
		int stop = 0;
		
		// 전체 루프
		while(stop != loopCount) {
				String trash = input.nextLine();	
			// 작업 개수 n
			int n = input.nextInt();
			
			// 일수와 벌금 class
			class shoe{
				int days;
				int cost;
				
				shoe(int d, int c){
					this.days = d;
					this.cost = c;
				}
			}
			
			// 그 class 작업 수 만큼 배열 생성
			shoe[] s = new shoe[n];
			for(int i = 0; i < n; i++) {
				s[i] = new shoe(0,0);
			}
			
			// 순서도 출력해줘야해서
			int[] number = new int[n];
			for(int i = 0; i < n; i++) {
				number[i] = i;
			}
			
			
			// 날짜랑 벌금 받기 그리고 곱셈받기
			for(int i = 0; i < n; i++) {
				s[i].days = input.nextInt();
				s[i].cost = input.nextInt();
			}
			
			// 정렬하기
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < n-i; j++) {
					if(s[number[j]].days*s[number[j+1]].cost > s[number[j+1]].days*s[number[j]].cost) {
						int temp = number[j];
						number[j] = number[j+1];
						number[j+1] = temp;
					}
				}
			}
			
			// 출력하기
			String answer = "";
			for(int i = 0; i < n; i++) {
				answer += (number[i]+1) + " ";
			}
			
			answer = answer.substring(0, answer.length()-1);
			
			System.out.println(answer);
			System.out.println("");
			
			stop++;
		}

	}

}