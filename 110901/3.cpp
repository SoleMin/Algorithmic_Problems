#include <iostream>
#include <queue>
#include <stack>

#define MAXV 200
#define MAXDEGREE 200

using namespace std;

class graph {
private:
	int edges[MAXV][MAXDEGREE];
	int degree[MAXV];
	int colors[MAXV];
	bool discovered[MAXV];
	bool processed[MAXV];
	int parent[MAXV];
	int n_vertices;
	int n_edges;
	int BCA;
	int finished;

public:
	graph(int n, int l) {
		n_vertices = n;
		n_edges = l;
		BCA = 1;
		finished = 0;
		for (int i = 0; i < MAXV; i++) {
			degree[i] = 0;
			colors[i] = 0;
			processed[i] = 0;
			discovered[i] = 0;
		}
	}

	// 스타트
	void run(bool directed) {
		int a, b;
		for (int i = 0; i < n_edges; i++) {
			cin >> a >> b;
			init_edge(a, b, directed);
		}
		color_check(0, 1);
		print_ans();
		//print_edge();
	}

	// 그래프 값넣기
	void init_edge(int a, int b, bool directed) {
		int num;
		if (degree[a] > MAXDEGREE)
			printf("warning 1\n");
		edges[a][degree[a]] = b;
		degree[a]++;
		if (directed == false) {
			init_edge(b, a, true);
		}
		else {
			//this -> n_edges++;
		}
	}
	void color_check(int start, int color) {
		int temp;
		int y;
		if (finished) return;
		if (start < 0 && start >= MAXV) {
			cout << "wfwf" << endl;
			return;
		}
		if (colors[start] == 0)
			colors[start] = color;
		else {
			if (colors[start] != color) {
				BCA = 0;
				finished = 1;
			}
			return;
		}

		for (int i = 0; i < degree[start]; i++) {
			if (color == 1) temp = 2;
			else temp = 1;
			y = edges[start][i];
			if (discovered[y] == false) {
				parent[y] = start;
			}
			else if (processed[y] == false) {}
			color_check(edges[start][i], temp);
			processed[start] = 1;
			if (finished) return;
		}
	}

	void print_ans() {
		if (BCA == 1) {
			cout << "BICOLORABLE." << endl;
		}
		else {
			cout << "NOT BICOLORABLE." << endl;
		}
	}

	// 내 확인용
	void print_edge() {
		for (int i = 0; i < this->n_vertices; i++) {
			for (int j = 0; j < this->degree[i]; j++)
				cout << this->edges[i][j] << " ";
			cout << endl;
		}
	}
};


int main() {
	int n, l;
	for (; (cin >> n) && (n != 0);) {
		cin >> l;
		graph a(n, l);

		a.run(false);

	}
}