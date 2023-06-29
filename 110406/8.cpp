#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;
vector<string> split(string s);
int main() {
	int t;
	string s;
	cin >> t;
	cin.ignore();
	getline(cin, s);
	while(t--) {
		vector<vector<string>> cdvii;
		getline(cin, s);
		vector<string> cent = split(s);
		while(true) {
			getline(cin, s);
			if(s.empty()) break;
			cdvii.push_back(split(s));
		}
		
		sort(cdvii.begin(), cdvii.end());
		
		map<string, int> result;
		for(auto i: cdvii) result.insert({i[0], 200});
		
		for(int i = 0; i < cdvii.size(); i++) {
			if(cdvii[i][2] != "enter") continue;
			string car = cdvii[i][0];
			int km = 0, time = (cdvii[i][1][6] - '0') * 10 + cdvii[i][1][7] - '0';
			vector<int> pass;
			for(int j = i; j < cdvii.size(); j++) {
				if(find(pass.begin(), pass.end(), j) != pass.end()) break;
				if(car != cdvii[j][0]) break;
				if(cdvii[j][2] == "exit") {
					km = abs(stoi(cdvii[j][3]) - stoi(cdvii[i][3]));
					result[car] += 100 + km * stoi(cent[time]);
					pass.push_back(j);
					break;
				}
			}
		}
		cout << fixed;
		cout.precision(2);
		for(auto i: result) {
			double temp = i.second;
			temp /= 100;
			if(i.second != 200) cout << i.first << " $" << temp << endl;
		}
		cout << endl;
	}
	return 0;
}

vector<string> split(string s) {
	string temp;
	vector<string> str;
	for (char i: s) {
		if(i == ' ') {
			str.push_back(temp);
			temp.clear();
		} else temp += i;
	}
	str.push_back(temp);
	return str;
}