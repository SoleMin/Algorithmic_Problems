#include<string>
#include<cstdio>
#include<iostream>
using namespace std;

int s[32], automata[8], a[33];
int id;
int n;
bool back(int index) {
	if(index >= n) {
		int result = ((a[0] == a[n]) && (a[1] == a[n+1]));
		return result;
	}
	for(int i = 0; i < 8; i++){
		if((s[index] == automata[i]) && (!index||(a[index]*4+a[index+1]*2 == (i&6)))) {
			if(index==false) {
				a[0] = ((i&4) > 0);
				a[1] = ((i&2) > 0);
			}
			a[index+2] = ((i&1) > 0);
			if(back(index+1))
				return 1;
		}
	}
	return 0;
}

int main() {
	string txt;
	while(cin >> id >> n >> txt) {
		for(int i = 0; i < 8; i++)
			automata[i] = 1 & (id >> i);
		
		for(int i = 0; i < n; i++)
			s[i] = txt[i] - 48;//0
		
		if(back(0))
			puts("REACHABLE");
		else 
			puts("GARDEN OF EDEN");
	}
}