import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int Testcase = scan.nextInt();
		scan.nextLine();
		scan.nextLine();
		for(int t=0;t<Testcase;t++) {
			Team team[]=new Team[100];
			while(scan.hasNextLine()) {
				String S= scan.nextLine();
				if(S.equals(""))break;
				String s[]=S.split(" ");
				int num= Integer.parseInt(s[0]);
				int Qnum=Integer.parseInt(s[1]);
				int time_p=Integer.parseInt(s[2]);
				String L= s[3];
				if(team[num-1]==null)
					team[num-1]=new Team(num,0,0);
				if(L.equals("I")) {
					team[num-1].settried(Qnum, 1);
				}
				if(L.equals("C")) {
					if(!team[num-1].bool[Qnum-1]) { //중복 정답일 경우 pass
						team[num-1].bool[Qnum-1]=true;
						team[num-1].settime_p(time_p);
						team[num-1].setcorrect();
						if(team[num-1].tried[Qnum-1][0]==1)
							team[num-1].settime_p(team[num-1].tried[Qnum-1][1]);
					}
				}
			}	
				int cnt=0;
				for(int i=0;i<100;i++)
					if(team[i]!=null)
						cnt++;
				Team[] team2 = new Team[cnt];
				int j=0;
				for(int i=0;i<100;i++) {
					if(team[i]!=null) {
						team2[j++]=new Team(team[i].num,team[i].correct,team[i].time_p);
					}
				}
				Arrays.sort(team2);
				
				for(int i=0;i<cnt;i++) {
					//if(team2[i].correct!=0)
						System.out.println(team2[i].num+" "+team2[i].correct+" "+team2[i].time_p);
				}
			System.out.println();
		}
	}
}

class Team implements Comparable<Team>{
	int num;
	int correct;
	int time_p;
	int[][] tried = new int[9][2];//문제당 타임페널티 저장
	boolean[] bool = new boolean[9]; //중복 정답 체크
	
	public Team(int num,int correct,int time_p){	
		this.num=num;
		this.correct=correct;
		this.time_p=time_p;
		for(int i=0;i<9;i++)bool[i]=false;
	}
	public void setnum(int num) {
		this.num=num;
	}
	public void setcorrect() {
		this.correct++;
	}
	public void settime_p(int time_p) {
		this.time_p+=time_p;
	}
	public void settried(int n,int tried) {
		this.tried[n-1][0]=tried;
		this.tried[n-1][1]+=20;
	}
	@Override
	public int compareTo(Team o) {
		if(o.correct==correct) {
			if( o.time_p==time_p) return num- o.num;
			return time_p-o.time_p;
		}
		return o.correct-correct;
	}
	
}