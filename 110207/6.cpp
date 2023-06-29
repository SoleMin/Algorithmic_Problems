#include <iostream>
#include <string>
#include <sstream>

using namespace std;

typedef struct{
	int team_num;
	int q_num;
	int time;
}SCORE;

void Rank(SCORE s[], int count){
	SCORE max_s;
	for(int i=0; i<count; i++){
		for(int j=i+1; j<count; j++){
			if(s[i].q_num<0)
				s[i].q_num = 0;
			if(s[i].q_num < s[j].q_num){
				max_s = s[i];
				s[i] = s[j];
				s[j] = max_s;
			}
			else if(s[i].q_num == s[j].q_num){
				if(s[i].time > s[j].time){
					max_s = s[i];
					s[i] = s[j];
					s[j] = max_s;
				}
				else if(s[i].time == s[j].time){
					if(s[i].team_num > s[j].team_num){
						max_s = s[i];
						s[i] = s[j];
						s[j] = max_s;
					}
				}
			} 
		}
	}
}

int main() {
	int t;
	
	cin >> t;
	cin.ignore();
	cin.ignore();
	for(; t>0; t--){
		int team[100][9][3] = {0};
		int cnt = 0;
		string line;
		
		while(getline(cin, line) && line.length()){
			int n[3];
			char L;
			istringstream iss(line);
			iss >> n[0] >> n[1] >> n[2] >> L;
			team[n[0]-1][n[1]-1][2] = 1;
			if(L=='I')
				team[n[0]-1][n[1]-1][1] += 20;
			else if(L=='C')
				team[n[0]-1][n[1]-1][0] = n[2];
		}
		
		for(int i=0; i<100; i++){
			int check = 0;
			for (int j=0; j<9; j++){
				if(team[i][j][0]>0 || team[i][j][2])
					check = 1;
			}
			if(check)
				cnt++;
		}
		
		SCORE result[cnt];
		cnt = 0;
		for(int i=0; i<100; i++){
			int input[3] = {0};
			for(int j=0; j<9; j++){
				if(team[i][j][0]>0){
					input[0]++;
					input[1] = input[1] + team[i][j][0] + team[i][j][1];
				}
				else if(team[i][j][2]){
					input[2] = -1;
				}
			}
			if(input[0] || (!input[0] && input[2])){
				result[cnt].team_num = i+1;
				result[cnt].q_num = input[0];
				result[cnt].time = input[1];
				cnt++;
			}
			
		}
		
		Rank(result, cnt);
		
		for(int i=0; i<cnt; i++){
			cout << result[i].team_num << " " << result[i].q_num << " " << result[i].time << endl;
		}
		cout << endl;
	}
	return 0;
}