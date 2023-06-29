# include <iostream>
# include <string>
# include <vector>
# define MAX_SIZE (1000002)
# define endl ('\n')

using namespace std;

/*
	well-known KMP algorithm
	
	타임아웃 무엇
	출력이 구린가
	next함수 구하는거 구려서 그런가
	
*/

static int next_arr[MAX_SIZE];
static vector<int> answer;

void compute_next(string p) {
	int j = 0;
	for (int i = 1; i <p.size(); i++) {
		while(j > 0 && p[i] != p[j]) {
			j = next_arr[j - 1];
		}
		if(p[i] == p[j]) {
			next_arr[i] = ++j;
		}
	}
	
}

void kmp(string t,string p) {
	int j = 0;
	for (int i = 0; i <= t.size(); i++) {
		while(t[i] != p[j] && j > 0) {
			j = next_arr[j - 1];
		}
		if (t[i] == p[j]){
			j++;
		}
		if (j == p.length()) {
			answer.push_back(i - p.length() + 2);
		}
	}
}

void printf_answer() {
	cout << answer.size() << endl;
	for (int i = 0; i < answer.size(); i++){
		cout << answer[i];
		if (i != answer.size()){
			cout << " ";
		}
	}
	cout << endl;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	string t;
	string p;
	
	getline(cin, t);
	getline(cin, p);
	
	compute_next(p);
	kmp(t, p);
	
	printf_answer();
	
	return 0;
}