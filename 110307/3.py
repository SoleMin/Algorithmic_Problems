from collections import deque
inputlist=[]
while True:
	A=input()
	if A=='':
		break
	else:
		inputlist.append(A)		
Qlist=[]
try:
	while True:
		B=input()
		if B=='':
			break
		else:
			Qlist.append(B)
except:
	print('',end='')
QList=[]
for i in Qlist:
	a,b=i.split()
	QList.append((a,b))

def doublelit(word1,word2):
	count=0
	if len(word1)==len(word2):
		for i in range(0,len(word1)):
			if word1[i]==word2[i]:
				continue
			else:
				count+=1
		if count==1:
			return True
		else:
			return False
	else:
		return False
# doublelitgraph를 만들어야 한다. 왜냐 bfs를 쓸거거든 그래서 end랑 비교해서 1차이나면 stop하고 해당 루트를 출력하며 될거같기때문
graph={}
for i in inputlist:
	graph[i]=[]
	for j in inputlist:
		if doublelit(i,j):
			graph[i].append(j)
			
def bfs(graph,start,end):
	queue=deque([(start,start)])
	visit={}
	while queue:
		node,tmp=queue.popleft()
		if node not in visit:
			visit[node]=tmp
			for i in graph[node]:
				queue.append((i,node))
		if node==end:
			return visit
	return visit

for j in QList:
	startword,endword=j
	rootdict=bfs(graph,startword,endword)
	if len(rootdict)==1:
		print('No solution.')
		print()
	else:
		node=endword
		outputlist=[]
		while node!=startword:
			outputlist.append(node)
			node=rootdict[node]
		outputlist.append(node)
		for t in range(len(outputlist)-1,-1,-1):
			print(outputlist[t])
		print()
		










