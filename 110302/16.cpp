#include <iostream>
#include <cstring>
using namespace std;

int a,b,t, n;
int m, k, len;
char grid[100][100], word[100];
 
int x[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
int y[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
 
bool scase(char aa, char bb) {
	if(aa == bb) 
		return true;
	if(aa >= 'A' && aa <= 'Z' && aa == (bb + 'A' - 'a'))
		return true;
	if(aa >= 'a' && aa <= 'z' && bb == (aa + 'A' - 'a'))
		return true;
	return false;
}
 
bool find(int a, int b) {
	for(int i = 0; i < 8; i++) {
		int a1 = a, b1 = b, k;
		for(k = 0; k < len; k++) {
			if(a1 >= n || a1 < 0 || b1 >= m || b1 < 0) break;
			if(!scase(grid[a1][b1], word[k])) break;
			a1 += x[i], b1 += y[i];
		}
		if(k == len) 
			return true;
	}
return false;
}

void chec() {
	for(a = 0; a < n; a++){
		for(b = 0; b < m; b++) {
			if(find(a, b))
				return;
		}
	}
}
 
int main() {
	cin>>t;
	for(int u = 0; u < t; u++) {
		if(u != 0) 
			printf("\n");
		cin>>n>>m;
		for(int i = 0; i < n; i++)
			cin>>grid[i];
		cin>>k;
		for(int i = 0; i < k; i++) {
			cin>>word;
			len = strlen(word);
			chec();
			cout<< a + 1<<" "<< b + 1<<endl;
		}
	}
}
