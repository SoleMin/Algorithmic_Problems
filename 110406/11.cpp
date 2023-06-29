#include <bits/stdc++.h>
using namespace std;

struct Car{
	int month, hour, mins, day, loc, sec;
	bool ex;
	int getTime(){
		return mins + hour*60 + day*1440;
	}
};
int main() {
	int t;
	string ss;
	cin>>t;
	while(t--){
		int fares[24] = {};
		map<string,vector<Car>> licar;
		for(int i=0;i<24;i++) 
			scanf("%d",fares+i);
		cin.ignore();
		while(getline(cin,ss), !ss.empty()){
			istringstream iss(ss);
			string plate, command;
			int rr;
			char ignore;
			Car r;
			iss >> plate >> r.month >> ignore >> r.day >> ignore >> r.hour >> ignore >> r.mins >> command >> r.loc;
			r.ex = command == "exit";
			licar[plate].push_back(r);
		}
		for(auto& p : licar){
			sort(p.second.begin(), p.second.end(),[](Car a, Car b){
				return a.getTime() < b.getTime();
			});
			int total = 200;
			for(int i=0;i<p.second.size();i++)
				if(!p.second[i].ex && i+1 < p.second.size() && p.second[i+1].ex){
					int dist = abs(p.second[i].loc - p.second[i+1].loc);
					total += dist*fares[p.second[i].hour];
					total += 100;
				}
			if(total != 200)
				cout << p.first << " $" << setprecision(2) << fixed << total/100.0 << endl;
		}
		if(t) 
			cout << endl;
	}
}
