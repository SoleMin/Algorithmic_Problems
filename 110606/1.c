#include <stdio.h>
static int one[150][100] = {};
static int two[10000][100] = {};
void move() {
	one[0][0] = 1;
	int i, j, k, l = 0, idx = 2;
	two[1][0] = 1;
	for(i = 1; i < 150; i++)
	{
		for(j = 0; j <= l; j++)
			one[i][j] = one[i-1][j]*2;
		for(j = 0; j <= l; j++)
		{
			if(one[i][j] >= 10)
			{
				one[i][j+1] += one[i][j]/10;
				one[i][j] %= 10;
			}
		}
		if(one[i][l+1]) l++;
		k = i+1;
		while(k && idx <= 10000)
		{
			for(j = 0; j < 99; j++)
				two[idx][j] = two[idx-1][j]+one[i][j];
			for(j = 0; j < 99; j++)
			{
				if(two[idx][j] >= 10)
				{
					two[idx][j+1] += two[idx][j]/10;
					two[idx][j] %= 10;
				}
			}
			idx++, k--;
		}
	}
}
int main() {
    move();
    int n, i;
    while(scanf("%d", &n) == 1) {
        if(n == 0)
            putchar('0');
        for(i = 99; i >= 0; i--)
            if(two[n][i])
                break;
        while(i >= 0)    putchar(two[n][i]+'0'), i--;
        puts("");
    }
    return 0;
}