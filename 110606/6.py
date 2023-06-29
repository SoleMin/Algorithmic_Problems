import math
Inputlist=[]
try:
	while True:
		A=int(input())
		Inputlist.append(A)
except:

	top=max(Inputlist)
	
	dp=[0]+[2**x-1 for x in range(1,top+1)]
	ddp=[0,1,3,5]
	
	for i in range(4,top+1):
		ddp.append(min([ddp[a]*2+dp[i-a]for a in range(1,i)]))
		
	for Input in Inputlist:
		print(ddp[Input])
	
# 	def recu(n,r):
# 		k=n-round(math.sqrt(2*n+1))+1
# 		if n==1:
# 			return 1
# 		if r==3:
# 			return pow(2,n)-1
# 		return recu(k,r)*2+recu(n-k,r-1)

# 	for Input in Inputlist:
# 		print(recu(Input,4))
	