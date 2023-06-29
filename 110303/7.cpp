#include <iostream>
#include <string>
#include <queue>

using namespace std;

int main() {
	string word1;
	while(getline(cin, word1)){
		string word2;
		getline(cin, word2);
		int i = 0;
		priority_queue<char> pq;
		while(word2[i]){
			char c = word2[i];
			if(word1.find(c) != string::npos){
				pq.push(c);
				word1.erase(word1.find(c), 1);
			}
			i++;
		}
		string s;
		while(!pq.empty()){
			s = s + pq.top();
			pq.pop();
		}
		int j = s.length() - 1;
		while(s[j]){
			cout << s[j];
			j--;
		}
		cout << endl;
	}

	return 0;
}