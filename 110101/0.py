# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys
l = []
for i in sys.stdin:
	l.append(i.rstrip('\n').split(' '))
p = [False] * 1000001
	
for i in l:
	i = list(map(int,i))
	
	d = 0
	if i[0] > i[1]:
		max = i[0]
		min = i[1]
	else:
		max = i[1]
		min = i[0]
	
	max_num = 0
	for j in range(min,max+1):
		t = 1
		n = j
		while n != 1:
			if n % 2 == 0:
				n /= 2
				t += 1
			else:
				n = 3 * n + 1
				t += 1
			
		c = t
		if max_num < c:
			max_num = c
	
	print(i[0],i[1],max_num)

