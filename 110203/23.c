//방법1 사용 결과: 일부 케이스를 통과못함
//방법2: 날짜를 일일히 읽어내서, 입력한 값과 모든 날짜를 비교
//장점 : 모든 날짜를 비교하기에 보다 정확한 값을 얻어낼 수 있음
//단점 : 방법1에 비해 메모리 사용량이 큼
#include <stdio.h>

int main()
{
	//연산을 몇번 반복할건지 입력
	int count=0, limitation=0;
	scanf("%d", &limitation);
	int days, teams, rule, sum;
	
	//입력한 시도 횟수만큼 실행하면 반복 종료
	while(count<limitation)
	{
		sum=0;		//합 초기화
		
		days=0;		//총 일수 초기화
		teams=0;	//정당수 초기화
		scanf("%d", &days);		//총 일 수 입력
		//입력한 값이 범위내에 포함되는지 확인
		if(days<7 || days>3650)
		{
			continue;
		}
		
		scanf("%d", &teams);		//정당수 입력
		//입력한 값이 범위내에 포함되는지 확인
		if(teams<1 || teams>100)
		{
			continue;
		}
		
		int savevalue[teams];		//정당수만큼의 길이를 가진 배열 생성
		//길이가 조정된 배열의 각 값을 초기화
		for(int i=0;i<teams;i++)
		{
			savevalue[i]=0;
		}
		
		//정당수만큼만 각 휴일규칙을 입력받음
		for(int i=0;i<teams;i++)
		{
			scanf("%d", &rule);
			savevalue[i]=rule;
		}
		
		//입력한 범위 내에서 모든 날을 순회
		for(int j=1;j<=days;j++)
		{
			if((j-1)%7<5)		//5와 6을 금,토로 잡고, 금토 이외의 날일때 검사 진행
			{
				for(int k=0;k<teams;k++)		//배열 길이만큼만 반복
				{
					if(j%savevalue[k]==0)		//오늘이 동맹휴일이라면
					{
						sum++;			//값을 더해주고
						break;			//다른 정당의 휴일규칙으로의 연산으로 인한 중복을 막기 위해 검사반복 탈출
					}
				}
			}
		}
		printf("%d\n", sum);			//합 출력
		count++;			//시도횟수 +1
	}
}

//방법1 : 입력한 규칙으로 총 일수를 나눠줌
//장점 : 메모리 사용이 비교적 적음. (모든 날을 일일히 비교하기보다는 수식으로 처리하기 때문)
//문제 : 어째서인지, 통과를 못하는 케이스가 있음
/*
#include <stdio.h>

int main()
{
	int count=0, limitation=0;		//입력단위
	scanf("%d", &limitation);		//입력단위 입력
	int days, teams, rule, sum, result, same, same2;
	
	while(count<limitation)		//입력단위 수만큼만 반복
	{
		//연산관련변수 초기화
		sum=0;
		result=0;
		same=0;
		same2=0;
		
		days=0;		//총 일수 초기화
		teams=0;	//정당 수 초기화
		scanf("%d", &days);			//총 일수 입력
		
		if(days<7 || days>3650)		//범위설정
		{
			continue;
		}
		
		scanf("%d", &teams);		//정당 수 초기화
		
		if(teams<1 || teams>100)		//범위설정
		{
			continue;
		}
		
		int forminus[teams];		//공배수 탐지용 배열 초기화
		for(int i=0;i<teams;i++)
		{
			forminus[i]=0;
		}

		for(int i=0;i<teams;i++)		//정당 수만큼 반복
		{
			scanf("%d", &rule);				//각 정당의 휴일주기 입력
			forminus[i]=rule;					//공배수 탐지용 배열에 규칙추가
			//중복검사
			//모든 날을 순회해서
			for(int j=1;j<=days;j++)
			{
				//해당 정당휴일의 주기중 금요일이나 토요일이 포함될 경우
				if((j%7==6 && j%rule==0) || (j%7==0 && j%rule==0))
				{
					same++;		//중복 수치 증가
					continue;
				}
				
				for(int k=0;k<teams;k++)
				{
					//서로다른 두 정당의 휴일이 겹치게 되면
					if(forminus[k]!=0 && forminus[k]!=rule && j%forminus[k]==0 && j%rule==0)
					{
						same2++;		//별개의 중복수치 증가
					}
				}
			}
			sum=sum+(days/rule);				//총일수/해당 정당을 더해줌
		}
		result=sum-same-same2;		//최종연산. 합-모든 중복수
		
		printf("%d\n", result);				//결과 출력
		
		count++;						//반복주기+1
	}
}
*/