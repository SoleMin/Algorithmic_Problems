# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
while True:
	try:
		word=(input().split())
		
		wc=0
		fc=len(word)
		for i in range(fc):
			wc+=len(word[i])
		print(wc,fc)
	
	except EOFError: break