# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

import sys

n = int(input())
l = input()
for _ in range(n):
	d = 'the quick brown fox jumps over the lazy dog'
	d_list = ' '.join(d).split(' ')
	d_len = []
	for i in d_list:
		d_len.append(d.count(i))
	
	l = []
	while True:
		a = sys.stdin.readline().rstrip('\n')
		if a == '':
			break
			
		l.append(a)
	
	a = 0
	can = 0
	for i in l:
		if (len(i) == len(d)):
			i_len = []
			for j in ' '.join(i).split(' '):
				i_len.append(i.count(j))
			
			if i_len == d_len:
				can = 1
				break
		a += 1
	
	if can == 0:
		print('No solution.')
	else:
		for i in range(len(l)):
			if a != i:
				for j in l[i]:
					print(d[l[a].index(j)], end='')
			else:
				print(d, end='')
				
			print()
		
	print()
	