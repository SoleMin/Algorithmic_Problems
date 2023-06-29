#include <iostream>
using namespace std;

int round(double x) {
	x += 0.5;
	return (int)x;
}

int main() {
	double count;
	double student[1000];
	
	while (cin >> count) {
		if (count == 0) break;
		
		int total = 0;
		int cent = 0, dallar = 0;
		for (int i = 0; i < count; i++) {
			scanf("%d.%d", &dallar, &cent);
			student[i] = cent + (100 * dallar);
			total += student[i];
		}
		int avg = round((total * 1.0) / count);
		int result1 = 0, result2 = 0;
		
		for (int i = 0; i < count; i++) {
			if (student[i] < avg)
				result1 += (avg - student[i]);
			else if (student[i] > avg)
				result2 += (student[i] - avg);
		}
		
		int result = result1 < result2 ? result1 : result2;
		
		printf("$%d.%02d\n", result / 100, result % 100);
	}
}