#include <iostream>
using namespace std;

int n, identifier, possible;
char automata[8], precell[32], cell[33];

void backTracking(int a)
{
    int i;
    if (a == n - 1) {
        if (automata[precell[a - 1] * 4 + precell[a] * 2 + precell[0]] == cell[a] && automata[precell[a] * 4 + precell[0] * 2 + precell[1]] == cell[0])
            possible = 1;
        return;
    }
    for (i = precell[a - 1] * 4 + precell[a] * 2; i <= precell[a - 1] * 4 + precell[a] * 2 + 1; i++) {
        if (automata[i] == cell[a]) {
            precell[a + 1] = i % 2;
            backTracking(a + 1);
            if (possible)
                break;
        }
    }
}

int main(void)
{
    int i;
    while (cin >> identifier >> n >> cell) {
        for (i = 0; i < n; i++)
            cell[i] -= '0';
        for (i = 0; i < 8; i++) {
            automata[i] = identifier % 2;
            identifier /= 2;
        }

        possible = 0;
        for (i = 0; i < 8; i++) {
            if (automata[i] == cell[1]) {
                precell[0] = (i / 4) % 2;
                precell[1] = (i / 2) % 2;
                precell[2] = i % 2;
                backTracking(2);
                if (possible)
                    break;
            }
        }

        if (possible)
            cout << "REACHABLE\n";
        else
            cout << "GARDEN OF EDEN\n";
    }
}