#include <iostream>
#include <cstdlib>

using namespace std;

int main() {
	int t;
	cin >> t;
	for(; t>0; t--){
		int r, j, left, right, pivot, sum = 0;
		cin >> r;
		int s[r];
		for(int i=0; i<r; i++){
			cin  >> s[i];
		}
		left = 0;
		right = r - 1;
		do{
			int i, temp;
			i = left;
			j = right;
			pivot = s[left];
			while(i <= j){
				while(i <= right && s[i] <= pivot)
					i++;
				while(j > left && s[j] >= pivot)
					j--;
				if(i < j){
					temp = s[i];
					s[i] = s[j];
					s[j] = temp;
				}
			}
			s[left] = s[j];
			s[j] = pivot;
			if(j < r/2)
				left = j + 1;
			else
				right = j - 1;
			
		}while(j != r/2);
		
		for(int i=0; i<r; i++)
			sum += abs(pivot-s[i]);
		cout << sum << endl;
		
	}
	
	return 0;
}