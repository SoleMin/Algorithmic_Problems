# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
def c(num,cnt):
	while(num!=1):
		if(num%2!=0):
			num=num*3+1
			cnt+=1
		while(num%2==0):
			num//=2
			cnt+=1
	return cnt		

while(True):
	try:
		a,b = map(int,input().split())
		res=[]
		temp = a
		temp_2 = b
		
		if(a>b):
			a=b
			b=temp

		for i in range(a,b+1):
			cnt=1
			res.append(c(i,cnt))

		ans=max(res)
		print (temp,temp_2,ans)
		
	except EOFError: break