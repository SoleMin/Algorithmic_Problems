import java.util.Scanner;
import java.util.Arrays;

class Main {
	
	static class Team implements Comparable<Team> {
		int no;
		int score = 0, penalty = 0, submitCount = 0;
		int[] problems = new int[9];
		int[] solved = new int[9];
		
		public Team(int number) {
			this.no = number;
			for (int i=0; i < 9; i++) {
				this.problems[i] = 0;
				this.solved[i] = 0;
			}
		}
		
		@Override
		public int compareTo(Team o) {
			if (this.score - o.score != 0) {
				return -(this.score - o.score);
			}
			if (this.penalty - o.penalty != 0) {
				return this.penalty - o.penalty;
			}
			return this.no - o.no;
		}
	}
	
	Team[] teams = new Team[100];
	
	public Main() {
		for (int i=0; i < teams.length; i++) {
			this.teams[i] = new Team(i+1);
		}
	}
	
	private Team getTeam(int teamNo) {
		return teams[teamNo-1];	
	}
	
	public void submit(String line) {
		String[] values = line.split(" ");
		int teamNo = Integer.parseInt(values[0]);
		int problemNo = Integer.parseInt(values[1])-1;
		int elapsedTime = Integer.parseInt(values[2]);
		char status = values[3].charAt(0);
		
		Team team = getTeam(teamNo);
		team.submitCount++;
		
		if (status == 'C' && team.solved[problemNo] == 0) {
			team.penalty += team.problems[problemNo] * 20 + elapsedTime;
			team.solved[problemNo] = 1;
			team.score++;
		} else if (status == 'I') {
			team.problems[problemNo]++;
		}
	}
	
	public void printResult() {
		Arrays.sort(teams);
		
		for (int i=0; i < 100; i++) {
			if (teams[i].submitCount > 0) {
				System.out.println(String.format("%d %d %d",teams[i].no, teams[i].score, teams[i].penalty));
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner input = new Scanner(System.in);
		
		int tc = Integer.parseInt(input.nextLine());
		input.nextLine();
		
		for (int i=0; i < tc; i++) {
			Main board = new Main();
			
			while (input.hasNextLine()) {
				String line = input.nextLine();
				if (line == null || line.length() == 0) {
					break;
				}
				board.submit(line);
			}
			
			board.printResult();
		}
		
		input.close();
	}
}