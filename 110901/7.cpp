#include <iostream>
#include <queue>
#include <vector>
using namespace std;

vector<int> BFS(vector<vector<int>> graph)
{
    queue<int> q;
    vector<int> visit(graph.size(), 0);
    q.push(0);
    visit[0] = 1;

    while (!q.empty()) {
        int value = q.front();
        q.pop();
        int color = 0;
        if (visit[value] == 1)
            color = 2;
        else
            color = 1;

        for (int i = 0; i < graph[value].size(); i++) {
            int nextValue = graph[value][i];

            if (visit[nextValue] == 0) {
                q.push(nextValue);
                visit[nextValue] = color;
            }
        }
    }

    return visit;
}

int DFS(vector<vector<int>> graph, vector<int> visit, int start, int result, vector<int> visit2)
{

    int nowColor = visit[start];
    visit2[nowColor] = 1;
    for (int i = 0; i < graph[start].size(); i++) {
        int nextValue = graph[start][i];
        int nextColor = visit[nextValue];

        if (nowColor == nextColor) {
            result = 0;
        } else {
            if (visit2[nextValue] == 0) {
                visit2[nextValue] = 1;
                result = DFS(graph, visit, nextValue, result, visit2);
            }
        }
    }

    return result;
}

int main(void)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int a, b;
    while (cin >> a >> b) {
        vector<vector<int>> graph(a);

        for (int i = 0; i < b; i++) {
            int tmp, tmp2;
            cin >> tmp >> tmp2;
						
						if (tmp == tmp2) {
							continue;
						}
            graph[tmp].push_back(tmp2);
            graph[tmp2].push_back(tmp);
        }

        vector<int> visit = BFS(graph);

        int result = 1;
				for (int i = 0; i < a; i++) {
					result = DFS(graph, visit, i, result, vector<int>(graph.size(), 0));
					
					if (result == 0)
						break;
				}
				

        cout << (result ? "BICOLORABLE.\n" : "NOT BICOLORABLE.\n");
    }

    return 0;
}