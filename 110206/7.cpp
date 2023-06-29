#include <iostream>
#include <cstring>
#include <map>
#include <queue>

using namespace std;

int main() {
	int t;
	cin >> t;
	cin.ignore();
	for(int c=0; c<t; c++){
		int P, N;
		map<string, string> m;
		map<string, int> erdos;
		queue<string> q;
		erdos.insert(make_pair("Erdos, P.", 0));
		cin >> P >> N;
		cin.ignore();
		for(int i=0; i<P; i++){
			string line;
			getline(cin, line);
			string total = line.erase(line.find(":"));
			char *token;
			token = strtok((char*)total.c_str(), ", ");
			while(token){
				string name = token;
				string full = line;
				token = strtok(NULL, ", ");
				name = name + ", " + token;
				full.erase(full.find(name), name.length());
				if(m.find(name) != m.end()){
					full = m[name] + full;
					m.erase(name);
				}
				m.insert(make_pair(name, full));
				erdos.insert(make_pair(name, -1));
				token = strtok(NULL, ", ");
			}
		}
		for(int j=0; j<m.size(); j++){
			for(auto it=erdos.begin(); it!=erdos.end(); it++){
				if(it->second != -1){
					for(auto i=m.begin(); i!=m.end(); i++){
						if((i->second).find(it->first) != -1 && erdos[i->first] < 0)
							erdos[i->first] = it->second + 1;
					}
				}
			}
		}
		for(int i=0; i<N; i++){
			string name;
			getline(cin, name);
			q.push(name);
		}
		cout << "Scenario " << c+1 << endl;
		while(q.empty() == false){
			if(erdos[q.front()] == -1)
				cout << q.front() << " infinity" << endl;
			else
				cout << q.front() << " " << erdos[q.front()] << endl;
			q.pop();
		}
	}
	return 0;
}