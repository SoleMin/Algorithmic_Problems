#include <iostream>
#include <cstring>
#include <map>

using namespace std;

typedef struct{
	string e;
	int k;
}ST;

int main() {
	int t;
	cin >> t;
	for(; t>0; t--){
		map<string, string> m;
		int fee[24];
		string line;
		for(int i=0; i<24; i++){
			cin >> fee[i];
		}
		cin.ignore();
		while(getline(cin, line) && line.length()){
			int l = line.find(" ");
			string name = line.substr(0,l);
			string str = line.substr(l+1) + ",";
			if(m.find(name) == m.end())
				m.insert(make_pair(name, str));
			else{
				m[name] += str;
			}
		}
		for(auto it=m.begin(); it!=m.end(); it++){
			map<string, ST> pic;
			string s = it->second;
			while(s.find(",") != string::npos){
				int l = s.find(",");
				string str = s.substr(0,l);
				string time = str.substr(0,str.find(" "));
				str.erase(0,str.find(" ")+1);
				ST p;
				p.e = str.substr(0,str.find(" "));
				str.erase(0,str.find(" ")+1);
				p.k = atoi(str.c_str());
				pic.insert(make_pair(time, p));
				s.erase(0, l+1);
			}
			int result=0;
			for(auto i=pic.begin(); i!=pic.end(); i++){
				int h, km;
				if(i->second.e == "enter"){
					h = (i->first[6] - '0')*10 + (i->first[7] - '0');
					km = i->second.k;
					i++;
					if(i!=pic.end() && i->second.e == "exit"){
						km -= i->second.k;
						result += (fee[h]*abs(km) + 100);
					}
					i--;
				}
			}
			if(result){
				result += 200;
				cout << fixed;
				cout.precision(2);
				cout << it->first << " $" << (double)result/100.0 <<endl;
			}
		}
		
		cout << endl;
	}
	return 0;
}