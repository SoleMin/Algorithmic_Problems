# -*- coding: utf-8 -*-
# UTF-8 encoding when using koreanimpo
import sys
l = []
for i in sys.stdin:
	l.append(list(map(int, i.rstrip('\n').split())))

for i in l:
	p = []
	
	for j in range(1,i[0]):
		p.append(abs(i[j] - i[j+1]))
	
	q = [i for i in range(1,i[0])]
	p.sort()
	q.sort()
	
	if p == q:
		print('Jolly')
	else:
		print('Not jolly')