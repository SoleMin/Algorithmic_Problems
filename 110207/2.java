import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		
		input.nextLine();
		input.nextLine();
		
		while (t-- > 0) {
			
			Team[] teams = new Team[101];
			boolean[][] check = new boolean[101][11];
			for (int i = 0; i < 101; i++)
				teams[i] = new Team(i);
			
			while (input.hasNextLine()) {
				String line = input.nextLine();
				if (line.equals(""))
					break;
				else {
					int n = Integer.parseInt(line.split(" ")[0]);
					int p = Integer.parseInt(line.split(" ")[1]);
					int time = Integer.parseInt(line.split(" ")[2]);
					String L = line.split(" ")[3];
					if(L.equals("C")){
						if(check[n][p])
							continue;
						check[n][p] = true;
						teams[n].solved++;
						teams[n].time += time + teams[n].not[p]*20;
					} else if (L.equals("I")){
						if(check[n][p])
							continue;
						teams[n].not[p]++;
					}
					teams[n].participation = true;
				}
			}
			Arrays.sort(teams);
			for(int i = 0; i < 101; i++)
				if(teams[i].participation)
					System.out.println(teams[i]);
			System.out.println();
		}
	}
}

class Team implements Comparable<Team> {
	int number;
	int solved;
	int time;
	boolean participation;
	int[] not = new int[11];
	public Team(int n) {
		number = n;
		solved = 0;
		time = 0;
		participation = false;
	}
	
	public int compareTo(Team t) {
		int result = t.solved - this.solved;
		if (result == 0){
			result = this.time - t.time;
			if(result == 0)
				return this.number - t.number;
			else
				return result;
		} else
			return result;
	}
	
	public String toString() {
		return number + " " + solved + " " + time;
	}
}