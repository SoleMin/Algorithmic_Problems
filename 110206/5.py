# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
from collections import deque

def bfs(graph,start,dis):
	queue=deque([start])
	visited=[start]
	while queue:
		v=queue.popleft()
		
		for i in graph[v]:
			if i not in visited:
				visited.append(i)
				queue.append(i)
				dis[i]=dis[v]+1
				
	return dis
				
n=int(input())
for i in range(n):
	s={}
	ans=[]
	P,N=map(int,input().split())
	for j in range(P):
		names,se=input().split(": ")
		name=list(names.split("., "))
		
		for dot in range(len(name)-1):
			name[dot]=name[dot]+'.'
			
		for n in name:
			rename=name.copy()
			if n in s.keys():
				temp=s[n]
				rename.extend(temp)
				rename.remove(n)
				s[n]=rename

			else:
				rename.remove(n)
				s[n]=rename

	for j in range(N):
		ans.append(input())
	
	dis=dict.fromkeys(s.keys(),0)
	if 'Erdos, P.' not in dis.keys():
		num=dis
	else:
		num=bfs(s,'Erdos, P.',dis)
	
	print("Scenario",i+1)
	for enum in ans:
		if enum!='Erdos, P.' and num[enum]==0:
			print(enum,"infinity")
		else:
			print(enum,num[enum])
	

