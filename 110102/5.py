# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys
fieldNum = 1
while(1):
	n, m = map(int,sys.stdin.readline().split())
	if (n == 0 and m == 0):
		break
	field = [list(sys.stdin.readline().rstrip()) for _ in range(n)]
	
	dx = [1,1,-1,-1,0,0,1,-1]
	dy = [1,-1,1,-1,1,-1,0,0]
	
	for i in range(0, n):
		for j in range(0, m):
			if(field[i][j] == '*'):
				for k in range(0,8):
					nx = i + dx[k]
					ny = j + dy[k]
					if ( nx < 0 or ny < 0 or nx >= n or ny >= m ):
						continue
					if (field[nx][ny] == '*'):
						continue
					if(field[nx][ny] == '.'):
						field[nx][ny] = '1'
					else :
						field[nx][ny] = str(int(field[nx][ny]) + 1)
	
	for i in range(0,n):
		for j in range(0, m):
			if(field[i][j] == '.'):
				field[i][j] = '0'
	
	print("Field #%d:" % fieldNum )
	print("\n".join(["".join([str(i) for i in row]) for row in field]) + "\n")
	
	fieldNum += 1
					
	
