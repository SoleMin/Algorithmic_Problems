from collections import deque
import math
Num= int(input())
n=0

# def bfs(graph,start_node):
# 	visit=list()
# 	queue=deque()
# 	queue.append(start_node)
# 	while queue:
# 		node=queue.popleft()
# 		if node not in visit:
# 			visit.append(node)
# 			queue.extend(graph[node])
# 	return visit

def dfs_search(graph,start_node,countlist):
	visit=list()
	queue=list()
	queue.append(start_node)
	
	while queue:
		node=queue.pop()
		
		if node != 'Erdos, P.':
			comparelist=[]
			for i in graph[node]:
				comparelist.append(countlist[i])
			countlist[node]=min(comparelist)+1
		
		if node not in visit:
			visit.append(node)
			queue.extend(graph[node])
		

while n<Num:
	n+=1
	print(f'Scenario {n}')
	P,N=map(int,input().split())
	graph={}
	for _ in range(P):
		nonmun=input().split(':')
		name=nonmun[0].split('., ')
		for j in range(len(name)-2,-1,-1):
			name[j]=name[j]+'.'
		for i in name:
			k=[]
			if i not in graph:
				k.extend(name)
				graph[i]=k
			else:
				for k in name:
					graph[i].append(k)
		for t in graph:
			graph[t]=list(dict.fromkeys(graph[t]))
		for t in graph:
			if t in graph[t]:
				graph[t].remove(t)
				
	# Erdos_list=bfs(graph,'Erdos, P.') # 상관있는것과 없는거 분리
	###############################그래프 만들기############################
	count_Enum={}
	for p in graph:
		if p=='Erdos, P.':
			count_Enum[p]=0
		else:
			count_Enum[p]=float('inf')
	
	
	
	

	for _ in range(N):
		professor=input()
		dfs_search(graph,professor,count_Enum)
		if count_Enum[professor]==float('inf'):
			Enum='infinity'
		else:
			Enum=count_Enum[professor]
			
		print(professor, Enum)
		
		

	