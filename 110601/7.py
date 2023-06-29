# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

a,b=map(int,input().split())
while a!=0 and b!=0:
	fb=[1,2]
	ans=[]
	
	i=0
	if a==1:
		ans.append(1)
		ans.append(2)
	elif a==2:
		ans.append(2)
	
	while i<=b:
		i=fb[-1]+fb[-2]
		fb.append(i)
		
		if a<=i and i<=b:
			ans.append(i)
			
	print(len(ans))
	
	a,b=map(int,input().split())