import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		int repeat = Integer.parseInt(input.nextLine());
		input.nextLine();

		for(int r=0; r<repeat; r++) {
			// 데이터를 입력받는다.
			String[] firstLine = input.nextLine().split("\\s+");
			int[] fee = new int[24];
			for(int i=0; i<24; i++)
				fee[i] = Integer.parseInt(firstLine[i]);

			LinkedList<String[]> in = new LinkedList<String[]>(); 
			while(input.hasNextLine()) {
				String s = input.nextLine();
				if(s.equals(""))
					break;
				s = s.replace(':', ' ');
				in.add(s.split("\\s+"));
			}

			// 입력받은 데이터를 정리한다.
			String[][] data = new String[in.size()][7];
			int size = in.size();
			for(int i=0; i<size; i++)
				data[i] = in.remove();

			// 입력된 이름만을 알파벳 순으로 정렬한다.
			Set<String> nameSet = new TreeSet<String>();
			for(int i=0; i<data.length; i++)
				nameSet.add(data[i][0]);

			String[] name = new String[nameSet.size()];
			size = 0;
			for(String s : nameSet)
				name[size++] = s;
			Arrays.sort(name);

			// 데이터 정리
			int[][] driveData = new int[data.length][7];
			for(int i=0; i<data.length; i++) {
				for(int j=0; j<name.length; j++)
					if(name[j].equals(data[i][0]))
						driveData[i][0] = j;
				driveData[i][1] = Integer.parseInt(data[i][1]);
				driveData[i][2] = Integer.parseInt(data[i][2]);
				driveData[i][3] = Integer.parseInt(data[i][3]);
				driveData[i][4] = Integer.parseInt(data[i][4]);
				if(data[i][5].equals("exit"))
					driveData[i][5] = 1;
				driveData[i][6] = Integer.parseInt(data[i][6]);
			}

			// 데이터를 시간순으로 정렬.
			for(int i=0; i<driveData.length-1; i++) {
				int min = i;
				for(int j=i; j<driveData.length; j++) {
					if(driveData[min][1] > driveData[j][1])
						min = j;
					else if(driveData[min][1] == driveData[j][1]) {
						if(driveData[min][2] > driveData[j][2])
							min = j;
						else if(driveData[min][2] == driveData[j][2]) {
							if(driveData[min][3] > driveData[j][3])
								min = j;
							else if(driveData[min][3] == driveData[j][3]) {
								if(driveData[min][4] > driveData[j][4])
									min = j;
							}
						}
					}
				}
				int[] temp = driveData[min];
				driveData[min] = driveData[i];
				driveData[i] = temp;
			}

			// 각각의 이름별로 요금을 구하여 출력한다.
			if(r>0)
				System.out.println();
			for(int i=0; i<size; i++) {
				int result = 200;
				int enterTime = -1;
				int location = -1;

				for(int j=0; j<driveData.length; j++) {
					if(driveData[j][0] == i) {
						if(driveData[j][5] == 0) {		// enter 처리
							enterTime = driveData[j][3];
							location = driveData[j][6];
						}
						else {			// exit 처리
							if(enterTime != -1) {
								result += 100;
								result += fee[enterTime] * Math.abs(location - driveData[j][6]);
								enterTime = -1;
								location = -1;
							}
						}
					}
				}

				if(result != 200) {
					double dollar = result/100.0;
					System.out.printf(name[i] + " $%.2f\n", dollar);
				}
			}

		}
		input.close();
	}
}