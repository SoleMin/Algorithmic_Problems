import sys;
T = int(sys.stdin.readline())
idx = 0;

def one(x1,x2,x3,x4):
	return (x1*2) + x3 + x4;

def two(x1,x2,x3,x4):
	return x1 + (x2 * 2) +x4


while(idx < T):
	sys.stdin.readline();
	n = int(sys.stdin.readline());
	people = []
	for i in range(n):
		people.append(int(sys.stdin.readline()))
	
	people.sort()
	
	first = people[0];
	second = people[1];
	ans = 0
	while(1):
		if (len(people) <=3):
			if(len(people) == 3):
				for i in people:
					ans += i
			elif(len(people) == 2):
				ans += second
	
			break
		
		a= people.pop()
		b= people.pop()
		ans += min(one(first, second, b, a), two(first,second,b, a))
		
		
	
	
	
	
	print(str(ans) + "\n")
	idx += 1