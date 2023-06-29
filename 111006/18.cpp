# include <iostream>
# include <string>
# include <map>
# include <queue>
# include <vector>
# include <algorithm>

/*
* 흠...
* 그래프 형성은 해야하고
* for i 모든 정점에 대해서 루프
*	k 자기 자신을 제외한 모든 노드들 루프
*		i 부터 k 까지 갈 수 있는 모든 방안을 탐색
*		탐색 과정에서 방문한 노드들 counter++
*		만약 그 카운터의 수와 도달 할 수 있는 방법의 수가 같다면 => 카메라
* 
* 
* 탐색을 어떻게 구현할까.
* 백트레킹?
* 도달 할 수 있는 모든 경우의 수를 따지니 백트레킹이 어울리겠다.
* 
* <그래프 처리>
* map<string, vector>로 처리
* 방문 여부도 map으로 처리
* 
* ====================================
* 
* graph의 연결성 테스트
* 그냥 없에보고 연결성 테스트하면 끝이구나... 
*/
using namespace std;

map<string, vector<string>> graph;
map<string, int> is_visit;
vector<string> answer;
static int camera_counter;


void init();
void get_input(int n);

void print_graph();

void init_visit(string ban);
void bfs(string ban);
int solve();

bool compare(string s1, string s2) {
	return s1 < s2;
}

int main() {
	
	int n = -1;
	int test_case = 0;

	while (true) {
		test_case++;
		cin >> n;
		if (n == 0) { break; }
		init();
		get_input(n);
		//print_graph();
		cout << "City map #" << test_case << ": " << solve() << " camera(s) found" << endl;

		sort(answer.begin(), answer.end(), compare);
		for (int i = 0; i < answer.size(); i++) {
			cout << answer[i] << '\n';
		}		
		cout << '\n';
	}

	return 0;
}

void init() {
	graph.erase(graph.begin(), graph.end());
	is_visit.erase(is_visit.begin(), is_visit.end());
	camera_counter = 0;

	while (!answer.empty()) {
		answer.pop_back();
	}
}
void get_input(int n) {
	for (int i = 0; i < n; i++) {
		vector<string> v;
		string city_name;

		cin >> city_name;
		graph.insert({ city_name, v });		
	}

	int edge_num;
	string city1, city2;
	cin >> edge_num;
	for (int i = 0; i < edge_num; i++) {
		cin >> city1 >> city2;

		graph[city1].push_back(city2);
		graph[city2].push_back(city1);
	}
}

void print_graph() {
	for (auto iter = graph.begin(); iter != graph.end(); iter++) {
		cout << "==========<" << iter->first << ">==========" << endl;
		for (int i = 0; i < iter->second.size(); i++) {
			cout << iter->second[i] << "   ";
		}
		cout << endl;
	}
}

void init_visit(string ban) {
	is_visit.erase(is_visit.begin(), is_visit.end());
	for (auto iter = graph.begin(); iter != graph.end(); iter++) {
		if (iter->first != ban) {
			is_visit.insert({ iter->first, 0 });
		}		
	}
}
void bfs(string ban) {
	queue <string> que;
	string start_city;
	for (auto iter = graph.begin(); iter != graph.end(); iter++) {		
		if (iter->first != ban) {
			start_city = iter->first;
			break;
		}
	}
	init_visit(ban);
	que.push(start_city);
	is_visit[start_city] = 1;

	while (!que.empty()) {
		string cur_city = que.front();
		que.pop();
		for (int i = 0; i < graph[cur_city].size(); i++) {
			if (is_visit[graph[cur_city][i]] == 0 && graph[cur_city][i] != ban) {	// 방문한 적 없고, 금지도시가 아니라면 okay
				//cout << "Check => " << graph[cur_city][i] << endl;
				que.push(graph[cur_city][i]);
				is_visit[graph[cur_city][i]] = 1;
			}
		}
	}

	is_visit.erase(ban);

	for (auto iter = is_visit.begin(); iter != is_visit.end(); iter++) {
		if (iter->second == 0) {
			//cout << "Need Camera" << endl;
			answer.push_back(ban);
			camera_counter++;
			return;
		}
	}

	//cout << "No Camera" << endl;	
	return;
}
int solve() {
	for (auto iter = graph.begin(); iter != graph.end(); iter++) {
		//cout << "Cur Executed City is => " << iter->first << endl;
		bfs(iter->first);
	}
	return camera_counter;
}