#include <cstdio>

int main() {
	int team;
	double stu[1000]={0};
	double avg=0, money=0;
	while(1){
		scanf("%d",&team);
		if(!team) break;
		
		for(int i=0;i<team;i++){
			scanf("%lf",&stu[i]);
			avg+=stu[i];
		}
		avg/=team;
		
		for(int i=0;i<team;i++){
			if(stu[i] > avg) money+=(stu[i]-avg); //어차피 가진놈이 나눠줘야지...
			money=(int)(money*100)*0.01; //avg로 공평히 나눴으나 센트 단위라서... 셋째자리는 다 잘라야함
		}
		printf("$%.2lf\n",money);
		avg=money=0;
	}
}