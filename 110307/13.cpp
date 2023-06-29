# include <iostream>
# include <sstream>
# include <queue>
# include <vector>
# include <string>
# include <algorithm>
# define MAX_SIZE (25144)

using namespace std;

static string start;
static string end_point;
static vector<string> dict;
static int is_visit[MAX_SIZE];
/*
	BFS밖에 안 떠오르네
	1. 사전을 등록해 둠
	2. 입력 받은 것을 시작으로 BFS진행
	3. visited가 만료되기전에 BFS완수하면 답이 있는 것.
	4. 도달하지 못하고 BFS를 빠져나왔다면 No solution
	
	※생각해볼점
	BFS경로를 찾았다면 그 경로를 어떻게 출력할 것인가?
	BFS를 시행하는 큐를 다음과 같이 구성한다
	
	queue<sting cur_word, vector<string> path> que
	
	이렇게하면 각 경로에 대해서 자신이 지나온 path를 저장하면서 BFS진행이 가능하다.
	
*/

void reset(int size) {
	for (int i = 0; i < size; i++) {
		is_visit[i] = 0;
	}
}

int is_doublets(string s1, string s2) {
	if(s1 == s2) {
		return 0;
	}
	else if (s1.size() != s2.size()) {
		return 0;
	}
	else {
		int miss_counter = 0;
		for(int i = 0; i < s1.size(); i++) {
			if(s1[i] != s2[i]) {
				miss_counter++;
			}
		}
		if(miss_counter == 1) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

void bfs(string s, string e) {
	queue <pair<string, vector<string> > > que;
	vector<string> path;
	string cur_word;
	int index = 0;
	
	path.push_back(s);
	que.push(make_pair(s, path));
	
	index = find(dict.begin(), dict.end(), s) - dict.begin();
	is_visit[index] = 1;
	
	while(!que.empty()) {
		cur_word = que.front().first;
		path = que.front().second;
		que.pop();
		
		for (int i = 0; i < dict.size(); i++) {
			if (is_doublets(cur_word, dict[i]) && dict[i] == e && is_visit[i] != 1) {
				for (int i = 0; i < path.size(); i++) {
					cout << path[i] << endl;
				}
				cout << dict[i] << endl;
				return;
			}
			if (is_doublets(cur_word, dict[i]) && is_visit[i] != 1) {
				path.push_back(dict[i]);
				que.push(make_pair(dict[i], path));
				path.pop_back();
				is_visit[i] = 1;
			}
		}
	}
	
	cout << "No solution." << endl;
	return;
}

int main() {
	string input;
	
	while (getline(cin, input)) {
		if (input == "") {
			break;
		}
		
		dict.push_back(input);
	}
	
	while (getline(cin, input)) {
		if (input == "") {
			break;
		}
		stringstream ss(input);
		vector<string> tokens;
		string token;
		
		while (getline(ss, token, ' ')) {
			tokens.push_back(token);
		}
		
		start = tokens[0];
		end_point = tokens[1];
		
		bfs(start, end_point);
		reset(dict.size());
		cout << endl;
	}
	
	return 0;
}




