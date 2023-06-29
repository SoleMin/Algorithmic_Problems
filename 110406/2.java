import java.io.*;
import java.util.Scanner;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		int loopCount = input.nextInt();
		String trash = input.nextLine();
		int stop = 0;
		
		// 루프돌리기
		while(stop != loopCount) {
			
			// 요금 정보 받기
			int[] costTable = new int[24];
			for(int i = 0; i < 24; i++) {
				costTable[i] = input.nextInt();
			}
			
			// 번호판 사진 받기
			String a = "";
			String[] number = new String[1001];
			int m = 0;
			while(input.hasNextLine()) {
				a = input.nextLine();
				if(a.equals("") && a.length() == 0 && m > 0) {
					break;
				}
				number[m] = a + " ";
				m++;
			}
			
			// 일단 한문장으로 받기
			String all = "";
			for(int i = 0 ; i < m; i++) {
				all += number[i];	
			}
			
			// 빈칸으로 쪼개기
			String[] split = all.split(" ");
			
			// 차량 번호판, 입출력 시간, enter/exit, 킬로미터, 요금인덱스 배열
			String[] carName = new String[m-1];
			int[] time = new int[m-1];
			int[] enex = new int[m-1];
			int[] km = new int[m-1];
			int[] costIndex = new int[m-1];
			int[] day = new int[m-1];
			
			// 배열 집어넣기
			int c = 0;
			int t = 0;
			int e = 0;
			int k = 0;
			int x = 0;
			for(int i = 1; i < split.length; i++) {
				if(i % 4 == 1) {
					carName[c] = split[i];	
					c++;
				}
				else if(i % 4 == 2) {
					String b = split[i].replaceAll(":","");
					costIndex[t] = Integer.parseInt(b.substring(4, 6));
					day[t] = Integer.parseInt(b.substring(0, 4));
					time[t] =  Integer.parseInt(b);
					t++;
				}
				else if(i % 4 == 3) {
					if(split[i].equals("enter")) {
						enex[e] = 0;
						e++;
					}
					else {
						enex[e] = 1;
						e++;
					}
				}
				else {
					km[k] = Integer.parseInt(split[i]);
					k++;
				}
			}
			
			// 시간 순으로 정렬하기
			int least;
			for(int i = 0; i < m-2; i++) {
				least = i;
				for(int j = i + 1; j < m-1; j++) {
					if(time[j] < time[least]) {
						least = j;
					}
					int temp = time[i];
					time[i] = time[least];
					time[least] = temp;
					
					String temp_1 = carName[i];
					carName[i] = carName[least];
					carName[least] = temp_1;
					
					int temp_2 = enex[i];
					enex[i] = enex[least];
					enex[least] = temp_2;
					
					int temp_3 = km[i];
					km[i] = km[least];
					km[least] = temp_3;
					
					int temp_4 = costIndex[i];
					costIndex[i] = costIndex[least];
					costIndex[least] = temp_4;
					
					int temp_5 = day[i];
					day[i] = day[least];
					day[least] = temp_5;
				}
			}
			
			// 요금계산하기
			int index = 0;
			String[] answerName = new String[m-1];
			int[] answerCost = new int[m-1];
			int[] checked = new int[m-1];
			for(int i = 0; i < m-1; i++) {
				for(int j = 0; j < m-1; j++) {
					if(carName[i].equals(carName[j])  && enex[i] == 0 &&  enex[j] == 1 &&
							checked[i] == 0 && checked[j] == 0 && i != j && day[i] <= day[j]
							) {
						checked[i] = 1;
						checked[j] = 1;
						if(Math.abs((km[j] - km[i])) != 0) {
							int cost = (costTable[costIndex[i]] * Math.abs((km[j] - km[i]))) + 200;
							answerName[index] = carName[i];
							answerCost[index] = cost;
							index++;
							
							
						}
						else {
							int cost = 200;
							answerName[index] = carName[i];
							answerCost[index] = cost;
							index++;
						}
					}
				}
			}
			
			// 중복 계산...
			for(int i = 0; i < index; i++) {
				for(int j = 0; j < index; j++) {
					if(answerName[i].equals(answerName[j]) && i != j) {
						answerCost[i] += 100;
					}
				}
			}
			for(int i = 0; i < index; i++) {
				answerCost[i] += 100;
			}
			
			//ㅈㅂㅈㅂㅈㅂ
			int[] ok = new int[index];
			for(int i = 0; i < index; i++) {
				for(int j = 0; j < index; j++) {
					if(answerName[i].equals(answerName[j]) && i != j && ok[j] == 0) {
						answerCost[i] += answerCost[j];
						ok[j] = 1;
						answerCost[j] = -1;
					}
				}
				ok[i] = 1;
			} 
			
			// 차번호 정렬 으아아악
			int[] sb = new int[index];
			char[] first = new char[index];
			for(int i = 0; i < index; i++) {
				sb[i] = i;
				first[i] = answerName[i].charAt(0);
			//	System.out.println("dddd: " + answerName[i].charAt(0));
			}
			
			int leastt;
			for(int i = 0; i < index-1; i++) {
				leastt = i;
				for(int j = i + 1; j < index; j++) {
					if(first[j] < first[leastt]) {
					//	System.out.println(first[j] +" < "+ first[leastt]);
						leastt = j;
					}
					char temp = first[i];
					first[i] = first[leastt];
					first[leastt] = temp;
					
					int temp_2 = sb[i];
					sb[i] = sb[leastt];
					sb[leastt] = temp_2;
					
					
				}
			}
			
			//ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ나뭐해
			for(int i = 0; i < index-1; i++) {
				if(first[i] > first[i+1]) {
					char temp = first[i];
					first[i] = first[i+1];
					first[i+1] = temp;
					
					int temp_2 = sb[i];
					sb[i] = sb[i+1];
					sb[i+1] = temp_2;
				}
			}
			
			
			for(int i = 0; i < index; i++) {
				if(answerCost[sb[i]] % 100 == 0 && answerCost[sb[i]] != -1) {
					System.out.println(answerName[sb[i]] + " $" +(answerCost[sb[i]] / 100) + "." + (answerCost[sb[i]] % 100) + "0");
				}
				else if((answerCost[sb[i]] % 100) - 10 < 0 && answerCost[sb[i]] != -1) {
					System.out.println(answerName[sb[i]] + " $" +(answerCost[sb[i]] / 100) + "." + (answerCost[sb[i]] % 100) + "0");
				}
				else if(answerCost[sb[i]] != -1){
					System.out.println(answerName[sb[i]] + " $" +(answerCost[sb[i]] / 100) + "." + (answerCost[sb[i]] % 100));
				}
			}
			
			System.out.println("");
			
			
			
			// 출력 테스트용
			/*for(int i = 0; i < m-1; i++) {
				System.out.println(carName[i]);
				System.out.println(time[i]);
				System.out.println(enex[i]);
				System.out.println(km[i]);
				System.out.println(costIndex[i]);
				System.out.println("=====================================");
			}*/
			
			stop++;
			
		}
		

	}

}

