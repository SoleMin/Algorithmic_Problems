# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys
field = 1

def isInside(a,b):
	return a >= 0 and a < col and b >= 0 and b < row

def increase(col, row):
	if isInside(col, row) and board[col][row] != -1:
		board[col][row] += 1
		


def makeMine(col, row):
	board[col][row] = -1
	
	for i in range(-1,2):
		for j in range(-1,2):
			increase(col + i, row+j)
		
def printAll(field):
	print(f"Field #{field}:")
	for i in range(col):
		for j in range(row):
			n = board[i][j]
			if n == -1:
				print("*", end='')
			else:
				print(f"{n}", end='')
		print("")
		
	
	
	
while True:
	data = []
	a,b = sys.stdin.readline().strip().split(' ')
	col = int(a)
	row = int(b)
	if row == 0 and col == 0:
		break
	data.append([sys.stdin.readline().strip() for i in range(col)])
	
	flatData = sum(data, [])
	board = [[0 for i in range(row)] for j in range(col)]
	
	for i in range(col):
		line = flatData[i]
		for j in range(row):
			now = line[j]
			if now == "*":
				makeMine(i, j)
				
	if field > 1:
		print("")
	
	printAll(field)
	field += 1
	