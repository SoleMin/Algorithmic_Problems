#include <stdio.h>
#define MAXN 32
static int n, identifier, possible;
static char automata[8], precell[MAXN], cell[MAXN + 1];
void back(int a) {
    int i;
    if (a == n - 1) {
        if (automata[precell[a - 1] * 4 + precell[a] * 2 + precell[0]] == cell[a] &&
            automata[precell[a] * 4 + precell[0] * 2 + precell[1]] == cell[0])
            possible = 1;
        return;
    }
    for (i = precell[a - 1] * 4 + precell[a] * 2; i <= precell[a - 1] * 4 + precell[a] * 2 + 1; i++) {
        if (automata[i] == cell[a]) {
            precell[a + 1] = i % 2;
            back(a + 1);
            if (possible) break;
        }
    }
}
void main(void)
{
    int i;
    while (1) {
        char input[100] = { '\0', };
        gets(input);
        fflush(stdin);
        if (input[0] == '\0') return 0;
        char num[100] = { '\0', };
        char ident[100] = { '\0', };
        for (i = 0; i < 100; i++) {
            if (input[i] == ' ') break;
            num[i] = input[i];
        } identifier = atoi(num); int j;
        for (j = i + 1; j < 100; j++) {
            if (input[j] == ' ') break;
            ident[j - i - 1] = input[j];
        } n = atoi(ident);
        for (i = j + 1; input[i] != '\0'; i++)
            cell[i - j - 1] = input[i];
        cell[i - j - 1] = '\0';
        for (i = 0; i < n; i++) cell[i] -= '0';
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
                back(2);
                if (possible) break;
            }
        }
        if (possible)
            printf("REACHABLE\n");
        else
            printf("GARDEN OF EDEN\n");
    }
}