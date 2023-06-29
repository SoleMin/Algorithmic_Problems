#include <stdio.h>
int main() {
	long i = 0, j = 0, i_O = 0, j_O = 0, temp = 0, i_temp = 0, j_temp = 0, cycle = 0, max_cycle = 0;
	while(scanf("%ld %ld", &i_O, &j_O) == 2){
		i_temp = i_O;
		j_temp = j_O;
		max_cycle = 0;
		if(i_temp > j_temp){
			temp = i_temp;
			i_temp = j_temp;
			j_temp = temp;
		}
		for(i = i_temp; i <= j_temp; i++){
			j = i;
			cycle = 1;
			while(j != 1){
				if(j%2 == 1){
					j = j*3+1;
					cycle++;
				}
				while(j%2 != 1){
					j /= 2;
					cycle++;
				}
			}
			if(cycle > max_cycle)
				max_cycle = cycle;
		}
		printf("%ld %ld %ld\n", i_O, j_O, max_cycle);
	}
	return 0;
}
