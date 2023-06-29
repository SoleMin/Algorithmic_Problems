#include <cstdio>
#define SWAP(a,b,tmp) ((tmp)=(a), (a)=(b), (b)=(tmp))

int main() {
	long i, j, tmp, num;
	long max, cycle;
	long left, right;
	
	while(scanf("%ld %ld",&i, &j) == 2){
		left=i; right=j;
		max=0;
		if(i>j) SWAP(i,j,tmp); //혹시나 크기가 오름차순이 아니면 정렬
		
		for(int k=i; k<=j; k++){
			cycle=1;
			num=k;
			
			while(num != 1){
				if(num %2 != 0) num=num*3+1;
				else num/=2;
				++cycle;
			}
			if(max < cycle) max=cycle;
		}
		printf("%ld %ld %ld\n",left, right, max);
	}
}