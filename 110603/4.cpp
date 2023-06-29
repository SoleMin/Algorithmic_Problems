#include <cstdio>
#include <cstdlib>
#include <string>
#include <vector>

using namespace std;

void add(string sa, string sb, string* c)
{
	string a, b;

	if (sa.length() <= sb.length()) {
		a = sa, b = sb;
	}
	else {
		b = sa, a = sb;
	}
	int o, alen, blen, i, maxlen;
	string tmp;
	alen = a.length();
	blen = b.length();
	tmp.resize(alen);
	o = 0;
	for (i = 0; i < alen; i++)
	{
		tmp[i] = a[i] + b[i] - '0' + o;
		o = 0;
		if (tmp[i] > '9') {
			tmp[i] -= 10;
			o = 1;
		}
	}
	if (i < blen || o == 1) {
		tmp.resize(tmp.size() + 1);
		tmp[i] = 0;
		if (i < blen)
			tmp[i] += b[i];
		if (o == 1) {
			if (tmp[i] != 0)
				tmp[i] += o;
			else
				tmp[i] = '1';
		}
		if (tmp[i] > '9') {
			tmp[i] -= 10;
			tmp[i + 1] = '1';
		}
	}

	*c = tmp;
}

int main() {
	string str[4];
	char input[5];
	int n, i, j;

	while (fgets(input, 5, stdin))
	{
		n = atoi(input);
		str[0] = "2";
		str[1] = "5";
		str[2] = "31";

		for (i = 4; i <= n; i++)
		{
			add(str[0], str[1], &str[3]);
				add(str[2], str[3], &str[3]);
			add(str[2], str[3], &str[3]);

			str[0] = str[1];
			str[1] = str[2];
			str[2] = str[3];
		}
		if (n == 1)
			printf("2");
		else if (n == 2)
			printf("5");
		else if (n == 3)
			printf("13");
		else
			for (i = str[2].length() - 1; i >= 0; i--)
				printf("%c", str[3][i]);
		printf("\n");
	}
}
