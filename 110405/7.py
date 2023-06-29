# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
n=int(input())

for i in range(n):
	space=input()
	
	num=int(input())
	all=[]
	day=0
	for j in range(num):
		d,f=map(int,input().split())
		fd=round(f/d,3)
		all.append((j+1,fd))
		
	all.sort(reverse=True, key=lambda x:x[1])
	for ans in all:
		print(ans[0],end=' ')
		
	print('\n')
		