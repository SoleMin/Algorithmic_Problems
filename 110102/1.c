#include <stdio.h>
int main() {
	int row, col, i, j, star_cout=0, field;
	
	for(field = 1;;field++){
		scanf("%d %d", &row, &col);
		if(row == 0 && col == 0){
			break;
		}
		char** mine_Array = malloc(sizeof(char*) * row);
		for(i=0;i<row;i++){
			mine_Array[i] = malloc(sizeof(char)*col);
		}
		for(i=0;i<row;i++){
			scanf("%s", mine_Array[i]);
		}
	
		for(i=0;i<row;i++){
			for(j=0;j<col;j++){
				star_cout = 0;
				if(mine_Array[i][j]=='.'){
					if(i>0 && j>0 && mine_Array[i-1][j-1]=='*')
						star_cout++;
					if(i>0 && mine_Array[i-1][j]=='*')
						star_cout++;
					if(i>0 && j<(col-1) && mine_Array[i-1][j+1]=='*')
						star_cout++;
					if(j>0 && mine_Array[i][j-1]=='*')
						star_cout++;
					if(j<(col-1) && mine_Array[i][j+1]=='*')
						star_cout++;
					if(i<(row-1) && mine_Array[i+1][j-1]=='*')
						star_cout++;
					if(i<(row-1) && mine_Array[i+1][j]=='*')
						star_cout++;
					if(i<(row-1) && j<(col-1) && mine_Array[i+1][j+1]=='*')
						star_cout++;
					mine_Array[i][j] = star_cout + 48;
				}
			}
		}
		printf("Field #%d:\n", field);
		for(i=0;i<row;i++)
			printf("%s\n", mine_Array[i]);
		printf("\n");
		
		free(mine_Array);
	}
	
	return 0;
}

