#include <iostream>

using namespace std;

int main() {
	string text;
	string str;
	getline(cin, text);
	getline(cin, str);
	int count = 0;
	int indices[1000000];
	size_t found = text.find(str, 0);
	if (found != string::npos)
		indices[count++] = found + 1;
	//cout << found + 1 << " ";
	while (found != string::npos) {
		found = text.find(str, found + 1);
		if (found == string::npos)
			break;
		indices[count++] = found + 1;
		//cout << found + 1 << " ";
	}
	cout << count << endl;
	for (int i = 0; i < count; i++)
		cout << indices[i] << " ";
}