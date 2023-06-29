#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(void)
{
    char ch;
    string input;

    while ((ch = fgetc(stdin)) != -1) {
        input.push_back(ch);
    }

    for (size_t i = 0; i < input.size(); i++) {
        if (input[i] == '\n') {
            if (i + 1 < input.size()) {
                if (input[i + 1] != '\n' && input[i + 1] != ' ') {
                    input[i] = ' ';
                } else {
                    i = i + 1;
                }
            }
        }
    }

    size_t wordIndex = 0;
    size_t length = 0;
    for (size_t i = 0; i < input.size(); i++) {
        if (input[i] == ' ' || input[i] == '\n') {
            wordIndex = i;
            if (input[i] == '\n') {
                if (i + 1 < input.size()) {
                    if (input[i + 1] == ' ' || input[i + 1] == '\n') {
                        length = 0;
                        i++;
                    } else {
                        input[i] = ' ';
                        length++;
                    }
                }
            } else {
                wordIndex = i;
                length++;
                if (length > 72) {
                    input[i] = '\n';
                    length = 0;
                }
            }

        } else {
            length++;
            if (length > 72) {
                input[wordIndex] = '\n';
                length = i - wordIndex;
            }
        }
    }
    cout << input;

    return 0;
}