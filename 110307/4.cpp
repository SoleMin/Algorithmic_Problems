#include <iostream>
#include <cstring>
#include <queue>
#include <map>
#include <stack>

using namespace std;

stack<string> s;
map<string, string> m;
void result(string word1, string word2){
	if(word1 == word2){
		s.push(word1);
		return;
	}
	s.push(word2);
	result(word1, m[word2]);
}

int main() {
	string word, line;
	string dic[25143];
	int c = 0;
	
	while(getline(cin, word) && word.length()){
		dic[c] = word;
		c++;
	}
	
	while(getline(cin, line) && line.length()){
		queue<string> q;
		int check = 1;
		string w1, w2;
		w1 = strtok((char*)line.c_str(), " ");
		w2 = strtok(NULL, " ");
		if(w1.length() != w2.length()){
			cout << "No solution." << endl << endl;
			continue;
		}
		q.push(w1);
		while(!q.empty() && check){
			string str = q.front();
			q.pop();
			for(int i=0; i<w1.length(); i++){
				for(int j=0; j<c; j++){
					if(dic[j].length() == w1.length()){
						string str1 = str;
						string str2 = dic[j];
						string str3 = w2;
						str1[i] = ' ';
						str2[i] = ' ';
						str3[i] = ' ';
						if(str1 == str3){
							m[w2] = str;
							i = w1.length();
							check = 0;
							break;
						}
						else if((str1 == str2) && (m.find(dic[j]) == m.end())){
							m[dic[j]] = str;
							q.push(dic[j]);
						}
					}
				}
			}
		}
		if(check){
			cout << "No solution." << endl;
		}
		else{
			result(w1, w2);
			while(!s.empty()){
				cout << s.top() << endl;
				s.pop();
			}
		}
		cout << endl;
		m.clear();
	}
	
	return 0;
}