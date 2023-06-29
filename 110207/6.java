import java.io.*;
import java.util.*;

class Main {
	static class Score {
		int teamNum;
		int pCount;
		ArrayList<Integer> pNum;
		int time;
		char check;
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt();
		scan.nextLine();
		HashMap<Integer, Score> record = new HashMap();
		ArrayList<String> dataArray = new ArrayList<String>();
		
		for(int i = 0; i < tc; i++) {
			scan.nextLine();
			while(scan.hasNextLine()) {
				String input = scan.nextLine();
				if(input.trim().equals(""))
					break;
				else {
					dataArray.add(input);
				}
			}
			for(int j = 1; j <= dataArray.size(); j++) {
				String[] data = dataArray.get(j - 1).split(" ");
				int a = data[0].charAt(0) - '0';
				if(record.containsKey(a)) {
					Score temp = record.get(a);
					for(int k = 0; k < temp.pNum.size(); k++) {
						if(temp.pNum.get(k) == Integer.parseInt(data[1])) {
							if(data[3].equals("C")) {
								temp.time += Integer.parseInt(data[2]);
								temp.pCount++;
							}
							else if(data[3].equals("I"))
								temp.time += 20;
						}
						else {
							if(temp.check == 'I')
								temp.time += 20;
							else if(temp.check == 'C') {
								temp.time += Integer.parseInt(data[2]);
								temp.pCount++;
							}
						}
					}
					record.put(a, temp);
				}
				else {
					for(int k = 0; k < dataArray.size(); k++) {
						if(dataArray.get(k).charAt(0) - '0' == a) {
							Score score = new Score();
							score.pNum = new ArrayList<>();
							score.teamNum = Integer.parseInt(data[0]);
							score.pCount = 0;
							score.pNum.add(Integer.parseInt(data[1]));
							score.check = data[3].charAt(0);
							if(score.check == 'I')
								score.time += 20;
							else if (score.check == 'C') {
								score.time = Integer.parseInt(data[2]);
								score.pCount++;
							}
							record.put(a, score);
							break;
						}
					}
				}
			}
			for(int j = 0; j < tc; j++) {
				for(int k = 0; k < 100; k++) {
					if(record.containsKey(k))
						System.out.println(k + " " + record.get(k).pCount + " " + record.get(k).time);
				}
			}
		}
	}
}