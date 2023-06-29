# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
n, m = list(map(int,input().split()))
t = 1
while (n != 0) & (m != 0):
	
	l = []
	p = []
	for _ in range(n):
		l.append(input())
		p.append([False]*m)
	
	for i in range(n):
		for j in range(m):
			if l[i][j] == '*':
				p[i][j] = '*'
				continue
			
			cnt = 0
			for x in range(i-1,i+2):
				if x < 0:
					continue
				if x > n-1:
					continue
				
				for y in range(j-1, j+2):
					if y < 0:
						continue
					if y > m-1:
						continue
					if l[x][y] == '*':
						cnt += 1
				
			p[i][j] = cnt
		
	print('Field #{0}:'.format(t))
	for i in p:
		a = ''
		for j in i:
			a = a + str(j)
		print(a)
	
	print('')
	n, m = list(map(int, input().split()))
	t += 1
				
					