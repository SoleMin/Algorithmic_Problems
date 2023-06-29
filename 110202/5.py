# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
def get_value(x):
	return x//10

def get_suit(x):
	return x%10

def encode_card(card):
	result=0
	
	card_en=list(card)
	
	if card_en[0]=='T':
		result=100
	elif card_en[0]=='J':
		result=110
	elif card_en[0]=='Q':
		result=120
	elif card_en[0]=='K':
		result=130
	elif card_en[0]=='A':
		result=140
	else:
		result=(ord(card_en[0])-ord('0'))*10
		
	if card_en[1]=='H':
		result+=1
	elif card_en[1]=='D':
		result+=2
	elif card_en[1]=='S':
		result+=3
	elif card_en[1]=='C':
		result+=4
		
	return result

def get_hand(hand):
	card=[]
	value=[]
	suit=[]
	two=[]
	cnt={}
	result=0
	
	for i in range(1,6):
		card.append(encode_card(hand[i]))
		
	card.sort()
	
	for i in range(5):
		value.append(get_value(card[i]))
		suit.append(get_suit(card[i]))
	
	for x in value:
		if str(x) in cnt:
			cnt[str(x)]+=1
		else:
			cnt[str(x)]=1
	
	if ((value[0]+1==value[1] and value[0]+2==value[2] and value[0]+3==value[3] and value[0]+4==value[4]) and (suit[0]==suit[1] and suit[0]==suit[2] and suit[0]==suit[3] and suit[0]==suit[4])):
		result=800
		result+=int(max(cnt.keys()))
		
	elif (max(cnt.values())==4):
		result=700
		for key,value in cnt.items():
			if value==4:
				result+=int(key)
				
	elif ((max(cnt.values())==3) and 2 in cnt.values()):
		result=600
		for key,value in cnt.items():
			if value==3:
				result+=int(key)
				
	elif(suit[0]==suit[1] and suit[0]==suit[2] and suit[0]==suit[3] and suit[0]==suit[4]):
		result=list(map(int,cnt.keys()))
		result.append(500)
		
	elif(value[0]+1==value[1] and value[0]+2==value[2] and value[0]+3==value[3] and value[0]+4==value[4]):
		result=400
		result+=int(max(cnt.keys()))
		
	elif(max(cnt.values())==3):
		result=300
		for key,value in cnt.items():
			if value==3:
				result+=int(key)
				
	elif(max(cnt.values())==2):
		for key,v in cnt.items():
			if v==2:
				key=int(key)
				value=set(value)
				value=list(value)
				ix=value.index(key)
				two.append(key)
				value.pop(ix)
		
		if(len(two)==2):
			value.append(200+max(two))
			result=value.copy()
			
		elif(len(two)==1):
			value.append(100+two[0])
			result=value.copy()
	
	else:
		result=list((map(int,cnt.keys())))
	
	return result
	
def result(b,w):
	if(b>w): print("Black wins.")
	elif(b==w): print("Tie.")
	else: print("White wins.")
	
while(True):
	try:
		black=[0]
		white=[0]
		n=5
		
		card=list(input().split())
		
		
		for i in range(10):
			if(i<5):
				black.append(card[i])
			else:
				white.append(card[i])
				
	except EOFError: break
	
	else:
		black_hand=get_hand(black)
		white_hand=get_hand(white)
		
		if isinstance(black_hand,list)==True and isinstance(white_hand,list)==True:
			black_hand.sort()
			white_hand.sort()
			
			if max(black_hand)==500 and max(white_hand)==500: n=6
			elif max(black_hand)==max(white_hand) and max(black_hand)//100==2: n=2
			elif max(black_hand)==max(white_hand) and max(black_hand)//100==1: n=4
				

			for i in range(n):
				b=black_hand.pop()
				w=white_hand.pop()
				if(b==w):
					if(i==n-1):
						result(b,w)
					continue
				elif(b>w):
					result(b,w)
					break
				else:
					result(b,w)
					break
		
		elif isinstance(black_hand,list)==True:
			b=black_hand.pop()
			if b==500:
				bh=500
				result(bh,white_hand)
			elif b>=200 and b<300:
				bh=200
				result(bh,white_hand)
			elif b>=100 and b<200:
				bh=100
				result(bh,white_hand)
			else:
				result(b,white_hand)
			
		
		elif isinstance(white_hand,list)==True:
			w=white_hand.pop()
			if w==500:
				wh=500
				result(black_hand,w)
			elif w>=200 and w<300:
				wh=200
				result(black_hand,wh)
			elif w>=100 and w<200:
				wh=100
				result(black_hand,wh)
			else: 
				result(black_hand,w)
			
		
		else:
			result(black_hand,white_hand)
			
		
		
	