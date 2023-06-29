#include <stdio.h>
int main() {
	int T, i, day_num, j, party, holi, k, count=0;
	int* days;
	scanf("%d", &T);
	for(i=0;i<T;i++){
		count = 0;
		scanf("%d", &day_num);
		scanf("%d", &party);
		days = (int*)malloc(sizeof(int)*day_num);
		for(j=0;j<day_num;j++)
			days[j] = 0;
		for(j=0;j<party;j++){
			scanf("%d", &holi);
			for(k=0;k<day_num;k++){
				if((k+1)%holi==0)
					days[k] = 1;
			}
		}
		for(j=5;j<day_num;j=j+7)
			days[j]=0;
		for(j=6;j<day_num;j=j+7)
			days[j]=0;
		for(j=0;j<day_num;j++){
			if(days[j]==1)
				count++;
		}
		printf("%d\n", count);
		free(days);
	}
	
	
	return 0;
}
