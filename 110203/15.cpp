#include <iostream>
#include <set>
using namespace std;

int n, p, t;
bool visited[3651];
//int arr[101];

int main() {
	/*
	fri = 6 + 7i (i >= 0)
	sat = 7 + 7i (i >= 0)
	중복 필요x
	약수가 존재하는 값은 필요x
	*/
	cin >> t;
	while(t--) {
		cin >> n >> p;
		
		set<int> s;
		for(int i = 0; i < p; i++) {
			int tmp; cin >> tmp;
			s.insert(tmp);
		}
		for(int i = 0; i <= n; i++)
			visited[i] = false;
		
		for(set<int>::iterator iter = s.begin(); iter != s.end(); iter++) {
			int start = *iter;
			for(int i = start; i <= n; i += start) {
				if(i % 7 == 6 || i % 7 == 0 || visited[i]) continue;
				visited[i] = true;
			}
		}
		int cnt = 0;
		for(int i = 1; i <= n; i++)
			if(visited[i]) cnt++;
		cout << cnt << endl;	
	}
	
	return 0;
}