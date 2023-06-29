#include <cstdio>
#define abs(a) ((a) < 0 ? (-(a)) : (a))

int main() {
	int n, arr[2], sub;
	int seq[3000]={0};
	bool chk=1;
	
	while(scanf("%d",&n) == 1){
		for(int i=0;i<n;i++) seq[i]=0;
		
		scanf("%d", &arr[0]);
		for(int i=0;i<n-1;i++){
			scanf("%d", &arr[1]);
			sub=abs(arr[1]-arr[0]);
			if((sub >= n || sub <= 0) || seq[sub]){ chk=0; }
			
			++seq[abs(arr[1]-arr[0])];
			arr[0]=arr[1];
		}
		if(chk) printf("Jolly\n");
		else printf("Not jolly\n");
		chk=1;
	}
}