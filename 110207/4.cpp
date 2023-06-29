#include <algorithm>
#include <iostream>
#include <sstream>
#include <cstring>
#include <string>
#include <vector>
#include <map>
using namespace std;

struct team{
	int tryCount[10];
	int score, penalty;
};
map<int, team> teams;
vector<int> teamIndex;

bool compare(int A, int B) {
	if (teams[A].score != teams[B].score)
		return (teams[A].score > teams[B].score);
	if (teams[A].penalty != teams[B].penalty)
		return (teams[A].penalty < teams[B].penalty);
	return (A < B);
}

int main() {
	int t;
	stringstream ss;
	string line;
	getline(cin, line);
	ss.clear();
	ss << line;
	ss >> t;
	getline(cin, line);
	while (t--){
		teams.clear();
		teamIndex.clear();
		while (getline(cin, line)) {
			if (line.empty())
				break;
			int teamNum, questNum, time;
			string alphabet;
			ss.clear();
			ss << line;
			ss >> teamNum >> questNum >> time >> alphabet;
			
			if (teams.find(teamNum) == teams.end()) {
				team teamN;
				teamN.penalty = 0;
				teamN.score = -1;
				memset(teamN.tryCount, 0, sizeof teamN.tryCount);
				teamIndex.push_back(teamNum);
				teams.insert({teamNum, teamN});
			}
			
			if (alphabet == "C") {
				if (teams[teamNum].score == -1)
					teams[teamNum].score++;
				teams[teamNum].score++;
				teams[teamNum].penalty += (20 * teams[teamNum].tryCount[questNum]) + time;
			}
			else if (alphabet == "I") {
				if (teams[teamNum].score == -1)
					teams[teamNum].score++;
				teams[teamNum].tryCount[questNum]++;
			}
			else
				if (teams[teamNum].score == -1)
					teams[teamNum].score++;
		}
		
		sort(teamIndex.begin(), teamIndex.end(), compare);
		for (int i = 0; i < teamIndex.size(); i++)
			cout << teamIndex[i] << " " << teams[teamIndex[i]].score << " " << teams[teamIndex[i]].penalty << endl;
		
		if (t)
			cout << endl;
	}
	return 0;
}