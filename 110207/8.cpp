#include <iostream>
#include <string>
#include <sstream>
#include <algorithm>

using namespace std;

int t;
bool isCorrected[101][10];
int penaltyTime[101][10];

struct score {
	int teamNum, correctNum, wasted;
};

score pri[101];

bool cmp(const score &s1, const score &s2) {
	if(s1.correctNum > s2.correctNum)
		return true;
	else if(s1.correctNum < s2.correctNum)
		return false;
	
	if(s1.wasted < s2.wasted) return true;
	else if(s1.wasted > s2.wasted) return false;
		
	if(s1.teamNum < s2.teamNum) return true;
	else if(s1.teamNum > s2.teamNum) return false;
}

void print() {
	for(int i = 1; i < 101; i++) {
		int tn = pri[i].teamNum;
		if(tn) {
			cout << tn << ' ' << pri[i].correctNum << ' ' << pri[i].wasted << '\n';
		}
	}
	cout << '\n';
}

int main() {
	
	cin >> t;
	cin.get();
	cin.get();
	while(t--) {
		for(int i = 0; i < 101; i++) {
			pri[i].teamNum = 0;
			pri[i].correctNum = 0;
			pri[i].wasted = 0;
			for(int j = 0; j < 10; j++) {
				isCorrected[i][j] = false;
				penaltyTime[i][j] = 0;
			}
		}
		
		while(true) {
			string line = "";
			getline(cin, line);
			if(cin.eof()) break;
			if(line == "") break;
			
			istringstream iss(line);

			int team, num, time;
			char l;
			iss >> team >> num >> time >> l;

			pri[team].teamNum = team;
			if(isCorrected[team][num]) continue;

			if(l == 'C') {
				isCorrected[team][num] = true;
				// pri[team].wasted += time;
				pri[team].wasted += (penaltyTime[team][num] + time);
				pri[team].correctNum++;
			}
			else if(l == 'I') {
				//pri[team].wasted += 20;
				penaltyTime[team][num] += 20;
			}
		}
		sort(pri + 1, pri + 101, cmp);
		
		print();
		// if(t) cout << '\n';
	}
	
	return 0;
}