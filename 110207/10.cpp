# include <iostream>
# include <string>
# include <sstream>
# include <vector>
# include <algorithm>
# define MAX_TEAM_SIZE (101)
# define MAX_PROBLEM_SIZE (10)

using namespace std;

class Team {
public:
	int check_in = 0;
	int team_number = 0;
	int solved_counter = 0;
	int sum_of_penalty_time = 0;
	int is_solved[MAX_PROBLEM_SIZE] = {0, };
	int penalty_time[MAX_PROBLEM_SIZE] = {0, };
	
	Team() : solved_counter(0) {
		team_number = 0;
		solved_counter = 0;
		//cout << "default constructor" << endl;
	}
	
	Team(int _team_number) : solved_counter(0) {
		this->team_number = _team_number;
		//cout << "normal constructor" << endl;
	}
	
	~Team() {
		//cout << "terminated" << endl;
	}
	
	void handle_incorrect(int _problem_number) {
		this->penalty_time[_problem_number - 1] += 20;
	}
	
	void handle_correct(int _problem_number, int _time) {
		if (this->is_solved[_problem_number - 1] == 1) {
			return;
		}
		
		this->is_solved[_problem_number - 1] = 1;
		this->penalty_time[_problem_number - 1] += _time;
		this->solved_counter++;
		this->sum_of_penalty_time += penalty_time[_problem_number - 1];
	}
	
	void printf_result() {
		cout << this->team_number << " " << this->solved_counter << " " << this->sum_of_penalty_time << endl;
	}
private:
};

bool compare(Team* a, Team* b) {
	if (a->solved_counter > b->solved_counter) {
		return true;
	}
	else {
		if (a->solved_counter == b->solved_counter) {
			if (a->sum_of_penalty_time > b->sum_of_penalty_time) {
				return false;
			}
			else {
				if (a->sum_of_penalty_time == b->sum_of_penalty_time) {
					if (a->team_number < b->team_number) {
						return true;
					}
					else {
						return false;
					}
				}
				else {
					return true;
				}
			}
		}
		else {
			return false;
		}
	}
}

int main() {
	
	int test_case = 0;
	string dump;	//개행 처리 용
	
	/*테스트 입력 처리*/
	cin >> test_case;
	cin.ignore();
	getline(cin, dump);
	/*테스트 입력 처리*/
	
	while (test_case-- > 0) {
		int cur_team_number = 0;
		int cur_problem_number = 0;
		int cur_time = 0;
		string cur_command = "";
		
		/*Team 객체 생성*/
		Team* teams[MAX_TEAM_SIZE];
		for (int team_number = 0; team_number < MAX_TEAM_SIZE; team_number++) {
			teams[team_number] = new Team(team_number);
		}
		/*Team 객체 생성*/
		
		/*입력 처리*/
		while (getline(cin, dump)) {
			/*입력 토큰화*/
			vector<string> words;
			string word;
			if (dump == ""){
				break;
			}
			else {
				stringstream sstream(dump);
				while (getline(sstream, word, ' ')) {
					words.push_back(word);
				}
			}
			/*입력 토큰화*/
			
			/*토큰 분배*/
			cur_team_number = stoi(words[0]);
			cur_problem_number = stoi(words[1]);
			cur_time = stoi(words[2]);
			cur_command = words[3];
			/*토큰 분배*/
			
			/*커맨드에 따른 함수 실행*/
			if (cur_command == "I"){
				teams[cur_team_number]->handle_incorrect(cur_problem_number);
				teams[cur_team_number]->check_in = 1;
			}
			else if (cur_command == "C"){
				teams[cur_team_number]->handle_correct(cur_problem_number, cur_time);
				teams[cur_team_number]->check_in = 1;
			}
			else if (cur_command == "R" || cur_command == "L" || cur_command == "E") {
				teams[cur_team_number]->check_in = 1;
				continue;
			}
			/*커맨드에 따른 함수 실행*/
		}	//EOW(Input Handling)
		/*입력 처리 */
		
		/*정답인 팀만 배열에 저장*/
		vector<Team*> result;
		for (int i = 0; i < MAX_TEAM_SIZE; i++) {
			if (teams[i]->check_in == 1) {
				result.push_back(teams[i]);
			}
		}
		/*정답인 팀만 배열에 저장*/
		sort(result.begin(), result.end(), compare);	// 조건에 맞게 정렬
		/*결과 출력*/
		for (auto iter = result.begin(); iter != result.end(); iter++) {
			(*iter)->printf_result();
		}
		/*결과 출력*/
		
		/*동적 배열 해제*/
		for (int i = 0; i < MAX_TEAM_SIZE; i++){
			delete teams[i];
		}
		/*동적 배열 해제*/
		
		cout << '\n';
	}	//EOW(Test Case)
	
	
}



