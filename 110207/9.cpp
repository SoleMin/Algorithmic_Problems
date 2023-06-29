#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>

struct Team {
	int name = 0;
	int number_of_ans;
	int penalty_time;
};

int team_score[101][10];
Team result[101];

using namespace std;

void init_() {
	Team temp;
	for (int i = 0; i < 101; i++) {
		result[i] = temp;
		for (int j = 0; j < 10; j++)
			team_score[i][j] = 0;
	}
}

bool compare(Team a, Team b) {
	if (a.number_of_ans == b.number_of_ans)
		if (a.penalty_time == b.penalty_time)
			return a.name < b.name;
		else
			return a.penalty_time < b.penalty_time;
	else
		return a.number_of_ans > b.number_of_ans;
}

int main() {
	int T;
	string s;
	cin >> T;
	cin.ignore();
	getline(cin, s);
	while (T-- != 0) {
		init_();
		while (getline(cin, s)) {
			if (s[0] < '0')
				break;
			//cout << s << endl;
			stringstream ss(s);
			string temp;
			vector<string> v;
			while (getline(ss, temp, ' '))
				v.push_back(temp);
			int team_name = stoi(v[0]);
			int problem = stoi(v[1]);
			int time = stoi(v[2]);
			//cout << v[0] << v[1] << v[2] << v[3] << endl;
			if (v[3] == "I") {
				result[team_name].name = team_name;
				team_score[team_name][problem] += 20;
			}
			else if (v[3] == "C") {
				result[team_name].name = team_name;
				result[team_name].penalty_time += (team_score[team_name][problem] + time);
				result[team_name].number_of_ans += 1;
			}
			else
				result[team_name].name = team_name;
		}
		vector<Team> v;
		for (int i = 1; i < 101; i++)
			if (result[i].name) {
				v.push_back(result[i]);
			}
		sort(v.begin(), v.end(), compare);
		for (int i = 0; i < v.size(); i++)
			cout << v[i].name << " " << v[i].number_of_ans << " " << v[i].penalty_time << "\n";
		cout << "\n";
	}
	return 0;
}