#include <iostream>
#include <cstring>
#include <queue>

using namespace std;

int main() {
	string line, t = "";
	while(getline(cin, line)){
		if(!line.length())
			t += '\n';
		else
			t = t + line + " ";
	}
	
	char *token;
	token = strtok((char*)t.c_str(), "\n");
	
	while(token){
		string p = token;
		queue<string> q;
		while(p.length() > 0){
			if(p.length() <= 72){
				q.push(p);
				p.clear();
				break;
			}
			for(int i=72; i>=0; i--){
				if(p[i] == ' '){
					q.push(p.substr(0, i));
					p.erase(0, i+1);
					break;
				}
			}
			if(p.find(" ") >= 73){
				q.push(p.substr(0, p.find(" ")));
				p.erase(0, p.find(" ")+1);
			}
		}
		int i = 0;
		while(!q.empty()){
			string l = q.front();
			while(l.back() == ' '){
				l.erase(l.length()-1, 1);
			}
			while(i>0 && l.front() == ' '){
				l.erase(0, 1);
			}
			cout << l << endl;
			q.pop();
			i++;
		}
		cout << endl;
		token = strtok(NULL, "\n");
	}
	
	
	return 0;
}