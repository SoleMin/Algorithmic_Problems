#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#define MAX 10001
static int start[4], target[4];
static int A[4], B[4];
static int banned_nums[MAX] = { 0, };
static int queue[MAX], cnt[MAX];
static int move[8][4] = {
	0,0,0,1,0,0,0,-1,
	0,0,1,0,0,0,-1,0,
	0,1,0,0,0,-1,0,0,
	1,0,0,0,-1,0,0,0 };

int convert(int num[])
{
	return num[0] * 1000 + num[1] * 100 + num[2] * 10 + num[3];
}

int solve(int st, int tar)
{
	if (st == tar) 
		return 0;

	int front = 0;
	int rear = 0;
	queue[rear++] = st;
	banned_nums[st] = 1;
	cnt[st] = 0;
	while (front < rear) {

		int cur = queue[front];

		for (int i = 0; i < 4; i++) {
			A[3 - i] = cur % 10;
			cur /= 10;
		}

		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				B[j] = A[j] + move[i][j];
				if (B[j] == -1) 
					B[j] = 9;
				if (B[j] == 10) 
					B[j] = 0;
			}
			int cur2 = convert(B);
			if (cur2 == tar) 
				return cnt[queue[front]] + 1;
			if (!banned_nums[cur2]) 
			{
				banned_nums[cur2] = 1;
				cnt[cur2] = cnt[queue[front]] + 1;
				queue[rear++] = cur2;
			}
		}
		front++;
	}
	return -1;
}
int main(){
	int tmp[4];
	int N, ban;
	scanf("%d", &N);
	while (N--)
	{
		for (int i = 0; i < MAX; i++)
			banned_nums[i] = 0;

		getchar();
		scanf("%d %d %d %d", &start[0], &start[1], &start[2], &start[3]);
		scanf("%d %d %d %d", &target[0], &target[1], &target[2], &target[3]);
		scanf("%d", &ban);

		for (int i = 0; i < ban; i++)
		{
			scanf("%d %d %d %d", &tmp[0], &tmp[1], &tmp[2], &tmp[3]);
			banned_nums[convert(tmp)] = 1;
		}
		printf("%d\n", solve(convert(start), convert(target)));

	}
	return 0;
}