#include <cstdio>
#include <iostream>
#include <string>
#include <map>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;

map<string, int> name;
bool edge[101][101];
int T;

bool isConnected(int deleted, int N)
{
	int i, j, k, cnt, index;
	int iscnct[101];
	j = 1;
	for (i = 1; i <= 100; i++) {
		if (i != deleted)
			iscnct[i] = j++;
		else
			iscnct[i] = 0;
	}

	cnt = 0;
	for (i = 1; i <= N; i++)
	{
		if (i == deleted) continue;
		for (j = 1; j <= N; j++)
		{
			if (j == deleted || !edge[i][j] || i == j) continue;

			if (iscnct[i] < iscnct[j]) {
				index = iscnct[j];
				for (k = 1; k <= N; k++)
				{
					if (iscnct[k] == index)
						iscnct[k] = iscnct[i];
				}
			}
			else {
				index = iscnct[i];
				for (k = 1; k <= N; k++)
				{
					if (iscnct[k] == index)
						iscnct[k] = iscnct[j];
				}
			}
		}
	}
	for (i = 1; i <= N; i++)
		if (iscnct[i] > 1)
			return false;
	return true;
}

string findstr(int n)
{
	map<string, int>::iterator iter;
	for (iter = name.begin(); iter != name.end(); iter++)
	{
		if (iter->second == n)
			return (iter->first) + '\0';
	}
}

void cal(int N, int R)
{
	int i, j, k;
	vector<string> v;
	for (i = 1; i <= N; i++)
	{// i를 제거하는 경우
		if (!isConnected(i, N)) {
			v.push_back(findstr(i));
		}
	}
	sort(v.begin(), v.end());
	printf("City map #%d: %d camera(s) found\n", T, v.size());
	for (i = 0; i < v.size(); i++)
		printf("%s\n", v[i].c_str());
	printf("\n");
}

int main()
{
	int N, i, j, n, R;
	string str1, str2;
	while (++T)
	{
		scanf("%d", &N);
		if (N == 0) break;

		name.clear();
		memset(edge, 0, sizeof(edge));

		for (i = 1; i <= N; i++) {
			cin >> str1;
			name.insert(make_pair(str1, i));
		}

		scanf("%d", &R);

		for (i = 1; i <= R; i++)
		{
			cin >> str1;
			cin >> str2;
			edge[name[str1]][name[str2]] = true;
			edge[name[str2]][name[str1]] = true;
		}
		//-----------------------------입력 완료
		cal(N, R);
	}
	return 0;
}