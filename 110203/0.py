# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
n = int(input())

for _ in range(n):
	d = int(input())
	p = int(input())
	l = []
	for _ in range(p):
		l.append(int(input()))
	
	result = []
	
	a = [i for i in range(6,d+1,7)]
	b = [i for i in range(7,d+1,7)]
	a = set(a + b)
	for i in l:
		n = 1
		while True:
			if i * n > d:
				break
			else:
				result.append(n*i)
				n += 1
				
	result = set(result)
	result = result - a
	print(len(result))