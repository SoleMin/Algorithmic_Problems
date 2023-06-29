#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;
vector<vector<int>> v;
int** cnt;
int **D;

void print()
{
	int N = v.size();
	int i, j;
	printf("\n\n");
	for (i = 1; i < N; i++) {
		for (j = 1; j < N; j++)
			printf("%4d", D[i][j]);
		printf("\n");
	}
	printf("\n\n");
}
int compare(vector<int> v1, vector<int> v2)
{
	if (v1[1] == v2[1])
		return v1[0] < v2[0];
	return v1[1] < v2[1];
}

void cal()
{
	int i, j, N, total, mycnt, max;
	sort(v.begin(), v.end(), compare);
	N = v.size();
	for (i = 0; i < N; i++)
		for (j = 0; j < N; j++)
			D[i][j] = cnt[i][j] = 0;

	for (i = 1; i < N; i++) {
		for (j = 1; j <= i; j++) {
			if (i == j) {
				mycnt = cnt[i - 1][j - 1] + 1;
				total = D[i - 1][j - 1] + v[i][0];
			}
			else {
				if (D[i - 1][j - 1] + v[i][0] < D[i - 1][j]) {
					mycnt = cnt[i - 1][j - 1] + 1;
					total = D[i - 1][j - 1] + v[i][0];
				}
				else {
					mycnt = cnt[i - 1][j];
					total = D[i - 1][j];
				}
			}
			if (total <= v[i][1]) {
				D[i][j] = total;
				cnt[i][j] = mycnt;
			}
			else {
				D[i][j] = 2100000000;
			}
		}
	}
	max = 0;
	for (i = 0; i < N; i++)
		for (j = 0; j < N; j++)
			if (max < cnt[i][j])
				max = cnt[i][j];
	printf("%d\n", max);
	return;
}

int main()
{
	char str[30];
	int i, w, s;
	vector<int> tmp;
	tmp.push_back(0);
	tmp.push_back(0);
	v.push_back(tmp);

	while (fgets(str, 29, stdin))
	{
		tmp.clear();
		sscanf(str, "%d %d", &w, &s);
		tmp.push_back(w);
		tmp.push_back(s);
		v.push_back(tmp);
	}
	cnt = (int**)malloc(sizeof(int) * (v.size() + 1));
	D = (int**)malloc(sizeof(int) * (v.size() + 1));
	for (i = 0; i <= (v.size() + 1); i++) {
		D[i] = (int*)malloc(sizeof(int) * (v.size() + 1));
		cnt[i] = (int*)malloc(sizeof(int) * (v.size() + 1));
	}
	cal();
}