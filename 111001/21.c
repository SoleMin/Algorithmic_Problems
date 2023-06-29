#include <stdio.h>
#include <math.h>
#define MAXN 100
static int n, check[MAXN];
static double dot[MAXN][2], minval[MAXN], result;
void input(void) { int i;
    scanf("%d", &n);
    for (i = 0; i < n; i++) {
        scanf("%lf %lf", &dot[i][0], &dot[i][1]); }
}
double dist(int a, int b) {
    return sqrt(pow(dot[a][0] - dot[b][0], 2) +
                pow(dot[a][1] - dot[b][1], 2));
}


void solve(void) {
    int i, j, a;
    result = 0;
    for (i = 0; i < n; i++) {
        check[i] = 0;
    }
    check[0] = 1;
    for (i = 1; i < n; i++) {
        minval[i] = dist(0, i);
    }
    for (i = 0; i < n - 1; i++) {
        //(프림 알고리즘 구현)
        if (i == 0) {
            double min= 50.0;
            for (j = 1; j < n; j++) {
                if (min > minval[j]){
                    min = minval[j];
                    a = j;
                }
            }
            result = minval[a];
            check[a] = 1;
        } else {
            int k = 0;
            double min= 50.0;
            for (j = 0; j < n; j++) {
                if (check[j] == 1) {
                    for (k = 0; k < n; k++) {
                        if (min > dist(j, k) && check[k] == 0) {
                            min = dist(j, k);
                            a = k;
                        }
                    }
                }
            }
            result += min;
            check[a] = 1;
        }
    } }

int main(void) {
    int i, t;
    scanf("%d", &t);
    for (i = 0; i < t; i++) {
        input();
        solve();
        if (i > 0)
            printf("\n");
        printf("%0.2lf\n", result); }
}
