#include <stdio.h>
#define MAX 1000

static int time[MAX],fine[MAX],result[MAX];
static int n;
void input(){
	int i;
	
	scanf("%d",&n);
	for(i=0;i<n;i++){
		scanf("%d %d",&time[i],&fine[i]);
	}
}
	
void solve(){
	int i,j,temp;
	for(i=0;i<n;i++){
		result[i]=i;
	}
	
	for(i=1;i<n;i++){
		for(j=0;j<n-i;j++){
			if(time[result[j]]*fine[result[j+1]] > time[result[j+1]]*fine[result[j]]){
				temp= result[j];
				result[j] = result[j+1];
				result[j+1] =temp;
			}
		}
	}
}


int main(void) {
	
	int c,i,j;
	scanf("%d", &c);
	
	for(i=0;i<c;i++){
		input();
		solve();
		if(i>0)
			printf("\n");
		for(j=0;j<n;j++){
			printf("%d ",result[j]+1);
		}
			printf("\n");
		
	}
	
	return 0;
}

