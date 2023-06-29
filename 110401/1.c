#include <stdio.h>
#include <stdlib.h>
void qsort(void *base , size_t nel , size_t width , int(*compare)(const void* , const void*));

int intcompare(int *i , int *j)
{
	if(*i > *j) return(1);
	if(*i < *j) return(-1);
	return (0);
}

int main() {
	int cases = 0;
	int* save;
	scanf("%d" , &cases);
	
	for(int a=0; a<cases; a++) // 케이스의 수 만큼 반복
	{
		int many=0 , sum=0;
		scanf("%d" , &many);
		
		save = (int*)malloc(sizeof(int)*many); //동적할당
		
		for(int b=0; b<many; b++) scanf("%d" , &save[b]);
		
		qsort(save , many , sizeof(int) , intcompare); //번지수를 오름차순으로 정렬
		
		int myhome = save[many/2]; //비토가 살곳
		
		for(int h=0; h<many; h++)
		{
			int distance = save[h] - myhome;
			if(distance < 0 ) distance = -distance;
			sum = sum + distance;
		}
		printf("%d\n" , sum);
		free(save);
	}
}
