#include <iostream>
#include <vector>
#include <unordered_map>
#include <queue>
#include <stack>

using namespace std;

unordered_map<short, string> mp;
short graph[25143][25143];
short parent[25143];
short n;

void input();
void make_graph();
bool bfs(short, short);
void print(short, short);

/*
1. 원활한 bfs를 위해 단어들을 입력받는 순서대로 숫자를 부여해 맵에 저장
2. 더블릿인 단어들의 관계를 그래프에 나타냄
3. 정답을 요구하는 단어쌍에 대해 bfs 실행
   - 큐에 삽입할 때, parent 배열에서 해당 노드(자식)의 인덱스에 현재 노드(부모)를 저장
	   하나의 노드로 가는 경로가 여러 개인데 어떻게 역추적을 할 수 있을까 싶었는데
		 각각의 노드는 한 번만 방문하게 되므로 결국 처음 방문할 때의 현재 노드가 부모일 수밖에 없음
	 - 성공할 경우 true, 실패할 경우 false 반환
4. bfs 경로를 역추적해서 처음부터 출력해야 하므로 스택 이용
*/


int main() {
	input();
	make_graph();
	
	string s1, s2;
	while (cin >> s1 >> s2) {
		short n1 = 0;
		short n2 = 0;
		for (auto iter = mp.begin(); iter != mp.end(); iter++) {
			if (iter->second == s1)
				n1 = iter->first;
			else if (iter->second == s2)
				n2 = iter->first;
		}
		if (bfs(n1, n2))
			print(n1, n2);
		else
			cout << "No solution.\n";
		cout << '\n';
	}
	return 0;
}

void input() {
	string s;
	while (getline(cin, s)) {
		if (s[0] < '0')
			break;
		mp.insert({ n++, s });
	}
}

void make_graph() {
	for (short i = 0; i < n; i++) {
		for (short j = 0; j < n; j++) {
			int count = 0;
			string s1 = mp[i];
			string s2 = mp[j];
			if (s1.length() != s2.length())
				continue;
			int length = s1.length();
			for (int k = 0; k < length; k++)
				if (s1[k] != s2[k])
					count++;
			if (count == 1) {
				graph[i][j] = 1;
				graph[j][i] = 1;
			}
		}
	}
}

bool bfs(short a, short b) {
	short* visited = new short[n]();
	visited[a] = 1;
	queue<short> queue;
	queue.push(a);
	while (!queue.empty()) {
		short cur = queue.front();
		for (short next = 0; next < n; next++) {
			if (graph[cur][next] && !visited[next]) {
				queue.push(next);
				visited[next] = 1;
				parent[next] = cur;
				if (next == b)
					return true; 
			}
		}
		queue.pop();
	}
	delete[] visited;
	return false;
}

void print(short a, short b) {
	stack<short> stack;
	stack.push(b);
	while (stack.top() != a)
		stack.push(parent[stack.top()]);
	
	while (!stack.empty()) {
		cout << mp[stack.top()] << '\n';
		stack.pop();
	}
}