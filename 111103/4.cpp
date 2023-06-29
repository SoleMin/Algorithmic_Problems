#include <iostream>
#include <algorithm>
#define MAXN 1000

using namespace std;

typedef struct{
	int idx;
	int w;
	int iq;
}ELEP;

ELEP e[MAXN];
int n, k, r, result, m[MAXN], parent[MAXN], a[MAXN], res[MAXN];

void sort(){
	for(int i=0; i<n; i++){
		for(int j=i+1; j<n; j++){
			if(e[i].w > e[j].w)
				swap(e[i], e[j]);
			else if(e[i].w == e[j].w)
				if(e[i].iq > e[j].iq)
					swap(e[i], e[j]);
		}
	}
}

void dp(){
	for(int i=0; i<n; i++){
		m[i] = 1;
		parent[i] = -1;
		for(int j=0; j<i; j++){
			if(e[i].iq < e[j].iq && m[i] < m[j]+1){
				m[i] = m[j] + 1;
				parent[i] = j;
			}
		}
	}
}

void path(int i){
	if(i == -1) return;
	path(parent[i]);
	a[r] = e[i].idx + 1;
	r++;
}

int main() {
	n = 0;
	r = 0;
	while(cin >> e[n].w >> e[n].iq){
		e[n].idx = n;
		n++;
	}
	sort();
	dp();
	for(int i=0; i<n; i++){
		if(result < m[i]){
			result = m[i];
			k = i;
		}
	}
	path(k);
	swap(a, res);
	cout << result << endl;
	for(int i=0; i<n; i++){
		r = 0;
		if(result == m[i]){
			path(i);
			for(int j=0; j<result; j++){
				if(a[j] == res[j])
					continue;
				else if(a[j] < res[j]){
					swap(a, res);
					break;
				}
				else
					break;
			}
		}
	}
	
	for(int i=0; i<result; i++){
		cout << res[i] << endl;
	}
	
	return 0;
}