with open("data.txt") as f:
	depths = [int(depth) for depth in f.readlines()]

def sol1():
	return sum([depths[i] > depths[i-1] for i in range(1, len(depths))])

def sol2():
	count = 0
	prev = sum(depths[0:3])
	for i in range(3, len(depths)):
		cur = sum(depths[i-2:i+1])
		if (cur > prev):
			count += 1
		prev = cur
	return count
	
print(sol1())
print(sol2())