N=int(input())
inputlist=[]
for _ in range(N):
	inputlist.append(input().split())
	
for In in inputlist:
	poslist=[]
	housecount=int(In[0])
	for i in range(1,housecount+1):
		poslist.append(int(In[i]))
	poslist.sort()
	zitohouse=poslist[housecount//2]
	Sum=0
	for j in poslist:
		Sum+=(abs(j-zitohouse))
	print(Sum)
	

