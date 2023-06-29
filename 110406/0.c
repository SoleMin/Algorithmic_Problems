#include <stdio.h>
#include <string.h>
#include <math.h>
int main() {
	int num;
	int i,j;
	int cent[25];
	int month[1000];
	int day[1000];
	int time[1000];
	int time1[1000];
	int minute[1000];
	char name[1000][1000];
	char line;
	char state[1000][1000];
	int KM[1000];
	int temp=0;
	char temp1[1000];
	int cnt=0;
	char result[1000][1000];
	double result1[1000];
	double temp2;
	scanf("%d", &num);  //테스트케이스 입력 받기
	scanf("%c", &line);
	while(num != 0){ // 테스트케이스 동안 하기
		for(i=0;i<24;i++){
			scanf("%d ", &cent[i]);
		}// 시간별 요금 입력 받기
		for(i=0;i<1000;i++){
			for(j=0;j<1000;j++){
				scanf("%c", &name[i][j]);
				if(name[i][j] == ' '){
					name[i][j] = '\0';
					break;
				} // 이름을 입력받는데 빈칸이면 break
				if(name[i][j] =='\n'){
					name[i][j] = '\0';
					break; // 이름을 입력받는데 \n이면 break
				}
			}
			if(name[i][0] == '\0'){
				cnt = i;	
				break;
			} //만약 이름 첫번째 칸이 \0이면 값입력 받는 for문 탈출
			scanf("%d ",&month[i]);
			scanf("%c", &line);
			scanf("%d ", &day[i]);
			scanf("%c", &line);
			scanf("%d ", &time[i]);
			scanf("%c", &line);		
			scanf("%d", &minute[i]);
			scanf("%c",&line);
			for(j=0;j<1000;j++){
				scanf("%c", &state[i][j]);
				if(state[i][j]==' '){
					state[i][j] = '\0';
					break;
				}
			}
			scanf("%d", &KM[i]);
			scanf("%c", &line);
		} // 값 입력받기
		
		for(i=0;i<cnt-1;i++){
			for(j=0;j<cnt-1-i;j++){
				if(day[j]*10000+time[j]*100+minute[j]>day[j+1]*10000+time[j+1]*100+minute[j+1]){
					strcpy(temp1,name[j]);
					strcpy(name[j],name[j+1]);
					strcpy(name[j+1], temp1);
				
					temp = month[j];
					month[j] = month[j+1];
					month[j+1] = temp;
				
					temp = day[j];
					day[j] = day[j+1];
					day[j+1] = temp;
					
					temp = time[j];
					time[j] = time[j+1];
					time[j+1] = temp;
					
					temp = minute[j];
					minute[j] = minute[j+1];
					minute[j+1] = temp;
					
					strcpy(temp1,state[j]);
					strcpy(state[j],state[j+1]);
					strcpy(state[j+1],temp1);
					
					temp = KM[j];
					KM[j] = KM[j+1];
					KM[j+1] = temp;
				}
			}
		} // 시간순서로 정렬
		
		//for(i=0;i<cnt;i++){
			//printf("%s %d %d %d %d %s %d\n",name[i],month[i],day[i],time[i],minute[i],state[i],KM[i]);
		//}
		temp = 0;
		for(i=0;i<cnt;i++){
			for(j=i;j<cnt;j++){
				if(strcmp(name[i],name[j]) == 0){
					if(strcmp(state[i],state[j])==0)
						continue;
					else if(strcmp(state[i],"enter")==0 && strcmp(state[j],"exit")==0){
						strcpy(result[temp],name[i]);
						result1[temp] = (double)(cent[time[i]]*abs(KM[j]-KM[i])+1*200+1*100)/100;
						temp++;
						//printf("%s $%.2f\n", name[i], (double)(cent[time[i]]*abs(KM[j]-KM[i])+1*200+1*100)/100);
						break;
					}
				}
			}
		}// 이름이 같고 i번째 상태가 enter고 j번째 상태가 exit면 결과값에 이름과 요금 저장
		for(i=0;i<temp-1;i++){
			for(j=0;j<temp-1-i;j++){
				if(strcmp(result[j],result[j+1])>0){
					strcpy(temp1,result[j]);
					strcpy(result[j],result[j+1]);
					strcpy(result[j+1], temp1);
				
					temp2 = result1[j];
					result1[j] = result1[j+1];
					result1[j+1] = temp2;
				}
			}
		}// 결과값 알파벳순으로 정렬
		
		for(i=0;i<temp;i++){
			printf("%s $%.2f\n",result[i],result1[i]);
		}//값 출력
		printf("\n");
		num--;//테스트 케이스 마이너스
		for(i=0;i<cnt;i++){
			for(j=0;j<1000;j++){
				name[i][j] = '\0';
				state[i][j] = '\0';
				result[i][j] = '\0';
			}
		}//값 초기화
	}
}
