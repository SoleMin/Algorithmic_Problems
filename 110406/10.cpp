#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <map>
#include <cmath>
#include <algorithm>

using namespace std;

/*
1. 요금 기준 배열을 만듬
2. 기록이 순서대로 되어 있지 않으므로 한 번에 입력받고 정렬
3. 각각의 차량에 대해 정보를 저장해야 하니까 구조체 맵 사용
   - 저장해야 할 것: 들어온 시각, 들어온 게이트, 상태(enter/exit), 요금
4. 기록마다 우선적으로 등록된 차량인지 판단
	 - 등록됨
	   1) 들어오는 경우
		    = 이전에 들어왔는지 나갔는지와 상관없이 갱신
		 2) (들어온 상태였다가) 나가는 경우
		    = 요금 계산 후 상태 갱신
	 - 등록 안 됨
		 = enter일 때만 등록하도록 함
5. 요금이 부과된 차량에 한해서 출력
*/

struct Person {
	int enter_time;
	int enter_gate;
	string status;
	double money;
};

int charge[24];

int main() {
	int T;
	cin >> T;
	while (T-- != 0) {
		for (int i = 0; i < 24; i++)
			cin >> charge[i];
		cin.ignore();
		string s;
		map<string, Person> mp;
		vector<string> record;
		while (getline(cin, s)) {
			if (s[0] < '0')
				break;
			record.push_back(s);
		}
		sort(record.begin(), record.end());
		
		for (int i = 0; i < (int) record.size(); i++) {
			s = record[i];
			//cout << s << endl;
			stringstream ss(s);
			string temp;
			vector<string> v;
			while (getline(ss, temp, ' '))
				v.push_back(temp);
			string name = v[0];
			int time = stoi(v[1].substr(6, 2));
			string status = v[2];
			int gate = stoi(v[3]);
			
			//cout << name << ' ' << time << ' ' << status << ' ' << gate << '\n';
			
			try {
				mp.at(name);
				if (status == "enter") {
					mp[name].enter_time = time;
					mp[name].enter_gate = gate;
					mp[name].status = status;
				}
				else if (mp[name].status != status) {
					mp[name].money += (abs(mp[name].enter_gate - gate) * charge[mp[name].enter_time] / 100.0);
					mp[name].money += 1.0;
					mp[name].status = "exit";
				}
			}
			catch (exception e) {
				if (status == "enter")
					mp.insert({ name, Person { time, gate, status, 0.0 }});
			}
		}
		
		cout << fixed;
		cout.precision(2);
		for (auto iter = mp.begin(); iter != mp.end(); iter++)
			if (iter->second.money)
				cout << iter->first << " $" << (iter->second.money + 2.0) << '\n';
		cout << '\n';
	}
	return 0;
}