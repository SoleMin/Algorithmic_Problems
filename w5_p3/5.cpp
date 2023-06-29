#include <iostream>
#include <cstring>
#include <queue>
#define SIZE 1000000

using namespace std;

int main() {
	queue<int> Q;
	int n, m;
	char T[SIZE], P[SIZE];
	cin.getline(T, SIZE);
	cin.getline(P, SIZE);
	n = strlen(T);
	m = strlen(P);
	int i = 0, q = 0, k = 1, cnt = 0;
	int next[m];
	next[0] = 0;
	while(q + k < m){
		if(P[q] == P[q + k]){
			next[q + k] = q + 1;
			q++;
 		}
		else{
			next[q + k] = 0;
			if(q == 0)
				k++;
			else{
				k = q + k; 
				q = 0;
			}
		}
	}
	q = 0;
	while(i < n){
		while(q > 0 && P[q] != T[i]){
			q = next[q-1];
		}
		
		if(T[i] == P[q]){
			q++;
		}
		if(q == m){
			cnt++;
			Q.push(i-m+2);
		}
		i++;
	}
	
	cout << cnt << endl;
	while(!Q.empty()){
		cout << Q.front() << " ";
		Q.pop();
	}
	cout << endl;
	
	return 0;
}