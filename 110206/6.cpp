#include <iostream>
#include <set>
#include <queue>
#include <map>

using namespace std;

int main(void) {
	int scenario;
	cin >> scenario;
	int count = 1;
	while (scenario--) {
		int p;
		int n;
		cin >> p >> n;
		string parsed[p];
		set<string> names;
		getchar();
		for (int i = 0; i < p; i++) {
			getline(cin, parsed[i]);
			string parsed_name;
			int count = 0;
			for (int j = 0; j < parsed[i].size(); j++) {
				if (parsed[i][j] == ',' || parsed[i][j] == ':')
					count++;
				if (count == 2) {
					count = 0;
					names.insert(parsed_name);
					parsed_name = "";
					j++;
					continue;
				}
				parsed_name.push_back(parsed[i][j]);
			}
		}
		map<string, queue<string>> named_map;
		for (auto i = names.begin(); i != names.end(); i++) {
			//cout << "죽여줘 제발" <<  *i << endl;
			queue<string> named_queue;
			named_queue = queue<string>();
			for (auto j = names.begin(); j != names.end(); j++) {
				for (int k = 0; k < p; k++)
					if (parsed[k].find(*i) != string::npos && parsed[k].find(*j) != string::npos && *i != *j)
						named_queue.push(*j);
			}
			named_map.insert(make_pair(*i, named_queue));
		}
		map<string, int> erdos;
		for (auto i = named_map.begin(); i != named_map.end(); i++)
			erdos.insert(make_pair(i->first, -1));
		queue<string> pleasegod;
		pleasegod.push("Erdos, P.");
		string sir = "Erdos, P.";
		
		/*
		auto jebal = named_map.find("Martin, G.")->second;
		while (!jebal.empty()) {
			cout << "제발 " <<jebal.front() << endl;
			jebal.pop();
		}*/
	
		

		while (!pleasegod.empty()) {
			string name = pleasegod.front();
			pleasegod.pop();
			if (name == "Erdos, P.")
				erdos[name] = 0;
			
			if (named_map.count(name)) {
				auto i = named_map.find(name);
			
				while (!i->second.empty()) {
					string follower = i->second.front();
				//cout << name << " " << follower << endl;
				//cout << "죽여줘" << erdos.find(follower)->second << endl;
					if (erdos.find(follower)->second < 0) {
						erdos[follower] = erdos.find(name)->second + 1;
					}
					pleasegod.push(follower);
					i->second.pop();
				}
			}
		}
	
		
		
		
		cout << "Scenario " << count++ << endl;
		for (int i = 0; i < n; i++) {
			string name;
			getline(cin, name);
			cout << name << " ";
			if (erdos.find(name)->second < 0)
				cout << "infinity" << endl;
			else
				cout << erdos.find(name)->second << endl;
		}
	}
}