#include <iostream>
#include <sstream>
#include <algorithm>
using namespace std;

int W[1000] , Q[1000] , Ans[1000] , temp[1000];
int D[1000][1000];
int w , iq ,index=0;
int ct = 0;

void solve(int start , int check)	
{
	for(int a=0; a<index; a++)
	{
		if(D[start][a] == 1)
		{
			temp[check] = a+1;
			solve(a , check+1);
		}
	}
	if(check > ct) {
		ct = check;
		for(int k=0; k<check; k++)
		{
			Ans[k] = temp[k];
		}
	}
}
void init()
{
	for(int a=0; a<1000; a++)
	{
		W[a] = Q[a] = Ans[a] = temp[a] = 0;
		for(int b=0; b<1000; b++)
		{
			D[a][b] = 0;
		}
	}
}
int main()
{
	init();
	while(cin >> w >> iq)
	{
		W[index]  = w;
		Q[index]  = iq;
		index++;
	}
	for(int a=0; a<index; a++)
	{
		for(int b=0; b<index; b++)
		{
			if(a==b) D[a][b] = 0;
			else{
				if(W[a] < W[b] && Q[a] > Q[b])
					D[a][b] = 1;
			}
		}
	}
	for(int see = 0; see < index; see++)
	{
		temp[0] = see+1;
		solve(see, 1);
	}
	printf("%d\n" , ct);
	for(int see=0; see<ct; see++)
		printf("%d\n" , Ans[see]);
}