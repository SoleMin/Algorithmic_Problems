#include <stdio.h>
int main() {
	int num;
	int m,n,k,l,b;
	char line;
	int i,j;
	char grid[50][50];
	char search[20][100];
	int result[20][2]={0, };
	int temp = 0;
	int temp1 = 0;
	int cnt=0;
	int cnt1,cnt2;
	
	scanf("%d", &num);
	while(num != 0){
		scanf("%c", &line);
		scanf("%d %d", &m,&n);
		scanf("%c", &line);
		for(i=0;i<m;i++){
			for(j=0;j<n+1;j++){
				scanf("%c", &grid[i][j]);
				if(grid[i][j]>96)
					grid[i][j] -= 32;
				if(grid[i][j] == '\n'){
					grid[i][j] = '\0';
				}
			}
		}
		scanf("%d", &k);
		scanf("%c", &line);
		for(i=0;i<k;i++){
			for(j=0;j<100;j++){
				scanf("%c", &search[i][j]);
				if(search[i][j] == '\n'){
					search[i][j] ='\0';
					break;
				}
				if(search[i][j]>96)
					search[i][j] -= 32;
			}
		}
		for(l=0;l<k;l++){
			for(i=0;i<m;i++){
				for(j=0;j<n;j++){
					if(search[l][0] == grid[i][j]){
						int y = j;
						int d =1;
						for(b=i+1;b<m;b++){
							if(search[l][d] == grid[b][y]){
								d++;
								if(b==m-1){
									if(search[l][d] == '\0'){
										if(result[l][0] != 0)
											break;
										result[l][0]=i+1;
										result[l][1]=j+1;
										break;
									}
								}
							}
							else{
								if(search[l][d] == '\0'){
									if(result[l][0] != 0)
											break;
									result[l][0]=i+1;
									result[l][1]=j+1;
									break;
								}
								else
									break;
							}
						} // 밑
						d=1;
						y=j+1;
						for(b=i+1;b<m;b++){
							if(search[l][d] == grid[b][y]){
								d++;
								y++;
								if(b==m-1){
									if(search[l][d] == '\0'){
										if(result[l][0] != 0)
											break;
										result[l][0]=i+1;
										result[l][1]=j+1;
										break;
									}
								}
							}
							else{
								if(search[l][d] == '\0'){
									if(result[l][0] != 0)
											break;
									result[l][0]=i+1;
									result[l][1]=j+1;
									break;
								}
								else
									break;
							}
						}// 밑 오른쪽 대각선
						d=1;
						y=j-1;
						for(b=i+1;b<m;b++){
							if(search[l][d] == grid[b][y]){
								d++;
								y--;
								if(b==m-1){
									if(search[l][d] == '\0'){
										if(result[l][0] != 0)
											break;
										result[l][0]=i+1;
										result[l][1]=j+1;
										break;
									}
								}
							}
							else{
								if(search[l][d] == '\0'){
									if(result[l][0] != 0)
											break;
									result[l][0]=i+1;
									result[l][1]=j+1;
									break;
								}
								else
									break;
							}
						}// 밑 왼쪽 대각선
						d=1;
						y=j;
						for(b=i-1;b>=0;b--){
							if(search[l][d] == grid[b][y]){
								d++;
								if(b==0){
									if(search[l][d] == '\0'){
										if(result[l][0] != 0)
											break;
										result[l][0]=i+1;
										result[l][1]=j+1;
										break;
									}
								}
							}
							else{
								if(search[l][d] == '\0'){
									if(result[l][0] != 0)
											break;
									result[l][0]=i+1;
									result[l][1]=j+1;
									break;
								}
								else
									break;
							}
						}// 위
						d=1;
						y=j+1;
						for(b=i-1;b>=0;b--){
							if(search[l][d] == grid[b][y]){
								d++;
								y++;
								if(b==0){
									if(search[l][d] == '\0'){
										if(result[l][0] != 0)
											break;
										result[l][0]=i+1;
										result[l][1]=j+1;
										break;
									}
								}
							}
							else{
								if(search[l][d] == '\0'){
									if(result[l][0] != 0)
											break;
									result[l][0]=i+1;
									result[l][1]=j+1;
									break;
								}
								else
									break;
							}
						}// 위 오른쪽 대각선
						d=1;
						y=j-1;
						for(b=i-1;b>=0;b--){
							if(search[l][d] == grid[b][y]){
								d++;
								y--;
								if(b==0){
									if(search[l][d] == '\0'){
										if(result[l][0] != 0)
											break;
										result[l][0]=i+1;
										result[l][1]=j+1;
										break;
									}
								}
							}
							else{
								if(search[l][d] == '\0'){
									if(result[l][0] != 0)
											break;
									result[l][0]=i+1;
									result[l][1]=j+1;
									break;
								}
								else
									break;
							}
						}// 위 왼쪽 대각선
						d=1;
						b=i;
						for(y=j+1;y<n;y++){
							if(search[l][d] == grid[b][y]){
								d++;
								if(y==n-1){
									if(search[l][d] == '\0'){
										if(result[l][0] != 0)
											break;
										result[l][0]=i+1;
										result[l][1]=j+1;
										break;
									}
								}
							}
							else{
								if(search[l][d] == '\0'){
									if(result[l][0] != 0)
											break;
									result[l][0]=i+1;
									result[l][1]=j+1;
									break;
								}
								else
									break;
							}
						}// 오른쪽
						d=1;
						b=i;
						for(y=j-1;y>=0;y--){
							if(search[l][d] == grid[b][y]){
								d++;
								if(y==0){
									if(search[l][d] == '\0'){
										if(result[l][0] != 0)
											break;
										result[l][0]=i+1;
										result[l][1]=j+1;
										break;
									}
								}
							}
							else{
								if(search[l][d] == '\0'){
									if(result[l][0] != 0)
											break;
									result[l][0]=i+1;
									result[l][1]=j+1;
									break;
								}
								else
									break;
							}
						}// 왼쪽
					}
				}
			}
		}
		for(i=0;i<k;i++){
				printf("%d %d\n", result[i][0], result[i][1]);
		}
		printf("\n");
		num--;
		for(i=0;i<50;i++){
			for(j=0;j<50;j++){
				grid[i][j] = '\0';
			}
		}
		for(i=0;i<20;i++){
			for(j=0;j<100;j++){
				search[i][j] ='\0';
			}
		}
		for(i=0;i<20;i++){
			for(j=0;j<2;j++){
				result[i][j] = 0;
			}
		}
	}
}
