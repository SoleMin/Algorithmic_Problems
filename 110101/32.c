#include <stdio.h>

int main() {
	long i, j, id, jd, p;
	
	while(scanf("%ld %ld", &i, &j) == 2){
		long max=0;
		id = i;
		jd = j;
		
		if(i>j){
			id = j;
			jd = i;
		}
		
		for(long k=id; k<=jd; k++){
			long cnt=1;
			p = k;
			while(p!=1){
				if(p%2==0)
					p = p/2;
				else
					p = 3*p + 1;
				cnt++;
			}
			if(cnt>max)
				max = cnt;
		}
		printf("%ld %ld %ld\n", i, j, max);
	}
	
	
	return 0;
}
