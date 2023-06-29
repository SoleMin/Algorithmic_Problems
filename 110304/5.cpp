#include <iostream>
#include <cstring>
#include <queue>
#include <map>

using namespace std;

int main() {
	string check = "the quick brown fox jumps over the lazy dog";
	int t;
	cin >> t;
	cin.ignore();
	cin.ignore();
	for(; t>0; t--){
		string line;
		map<char, char> m;
		queue<string> q;
		while(getline(cin, line) && line.length()){
			q.push(line);
			char c;
			string s;
			string copy = line;
			char* token;
			token = strtok((char*)line.c_str(), " ");
			while(token){
				c = 48 + strlen(token);
				s = s + c;
				token = strtok(NULL, " ");
			}
			if(s == "355354343"){
				int i = 0;
				while(check[i]){
					if(m.find(copy[i]) != m.end()){
						if(m[copy[i]] != check[i]){
							m.clear();
							break;
						}
					}
					m.insert(make_pair(copy[i], check[i]));
					i++;
				}
			}
		}
		if(!m.empty()){
			while(!q.empty()){
				int i = 0;
				string result;
				result = q.front();
				while(result[i]){
					cout << m[result[i]];
					i++;
				}
				cout << endl;
				q.pop();
			}
		}
		else{
			cout << "No solution." << endl;
		}
		cout << endl;
	}
	
	return 0;
}