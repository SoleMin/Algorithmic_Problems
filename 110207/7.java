import java.io.*;
import java.util.*;

class Problem {
	boolean correct = false;
	boolean incorrect = false;
	int incorrectNum = 0;
}

class Team {
	int penalty = 0;
	int correctNum = 0;
}

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int caseNum = sc.nextInt();
		
		sc.nextLine(); sc.nextLine();
		String line;
		
		int teamNum;
		int prob;
		int time;
		
		for (int l = 0; l < caseNum; l++) {
			List<Integer> teamList = new ArrayList<>();
			Problem [][] list = new Problem[100][9];
			Team[] teamScore = new Team[100];
			
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				if (line.length() == 0) break;
				String [] tmp = line.split(" ");
				teamNum = Integer.parseInt(tmp[0]) -1;
				prob = Integer.parseInt(tmp[1]) -1;
				time = Integer.parseInt(tmp[2]);
				
				if (teamList.contains(teamNum) == false)
					teamList.add(teamNum);
				
				if (list[teamNum][prob] == null)
					list[teamNum][prob] = new Problem();
				if (teamScore[teamNum] == null)
					teamScore[teamNum] = new Team();
				
				if (tmp[3].equals("I") == true) {
					list[teamNum][prob].incorrectNum += 1;
					if (list[teamNum][prob].incorrect == false) {
						list[teamNum][prob].incorrect = true;
					}
				}
				else if (tmp[3].equals("C") == true) {
					if (list[teamNum][prob].correct == false) {
						list[teamNum][prob].correct = true;
						teamScore[teamNum].correctNum++;
						teamScore[teamNum].penalty += time;
						if (list[teamNum][prob].incorrect == true)
							teamScore[teamNum].penalty += (list[teamNum][prob].incorrectNum) * 20;
					}
				}
			}
			
			Collections.sort(teamList);
			
			int order[] = new int [teamList.size()];
			for (int i = 0; i < teamList.size(); i++) order[i]= i;
			
			for (int i = 1; i < teamList.size(); i++) {
				for (int j = 0; j < teamList.size() -i ; j++) {
					if (teamScore[teamList.get(order[j])].correctNum < teamScore[teamList.get(order[j+1])].correctNum) {
						int tmp = order[j];
						order[j] = order[j+1];
						order[j+1] = tmp;
					}
					else if (teamScore[teamList.get(j)].correctNum == teamScore[teamList.get(j+1)].correctNum) {
						if (teamScore[teamList.get(j)].penalty > teamScore[teamList.get(j+1)].penalty) {
							int tmp = order[j];
							order[j] = order[j+1];
							order[j+1] = tmp;
						}
					}
				}
			}
			for (int i =0; i < teamList.size(); i++) {
				System.out.print(teamList.get(order[i])+1 + " ");
				System.out.print(teamScore[teamList.get(order[i])].correctNum + " ");
				System.out.println(teamScore[teamList.get(order[i])].penalty);
			}
			System.out.println();
		}
	}
}