#include <iostream>
#include <cmath>
using namespace std;
int main() {
	int stu;
	float cost, moveCostF, moveCostC, averCost, averCostF, averCostC;
	while (scanf("%d", &stu)) {
		if (stu == 0)
			break;
		cost = 0, moveCostF = 0, moveCostC = 0; averCost = 0;
		float *costArr = new float[stu];
		for (int i = 0; i < stu; i++) {
			scanf("%f", &cost);
			costArr[i] = cost;
			averCost += cost;
		}
		
		averCost /= (float)stu;
		averCost *= (float)100;
		averCostF = floor(averCost)/(float)100;
		averCostC = ceil(averCost)/(float)100;
		
		for (int i = 0; i < stu; i++){
			if (costArr[i] < averCostF)
				moveCostF += (averCostF - costArr[i]);
			if (costArr[i] > averCostC)
				moveCostC += (costArr[i] - averCostC);
		}
			
		if (moveCostF > moveCostC)
			printf("$%.2f\n", moveCostF);
		else
			printf("$%.2f\n", moveCostC);
		
		delete [] costArr;
	}
	return 0;
}