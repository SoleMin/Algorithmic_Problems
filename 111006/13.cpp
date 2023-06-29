#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N; //노드의 개수
int R; //엣지의 개수
string str[100];
vector<vector<int>> adj;
bool visited[100];
int order[100];
bool selected[100];
vector<int> rst;
int cnt = 1;
int r_cnt = 0;

int dfs(int curr, bool root) {
	order[curr] = cnt++;
	visited[curr] = true;

	int ret = order[curr];
	int child = 0;

	for (int i = 0; i < (int)adj[curr].size(); i++) {
		int next = adj[curr][i];
		if (!visited[next]) {
			child++;

			int df = dfs(next, false);

			if (!root && df >= order[curr] && !selected[curr]) {
				rst.push_back(curr);
				r_cnt++;
				selected[curr] = true;
			}
			ret = min(ret, df);
		}
		else
			ret = min(ret, order[next]);
	}

	if (root && child > 1) {
		rst.push_back(curr);
		r_cnt++;
	}
	return ret;
}

int idx(string temp) {
  for (int i = 0; i < N; i++)
    if (temp == str[i])
      return i;
  return -1;
}

bool input(void) {
  cin >> N;
  if (!N)
    return false;
  for (int i = 0; i < N; i++) {
    visited[i] = false;
    order[i] = 0;
    selected[i] = false;
    cin >> str[i];
  }
  cin >> R;
  adj.resize(N);
  for (int i = 0; i < R; i++) {
    string temp1, temp2;
    cin >> temp1 >> temp2;
    int a, b;
    a = idx(temp1);
    b = idx(temp2);
    adj[a].push_back(b);
    adj[b].push_back(a);
  }
  return true;
}

int main(void) {
	int count = 0;
  while (input()) {
		r_cnt = 0;
		count++;
    //for (int i = 0; i < N; i++)
      //sort(adj[i].begin(), adj[i].end());
    
    for (int i = 0; i < N; i++)
      if (!visited[i])
        dfs(i, true);

    //sort(rst.begin(), rst.end());
		cout << "City map #" << count << ": " << r_cnt << " camera(s) found" << endl;
		vector<string> god;
		god.resize(r_cnt);
    for (int i = 0; i < (int)rst.size(); i++)
      god[i] = str[rst[i]];
		sort(god.begin(), god.end());
		for (string t : god)
			cout << t << endl;
		cout << endl;
		rst.clear();
		adj.clear();
		//rst.resize(1);
  }
}