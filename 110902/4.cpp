#include <iostream>
#include <queue>
#include <cstring>
#define MAX 10000

using namespace std;

string S, T;
int F[MAX];

int bfs(){
	if(S == T)
		return 0;
	queue<string> q;
	q.push(S);
	F[atoi(S.c_str())] = 1;
	while(!q.empty()){
		string s = q.front();
		int c = F[atoi(s.c_str())];
		q.pop();
		for(int i=0; i<4; i++){
			string str = s;
			if(str[i] == '9')
				str[i] = '0';
			else
				str[i]++;
			if(F[atoi(str.c_str())] != 0)
				continue;
			if(str == T)
				return c;
			F[atoi(str.c_str())] = c + 1;
			q.push(str);
		}
		for(int i=0; i<4; i++){
			string str = s;
			if(str[i] == '0')
				str[i] = '9';
			else
				str[i]--;
			if(F[atoi(str.c_str())] != 0)
				continue;
			if(str == T)
				return c;
			F[atoi(str.c_str())] = c + 1;
			q.push(str);
		}
	}
	return -1;
}

int main() {
	int k;
	cin >> k;
	for(; k>0; k--){
		int n;
		char s[4], t[4], f[4];
		memset(F,0,sizeof(F));
		S = "";
		T = "";
		cin >> s[0] >> s[1] >> s[2] >> s[3];
		cin >> t[0] >> t[1] >> t[2] >> t[3];
		for(int i=0; i<4; i++){
			S += s[i];
			T += t[i];
		}
		cin >> n;
		for(int i=0; i<n; i++){
			cin >> f[0] >> f[1] >> f[2] >> f[3];
			F[atoi(f)] = -1;
		}
		
		cout << bfs() << endl;
		
	}

	return 0;
}