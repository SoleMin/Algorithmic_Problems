#include <iostream>
#include <vector>
#include <string>
using namespace std;

int n;
int arr[5][5];
int dy[4] = {0, 1, 0, -1};
int dx[4] = {1, 0, -1, 0};
int invCnt;
int depth;
bool isSolved;
string s;
vector<int> ret;
pair<int, int> start;

void getInversionCnt() {
	invCnt = 0;
	for(int i = 0; i < 4; i++) {
		for(int j = 0; j < 4; j++) {
			if(!arr[i][j]) {
				invCnt += i;
				continue;
			}
			for(int r = i; r < 4; r++) {
				int c;
				if(r == i) c = j + 1;
				else c = 0;
				for(; c < 4; c++) {
					if(arr[i][j] > arr[r][c] && arr[r][c] != 0)
						invCnt++;
				}
			}
		}
	}	
}

int getMDist() {
	int dstY = 0, dstX = 0;
	for(int i = 0; i < 4; i++) {
		for(int j = 0; j < 4; j++) {
			if(arr[i][j] != 0) {
				dstY += abs(i - (arr[i][j] - 1) / 4);
				dstX += abs(j - (arr[i][j] - 1) % 4);
			}
		}
	}
	return dstY + dstX;
}

bool inRange(int y, int x) {
	return 0 <= y && y < 4 && 0 <= x && x < 4;
}

void convertRet() {
	for(int i = 0; i < ret.size(); i++) {
		switch(ret[i]) {
			case 0:
				s.push_back('R');
				break;
			case 1:
				s.push_back('D');
				break;
			case 2:
				s.push_back('L');
				break;
			case 3:
				s.push_back('U');
		}
	}
}

void dfs(int moved, int preDir, int curY, int curX) {
	int cost = getMDist();
	
	if(!cost) {
		isSolved = true;
		convertRet();
		return;
	}
	// 현재까지 이동 횟수 + 이동해야할 횟수가 최대 깊이보다 크면 실패
	if(moved + cost > depth) 
		return;
	
	// int preY = curY - dy[preDir], preX = curX - dx[preDir];
	int reversePreDir = (preDir + 2) % 4;
	// 빈 칸 자체를 이동
	for(int dirNum = 0; dirNum < 4; dirNum++) {
		int ny = curY + dy[dirNum], nx = curX + dx[dirNum];
		if(!inRange(ny, nx) || reversePreDir == dirNum) continue;
		ret.push_back(dirNum);
		swap(arr[curY][curX], arr[ny][nx]);
		dfs(moved + 1, dirNum, ny, nx);
		swap(arr[curY][curX], arr[ny][nx]);
		ret.pop_back();
	}
}

// 맨해튼 거리가 0이면 답
void solve() {
	getInversionCnt();
	if(!(invCnt & 0x1)) return;
	
	if(!getMDist()) isSolved = true;
	// max depth를 정해두고 dfs
	int cy = start.first, cx = start.second;
	for(depth = getMDist(); depth < 50; depth += 2) {
		if(isSolved) return;
		
		for(int dirNum = 0; dirNum < 4; dirNum++) {
			int ny = cy + dy[dirNum], nx = cx + dx[dirNum];
			if(!inRange(ny, nx)) continue;
			ret.push_back(dirNum);
			swap(arr[cy][cx], arr[ny][nx]);
			dfs(1, dirNum, ny, nx);
			swap(arr[cy][cx], arr[ny][nx]);
			ret.pop_back();
		}
	}
}

int main() {
	cin >> n;
	while(n--) {
		s = "";
		ret.clear();
		isSolved = false;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				cin >> arr[i][j];
				if(!arr[i][j])
					start = {i, j};
			}
		}
		solve();
		
		if(isSolved) {
			cout << s << '\n';
		}
		else {
			cout << "This puzzle is not solvable." << '\n';
		}
	}
	
	return 0;
}