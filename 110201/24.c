#include <stdio.h>
#define abs(x) ((x) < 0? -(x) : (x))
int main() {
	int n1, n2, n3, jolly, diff;
	char line[3000];
	
	while(scanf("%d", &n1) == 1)
	{
		int arr[3000] = {0, };
		jolly = 1;
		scanf("%d", &n2);
		for (int i = 1; i < n1; i++)
		{
			scanf("%d", &n3);
			diff = abs(n2 - n3);
			if (diff <= 0 || diff >= n1 || arr[diff])
			{
				jolly = 0;
				break;
			}
			arr[diff] = 1;
			n2 = n3;
		}
		gets(line);
		printf(jolly ? "Jolly\n" : "Not jolly\n");
	}
}
