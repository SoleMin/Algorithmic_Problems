# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
while(True):
	try:
		a = input()
		b = list(input())

		x = []
		for i in a:
			for j in b:
				if i == j:
					x.append(i)
					b.pop(b.index(j))
					break
					
		x.sort()
		
		g = ""
		for l in x:
			g += l + ""
			
		g.strip()
		
		print(g)
	except EOFError:
		break
	