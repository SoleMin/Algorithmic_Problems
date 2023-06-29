#include <iostream>
#include <algorithm>
#include <cstdlib>
#include <cstring>
#include <cstdio>
#include <vector>
#include <tuple>
#include <map>

using namespace std;

int main() {
	int input, h, metr, mon, day, ho, mi, pay, ti, tmp, ds, ti2;
	int hour[24];
	char line[1000];
	char nic1[1000];
	char et1[1000];
	string nic, t, et;
	cin >> input;
	getchar();
	map<int, tuple<string, string, int>>all; // 시간, 닉, enter/exit, 거리
	map<string, tuple<int, int>>a;
	map<string, tuple<int, int>>payy; //들어온 횟수, 요금*주행거리의 돈
	map<string, float>ans;
	for(int i=0;i<input;i++){
		for(int j=0;j<24;j++){
			cin >> h;
			hour[j] = h;
		}
		getchar();
		for(;cin.getline(line, 1000) && line[0] != '\0';){
			sscanf(line, "%s %d:%d:%d:%d %s %d", nic1, &mon, &day, &ho, &mi, et1, &metr);
			ds = (day*10000) + (ho*100) + mi;
			nic = nic1;
			et = et1;
			all.insert(make_pair(ds, make_tuple(nic, et, metr)));
		}
		
		for(auto it=all.begin();it!=all.end();it++){
			ti = (it->first % 10000) / 100;
			nic = get<0>(it->second);
			et = get<1>(it->second);
			metr = get<2>(it->second);
			if(et == "enter"){
				if(a.find(nic) == a.end()){
					a.insert(make_pair(nic, make_tuple(ti, metr)));
				}
			}
			else{
				if(a.find(nic) == a.end()){
				}
				else{
					ti2 = get<0>(a.find(nic)->second);
					tmp = get<1>(a.find(nic)->second);
					pay = abs(tmp - metr) * (hour[ti2]);
					if(payy.find(nic) == payy.end()){
						payy.insert(make_pair(nic, make_tuple(1, pay)));
						a.erase(nic);
					}
					else{
						get<0>(payy.find(nic)->second) += 1;
						get<1>(payy.find(nic)->second) += pay;
						a.erase(nic);
					}
				}
			}
		}
		for(auto kk=payy.begin();kk!=payy.end();kk++){
			get<1>(kk->second) += 200+(100*get<0>(kk->second));
		}
		for(auto kk=payy.begin();kk!=payy.end();kk++){
			ans.insert(make_pair(kk->first, (float)get<1>(kk->second)/100));
		}
		cout<<fixed;
		cout.precision(2);	
		for(auto kk=ans.begin();kk!=ans.end();kk++){
			cout << kk->first << " $" << kk->second <<endl;
		}
		cout << endl;
		all.clear();
		a.clear();
		payy.clear();
		ans.clear();
	}

	return 0;
}