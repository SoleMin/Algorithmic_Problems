# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
while True:
	try:
		num=[1,2,5,13]
		n=int(input())
		if  n<=1000:
			for i in range(4,n+1):
				num.append(num[i-1]*2+num[i-2]+num[i-3])
			
		print(num[n])
		
	except EOFError: break
			