# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
n=int(input())

for i in range(n):
	days=int(input())
	leng=int(input())
	
	day=[]
	rest=[0]
	for i in range(leng):
		day.append(int(input()))
	
		for j in range(day[i],days+1,day[i]):
			if j%7-6==0 or j%7==0:
				continue
			else:
				rest.append(j)
				
	rest=set(rest)
	print(len(rest)-1)
		