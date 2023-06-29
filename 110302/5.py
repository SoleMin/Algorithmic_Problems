N=int(input())
start=input()
num=0
def nomalization(a):
	if ord(a)<91:
		return chr(ord(a)+32)
	else:
		return chr(ord(a))	
	
def findindex(wordlist,a):#앞글자 찾기에서 인덱스 반환
	posfind=[]
	Wlist=wordlist.copy()
	for i in wordlist:
		k=0
		for j in range(len(i)):
			if i[j]==a:
				posfind.append((wordlist.index(i),j))
	return posfind
def rangeindex(m,n,A,word):
	y,x=A
	#(동, 남, 서, 북)
	if n-x>=len(word):
		tmp=True
		for i in range(len(word)):
			if comparisonword(word[i],y,x+i,wordlist)==False:
				tmp=False
				break		
		if tmp:
			return True
		
	if m-y>=len(word):
		tmp=True
		for i in range(len(word)):
			if comparisonword(word[i],y+i,x,wordlist)==False:
				tmp=False
				break
		if tmp:
			return True
			
	if x+1>=len(word):
		tmp=True
		for i in range(len(word)):
			if comparisonword(word[i],y,x-i,wordlist)==False:
				tmp=False
				break
		if tmp:
			return True

	if y+1>=len(word):
		tmp=True
		for i in range(len(word)):
			if comparisonword(word[i],y-i,x,wordlist)==False:
				tmp=False
				break
		if tmp:
			return True
		
	if n-x>=len(word) and m-y>=len(word):
		tmp=True
		for i in range(len(word)):
			if comparisonword(word[i],y+i,x+i,wordlist)==False:
				tmp=False
				break
		if tmp:
			return True
			
	if n-x>=len(word) and y+1>=len(word):
		tmp=True
		for i in range(len(word)):
			if comparisonword(word[i],y-i,x+i,wordlist)==False:
				tmp=False
				break
		if tmp:
			return True
		
	if x+1>=len(word) and m-y>=len(word):
		tmp=True
		for i in range(len(word)):
			if comparisonword(word[i],y+i,x-i,wordlist)==False:
				tmp=False
				break
		if tmp:
			return True
		
	if x+1>=len(word) and y+1>=len(word):
		tmp=True
		for i in range(len(word)):
			if comparisonword(word[i],y-i,x-i,wordlist)==False:
				tmp=False
				break
		if tmp:
			return True

def comparisonword(w,y,x,wordlist):

	if wordlist[y][x]==w:
		return True
	else:
		return False
	
while num<N:
	
	m,n=map(int,input().split())
	wordlist=[]
	for _ in range(m):
		a=list(input())
		nlist=[]
		for i in a:
			nlist.append(nomalization(i))
		wordlist.append(nlist)

	findnum=int(input())
	checklist=[]
	try:
		while True:
			In=input()
			if In=='':
				break
			else:
				nelist=[]
				for i in In:
					nelist.append(nomalization(i))
				checklist.append(list(nelist))
	except:
		print('',end='')
	
	#main
	library={}
	i=0
	for word in checklist:
		findlist=findindex(wordlist,word[0])
		libfindlist=[]
		for find in findlist:
			SP=rangeindex(m,n,find,word)
			if SP==True:
				a,b=find
				libfindlist.append((a+1,b+1))
		libfindlist.sort()
		library[i]=libfindlist
		i+=1
	for i in library:
		x,y=library[i][0]
		print(x,y)
	print()
	num+=1

