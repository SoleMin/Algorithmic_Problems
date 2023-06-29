#include <stdio.h>
#include <algorithm>
using namespace std;
int main() {
    int n, k,i,j;
    while (scanf("%d %d", &n, &k) == 2) {
        if (n == 0 && k == 0)
            break;
       
        int row[20] = {}, row1[20] = {};
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++)
                if ((i + j) % 2)
                    row[(i + j) / 2]++;
                else
                    row1[(i + j) / 2]++;
        }
        sort(row, row + n - 1);
        sort(row1, row1 + n);
        int sp[20][20] = {};
        int sp1[20][20] = {};
        sp[0][0] = 1, sp[0][1] = row[0];
        sp1[0][0] = 1, sp1[0][1] = row1[0];
        for (i = 1; i < n - 1; i++) {
            sp[i][0] = 1;
            for (j = 1; j <= row[i]; j++) 
                sp[i][j] = sp[i - 1][j] + sp[i - 1][j - 1] * (row[i] - (j - 1));
            
            }
        for (i = 1; i < n; i++) {
            sp1[i][0] = 1;
            for (j = 1; j <= row1[i]; j++) 
                sp1[i][j] = sp1[i - 1][j] + sp1[i - 1][j - 1] * (row1[i] - (j - 1));
            
            }

        int a = 0;
        for (i = 0; i <= k; i++)
            a += sp[n - 2][i] * sp1[n - 1][k - i];
        printf("%d\n", a);
    }
    return 0;
}