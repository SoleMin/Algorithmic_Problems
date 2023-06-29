#include <iostream>
#include <vector>
#include <queue>
//#include <algorithm>

using namespace std;

vector<string> words;
vector<vector<int>> matrix;

bool doublet(string s1, string s2) {
	if (s1.size() != s2.size())
		return false;
	int count = 0;
	for (int i = 0; i < s1.size(); i++)
		if (s1[i] != s2[i])
			count++;
	if (count == 1)
		return true;
	return false;
}

/*
int doublet(string s1, string s2) {
	if (s1.size() != s2.size())
		return 0;
	int len = s1.size();
	int c1[26] = {0, };
	int c2[26] = {0, };
	for (int i = 0; i < len; i++) {
		c1[s1[i] - 'a']++;
		c2[s2[i] - 'a']++;
	}
	int count = 0;
	for (int i = 0; i < 26; i++) {
		if (c1[i] - c2[i] == 1 || c1[i] - c2[i] == -1)
			count++;
		else if (c1[i] - c2[i] > 1 || c1[i] - c2[i] < -1)
			return 0;
	}
	if (count == 2)
		return 1;
	return 0;
}
*/
/*
void bfs(int start, vector<int> distance, vector<int> parent) {
	queue<int> q;
	distance[start] = 0;
	q.push(start);
	
	while (!q.empty()) {
		int node = q.front();
		q.pop();
		for (int i = 0; i < matrix[node].size(); i++) {
			if (matrix[node][i] == 0)
				continue;
			int next = matrix[node][i];
			if (distance[i] == -1) {
				distance[next] = distance[node] + 1;
				parent[next] = node;
				q.push(next);
			}
		}
	}
	cout << "asdf" << endl;
	for (int i = 0; i < parent.size(); i++)
		cout << distance[i] << " ";
	cout << endl;
}
*/

vector<int> bfs(int start, vector<int> distance, vector<int> parent, int end) {
	queue<int> q;
	vector<int> order;
	distance[start] = 0;
	q.push(start);
	while (!q.empty()) {
		int here = q.front();
		q.pop();
		order.push_back(here);
		for (int i = 0; i < matrix[here].size(); i++) {
			int there = matrix[here][i];
			if (distance[there] == -1) {
				q.push(there);
				distance[there] = distance[here] + 1;
				parent[there] = here;
			}
		}
	}
	//for (int i = 0; i < parent.size(); i++)
		//cout << parent[i] << " ";
	if (parent[end] == -1)
		cout << "No solution." << endl;
	int temp = end;
	vector<string> kill_me;
	while (parent[temp] != -1) {
		kill_me.push_back(words[temp]);
		temp = parent[temp];
	}

	if (parent[end] != -1) {
		cout << words[start] << endl;
		for (int i = kill_me.size() - 1; i >= 0; i--)
			cout << kill_me[i] << endl;
	}
	
	cout << endl;

	return parent;
}

/*
vector<int> path_finder(int v, vector<int> parent) {
	vector<int> path(1, v);
	while (parent[v] != v) {
		v = parent[v];
		path.push_back(v);
	}
	//reverse(path.begin(), path.end());
	return path;
}
*/

void printer(int node, int start, vector<int> parent) {
	if (node == start)
		return;
	int next = parent[node];
	printer(next, start, parent);
	cout << words[next];
}

int main(void) {
	string word;
	while(getline(cin, word)) {
		if (!word.size())
			break;
		while (word[word.size() - 1] == ' ')
			word.pop_back();
		bool duple = false;
		
		for (int i = 0; i < words.size(); i++)
			if (words[i] == word) {
				duple = true;
				break;
			}
		if (!duple)
			words.push_back(word);
	} //여기까지 중복되지 않은 단어들이 들어가 있음.
	
	for (int i = 0; i < words.size(); i++) {
		vector<int> temp;
		for (int j = 0; j < words.size(); j++) {
			if (doublet(words[i], words[j]))
				temp.push_back(j);
		}
		matrix.push_back(temp);
	} //여기까지 매트릭스 만들기

	/*
	for (int i = 0; i < matrix.size(); i++) {
		for (int j = 0; j < matrix[i].size(); j++)
			cout << matrix[i][j] << " ";
		cout << endl;
	}*/
	//cout << "matrix "<< endl;

	string start, end;
	while (cin >> start >> end) {
		vector<int> distance(matrix.size(), -1);
		vector<int> parent(matrix.size(), -1);
		int starting_point;
		int end_point;
		for (int i = 0; i < words.size(); i++) {
			if (start == words[i])
				starting_point = i;
			if (end == words[i])
				end_point = i;
		}
		vector<int> order = bfs(starting_point, distance, parent, end_point);
		//for (int i = 0; i < parent.size(); i++)
			//cout << parent[i] << " ";
		//cout << endl;
		//if (parent[end_point] == -1)
			//cout << "No solution." << endl;
		//printer(end_point, starting_point, parent);
		//printer(starting_point);
		//for (int i = 0; i < parent.size(); i++)
			//cout << parent[i] << " ";
		//vector<int> path = path_finder(starting_point, parent);
		//for (int i = 0; i < path.size(); i++)
			//cout << path[i] << " ";
	}
}