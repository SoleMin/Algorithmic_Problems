# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys

l = []

for i in sys.stdin:
	l.append(i.rstrip('\n'))

for i in range(0,len(l),2):
	a = l[i]
	b = '_'.join(l[i+1]).split('_')
	res = []

	for j in a:
		if j in b:
			res.append(j)
			b.remove(j)
	
	res.sort()
	for j in res:
		print(j,end='')
	print()
		