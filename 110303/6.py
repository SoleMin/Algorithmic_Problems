try:
	Inputlist=[]
	while True:
		partlist=[]
		partlist.append(input())
		partlist.append(input())
		Inputlist.append(partlist)
except:
	print('',end='')
for i in Inputlist:
	comparelist=[]
	Ans=[]
	for k in i[1]:
		comparelist.append(k)
	for j in i[0]:
		if j in comparelist:
			Ans.append(j)
			comparelist.remove(j)
	Ans.sort()
	print(*Ans,sep='')
		
			
	
	