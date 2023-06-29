#include <iostream>
#include <queue>

using namespace std;

void input();
bool coloring();
void init_();

int graph[200][200];
int visited[200];
int n, l;

int main() {
	cin >> n;
	while (n) {
		input();
		cout << (coloring() ? "BICOLORABLE.\n" : "NOT BICOLORABLE.\n");
		init_();
		cin >> n;
	} 
	return 0;
}

void input() {
	cin >> l;
		int a, b;
		for (int i = 0; i < l; i++) {
			cin >> a >> b;
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
}

bool coloring() {
	int color = 1;
	int v = 0;
	queue<int> queue;
	queue.push(v);
	visited[v] = color;
	while (!queue.empty()) {
		v = queue.front();
		color = (visited[v] == 1) ? 2 : 1;
		for (int i = 0; i < n; i++) {
			if (graph[v][i]) {
				if (!visited[i]) {
					visited[i] = color;
					queue.push(i);
				}
				else if (visited[i] == visited[v])
					return false;
			}
		}
		queue.pop();
	}
	return true;
}

void init_() {
	for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				graph[i][j] = 0;
			visited[i] = 0;
		}
}