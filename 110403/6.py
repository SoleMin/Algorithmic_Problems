# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
n=int(input())

for i in range(n):
	space_line=input()
	num=int(input())
	
	time=[]
	
	for j in range(num):
		time.append(int(input()))
	time.sort()
	
	result=0
	while num>=4:
		way1=time[1]+time[0]+time[num-1]+time[1]
		way2=time[num-1]+time[0]+time[num-2]+time[0]
		
		if(way1<way2):
			result+=way1
		else:
			result+=way2
			
		num-=2
		
	if num==3:
		result+=time[0]+time[1]+time[2]
		
	elif num==2:
		result+=time[1]
		
	else:
		result+=time[0]
		
	print(f'{result}\n')