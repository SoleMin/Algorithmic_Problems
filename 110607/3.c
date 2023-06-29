#include<stdio.h>
struct {
    int n, f;
}A[4810];
int BinarySearch(int l, int r, int v) {
    int a;
    do {
        a = (l + r) / 2;
        if (A[a].n < v)    l = a + 1;
        else {
            if (A[a].n >= v && A[a - 1].n < v)
                return a;
            r = a - 1;
        }
    } while (l <= r);
}
int f(int n, int limit) {
    int i, f;
    if (n == 1)    return 1;
    i = BinarySearch(1, limit, n);
    i--;
    f = (n - A[i].n) / i + A[i].f;
    return f;
}
int main() {
    A[1].n = 1, A[1].f = 1;
    A[2].n = 2, A[2].f = 2;
    A[3].n = 6, A[3].f = 4;
    int i=0;
    for (i = 4; i < 4810; i++) {
        A[i].n = A[i - 1].n + f(i - 1, i - 1) * (i - 1);
        A[i].f = A[i - 1].f + (A[i].n - A[i - 1].n) / (i - 1);
    }
    while (1) {
        scanf("%d", &i);
        if (i == 0) {
            break;
        }
        printf("%d\n", f(i, 4810));
    }
    return 0;
}