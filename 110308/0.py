# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

import sys

l = []

for i in sys.stdin:
	l.append(i.rstrip('\n'))

l.append('')
#print(l)

k = 0
res = []
for i in range(len(l)):
	if l[i] == '':
		res.append(l[k:i])		
		k = i + 1 

#print(res)


k = 0
result = []
for i in res:
	x = ''
	for j in i:
		x += ' ' + j
	
	x = x[1:]
	
	
	#print('x : ', [x])
	while True:
		if len(x) < 72:
			print(x)
			break
		else:
			a = 72
			while True:
				if a == 0:
					h = 0
					for j in range(len(x)):
						if x[j] == ' ':
							print(x[:j])
							x = x[j:]
							x = x[1:]
							h = 1
							break
							
					if h == 1:
						break
				
				x = x + ' '
				if x[a] == ' ':
					print(x[:a])
					x = x[a:]
					x = x[1:]
					x = x[:-1]
					break
				else:
					a -= 1
					x = x[:-1]
			
	print()