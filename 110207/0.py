# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys

x = int(input())
n = input()
for _ in range(x):
	team = [[0] * 3 for _ in range(100)]
	l = []
	n = sys.stdin.readline().rstrip('\n')
	
	while n != '':
		t = n.split(' ')
		l.append([int(t[0]), int(t[1]), int(t[2]), t[3]])
		n = sys.stdin.readline().rstrip('\n')
	
	team_list = []
	c_list = []
	for i in l:
		if i[3] == 'C':
			if [i[0],i[1]] in c_list:
				continue
			
			y = 0
			for j in l:
				if [i[0], i[1], 'C'] == [j[0], j[1], j[3]]:
					break
				if [j[0],j[1]] == [i[0],i[1]]:
					if j[3] == 'I':
						y += 1
			c_list.append([i[0],i[1]])
			team[i[0] - 1] = [team[i[0] - 1][0] + 1, team[i[0] - 1][1] + i[2] + y * 20]
			team_list.append(i[0])
		else:
			team_list.append(i[0])
	
	team_list = list(set(team_list))
	
	res = []
	for i in team_list:
		res.append([i, team[i-1][0], team[i-1][1]])

	result = [res[0]]
	for i in res: #랭킹 순서 만들기
		h = 1
		for j in range(len(result)):
			if i[1] > result[j][1]:
				result.insert(j,i)
				h = 0
				break
			elif i[1] == result[j][1]:
				
				if i[2] < result[j][2]:
					result.insert(j,i)
					h = 0
					break
				elif i[2] == result[j][2]:
					
					if i[0] < result[j][0]:
						result.insert(j,i)
						h = 0
						break
					elif i[0] == result[j][0]:
						h = 0
						break
					else:
						continue
						
				else:
					continue
			else:
				continue
		
		if h == 1:
			result.append(i)

	for i in result:
		print(*i)
	print()