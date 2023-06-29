#include <iostream>
#include <string>
#include <algorithm>
#include <sstream>
#include <vector>
#include <map>
using namespace std;

int fee[24];
string line[1005];
map<string, pair<int, int>> start;
map<string, pair<int, int>> ret;


int main() {
	int t; cin >> t;
	while(t--) {
		start.clear();
		ret.clear();
		for(int i = 0; i < 24; i++)
			cin >> fee[i];
		cin.get();
		int idx = 0;
		while(getline(cin, line[idx])) {
			if(line[idx] == "") break;
			idx++;
		}
		sort(line, line + idx);
		
		string car, time, io;
		int km;
		for(int i = 0; i < idx; i++) {
			stringstream ss(line[i]);
			ss >> car >> time >> io >> km;
			int startTime = (time[6] - '0') * 10 + (time[7] - '0');
			
			if(io == "enter") {		// 이전에 enter가 있는지 확인해야하나?
				start[car] = {fee[startTime], km};
			}
			else if(start.find(car) != start.end()) {
				//ret[car] += 1 + (start[car].first * (km - start[car].second)) / 100.0;
				
				pair<int, int> cur = ret[car];
				int cent = start[car].first * abs(km - start[car].second);
				cur.first += 1 + cent / 100;
				cur.second += cent % 100;
				ret[car] = cur;
				start.erase(car);
			}
		}
		// cout << fixed;
		// cout.precision(2);
		
		vector<pair<string, pair<int, int>>> sorted_ret;
		for(auto f : ret)
			sorted_ret.push_back(f);	
		
		sort(sorted_ret.begin(), sorted_ret.end());
		
		for(int i = 0; i < sorted_ret.size(); i++) {
			pair<int, int> sec = sorted_ret[i].second;
			int cent = sec.second;
			cout << sorted_ret[i].first << " $" << 2 + sec.first + cent / 100;
			if(cent % 100 < 10)
				cout << ".0" << cent % 100 << '\n';
			else
				cout << "." << cent % 100 << '\n';
		}
		cout << '\n';
	}
	
	return 0;
}