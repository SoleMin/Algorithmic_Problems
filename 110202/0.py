# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
import sys

k = ['C','D','H','S']
n = ['T','J','Q','K','A']

def fo(x):
	b = 0
	for j in range(4):
		if x[1] == k[j]:
			b += j+1
	for j in range(5):
		if x[0] == n[j]:
			b += (10 + j) * 10
	if b < 5:
		b += int(x[0]) * 10
	return b

##########################################################################################
def rank(x):
	y = []
	z = []
	o = []
	g = [[2,3,4,5,14],[2,3,4,13,14], [2,3,12,13,14],[2,11,12,13,14]]
	for i in x:
		y.append(i // 10)
		z.append(i % 10)
	
	for i in range(4):
		o.append(y[i+1]-y[i])
		
	rank2 = y

	if (len(set(z)) == 1) and ((o == [1,1,1,1]) or (y in g)):
		rank1 = 8
		
		
	elif (o[:3] == [0,0,0]):
		rank1 = 7
		rank2 = y[:4]
	elif (o[1:] == [0,0,0]):
		rank1 = 7
		rank2 = y[1:]
		
		
	elif ((o[1] != 0) and (o[0] == 0) and (o[2:] == [0,0])):
		rank1 = 6
		rank2 = y[2:]
	elif ((o[2] !=0) and (o[:2] == [0,0]) and (o[-1] == 0)):
		rank1 = 6
		rank2 = y[:3]
		
		
	elif (len(set(z)) == 1):
		rank1 = 5
		
		
	elif ((o == [1,1,1,1]) or (y in g)):
		rank1 = 4
		
		
	elif (o[:2] == [0,0]):
		rank1 = 3
		rank2 = y[:3]
	elif (o[1:3] == [0,0]): 
		rank1 = 3
		rank2 = y[1:4]
	elif (o[2:] == [0,0]):
		rank1 = 3
		rank2 = y[2:]
		
		
	elif (o.count(0) == 2):
		rank1 = 2
		a = []
		b = []
		for i in y:
			if y.count(i) == 1:
				a.append(i)
			else:
				b.append(i)

		b.sort()
		rank2 = a + b
	
	
	elif (o.count(0) == 1):
		rank1 = 1
		a = []
		b = []
		for i in y:
			if y.count(i) == 1:
				a.append(i)
			else:
				b.append(i)
		a.sort()
		b.sort()
		rank2 = a + b
		
		
	else:
		rank1 = 0
	
	return rank1, rank2
	
		
		
		
		
#########################################################################################
l = []
for i in sys.stdin:
	l.append(list(map(fo, i.rstrip('\n').split())))

for i in l:
	bl = []
	wh = []
	for j in range(5):
		bl.append(i[j])
		wh.append(i[j+5])
		
	bl.sort()
	wh.sort()
	
	b1, b2 = rank(bl)
	w1, w2 = rank(wh)

	if b1 > w1:
		print('Black wins.')
	elif b1 < w1:
		print('White wins.')
	else:
		for j in range(-1,-(len(b2)+1),-1):
			if b2[j] > w2[j]:
				print('Black wins.')
				h = 1
				break
			elif b2[j] < w2[j]:
				print('White wins.')
				h = 1
				break
			else:
				h = 0
				continue
		if h == 0:
			print('Tie.')