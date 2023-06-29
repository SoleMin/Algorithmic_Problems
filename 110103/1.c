#include <stdio.h>
#include <math.h>
int main() {
	int stu_num, i;
	double sum=0, aver, move_money=0, modi_aver=0, ud=0;
	for(;;){
		scanf("%d", &stu_num);
		if(stu_num==0)
			break;
		
		double* stu_money = malloc(sizeof(double)*stu_num);
		
		for(i=0;i<stu_num;i++){
			scanf("%lf", &stu_money[i]);
			sum+=stu_money[i];
		}
		aver = sum / stu_num;
		modi_aver = roundf(aver*100)/100;
		
		for(i=0;i<stu_num;i++){
			if(aver-modi_aver<0){
				if(stu_money[i]>modi_aver)
					move_money += (stu_money[i]-modi_aver);
			}
			else if(aver-modi_aver>=0){
				if(stu_money[i]<modi_aver)
					move_money += (modi_aver-stu_money[i]);
			}
		}
		printf("$%.2lf\n", move_money);
		
		free(stu_money);
		sum=0, aver=0, move_money=0, modi_aver=0;
	}
	return 0;
}
