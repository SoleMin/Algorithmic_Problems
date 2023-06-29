#include <iostream>
#include <vector>
using namespace std;

/*
	n <= 5
	16번 이내의 움직임
*/

int minShift[11][11] {{0, 1, 1, 0, 1, 2, 3, 2, 3, 3, 3},
					  {1, 2, 2, 0, 0, 1, 2, 3, 4 ,4, 4},
					  {0, 2, 3, 1, 1, 0, 1, 4, 5, 3, 5},
					  {1, 1, 2, 2, 2, 0, 0, 3, 4, 2, 4},
					  {0, 0, 1, 2, 3, 1, 1, 2, 3, 1, 3},
					  {1, 0, 0, 1, 2, 2, 2, 1, 2, 2, 2},
					  {0, 1, 1, 2, 3, 3, 3, 0, 1, 2, 3},
					  {1, 2, 2, 3, 4, 4, 4, 0, 0, 1, 2},
					  {0, 2, 3, 4, 5, 3, 5, 1, 1, 0, 1},
					  {1, 1, 2, 3, 4, 2, 4, 2, 2, 0, 0},
					  {0, 0, 1, 2, 3, 1, 3, 2, 3, 1, 1}};
int ans[24] = {0, 3, 4, 3, 0, 5, 6, 5, 0, 1, 2, 1, 0, 7, 8, 7, 0, 9, 10, 9, 0, 1, 2, 1};

int arr[24];
int pointer[2];
int cnt[2];
int rn;
bool isSolved;
vector<int> ret;
vector<int> printret;

int leftNum(int base, int offset) {
	if(base < 12) {
		base = (base + offset) % 12;
	}
	else {
		base += offset;
		if(base >= 24)
			base -= 12;
	}
	return base;
}

int rightNum(int base, int offset) {
	if(base < 12) {
		base -= offset;
		if(base < 0)
			base += 12;
	}
	else {
		base -= offset;
		if(base < 12)
			base += 12;
	}
	return base;
}

int calRemain() {
	int mx = 0;
	for(int i = 0; i < 21; i++) {
		int num = arr[leftNum(pointer[i / 12], i % 12)];
		if(mx < minShift[i / 2][num])
			mx = minShift[i / 2][num];
		// mx = max(mx, minShift[i / 2][num]);
	}
	return mx;
}

void solve(int moved) {
	if(moved == rn) return;
	
	bool isSame = true;
	for(int i = 0; isSame && i < 12; i++) {
		if(arr[leftNum(pointer[0], i)] != ans[i])
			isSame = false;
	}
	for(int i = 0; isSame && i < 12; i++) {
		if(arr[leftNum(pointer[1], i)] != ans[i + 12])
			isSame = false;
	}
	if(isSame) {
		isSolved = true;
		rn = moved;
		printret = ret;
		return;
	}
	int cost = calRemain();
	
	if(moved == 16 || moved + cost > 16 || moved + cost >= rn) return;
	
	
	int cntTmp1, cntTmp2;
	for(int i = 1; i <= 4; i++) {
		if(moved >= rn - 1) break;
		
		// 왼쪽을 왼쪽으로(시계)
		if(i == 1) {
			if(cnt[0] > 0 || cnt[0] <= -5) continue;
			pointer[0] = rightNum(pointer[0], 2);
			// 오른쪽의 중복되는 부분 갱신
			for(int j = 1; j <= 3; j++) 
				arr[rightNum(pointer[1], j)] = arr[rightNum(pointer[0], j)];
			
			ret.push_back(i);
			cntTmp1 = cnt[0];
			cntTmp2 = cnt[1];
			cnt[0]--;
			cnt[1] = 0;
			solve(moved + 1);
			cnt[0] = cntTmp1;
			cnt[1] = cntTmp2;
			ret.pop_back();
			
			pointer[0] = leftNum(pointer[0], 2);
			for(int j = 1; j <= 3; j++)
				arr[rightNum(pointer[1], j)] = arr[rightNum(pointer[0], j)];
		}
		else if(i == 2) {		// 오른쪽을 왼쪽으로(시계)
			if(cnt[1] > 0 || cnt[1] <= -5) continue;
			pointer[1] = leftNum(pointer[1], 2);
			// 왼쪽의 중복되는 부분 갱신
			for(int j = 1; j <= 3; j++) 
				arr[rightNum(pointer[0], j)] = arr[rightNum(pointer[1], j)];
			
			ret.push_back(i);
			cntTmp1 = cnt[0];
			cntTmp2 = cnt[1];
			cnt[0] = 0;
			cnt[1]--;
			solve(moved + 1);
			cnt[0] = cntTmp1;
			cnt[1] = cntTmp2;
			ret.pop_back();
			
			pointer[1] = rightNum(pointer[1], 2);
			for(int j = 1; j <= 3; j++)
				arr[rightNum(pointer[0], j)] = arr[rightNum(pointer[1], j)];
		}
		else if(i == 3) {		// 왼쪽을 오른쪽으로(반시계 회전)
			if(cnt[0] >= 5 || cnt[0] < 0) continue;
			pointer[0] = leftNum(pointer[0], 2);
			// 오른쪽의 중복되는 부분 갱신
			for(int j = 1; j <= 3; j++) 
				arr[rightNum(pointer[1], j)] = arr[rightNum(pointer[0], j)];
			
			ret.push_back(i);
			cntTmp1 = cnt[0];
			cntTmp2 = cnt[1];
			cnt[0]++;
			cnt[1] = 0;
			solve(moved + 1);
			cnt[0] = cntTmp1;
			cnt[1] = cntTmp2;
			ret.pop_back();
			
			pointer[0] = rightNum(pointer[0], 2);
			for(int j = 1; j <= 3; j++)
				arr[rightNum(pointer[1], j)] = arr[rightNum(pointer[0], j)];
		}
		
		else if(i == 4) {		// 오른쪽을 오른쪽으로(반시계)
			if(cnt[1] < 0 || cnt[1] >= 5) continue;
			pointer[1] = rightNum(pointer[1], 2);
			// 왼쪽의 중복되는 부분 갱신
			for(int j = 1; j <= 3; j++) 
				arr[rightNum(pointer[0], j)] = arr[rightNum(pointer[1], j)];
			
			ret.push_back(i);
			cntTmp1 = cnt[0];
			cntTmp2 = cnt[1];
			cnt[0] = 0;
			cnt[1]++;
			solve(moved + 1);
			cnt[0] = cntTmp1;
			cnt[1] = cntTmp2;
			ret.pop_back();
			
			pointer[1] = leftNum(pointer[1], 2);
			for(int j = 1; j <= 3; j++)
				arr[rightNum(pointer[0], j)] = arr[rightNum(pointer[1], j)];
		}
	}
}

int main() {
	int n;
	cin >> n;
	while(n--) {
		for(int i = 0; i < 24; i++)
			cin >> arr[i];
		pointer[0] = 0;
		pointer[1] = 12;
		cnt[0] = cnt[1] = 0;
		isSolved = false;
		ret.clear();
		rn = 17;			// 현재까지 구한 최적해
		
		solve(0);
		if(isSolved) {
			if(printret.size() == 0)
				cout << "PUZZLE ALREADY SOLVED\n";
			else {
				for(int i = 0; i < printret.size(); i++)
					cout << printret[i];
				cout << '\n';
			}
		}
		else 
			cout << "NO SOLUTION WAS FOUND IN 16 STEPS\n";
	}
	
	return 0;
}