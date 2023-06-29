#include <stdio.h>

int main()
{
	int ccase, ccounter=0;
	scanf("%d", &ccase);
	char dummy;
	
	int humanz;//사람수
	int i, j;//반복문용
	int temp;//정렬용
	int result;//결과연산용
	//int calc;
	
	while(ccounter<ccase)
	{
		dummy=0;
		scanf("%c", &dummy);
		//초기화
		humanz=0;
		result=0;
		//입력
		scanf("%d", &humanz);									//사람수 입력
		int speed[humanz];										//사람수만큼 배열 할당
		for(i=0;i<humanz;i++)
		{
			scanf("%d", &speed[i]);							//사람수만큼 배열에 값 입력
		}
		
		//정렬, 버블정렬 사용
		for(i=0;i<humanz;i++)
		{
			for(j=i+1;j<humanz;j++)
			{
				if(speed[i]>speed[j])
				{
					temp=speed[i];
					speed[i]=speed[j];
					speed[j]=temp;
				}
				else if(speed[i]==speed[j])
				{
					continue;
				}
			}
		}
		
		//연산
		while(humanz>3)		//인원수가 3이하가 될 때까지 반복
		{									//if문 연산 후 다시 여기로 돌아오기에, 연산방식을 유동적으로 선택할 수 있음.
			if(speed[humanz-2]+speed[0]<speed[1]*2)			//연산 방식을 구분짓는 조건
			{	//방법1, 빠른 값만 반복이동
				result+=speed[humanz-1];									//가장 느린값과 가장빠른값이 다리를 건넘
				result+=speed[0];													//가장빠른값이 돌아옴
				result+=speed[humanz-2];									//두번째로 느린값과 가장빠른값이 다리를 건넘
				result+=speed[0];													//가장빠른값이 돌아옴
				humanz-=2;																//일단 가장 느린 두 값은 다리를 건넜으니 연산조건에서 제외
			}
			else
			{	//방법2, 순서대로 이동
				result+=speed[1];													//가장빠른값과 두번째로 빠른값 이동
				result+=speed[0];													//가장빠른값 돌아옴
				result+=speed[humanz-1];									//가장 느린값과 두번째로 느린값 이동
				result+=speed[1];													//이미 다리를 건넜던 두번째로 빠른값 복귀
				humanz-=2;																//가장 느린 두 값은 다리를 건넜으니 연산 조건에서 제외
			}
		}
		
		if(humanz==3)																	//3명 남았을 때
		{
			result+=speed[2];														//첫번째, 3번째로 빠른 값 이동
			result+=speed[0];														//첫번째 복귀
			result+=speed[1];														//나머지 이동
		}
		else if(humanz==2)														//2명 남았을 때
		{
			result+=speed[1];														//첫번째, 두번째 이동
		}
		else if(humanz==1)														//1명 남았을 때
		{
			result+=speed[0];														//첫번째 이동
		}
			
		/*
		//기존 연산방식, 조건을 유동적으로 적용하지 않고, 최초의 조건에 따라 최후의 연산까지 같은 방식을 그대로 적용
		//==>결국 일부 케이스는 통과를 못하게 됨.
		if(speed[humanz-2]+speed[0]<speed[1]*2)
		{
			printf("check1\n");
			calc=0;
			for(i=humanz-1;i>0;i--)
			{
				result+=speed[i];
				calc++;
				printf("check2, %d, %d\n", result, calc);
			}
			
			for(i=0;i<calc-1;i++)
			{
				result+=speed[0];
			}
		}
		else
		{
		//연산
			while(humanz>3)
			{
				calc=0;
				for(i=0;i<humanz;i+=2)
				{
					if(i+1<humanz)
					{
						//printf("check1\n");
						result+=(speed[i]>=speed[i+1])?speed[i]:speed[i+1];
						calc++;
					}
					else
					{
						//printf("check2\n");
						result+=(speed[i]>=speed[0])?speed[i]:speed[0];
						result+=speed[0];
						//calc++;
						//break;
						//continue;
					}
				}
				//printf("check3\n");
				for(i=0;i<calc;i++)
				{
					result+=speed[i];
				}
			
				//printf("check4, %d\n", humanz);
				humanz=(humanz%2==0)?(humanz/2):((humanz-1)/2);
				//printf("check5, %d\n", humanz);
			}
		}
		
		if(humanz==3)
		{
			result+=speed[2];
			result+=speed[0];
			result+=speed[1];
		}
		else if(humanz<=2)
		{
			//result+=(humanz%2==0)?speed[1]:speed[0];
			result+=speed[1];
		}
		*/
		
		//출력
		printf("%d\n", result);
		printf("\n");
		ccounter++;
	}
}
