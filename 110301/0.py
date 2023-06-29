# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys

l = ['QWERTYUIOP[]\\','ASDFGHJKL;','ZXCVBNM,./','1234567890-=']
for i in sys.stdin:
	res = ''
	for j in i.upper():
		if j == ' ':
			res += ' '
			continue
		
		for k in l:
			h = 0
			for m in range(len(k)):
				if j == k[m]:
					res += k[m-1]
					h = 1
					break
				
			if h == 1:
				break
	
	print(res)
				
	
	
