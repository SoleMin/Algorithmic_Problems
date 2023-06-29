# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean

n=int(input())

while n!=0:
	dic={1:1,2:2,3:2,4:3,5:3,6:4,7:4,8:4,9:5,10:5,11:5}
	
	i=12
	cnt=6
	jump=0
	if n<12:
		print(dic[n])
		n=int(input())
		continue
	while i<=n:
		if cnt in dic.keys():
			dic[i]=cnt
			jump=dic[cnt]
			i+=jump
		else:
			dic[i]=cnt
			i+=jump
		cnt+=1
	
	print(cnt-1)
	n=int(input())