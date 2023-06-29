#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <set>
#include <string>
#include <cstring>
using namespace std;

struct word {
	string my_str;
	int my_cnt;
	int my_num;
};

vector<string> dict;
int ss[1000];

bool check(string a, string b) {
	if (a.size() != b.size()) return false;
	int cnt = 0;
	for (int i = 0; i < a.size(); i++) {
		if (a[i] != b[i]) cnt++;
		if (cnt > 1) 
			return false;
	}
	if (cnt == 1) 
		return true;
	return 
		false;
}

vector<string> solve(string start, string end, int pin) {
	set<string> visit;
	queue<word> q;
	vector<pair<string, int> > btr;
	vector<string> answer;
	int last_pin;
	bool sol = false;
	
	q.push({ start,0,pin });
	while(!q.empty()){
		string str = q.front().my_str;
		int cnt = q.front().my_cnt;
		int my_num = q.front().my_num;
		q.pop();
		
		if (str.compare(end) == 0){
			sol = true;
			last_pin = my_num;
			break;
		}
		
		int visit_size = visit.size();
		visit.insert(str);
		if(visit_size == visit.size())
			continue;
	
		for(int i = 0; i < dict.size(); i++){
			if (check(str, dict[i])){
				visit_size = visit.size();
				visit.insert(dict[i]);
				if (visit_size != visit.size()) {
					visit.erase(dict[i]);
					q.push({ dict[i],cnt + 1, i });
					if (ss[i] == -1)
						ss[i] = my_num;
				}
			}
		}
	}
	
	if (!sol) return answer;
	else{
		answer.push_back(end);
		while (1){
			string str = dict[ss[last_pin]];
			answer.push_back(str);
			if(str.compare(start) == 0)
				break;
			last_pin = ss[last_pin];
		}
		return answer;
	}
}

int main(){
	ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
	
	string str, start, end;
	while(getline(cin, str), str != ""){
		while (1){
			if(str[str.size() - 1] == ' ') 
				str.pop_back();
			else break;
		}
	dict.push_back(str);
	}
	
	while(cin >> start >> end){
		memset(ss, -1, sizeof(ss));
		if(start.size() != end.size()){
			cout << "No solution.\n\n";
			continue;
		}
		if(start.compare(end) == 0){
			cout << end << "\n" << end << "\n\n";
			continue;
		}
		int pin;
		for(int i = 0; i < dict.size(); i++){
			if(start.compare(dict[i]) == 0){
				pin = i;
				break;
			}
		}
		vector<string> answer = solve(start, end, pin);
				
		if (answer.size() == 0) cout << "No solution.\n";
		else for (int i = answer.size() - 1; i >= 0; i--) cout << answer[i] << "\n";
		cout << "\n";
	}	
	return 0;
}
