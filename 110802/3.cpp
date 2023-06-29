#include <cstdio>
#include <cmath>
#include <stack>
#include <iterator>

using namespace std;

char list[] = { 'U', 'L', 'R', 'D' };
bool isSolved = false;
int zerox, zeroy;
int puzzle[4][4];
stack<int> s;

void printstack()
{
	stack<int> copy;

	while (!s.empty()) {
		copy.push(s.top());
		s.pop();
	}
	while (!copy.empty()) {
		printf("%c", list[copy.top()]);
		copy.pop();
	}
	printf("\n");
}
void swap(int* a, int* b)
{
	int tmp;
	tmp = *a;
	*a = *b;
	*b = tmp;
}

int MD()
{
	int i, j, dist = 0;
	for (i = 0; i < 4; i++)
	{
		for (j = 0; j < 4; j++)
		{
			if (puzzle[i][j] == 0)
				continue;
			dist += abs(((puzzle[i][j] - 1) % 4) - j) + abs(((int)(puzzle[i][j] - 1) / 4) - i);
		}
	}
	return dist;
}

int move(int n)
{
	switch (n)
	{
	case 0:
		if (zeroy == 0)
			return 0;
		swap(&puzzle[zeroy][zerox], &puzzle[zeroy - 1][zerox]);
		zeroy--;
		break;
	case 1:
		if (zerox == 0)
			return 0;
		swap(&puzzle[zeroy][zerox], &puzzle[zeroy][zerox - 1]);
		zerox--;
		break;
	case 2:
		if (zerox == 3)
			return 0;
		swap(&puzzle[zeroy][zerox], &puzzle[zeroy][zerox+1]);
		zerox++;
		break;
	case 3:
		if (zeroy == 3)
			return 0;
		swap(&puzzle[zeroy][zerox], &puzzle[zeroy + 1][zerox]);
		zeroy++;
		break;
	}
	return 1;
}

int can_solve()
{
	int i, j, count = 0;

	for (i = 0; i < 15; i++) {
		if (puzzle[0][i] == 0)
			continue;
		for (j = i+1; j < 16; j++)
		{
			if (puzzle[0][j] == 0)
				continue;
			if (puzzle[0][i] > puzzle[0][j])
				count++;
		}
	}

	if ((zeroy + count) % 2)
		return 1;
	return 0;
}

void cal(int n)
{
	static int depth = 0;
	int i, j, d;

	if (isSolved)
		return;
	if (MD() + depth > n)
		return;
	if (MD() == 0) {
		isSolved = true;
		return;
	}
	depth++;

	for (i = 0; i < 4; i++)
	{
		if (!s.empty() && s.top() + i == 3)
			continue;

		if (move(i)) {
			s.push(i);
			cal(n);

			if (isSolved)
				return;

			move(3 - i);
			if (!s.empty())
				s.pop();
		}
	}
	return;
}

int main()
{
	int i, j, t, T;

	scanf("%d", &T);

	for (t = 0; t < T; t++) {
		isSolved = false;
		for (i = 0; i < 4; i++)
		{
			for (j = 0; j < 4; j++)
			{
				scanf("%d", &puzzle[i][j]);
				if (puzzle[i][j] == 0) {
					zerox = j;
					zeroy = i;
				}
			}
		}

		if (!can_solve())
			printf("This puzzle is not solvable.\n");
		else {
			for (i = 0; i <= 50; i++)
			{
				if (isSolved)
					break;
				cal(i);
			}
			if (isSolved) {
				printstack();
			}
			else
				printf("This puzzle is not solvable.\n");
		}
	}
}