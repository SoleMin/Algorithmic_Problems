#include <cstdio>
#include <map>
#include <string>
#include <queue>
using namespace std;

int route[1002][4];
int mintime[102][2];

int main()
{
	int t, T, i, j, numE, n, N, startt, endt, point, curtime[2], pointd, pointt, dest;
	char start[40], end[40];
	scanf("%d", &T);

	for (t = 1; t <= T; t++)
	{
		map<string, int> namelist;
		queue<int> q;

		for (j = 0; j < 101; j++)
			mintime[j][0] = mintime[j][1] = 10000000;
		j = 1;
		numE = 0;

		scanf("%d", &N);
		for (i = 0; i < N; i++) {

			scanf("%s %s %d %d", start, end, &startt, &endt);
			if ((5 < startt && startt < 18) || ((6 < ((startt + endt) % 24)) && ((startt + endt) % 24) < 19))
				continue;
			if (namelist.find(start) == namelist.end())
				namelist.insert(make_pair(start, j++));
			if (namelist.find(end) == namelist.end())
				namelist.insert(make_pair(end, j++));
			startt = (startt + 6) % 24;

			route[numE][0] = namelist[start];
			route[numE][1] = namelist[end];
			route[numE][2] = startt;
			route[numE][3] = endt;
			numE++;
		}
		scanf("%s %s", start, end);
		if (namelist.size()) {
			q.push(namelist[start]);
			mintime[q.front()][0] = mintime[q.front()][1] = 0;
		}
		// 출발시간 0시, 도착은 12시 전에, 매 18시에 피 먹어야됨
		while (!q.empty()) {
			point = q.front();  // 현재 나는 point 에 있음
			curtime[0] = mintime[point][0]; // 현재 날짜
			curtime[1] = mintime[point][1]; // 현재 시간
			q.pop();
			if (point == namelist[end])
				continue;

			for (i = 0; i < numE; i++) // i에서 출발하는 루트 차례로 방문
			{
				if (route[i][0] != point)continue; // 출발지가 현재 위치가 아니라면

				pointd = curtime[0]; // pointd 는 i에 도착했을 때 날짜
				pointt = route[i][2] + route[i][3];		// pointt 는 i에 도착했을 때 시간
				dest = route[i][1];

				if (route[i][2] < curtime[1]) { // 현재 차가 이미 출발했다면
					pointd++; // 다음날 차 타야됨
				}

				if (pointd < mintime[dest][0] || ((pointd == mintime[dest][0]) && pointt < mintime[dest][1])) {
					mintime[dest][0] = pointd;
					mintime[dest][1] = pointt;
					q.push(route[i][1]);
				}
			}


		}
		i = namelist[end];
		printf("Test Case %d.\n", t);
		if (mintime[namelist[end]][1] != 10000000)
			printf("Vladimir needs %d litre(s) of blood.\n", mintime[namelist[end]][0]);
		else
			printf("There is no route Vladimir can take.\n");
	}
}