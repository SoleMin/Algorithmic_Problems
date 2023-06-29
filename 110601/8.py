Inputlist=[]
while True:

	a,b=map(int,input().split())
	if a==0 and b==0:
		break
	else:
			Inputlist.append((a,b))
			

def calculate():
	global F0
	global F1
	global Tmp
	# print(F0,F1)
	Tmp=[]
	Len=len(F1)
	for _ in range(Len):
		Tmp.append([0])
	for i in range(Len):
		Tmp[i][0]=F0[i][0]+F1[i][0]
		if Tmp[i][0]>9 and i==len(Tmp)-1:
			Tmp.append([0])
			F1.append([0])
	F0=F1.copy()
	for j in range(len(Tmp)-1):
		if Tmp[j][0]>9:
			Tmp[j][0]-=10
			Tmp[j+1][0]+=1
	F1=Tmp.copy()
	return Tmp

for Input in Inputlist:
	a,b=Input
	L=0
	count=0
	F0=[[0]]
	F1=[[1]]
	while True:
		tmpnum=0
		Fn=calculate()
		# print(Tmp)
		A=''
		for j in range(len(Fn)-1,-1,-1):
			A+=str(Fn[j][0])
		tmpnum=int(A)
		
# 		print(tmpnum)
		if tmpnum>=a and tmpnum<=b:
			count+=1
			# print(count)
		elif tmpnum>b:
			break
		L=len(F1)
	print(count)
