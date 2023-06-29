#include <stdio.h>
int main() {
	int n, i, num, pre_num, sub, j;
	int* check;
	char line[5000];
	
	for(;scanf("%d", &n) == 1;){
		check = (int*)malloc(sizeof(int)*n);
		for(i=0;i<n;i++)
			check[i] = 0;
		j = 1;
		scanf("%d", &num);
		for(i=1;i<n;i++, j++){
			pre_num = num;
			scanf("%d", &num);
			sub = pre_num - num;
			if(sub<0)
				sub = 0-sub;
			if(sub<1 || sub>n-1 || check[sub-1] == 1){
				printf("Not jolly\n");
				break;
			}
			else{
				check[sub-1] = 1;
			}
		}
		gets(line);
		if(j == n)
			printf("Jolly\n");
		free(check);
	}
	return 0;
}
