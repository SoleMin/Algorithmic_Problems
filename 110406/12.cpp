#include <iostream>
#include <algorithm>
#include <string>
#include <sstream>
#include <vector>
#include <map>
#include <iomanip>
#define ABS(x) ((x) > 0 ? (x) : (-(x)))
#define TIME (24)
#define DAY (1440)
#define HOUR (60)

using namespace std;

typedef struct {
	string name;
	int time;
	int in;
	int point;
}Record;

static int costs[TIME];
map<string, int> cost_table;

void init() {
	for(int i = 0; i < TIME; i++){
		costs[i] = 0;
	}
	
	cost_table.erase(cost_table.begin(), cost_table.end());
}

bool compare(Record r1, Record r2) {
	return r1.time < r2.time;
}

bool compare_2(pair<string, int> v1, pair<string, int> v2) {
	return v1.first < v2.first;
}

int get_price(int time, int p1, int p2) {
	int cost_index = (time / HOUR) % TIME;
	return ABS(p2 - p1) * costs[cost_index] + 100;
}

void solve(vector<Record>& data) {
	map<string, Record> m;
	
	for (int i = 0; i < data.size(); i++){
		if (m.find(data[i].name) != m.end()) {
			Record previous_record = m.find(data[i].name)->second;
			if (previous_record.in == 1 && data[i].in == 2) {
				int price = get_price(previous_record.time, previous_record.point, data[i].point);
				
				if (cost_table.find(data[i].name) != cost_table.end()) {
					cost_table[data[i].name] += price;
				}
				else {
					cost_table.insert({data[i].name, price});
				}
				m.erase(data[i].name);
			}
			/*else {
				m.erase(data[i].name);
			}*/
		}
		else {
			if (data[i].in == 1) {
				m.insert({data[i].name, data[i]});
			}
		}
	}
}

void get_costs() {
	for (int i = 0; i < TIME; i++) {
		cin >> costs[i];
	}
}

int get_time(string time) {
	stringstream ss(time);
	vector<string> tokens;
	string token;
	
	while (getline(ss, token, ':')) {
		tokens.push_back(token);
	}
	
	int month = stoi(tokens[0]);
	int day = stoi(tokens[1]);
	int hour = stoi(tokens[2]);
	int minute = stoi(tokens[3]);
	
	return day*DAY + hour*HOUR + minute;
}

int main(void) {
	int test_case = 0;
	string input;
	cin >> test_case;
	getline(cin, input);
	cin.ignore();
	
	while(test_case-- > 0){
		init();
		vector<Record> data;
		
		get_costs();
		cin.ignore();
		
		while (getline(cin, input) && !input.empty()) {
			stringstream ss(input);
			vector<string> tokens;
			string token;
			while (getline(ss, token, ' ')) {
				tokens.push_back(token);
			}
			string name = tokens[0];
			int time = get_time(tokens[1]);
			int in = tokens[2] == "enter" ? 1 : 2;
			int point = stoi(tokens[3]);
			Record temp = {name, time, in, point};
			data.push_back(temp);	
		}
		
		stable_sort(data.begin(), data.end(), compare);
		
		solve(data);
		
		vector<pair<string, int> > v;
		for (auto i = cost_table.begin(); i != cost_table.end(); i++){
			string cur_name = i->first;
			int cur_price = i->second;
			v.push_back(make_pair(cur_name, cur_price));
		}
		stable_sort(v.begin(), v.end(), compare_2);
		
		for (int i = 0; i < v.size(); i++) {
			int dollor = v[i].second / 100;
			int cent = v[i].second % 100;
			cout << v[i].first << " $" << dollor + 2 << '.' << setw(2) << setfill('0') << cent << endl;
		}
		cout << endl;
	}
	
	return 0;
}











