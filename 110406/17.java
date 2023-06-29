import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		/**테스트 케이스 여러개일때**/
		/**카들 출력 정렬**/
		/**오전 오후 시간 잘 출력되는지 조심-> 날짜 바뀌는 경우**/
		/**그냥 한번 해도 3달러 = 왜냐 1번에 1달러 추가 + 그냥 매달 2달러 추가**/
		/**나갈때 1.0**/
		int test_case = Integer.parseInt(input.nextLine());
		String garbage = input.nextLine();
	
		for(int i =0; i<test_case; i++) {
			String[] time = input.nextLine().split(" ");
			double[] time_charge = new double[time.length];
			for(int z =0; z<time.length; z++) {
				time_charge[z] = Double.parseDouble(time[z])/10;
			}
			
			HashMap<String, String[]> map = new HashMap<>();
			HashMap<String, Double> result = new HashMap<>(); 
			while(input.hasNextLine()) {
				String s = input.nextLine();
				if(s.isEmpty()) {
					break;
				}
				String[] write = s.split(" ");
				if(!result.containsKey(write[0])) {
					result.put(write[0],2.00);
				}
				if(write[2].equals("enter")) {
					if(!map.containsKey(write[0])) {
						map.put(write[0], write);
					}
					else {
						if(map.get(write[0])[2].equals("exit")) {
						String[] exit1 = map.get(write[0]);
						String[] day_time2 = write[1].split(":");
						String[] exit_time2 = exit1[1].split(":");
						int[] day_time = 	Arrays.stream(day_time2).mapToInt(Integer::parseInt).toArray();
						int[] exit_time = Arrays.stream(exit_time2).mapToInt(Integer::parseInt).toArray();
							if((day_time[1]<exit_time[1]) || ((day_time[1] == exit_time[1])&&((day_time[2] < exit_time[2])) || ((day_time[1] == exit_time[1] ) && (day_time[2] == exit_time[2]) && (day_time[3] < exit_time[3])))) {
								double normal2 = time_charge[day_time[2]];
								int range2 = Integer.parseInt(exit1[3]) - Integer.parseInt(write[3]);
								if(range2 <0) {
									range2 = -range2;
								}
								double cnt2 = range2 * (normal2/10);
								result.put(write[0], result.get(write[0]) + 1.00 + cnt2);
								map.put(write[0], write);
							}
							else {
								map.put(write[0], write);
							}
						}
					}
				}
				else if(write[2].equals("exit")) {
					if(map.containsKey(write[0]) && map.get(write[0])[2].equals("enter")) {
						String[] enter1 = map.get(write[0]);
						String[] day_time1 = enter1[1].split(":");
						String[] enter_time1 = write[1].split(":");
						int[] da_time = Arrays.stream(day_time1).mapToInt(Integer::parseInt).toArray();
						int[] ex_time = Arrays.stream(enter_time1).mapToInt(Integer::parseInt).toArray();
						if((da_time[1] < ex_time[1]) || ((da_time[1] == ex_time[1]) && ((da_time[2] < ex_time[2])) || ((da_time[1] == ex_time[1])&& (da_time[2] == ex_time[2]) && (da_time[3] < ex_time[3])))) {
							double normal1 = time_charge[da_time[2]];
							int range1 = Integer.parseInt(write[3]) - Integer.parseInt(enter1[3]);
							if(range1 <0) {
								range1 = -range1;
							}
							double cnt1 = (range1) * (normal1/10);
							result.put(write[0], (result.get(write[0]) + 1.00 + cnt1));
							map.put(write[0], write);
						}
					}
					else {
						map.put(write[0], write);
					}
				}
			}
			Object[] key = result.keySet().toArray();
			Arrays.sort(key);
			int count =0;
			for(int l =0; l<key.length; l++) {
				if(!(result.get(key[l]) == 2.00)) {
					System.out.println(String.format("%s $%.2f", key[l], result.get(key[l])));
					count++;
				}
			}
			System.out.println();
		}
	}
}