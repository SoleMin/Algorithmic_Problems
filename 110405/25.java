import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
//import java.util.Array;
class Main {
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt(); // 케이스 수 입력받기
		sc.nextLine();
		int c=0;
		
		//while(c<1){
		while(c<cases){
			sc.nextLine();
			int task = sc.nextInt(); // 일의 개수
			
			ArrayList<Integer> day = new ArrayList<>();
			ArrayList<Integer> money = new ArrayList<>();
			String tmp = "";
			String[] tmpp = new String[2];
			int t=0;
			sc.nextLine();
			
			// 한 케이스의 날과 벌금을 입력받기	
			for(int i=0; i<task; i++){
				tmp = sc.nextLine();
				tmpp = tmp.split(" ");
				day.add(Integer.parseInt(tmpp[0]));
				money.add(Integer.parseInt(tmpp[1]));
			}
			
			//// day 와 money에 잘 들어갔나 ?
			//for(int i=0; i<day.size(); i++){
				//System.out.println("day[" + i + "] = " + day.get(i));
				//System.out.println("money[" + i +"] = " + money.get(i));
			//}
			
			// 정보량이 총합된 배열 만들기
			int[][] bubble = new int[task][4];
			for(int i=0; i<task; i++){
				bubble[i][0] = i + 1; //몇번째 일인가?
				bubble[i][1] = day.get(i); // 며칠 소요되는가?
				bubble[i][2] = money.get(i); // 벌금이 얼마인가?
				bubble[i][3] = day.get(i)/money.get(i); // 작업소요일 당 벌금은 얼마인가?
			}
			
			int[] btemp = new int[4];
			
			//for(int i=0; i<task; i++){
				//System.out.println("bubble[i][3] = " + bubble[i][3]);
			//}
			
			//bubble[i][3]에 맞춰서 bubble 정렬하기
			for(int i=0; i<task; i++){
				//System.out.println("버블 정렬중");
				for(int j=0; j<task-1; j++){
					//System.out.println("버블 정렬중2");
					if(bubble[j][1]*bubble[j+1][2] > bubble[j+1][1]*bubble[j][2]){
						//System.out.println("bubble[" + j + "][3] = " + bubble[j][3] + "이고");
						//System.out.println("bubble[" + (j+1) + "][3] = " + bubble[j+1][3] + "이니까 바꿔야지.");
						btemp = bubble[j];
						bubble[j] = bubble[j+1];
						bubble[j+1] = btemp;		
					}
				}
			}
			
			for(int i=0; i<task; i++){
				System.out.print(bubble[i][0] + " ");
			}
			
			System.out.println(); // 케이스 한번당 한줄 띄기.
			System.out.println();
			c++;
		} // 케이스 개수대로 반복하는 while문
		
		
	}// main함수
}// class