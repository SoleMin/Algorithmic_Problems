import java.util.*;

class Team implements Comparable<Team>{
	private int team_n;
	private int score = 0;
	private int time_p = 0;
	private int[] fail = new int[9];
	
	public Team(int team_n){
		this.team_n = team_n;
	}
	public int getTeam_n(){
		return team_n;
	}
	public void addScore(){
		score += 1;
	}
	public void addTime_p(int p,int i){
		time_p += (p + fail[i]);
	}
	public void addFail(int i){
		fail[i] += 20;
	}
	
	public int compareTo(Team team){
		//푼 문제 갯수
		if(team.score < score) return 1;
		else if(team.score > score) return -1;
		else {
			//시간 벌점
			if(team.time_p > time_p) return 1;
			else if(team.time_p < time_p) return -1;
			else{
				//팀 숫자
				if(team.team_n > team_n) return 1;
				else return -1;
			}
		}
	}
	
	public String toString(){
		return team_n + " " + score + " " + time_p;
	}
}
class Main {
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		in.nextInt();
		in.nextLine();
		
		while(in.hasNextLine()){
			List<Team> team = new ArrayList<>();
			
			while(true){
				if(!in.hasNextLine()) break;
				String s = in.nextLine();
				if(s.length() == 0) break; 
				
				String[] s_a = s.split(" ");
				int[] num = new int[3];
				for(int i=0; i<3; i++){
					num[i] = Integer.parseInt(s_a[i]);
				}
				String str = s_a[3];
				
				//리스트에 해당 팀이 있는지 검사 후 없으면 생성
				int index = -1;
				int j = 0;
				for(j = 0; j < team.size(); j++){
					if(num[0] == team.get(j).getTeam_n()){
						index = j;
						break;
					}
				}
				if(index == -1) {
					team.add(new Team(num[0]));
					index = j;
				}
				//페널티를 더함
				if(str.equals("I")) {
					team.get(index).addFail(num[1]-1);
				}
				if(str.equals("C")){
					team.get(index).addScore();
					team.get(index).addTime_p(num[2], num[1]-1);
				}
	
			}	
			Collections.sort(team, Collections.reverseOrder());
			for(int i=0; i<team.size(); i++){
				System.out.println(team.get(i));
			}
			System.out.println();
		}
	}
	
}