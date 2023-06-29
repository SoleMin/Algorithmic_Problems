#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<string> v;

/*
flag = 얼마나 더 넣을 수 있는가?
       공백 하나가 추가되는 것을 고려해 -1까지는 허용
v = 문자열 벡터

1. 빈 줄이 입력된 경우 -> 벡터에 넣고 flag 초기화
2. 새로운 줄을 시작해야 하는 경우 (flag <= 0)
   - 입력된 문자열이 72자 이하인 경우 = 그냥 넣고 flag 갱신
	 - 72자를 초과하는 경우 = 71번째 인덱스부터 왼쪽으로 가면서 공백 탐색
	   1) 공백이 있는 경우: 그대로 스플릿해서 넣고 뒷부분에 대해 flag 갱신
		 2) 공백이 없는 경우: 72번째 인덱스부터 오른쪽으로 가면서 공백 탐색
		                   - 공백이 없다 (줄 전체가 한 단어이므로)
									  	 - 공백이 있다 (스플릿 후 flag 갱신)
3. 이전 줄을 마저 채워야 하는 경우 -> 입력된 문자열에 대해 공백 탐색 (변수 index = 공백의 위치 / 단어의 길이)
   - 공백이 없거나, 있는데 스플릿하기엔 범위를 초과하는 경우
	   모두 index = 0으로 처리하므로 flag를 갱신했을 때의 값을 확인
		 1) 마저 채울 수 있는 경우: 벡터의 마지막 값에 추가
		 2) 새로 채워야 하는 경우: 벡터에 넣고 flag 갱신
   - 스플릿해서 채울 수 있는 경우
*/


int main() {
	string s;
	int flag = 0;
	while (getline(cin, s)) {
		int length = s.length();
		if (!length) { // \n이 입력되는 경우
			v.push_back(s);
			flag = 0;
			continue;
		}
		if (flag <= 0) { // 새로운 줄의 시작
			if (length <= 72) { // 그냥 그대로 넣음
				flag = 72 - (length + 1);
				v.push_back(s + ' ');
			}
			else { // 공백의 위치에 따라서 스플릿
				bool one = true;
				for (int i = 71; i >= 0; i--) {
					if (s[i] == ' ') {
						v.push_back(s.substr(0, i));
						while (s[i] == ' ' && i != length - 1)
							i++;
						length -= i;
						v.push_back(s.substr(i, length) + ' ');
						flag = 72 - (length + 1);
						one = false;
						break;
					}
				}
				if (one) { // 한 단어라면
					int index = 0;
					for (int i = 72; i < length; i++)
						if (s[i] == ' ') {
							index = i;
							break;
						}
					if (!index) {
						v.push_back(s);
						flag = 0;
					}
					else {
						v.push_back(s.substr(0, index) + ' ');
						length -= ++index;
						v.push_back(s.substr(index, length) + ' ');
						flag = 72 - (length + 1);
					}
				}
			}
		}
		else {
			//cout << s << endl;
			//cout << "flag: " << flag << endl;
			int index = 0; // 스플릿 위치 체크
			for (int i = 0; i < length; i++) {
				if (s[i] == ' ') {
					if (i <= flag) // 
						index = i;
					else
						break;
				}
				else if (i == length - 1) // 마지막 부분은 따로 체크
					if (i + 1 <= flag)
						index = i + 1;
			}
			
			//cout << "index: " << index << endl;
			if (!index) { // 한 단어이거나 범위를 초과하는 경우
				flag -= (length + 1);
				if (flag < -1) { // 새로운 줄의 시작
					v.push_back(s + ' ');
					flag = 72 - (length + 1);
				}
				else // 그대로 다 넣음
					v.back() += (s + ' ');
			}
			else { // 스플릿으로 넣을 수 있는 경우
				if (index == length) {
					v.back() += (s + ' ');
					flag -= (length + 1);
				}
				else {
					v.back() += (s.substr(0, index) + ' ');
					while (s[index] == ' ')
						index++;
					length -= index;
					v.push_back(s.substr(index, length) + ' ');
					flag = 72 - (length + 1);
				}
			}
		}
	}
	for (int i = 0; i < (int) v.size(); i++)
		cout << v[i] << '\n';
	return 0;
}