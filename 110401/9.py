# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
def quick_sort(s,e):
	global case
	if s<e:
		pivot = partition(s,e)
		quick_sort(s,pivot-1)
		quick_sort(pivot+1,e)
		
def swap(i,j):
	global case
	temp=case[i]
	case[i]=case[j]
	case[j]=temp
	
def partition(s,e):
	global case
	
	if s+1==e:
		if case[s]>case[e]:
			swap(s,e)
		return e
	
	m=(s+e)//2
	swap(s,m)
	pivot=case[s]
	i=s+1
	j=e
	
	while i<=j:
		while pivot<case[j] and j>0:
			j=j-1
		while pivot>case[i] and i<len(case)-1:
			i=i+1
		if i<=j:
			swap(i,j)
			i=i+1
			j=j-1
			
	case[s]=case[j]
	case[j]=pivot
	return j

num=int(input())

for i in range(num):
	case=list(map(int,input().split()))
	
	del case[0]
	quick_sort(0,len(case)-1)
	mid=len(case)//2
	vito=case[mid]
	sum=0
	for dis in case:
		if dis==vito:
			continue
		sum+=abs(dis-vito)
	print(sum)