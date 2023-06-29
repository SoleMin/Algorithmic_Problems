#include <stdio.h>
#include <math.h>
#define SIZE 100

struct edge{
	double x;
	double y;
};
static double minval[SIZE];
static struct edge F[SIZE] = { 0 };
static int n, check[SIZE];

double dist(int a, int b){
	return sqrt(pow(F[a].x - F[b].x,2) + pow(F[a].y - F[b].y,2));
}

double solve(){
	int i,j,a;
	double result=0;
	for(i=0;i<n;i++){
		check[i] =0;
	}
	check[0]=1;
	for(i=1;i<n;i++){
		minval[i] = dist(0,i);
	}
	for(i=0;i<n-1;i++){
		a=-1;
		for(j=0;j<n;j++){
			if(check[j] == 1)
				continue;
			if (a == -1 || minval[j] < minval[a]) {
				//minval[a] = minval[j];
				a=j;
			}
		}
		result+=minval[a];
		check[a]=1;
		
		for(j=0;j<n;j++){
			if(check[j] == 1)
				continue;
			if(minval[j]>dist(a,j)){
				minval[j]=dist(a,j);
			}
		}
			
	}
	return result;
}
int main() {
int i,j,c;
	scanf("%d", &c);
	for(i=0;i<c;i++){
		scanf("%d",&n);
		for(j=0;j<n;j++){
			scanf("%lf %lf",&F[j].x , &F[j].y);
		}
	
		printf("%0.2lf\n",solve());
		if(i<=c)
			printf("\n");
	}
	return 0;
}
