#include <iostream>
using namespace std;

char hex(int num) {
	char ch[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	return ch[num];
}

long long hexToDecimal(string input) {
	long long hex = 1, result = 0;
	for (int i = input.length() - 1; i >= 2; i--) {
		int tmp = input[i];
		if (tmp >= '0' && tmp <= '9') {
			tmp -= 48;
		} else if (tmp >= 'A' && tmp <= 'F') {
			tmp -= 65;
			tmp += 10;
		} else {
			tmp -= 97;
			tmp += 10;
		}
		
		result += tmp * hex;
		hex *= 16;
	}
	if (result >= INT32_MAX) {
		return INT32_MAX;
	}
	
	return result;
}

string decimalToHex(string input) {
	int num = 0, dec = 1;
	for (int i = input.length() - 1; i >= 0; i--) {
		num += (input[i] - 48) * dec;
		dec *= 10;
	}
	
	if (num >= INT32_MAX) {
		return "7FFFFFFF";
	}
	
	string result;
	while (num) {
		result = hex(num % 16) + result;
		num /= 16;
	}
	
	return result;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	string input;
	while (cin >> input) {
		if (input[0] == '0' && input[1] == 'x') {
			int result = hexToDecimal(input);
			
			cout << result << "\n";
		} else {
			string result = decimalToHex(input);
			
			cout << "0x" << result << "\n";
		}
	}
}