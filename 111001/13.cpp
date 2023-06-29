#include <bits/stdc++.h>
using namespace std;
struct point{
	double x;
	double y;
}P[100];

struct edge {
	int i_a;
	int i_b;
	double L;
}E[100*100];
int Set[100];
double Ans;
bool cmp (edge A, edge B)
{
	return A.L < B.L;
}
void Initial(int N)
{
	Ans = 0;
	for (int i = 0; i < N; ++i){
		Set[i] = i;
	}
}
int FF(int x)
{
	if (x == Set[x])
		return x;
	return Set[x] = FF(Set[x]);
}
bool Union(edge A)
{
	int x = FF(A.i_a);
	int y = FF(A.i_b);
	if (x != y) {
		Set[x] = y;
		Ans += A.L;
		return true;
	}
	return false;
}
int main()
{
	int cc, N;
	cin>>cc;
	while (cc--) {
		cin>>N;
		for (int i = 0; i < N; ++i)
			scanf("%lf%lf", &P[i].x, &P[i].y);
		int ee = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = i + 1; j < N; ++j) {
				double Len = sqrt(pow(P[i].x - P[j].x, 2) + pow(P[i].y - P[j].y, 2));
				E[ee++] = {i,j,Len};
			}
		}

		sort (E, E + ee, cmp);
		Initial(N);

		for(int i = 0, sum = 0; sum != N - 1; ++i){
			if(Union(E[i]))
				sum++;
		}

		printf("%.2f\n", Ans);
		if (cc) putchar('\n');
	}
}
