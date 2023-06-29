import java.io.*;
import java.util.*;

class Team {
	int team_num;
	int pro_num;
	int sec;
	int incorrect;
	char response;
	
	public Team(int team_num, int pro_num){
		
		this.team_num = team_num;		
		this.pro_num = pro_num;
		this.sec=0;
		this.incorrect=0;
		
	}
	
	void ud_sec(int sec){
		this.sec=sec;
	}
	
	void ud_incorrect(){
		this.incorrect += 1;
	}
	
	void ud_response(char response){
		this.response=response;
	}
	
	int get_teamNumber(){
		return this.team_num;	
	}
	int get_proNumber(){
		return this.pro_num;
	}
	int get_sec(){
		return this.sec;
	}
	int get_incorrect(){
		return this.incorrect;
	}
	
	char get_response(){
		return this.response;
	}
	


	
	
}


class SortInfo implements Comparable<SortInfo> {
	int team_num;
	int total_count;
	int total_sec;
	
	SortInfo(int team_num, int total_count, int total_sec){
		this.team_num = team_num;
		this.total_count = total_count;
		this.total_sec = total_sec;
	}
	
	public int compareTo(SortInfo team){
		if(this.total_count > team.total_count || (this.total_count == team.total_count && this.total_sec< team.total_sec)
			|| ((this.total_count== team.total_count && this.total_sec == team.total_sec) && this.team_num<team.team_num))
			return -1;
		else if( this.total_count==team.total_count && this.total_sec == team.total_sec && this.team_num == team.team_num )
			return 0;
		else
			return 1;
	}
	
}




class Main {
	public static void main(String[] args) throws Exception {
	
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		scanner.nextLine();
		scanner.nextLine();
		for(int i = 0 ; i<n; i++){
			Vector<Team> t_arr= new Vector<Team>();
			ArrayList<Integer> t_num= new ArrayList<Integer>();
		
			while(scanner.hasNextLine()){
				String str= scanner.nextLine();
				//System.out.println(str+"ssss");				
				if(str.equals(""))
					break;
				String []info= str.split(" ");

				int team_num = Integer.parseInt(info[0]);
				int pro_num = Integer.parseInt(info[1]);
				int sec = Integer.parseInt(info[2]);
				char response = info[3].charAt(0);
									
				//if(response == 'R' || response=='L' || response=='E'){
				//	continue;
				//}
				
				boolean find = true;
				
				for(Team j : t_arr){
					
					if(j.get_teamNumber() == team_num && j.get_proNumber()==pro_num){
					
						if(j.get_response()!='C' && response == 'I'){
							j.ud_incorrect();

						}
						else if(j.get_response()!='C' && response =='C'){
							j.ud_sec(sec);
							j.ud_response(response);
					
						}
						find=false;
						break;
					}
					
				}
				
				if(find){
					if(!t_num.contains(team_num))
						t_num.add(team_num);
					Team tmp = new Team(team_num,pro_num);
					

					
					if(response=='I')
						tmp.ud_incorrect();
					else if(response=='C'){
						tmp.ud_sec(sec);
						//System.out.println(team_num+" "+pro_num+" "+tmp.get_sec());	
					}
					
					tmp.ud_response(response);

					
					t_arr.add(tmp);
				}
				
			}
			
			
			SortInfo[] f_team = new SortInfo[t_num.size()];
			
			
			int index=0;
			for(int j :t_num){
				int total_count=0;
				int total_sec=0;
				
				for(Team t : t_arr){
					//System.out.println("->"+t.team_num+" "+t.pro_num+" "+t.get_sec());		
					if(t.get_teamNumber()== j && t.get_response() =='C'){
						total_count++;
						total_sec += t.get_incorrect()*20+ t.get_sec();
						
					}
				}

				f_team[index++]= new SortInfo(j, total_count, total_sec);

			}
			
			Arrays.sort(f_team);
			
			for(SortInfo info: f_team)
				System.out.println(info.team_num+" "+info.total_count+" "+info.total_sec);
			
			System.out.println("");
			
			
		}
		
	}
}