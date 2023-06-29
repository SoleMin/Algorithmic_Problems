#include <bits/stdc++.h>
using namespace std;
int main() {
	int t; cin>>t; t++; 
	cin.ignore(); 
	while(t--){
		cout << fixed << setprecision(2); 
		vector<string> s; 
		string a; 
		while(1){
			getline(cin, a); 
			if(a == "") break; 
			s.push_back(a); 
		}
		if(s.empty()) continue; 
		vector<int> v(24); 
		stringstream in_3(s[0]); 
		for(int i = 0; i < 24; i++){
			in_3 >> v[i]; 
		}
		s.erase(s.begin()); 
		sort(s.begin(), s.end()); 
		for(int i = 0; i < s.size() - 1; i++){
			auto a = s[i], b = s[i + 1]; 
			double ans = 0; 
			string u[2], t[2], h[2]; int km[2]; 
			stringstream in_1(s[i]); 
			stringstream in_2(s[i + 1]); 
			in_1 >> u[0] >> h[0] >> t[0] >> km[0]; 
			in_2 >> u[1] >> h[1] >> t[1] >> km[1]; 
			if(u[0] == u[1] && t[0] == "enter" && t[1] == "exit"){
				string p; 
				p.push_back(h[0][6]); 
				p.push_back(h[0][7]); 
				ans += v[stoi(p)] * abs(km[0] - km[1]) + 100; 
				cout << u[0] << " " << "$" << (double)ans / 100 + 2 << "\n"; 
			}
		}
		cout << "\n"; 
	}
}