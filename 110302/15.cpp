#include <iostream>
#include <string>
using namespace std;

#define MAX_GRID 50
// 왼쪽 상단 대각선부터 시계방향
int row[] = {-1, -1, -1, 0, 1, 1, 1, 0};
int col[] = {-1, 0, 1, 1, 1, 0, -1, -1};
int m, n;	// 실제 grid 행, 열 개수
unsigned int index = 1;	// word의 철자 index
char grid[MAX_GRID + 2][MAX_GRID + 2];	// 단어 grid
string word;
bool isFound = false;

// 유효 범위 판단
bool isValid(int r, int c) {
	if (r < 1 || c < 1 || r > m || c > n) return false;	// 유효 범위) 행: 1~m, 열: 1~n
	return true;
}

// 한 방향으로 단어의 철자 검사
void word_search(int direction, int r, int c) {
	int dr = r + row[direction];
	int dc = c + col[direction];
	// 유효 범위 && 철자가 같으면
	if (isValid(dr, dc) && (word[index] == grid[dr][dc])) {
		if (index == word.length() - 1) {	// 철자가 모두 같으면
			isFound = true; return;
		}
		++index;
		word_search(direction, dr, dc);	// direction 방향으로 계속 검사
	}
	else return;
}

bool find_word(int r, int c) {
	for (int dir = 0; dir < 8; dir++) {	// 8방향으로 검색
		word_search(dir, r, c);	// 먼저 검색하고
		if (isFound) {	// 단어 찾으면
			cout << r << ' ' << c << endl;	// 단어의 시작 행 번호, 열 번호 출력
			return true;	// true
		}
		index = 1;	// 탐색한 후 index 초기화
	}
	return false;	// 만약 단어 못 찾으면 false
}

int main(void) {
	int test, i, j, k, r, c;
	string line;
	
	cin >> test; cin.ignore();
	for (int tc = 0; tc < test; tc++) {
		getline(cin, line);	// 빈 줄 입력
		cin >> m >> n; cin.ignore();	// m, n 입력
		
		// grid 채우기
		for (i = 1; i <= m; i++) {	// 행 개수만큼 입력받기
			getline(cin, line);	// line 입력 받아서 한줄씩 넣기
			for (j = 1; j <= n; j++) {
				grid[i][j] = tolower(line[j-1]);	// 입력받은 모든 문자를 소문자로 바꿔서 넣기
			}
		}
		// 검색할 단어 입력 받기
		cin >> k; cin.ignore();
		for (i = 0; i < k; i++) {	// k번 반복
			getline(cin, line);			// 단어 입력 받기
			for (unsigned int t = 0; t < line.length(); t++) {
				word.push_back(tolower(line[t]));	// 입력 받은 문자 소문자로 word에 저장
			}
			
			// 단어 찾기
			for (r = 1; r <= m; r++) {	// grid의 요소 하나씩 차례대로 검사
				for (c = 1; c <= n; c++) {
					if (word[0] == grid[r][c]) {	// 찾고자 하는 단어의 첫번째 철자를 발견하면
						if (find_word(r, c))	// 단어 찾기 함수 호출
							goto EXIT;					// 찾으면 EXIT
					}
				}
			}
		EXIT:
			isFound = false;	// 초기화
			word.clear();	// 문자열 비우기
			
			//cout << endl;
		}	// k번 반복문 괄호
		cout << endl;
	}	// textcase 괄호
	return 0;
}