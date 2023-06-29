# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import copy
def f(n):
	return n.rstrip('.')
	
n = int(input())
for q in range(n):
	n, p = map(int, input().split())
	l = []
	o = []
	dict_1 = {}
	for i in range(n):
		m = list(map(f, input().split(':')[0].split('., ')))
		l.append(m)
		for j in m:
			dict_1[j] = 0
		
	for i in l:
		for j in i:
			if 'Erdos, P' in i:
				dict_1[j] = 1
			else:
				if dict_1[j] == 1:
					continue
				else:
					dict_1[j] = 0	
	
	while True: 
		z = copy.deepcopy(dict_1)
		for i in l:
			b = [False] * len(i)
			for j in range(len(i)):
				b[j] = dict_1[i[j]]

			if 0 in b:
				if [0] * len(b) != b:
					for j in range(len(i)):
						if b[j] == 0:
							dict_1[i[j]] = max(b) + 1
		
		if z == dict_1:
			break
	
	for i in range(p):
		o.append(input())
	
	print('Scenario',q+1)
	for i in range(p):
		if dict_1[o[i].rstrip('.')] == 0:
			print(o[i], 'infinity')
		else:
			print(o[i],dict_1[o[i].rstrip('.')])
		