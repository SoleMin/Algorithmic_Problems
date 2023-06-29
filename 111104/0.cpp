#include <iostream>
#include <sstream>
#include <algorithm>
using namespace std;
#define Inf 9999999

int D[5607][5607];
int W[5607]={0,};
int P[5607]={0,};
int index=0;


void init()
{
	for(int a=0; a<index; a++)
		for(int b=0; b<index; b++)
			D[a][b]=Inf;
}
void solve()
{
	int less = W[0]; //1열부분을 해당 번호 거북이까지에서의 최소값으로 초기화
	for(int a=0; a<index; a++){
		if(less > W[a]) less = W[a];
		D[a][0] = less;
	}
		
	for(int i=0; i<index; i++)
		for(int j=1; j<=i; j++)
			if(D[i-1][j-1] + W[i] <= P[i]){
				D[i][j] = min(D[i-1][j-1] + W[i] , D[i-1][j]);
			}
			else if(D[i-1][j-1] + W[i] > P[i]){ //예외처리
				if(D[i-1][j] != Inf) D[i][j] = D[i-1][j];
			}
}
void print()
{
	for(int solve=0; solve<index; solve++)
	{
		if(D[index-1][solve] == Inf){
			printf("%d" , solve);
			break;
		}
	}
}
int main() 
{
	int w , power;
	while(cin >> w >> power) //거북이들의 특성입력
	{
		W[index] = w;
		P[index++] = power;
	}
	for(int a=0; a<index-1; a++)
		for(int b=a+1; b<index; b++)
			if(P[a] > P[b])
			{
				int temp = P[a];
				int temp_2 = W[a];
				P[a] = P[b];
				P[b] = temp;
				W[a] = W[b];
				W[b] = temp_2;
			}
	init();
	solve();
	/*for(int a=0; a<index; a++){
		for(int b=0; b<index; b++)
			printf("[%8d]" , D[a][b]);
		printf("\n");
	}*/
		
	print();
}