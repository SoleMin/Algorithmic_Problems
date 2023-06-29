# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
while(True):
	try:
		num=list(map(int,input().split()))
		n=num[0]
		num=num[1:]
		num_ans=[]
		
		if n==1:
			print("Jolly")
			
		for i in range(n-1):
			num_ans.append(abs(num[i]-num[i+1]))
			num_ans.sort()
	except EOFError: break
	
	else:
		for i in range(n-1):
			j=i+1
			if num_ans[i]!=j:
				print("Not jolly")
				break
			elif j==n-1:
				print("Jolly")