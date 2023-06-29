#include <stdio.h>
#define MAX_CHOPSTICK 5000

int chopstick_length[MAX_CHOPSTICK];
int pre_badness[MAX_CHOPSTICK+1];
int now_badness[MAX_CHOPSTICK+1];
int main() {
	int i,t;
	scanf("%d",&t);
	for(i=0; i<t; i++) {
		int j,k;
		int guests_num, chopsticks_num;
		scanf("%d %d", &guests_num, &chopsticks_num);
		for(j=0; j<chopsticks_num; j++) {
			scanf("%d",&chopstick_length[j]);
		}
		
		guests_num += 8;
		for(j=0; j<=chopsticks_num; j++) {
			pre_badness[j] =0;
		}
		for(j=0; j<guests_num; j++) {
			int max_candidate = chopsticks_num-3 *(guests_num-1-j)-1;
			now_badness[0]=-1;
			now_badness[1]=-1;
			for(k=2; k<=max_candidate; k++){
				if(pre_badness[k-2]>-1) {
					int badness, diff;
					diff = chopstick_length[k-1]-chopstick_length[k-2];
					badness = pre_badness[k-2]+diff*diff;
					if(now_badness[k-1] > badness || now_badness[k-1]==-1)
						now_badness[k] = badness;
					else
						now_badness[k] = now_badness[k-1];
				}
				else
					now_badness[k]=-1;
			}
			now_badness[max_candidate+1]=now_badness[max_candidate];
			for(k=0; k<=max_candidate + 1; k++) 
				pre_badness[k] = now_badness[k];
			}
		printf("%d\n",pre_badness[chopsticks_num-1]);
	}
	return 0;
}
