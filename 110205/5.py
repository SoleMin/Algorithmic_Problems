import sys
N=int(input())
num=0
cardlist=[]
for i in range(4):
	for j in range(2,15):
		cardlist.append((i,j))
Shape={0:'Clubs',1:'Diamonds',2:'Hearts',3:'Spades'}
def outnumber(a):
	if a==14:
		return 'Ace'
	elif a==11:
		return 'Jack'
	elif a==12:
		return 'Queen'
	elif a==13:
		return 'King'
	else:
		return a
start=input()
while num<N:

	try:
		n=int(input())
	except:
		continue
	shupple_list=[]
	for _ in range(n):
		shupple_list.append(list(map(int,input().split())))
		
	shupple_num_list=[]
	while True:
		try:
			A=input()
			if A=='':
				break
			else:
				shupple_num_list.append(A)
		except:
			break
			
	Shupple_num_list=[]
	for sn in shupple_num_list:
		if sn=='':
			break
		else:
			Shupple_num_list.append(int(sn))
	
	new_list=cardlist.copy()
	
	for shupple_num in Shupple_num_list:
		new1_list=[]
		for i in shupple_list[shupple_num-1]:
			new1_list.append(new_list[i-1])
		new_list=new1_list.copy()
	
	for j in new_list:
		a,b=j
		print(f'{outnumber(b)} of {Shape[a]}')

	num+=1
	print()
	 