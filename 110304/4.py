N=int(input())
start=input()
num=0
codelinenum=(3,5,5,3,5,4,3,4,3)
code='the quick brown fox jumps over the lazy dog'
while num<N:
	try:
		Inputlist=[]
		while True:
			A=input()
			if A=='':
				break
			else:
				Inputlist.append(A)
	except:
		print('',end='')
	codenamelist=[]
	alphadict={}
	for i in Inputlist:
		wordlist=i.split()
		codelist=[]
		for j in wordlist:
			codelist.append(len(j))
		codename=tuple(codelist)
		#일단 두개라고 codename이 같은게 없다고 가정하고 문제풀이
		testcase=[]
		if codename==codelinenum:
			testcase.append(i)
		
		for j in testcase:
			case=True
			for a in range(len(j)):
				if j[a] not in alphadict:
					alphadict[j[a]]=code[a]
				else:
					if not alphadict[j[a]]==code[a]:
						case=False
			if case:
				break
			
	#dict 만들었죠?
	if alphadict=={}:
		print('No solution.')
	elif case==False:
		print('No solution.')
	else:
		for i in Inputlist:
			Anslist=[]
			solution=True
			for j in i:
				if j in alphadict:
					Anslist.append(alphadict[j])
				else:
					solution=False
			if solution:
				print(*Anslist,sep='')
			else:
				print('No solution.')
				
	print()
	num+=1

			