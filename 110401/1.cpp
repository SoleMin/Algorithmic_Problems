#include <iostream>
#include <algorithm>
#include <vector>
#include <stdlib.h>
using namespace std;
int main() {
	int input, i, house_num, a, beeto, beeto1, beeto2, sum = 0, count, sum1, sum2,j;
	vector<int> v1;
	vector<int> v2;
	cin >> input;
	for(i=0;i<input;i++){
		sum = 0;
		sum1 = 0;
		sum2 = 0;
		count = 0;
		cin >> house_num;
		for(int j=0;j<house_num;j++){
			cin >> a;
			v1.push_back(a);
			v2.push_back(a);
		}
		sort(v1.begin(), v1.end());
		sort(v2.begin(), v2.end());
		if(house_num%2 == 1){
			beeto = v1[house_num/2];
		}
		else{
			beeto1 = v1[house_num/2];
			beeto2 = v2[house_num/2 - 1];
		}
		
		if(house_num%2 == 1){
			for(j=0;j<house_num/2;j++){
				sum = sum + abs(v1[j]-beeto);
			}
			for(j=(house_num/2)+1 ; j<house_num; j++){
				sum = sum + abs(v1[j]-beeto);
			}
			cout << sum << endl;
		}
		else{
			for(j=0;j<house_num/2;j++)
				sum1 = sum1 + abs(v1[j]-beeto1);
			for(j=(house_num/2)+1 ; j<house_num; j++)
				sum1 = sum1 + abs(v1[j]-beeto1);
			for(j=0;j<(house_num/2)-1;j++)
				sum2 = sum2 + abs(v2[j]-beeto2);
			for(j=house_num/2 ; j<house_num; j++)
				sum2 = sum2 + abs(v2[j]-beeto2);
			if(sum1<sum2)
				cout << sum1 << endl;
			else
				cout << sum2 << endl;
		}
		v1.clear();
		v2.clear();
	}
	// 1 2 3 4 5 6
	return 0;
}