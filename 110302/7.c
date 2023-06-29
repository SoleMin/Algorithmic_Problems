#include <stdio.h>
#include <string.h>

int find (char map [][51], int mbuf, int nbuf, int m, int n, char buf[50])
{
	int mtmp = mbuf; int ntmp = nbuf;
	int b= 0;
	int way[8][2] = {{1,0}, {1,1}, {0,1}, {-1,1}, {-1,0}, {-1,-1}, {0,-1}, {1,-1}};
	for (int i = 0 ; i < 8; i++)
	{
		mtmp = mbuf; ntmp = nbuf; b = 0;
		while(mtmp>=0 && mtmp < m && ntmp >= 0 && ntmp < n && b < strlen(buf))
		{
			if (map[mtmp][ntmp] != buf[b])
				break;
			mtmp += way[i][0];
			ntmp += way[i][1];
			b++;
		}
		if (buf[b] == '\0')
			return 1;
	}
	return 0;
}
int main(void)
{
	int testCase, m, n, findWord, startM, startN;
	char map [51][51];
	char buf[51];
	scanf ("%d", &testCase);
	fgets(buf, 10, stdin);
	for (int tc = 0; tc < testCase; tc++)
	{
		scanf("%d %d", &m, &n);
		fgets(buf, 10, stdin);
		for (int mbuf =0; mbuf < m; mbuf++)
		{
			fgets(map[mbuf], n+1, stdin);
			for (int i = 0; i < n+1; i++)
				if (map[mbuf][i] >= 'A' && map[mbuf][i] <= 'Z')
					map[mbuf][i] += ('a' - 'A');
			
			fgets(buf, 10, stdin);
		}
		
		int correct = 0;
		scanf("%d", &findWord);
		fgets(buf, 10, stdin);
		for (int f = 0; f < findWord; f++)
		{
			correct = 0;
			fgets(buf, 51, stdin);
			buf[strlen(buf)-1] = '\0';
			for (int i = 0; i < strlen(buf); i++)
			{
				if(buf[i] >= 'A' && buf[i] <= 'Z')
					buf[i] += ('a' - 'A');
			}
			for (int mbuf = 0; mbuf < m ; mbuf++)
			{
				for (int nbuf = 0; nbuf < n; nbuf++)
				{
					if (buf[0] == map[mbuf][nbuf])
						correct = find(map ,mbuf, nbuf, m, n, buf);
					if (correct == 1)
					{
						startM = mbuf+1; startN = nbuf +1;
						break;
					}
				}
				if (correct == 1)
					break;
			}
			printf("%d %d\n", startM, startN);
		}
		if (tc + 1 != testCase)
			printf("\n");
	}
}