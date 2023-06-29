firstlist=['Q','W','E','R','T','Y','U','I','O','P','[',']','\\']
secondlist=['A','S','D','F','G','H','J','K','L',';',"'",'\n']
thirdlist=['Z','X','C','V','B','N','M',',','.','/']
zerolist=['`','1','2','3','4','5','6','7','8','9','0','-','=']

Inputlist=[]
try:
	while True:
		A=input()
		if A==' ':
			break
		else:
			Inputlist.append(A)
except:
	print('',end='')


def number(In):
	if In==' ':
		return (3,0)
	elif In in firstlist:
		return (0,firstlist.index(In)-1)
	elif In in secondlist:
		return (1,secondlist.index(In)-1)
	elif In in thirdlist:
		return (2,thirdlist.index(In)-1)
	elif In in zerolist:
		return (-1,zerolist.index(In)-1)
	else:
		return (0,0)
def out(In):
	a,b=In
	if a==0:
		return firstlist[b]
	elif a==1:
		return secondlist[b]
	elif a==2:
		return thirdlist[b]
	elif a==3:
		return ' '
	elif a==-1:
		return zerolist[b]
	else:
		return ' '
	
for i in Inputlist:
	for j in i:
		A=number(j)
		print(out(A),end='')
	print()

