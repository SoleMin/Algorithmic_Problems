#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#define MAXN 100
#define MAXE 1000
#define MAXLEN 32
#define MAXSIZE 10000

static int n, res;
static int init[4], fin[4], check[10][10][10][10];

void initialize() {
	int i, j, k, l;

	for (i=0; i<10; i++) {
		for (j=0; j<10; j++) {
			for (k=0; k<10; k++) {
				for (l=0; l<10; l++) {
					check[i][j][k][l] = 0;
				}
			}
		}
	}
}

void search() {
	int front, rear, res_check;
	int pi, pil, pir, pj, pjl, pjr, pk, pkl, pkr, pl, pll, plr;
	int qi[10001], qj[10001], qk[10001], ql[10001] ;

	front = 1;
	rear = 0;
	qi[0] = init[0];
	qj[0] = init[1];
	qk[0] = init[2];
	ql[0] = init[3];
	check[init[0]][init[1]][init[2]][init[3]] = 1;

	while (front>rear && check[fin[0]][fin[1]][fin[2]][fin[3]]==0) {
		pi = qi[rear];
		pj = qj[rear];
		pk = qk[rear];
		pl = ql[rear];
		res_check = check[pi][pj][pk][pl];
		rear++;

		if (pi==0) {
			pil = 9;
		}
		else {
			pil = pi-1;
		}
		pir = (pi+1)%10;
		if (pj==0) {
			pjl = 9;
		}
		else {
			pjl = pj-1;
		}
		pjr = (pj+1)%10;
		if (pk==0) {
			pkl = 9;
		}
		else {
			pkl = pk-1;
		}
		pkr = (pk+1)%10;
		if (pl==0) {
			pll = 9;
		}
		else {
			pll = pl-1;
		}
		plr = (pl+1)%10;

		if (check[pil][pj][pk][pl]==0) {
			check[pil][pj][pk][pl] = res_check+1;
			qi[front] = pil;
			qj[front] = pj;
			qk[front] = pk;
			ql[front] = pl;
			front++;
		}
		if (check[pir][pj][pk][pl]==0) {
			check[pir][pj][pk][pl] = res_check+1;
			qi[front] = pir;
			qj[front] = pj;
			qk[front] = pk;
			ql[front] = pl;
			front++;
		}
		if (check[pi][pjl][pk][pl]==0) {
			check[pi][pjl][pk][pl] = res_check+1;
			qi[front] = pi;
			qj[front] = pjl;
			qk[front] = pk;
			ql[front] = pl;
			front++;
		}
		if (check[pi][pjr][pk][pl]==0) {
			check[pi][pjr][pk][pl] = res_check+1;
			qi[front] = pi;
			qj[front] = pjr;
			qk[front] = pk;
			ql[front] = pl;
			front++;
		}
		if (check[pi][pj][pkl][pl]==0) {
			check[pi][pj][pkl][pl] = res_check+1;
			qi[front] = pi;
			qj[front] = pj;
			qk[front] = pkl;
			ql[front] = pl;
			front++;
		}
		if (check[pi][pj][pkr][pl]==0) {
			check[pi][pj][pkr][pl] = res_check+1;
			qi[front] = pi;
			qj[front] = pj;
			qk[front] = pkr;
			ql[front] = pl;
			front++;
		}
		if (check[pi][pj][pk][pll]==0) {
			check[pi][pj][pk][pll] = res_check+1;
			qi[front] = pi;
			qj[front] = pj;
			qk[front] = pk;
			ql[front] = pll;
			front++;
		}
		if (check[pi][pj][pk][plr]==0) {
			check[pi][pj][pk][plr] = res_check+1;
			qi[front] = pi;
			qj[front] = pj;
			qk[front] = pk;
			ql[front] = plr;
			front++;
		}
	}
	res = check[fin[0]][fin[1]][fin[2]][fin[3]];
}

int main(){ 
	int t, i, ti, tj, tk, tl;

	scanf("%d", &t);
	while (t--) {
		initialize();

		scanf("%d %d %d %d", &init[0], &init[1], &init[2], &init[3]);
		scanf("%d %d %d %d", &fin[0], &fin[1], &fin[2], &fin[3]);
		scanf("%d", &n);
		for (i=0; i<n; i++) {
			scanf("%d %d %d %d", &ti, &tj, &tk, &tl);
			check[ti][tj][tk][tl] = -1;
		}

		search();
		printf("%d\n", res-1);
	}
}