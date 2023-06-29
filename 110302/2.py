def search(row, col, name, matrix):
	direction = [[0,1], [1,1], [1,0], [1,-1], [0,-1], [-1,-1],[-1,0],[-1,1]]
	for i in range(row):
		for j in range(col):
			if name[0] == matrix[i][j]:
				if len(name) == 1:
					print(i+1, j+1)
					return
				check = False
				for a,b in direction:
					x, y = i, j
					for idx in range(1, len(name)):
						x += a
						y += b
						if x >= row or y >= col:
							break
						if matrix[x][y] != name[idx]:
							break
						if idx == len(name) - 1:
							check = True
					if check:
						print(i+1, j+1)
						return
				
				
T = int(input())

for _ in range(T):
	input()
	row, col = map(int, input().split())
	matrix = []
	for __ in range(row):
		matrix.append(list(input().lower()))
	K = int(input())
	names = []
	for  __ in range(K):
		names.append(list(input().lower()))
	for name in names:
		search(row, col, name, matrix)
	print()
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				