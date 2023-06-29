import sys
try:
	while(True):
		case= input()
		delim = ["\t"," ","\n","\r"]	
		char_count = 0
		word_count = 0
		Flag = False
		
		for i in case:
			if i.isalnum():
				char_count+=1
				
			if i.isalnum() and Flag == False:
				word_count +=1
				Flag = True
				
			for j in delim:
				if i == j:
					Flag = False
					
		print(char_count, word_count)
except:
	pass