# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

import sys

l = []
p = []
for i in sys.stdin:
	l.append(i.rstrip('\n'))

for i in l:
	a = []
	b = 0
	c = len(i) - 1
	for j in range(c + 1):
		if j == c:
			if i[j] == ' ':
				a.append(i[b:].rstrip(' '))
			elif i[j] == '\t':
				a.append(i[b:].rstrip('\t'))
			else:
				a.append(i[b:])
		else:
			if i[j] == ' ':
				a.append(i[b:j+1].rstrip(' '))
				b = j + 1
			if i[j] == '\t':
				a.append(i[b:j+1].rstrip('\t'))
				b = j+1
		
	result = [0,0]
	for i in a:
		if not i:
			continue
		result[1] = result[1] + 1
		result[0] = result[0] + len(i)
	
	print(*result)
