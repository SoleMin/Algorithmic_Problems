import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());
		for(int r=1; r<=repeat; r++) {
			int size = Integer.parseInt(input.nextLine());
			String[][] information = new String[size][4];
			ArrayList<String[]> list = new ArrayList<String[]>(); // 유효한 경로를 저장.
			Set<String> s = new HashSet<String>();				// 지명의 집합.
			for(int i=0; i<size; i++) {
				information[i] = input.nextLine().split("\\s+");
				s.add(information[i][0]);
				s.add(information[i][1]);
				int start = Integer.parseInt(information[i][2]);
				int arriveTime = start + Integer.parseInt(information[i][3]);
				if(arriveTime > 24)
					arriveTime -= 24;

				if((start>=18 || start<=6) && (arriveTime>=18 || arriveTime<=6)) {
					list.add(information[i]);
				}
			}

			// 이름 배열 생성.
			String[] nameArr = new String[s.size()];
			int nameSize = nameArr.length;
			int count = 0;
			for(String str : s) 
				nameArr[count++] = str;

			String[] split = input.nextLine().split("\\s+");
			int start=-1, end=-1;
			for(int i=0; i<nameSize; i++)
				if(nameArr[i].equals(split[0])) {
					start = i;
					break;
				}
			for(int i=0; i<nameSize; i++)
				if(nameArr[i].equals(split[1])) {
					end = i;
					break;
				}

			int[] bloodNeed = new int[nameSize];
			for(int i=0; i<nameSize; i++)
				bloodNeed[i] = -1;
			bloodNeed[start] = 0;
			int[] arriveTime = new int[nameSize];
			boolean[] changed = new boolean[nameSize];
			changed[start] = true;
			boolean somethingChanged = true;
			while(somethingChanged) {
				boolean[] nextChanged = new boolean[nameSize];
				somethingChanged = false;
				for(int i=0; i<nameSize; i++)
					if(changed[i]) {
						for(String[] data : list) {
							if(data[0].equals(nameArr[i])) {
								int destination = -1;
								for(int j=0; j<nameSize; j++)
									if(nameArr[j].equals(data[1])) {
										destination = j;
										break;
									}

								int nextBloodNeed = bloodNeed[i] + 1;
								if(i != start) {
									if(arriveTime[i] < 12 && Integer.parseInt(data[2]) >= 12) {
										if(arriveTime[i] + 24 <= Integer.parseInt(data[2]))
											nextBloodNeed--;
									}
									else if(arriveTime[i] >= 12 && Integer.parseInt(data[2]) < 12) {
										if(arriveTime[i] <= Integer.parseInt(data[2]) + 24)
											nextBloodNeed--;
									}
									else {
										if(arriveTime[i] <= Integer.parseInt(data[2]))
											nextBloodNeed--;
									}
								}

								int arrive = Integer.parseInt(data[2]) + Integer.parseInt(data[3]);
								if(arrive > 24)
									arrive -= 24;
								if(bloodNeed[destination]==-1 || bloodNeed[destination] > nextBloodNeed) {
									bloodNeed[destination] = nextBloodNeed;
									arriveTime[destination] = arrive;
									nextChanged[destination] = true;
									somethingChanged = true;
								}
								
								if(arrive < 12)
									arrive += 24;
								if(bloodNeed[destination] == nextBloodNeed)
									if(arriveTime[destination] > arrive) {
										if(arrive > 24)
											arrive -= 24;
										arriveTime[destination] = arrive;
										nextChanged[destination] = true;
										somethingChanged = true;
									}
							}
						}
					}
				changed = nextChanged;
			}

			System.out.println("Test Case " + r + ".");
			if(bloodNeed[end] == -1)
				System.out.println("There is no route Vladimir can take.");
			else
				System.out.println("Vladimir needs " + (bloodNeed[end]-1) + " litre(s) of blood.");

		}
		input.close();
	}
}