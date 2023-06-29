#include <iostream>
#include <cstdlib>
#define MAX_N 1000
using namespace std;

int compare(const void *arg1, const void *arg2) {
	return (*(int*)arg1) - (*(int*)arg2);
}

int main() {
	int total_case, i;
	cin >> total_case;
	for (i = 0; i < total_case; i++) {
		int j, n;
		int time[MAX_N] = {0};	// 최대 1000명의 걸리는 시간
		int total_time = 0;
		int size = 0;
		int num[MAX_N*2-1] = {0};
		int person[MAX_N*2-1][2] = {0};
		
		cin >> n;
		for(j = 0; j < n; j++)
			cin >> time[j];
		qsort((void*)time, (size_t)n, sizeof(int), compare);
		
		while (n > 3) {
			int a, b, c, d;
			a = time[0];
			b = time[1];
			c = time[n-2];
			d = time[n-1];
			
			if (b+b < c+a) {	// a,b - a - c,d - b
				num[size] = 2;
				person[size][0] = a;
				person[size][1] = b;
				size++;
				
				num[size] = 1;
				person[size][0] = a;
				size++;
				
				num[size] = 2;
				person[size][0] = c;
				person[size][1] = d;
				size++;
				
				num[size] = 1;
				person[size][0] = b;
				size++;
				
				total_time += b+a+d+b;
			}
			else {	// a,c - a - a,d - a
				num[size] = 2;
				person[size][0] = a;
				person[size][1] = c;
				size++;
				
				num[size] = 1;
				person[size][0] = a;
				size++;
				
				num[size] = 2;
				person[size][0] = a;
				person[size][1] = d;
				size++;
				
				num[size] = 1;
				person[size][0] = a;
				size++;
				
				total_time += c+a+d+a;
			}
			n -= 2;
		}
		
		// n이 3 이하일 경우
		if(n == 3) {
			num[size] = 2;
			person[size][0] = time[0];
			person[size][1] = time[2];
			size++;
			
			num[size] = 1;
			person[size][0] = time[0];
			size++;
			
			total_time += time[2] + time[0];
			n--;
		}
	
		num[size] = n;
		for(j = 0; j < n; j++)
			person[size][j] = time[j];
		total_time += time[n-1];
		size++;

		cout << total_time << "\n";

		if(i < total_case-1)
			cout << "\n";
	}
	return 0;
}