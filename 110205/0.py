# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys

x = int(input())
t = [2,3,4,5,6,7,8,9,10,'Jack','Queen','King','Ace']
shape = ['Clubs','Diamonds','Hearts','Spades']
n = input()
for v in range(x):

	n = int(input())
	l = []
	for _ in range(n):
		l.append(list(map(int,input().split())))
	
	p = [i for i in range(1,53)]
	
	k = sys.stdin.readline().rstrip('\n')
	while k != '':
		k = int(k)
		f = [False] * 52
		for j in range(52):
			f[j] = p[l[k-1][j]-1]
		p = f
		k = sys.stdin.readline().rstrip('\n')
	
	for i in p:
		if (i-1) // 13 == 4:
			a = shape[3]
		else:
			a = shape[(i-1) // 13]
		b = t[(i-1) % 13]
		print('{0} of {1}'.format(b,a))
	
	if v != x-1:
		print()