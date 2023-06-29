#include <string.h>
#include <stdio.h>
#include <vector>

#define MAX_DIC 25200
using namespace std;

int isDoublets(const char* str1, const char* str2);
int findArr(const char arr[25200][17], const char* str, int N);

char dic[MAX_DIC][17];
bool isCheck[MAX_DIC] = { 0, };
vector<int> v[MAX_DIC];
vector<int> result;
bool exitCode = false;


void makeVec(int index, int how_many, const char* inp2)
{
	int i;
	isCheck[index] = true;
	if (exitCode)
		return;

	if (isDoublets(dic[index], inp2)) {						// inp2 하고 더블릿인 문자열 찾음 => 종료
		exitCode = true;
		result.push_back(findArr(dic, inp2, how_many));
		result.push_back(index);
		return;
	}

	for (i = 0; i < how_many; i++) {
		if (isCheck[i] == true)
			continue;

		if (isDoublets(dic[index], dic[i])) {
			v[index].push_back(i);
			isCheck[i] = true;
		}
	}
	for (i = 0; i < v[index].size() && exitCode == false; i++) {
		makeVec(v[index][i], how_many, inp2);
	}
	if (exitCode) {
		for (i = 0; i < v[index].size(); i++) {
			if (v[index][i] == result.back())
				result.push_back(index);
		}
	}
}

int findArr(const char arr[25200][17], const char* str, int N) {

	int i;
	for (i = 0; i < N; i++) {
		if (strcmp(arr[i], str) == 0)
			return i;
	}
	return -1;
}

int isDoublets(const char* str1, const char* str2) {
	int i, check, len;

	check = 0;
	i = 0;
	len = strlen(str1);
	if (strlen(str1) == strlen(str2)) {
		for (i = 0; i < len; i++) {
			if (str1[i] != str2[i])
				check++;
		}
		if (check <= 1)
			return 1;
	}
	return 0;
}

int main() {
	int how_many, i, j, start, end, len;
	char input[40], inp1[20], inp2[20], tmp[20];

	how_many = 0;
	do {
		fgets(tmp, 20, stdin);
		sscanf(tmp, "%s", dic[how_many++]);
	} while (tmp[0] != '\n');

	while (fgets(input, 40, stdin)) {

		for (i = 0; i < MAX_DIC; i++) {
			isCheck[i] = 0;
			v[i].clear();
		}
		result.clear();
		exitCode = false;

		sscanf(input, "%s %s", inp1, inp2);

		start = findArr(dic, inp1, how_many);
		end = findArr(dic, inp2, how_many);

		if (start < 0 || end < 0 || strlen(inp1) != strlen(inp2)) {
			printf("No solution.\n\n");		//no solution 조건문
			continue;
		}
		else if (strcmp(inp1, inp2) == 0) {
			printf("%s\n\n", inp1);
			continue;
		}

		//------------------------solution 찾기

		makeVec(start, how_many, inp2);

		len = result.size();
		if (len == 0)
			printf("No solution.\n");
		else {
			for (i = 0; i < len; i++)
			{
				printf("%s\n", dic[result.back()]);
				result.pop_back();
			}
		}
		printf("\n");
	}
	return 0;
}
