import sys

N, K = map(int, input().split()) 
nums = []
tmp = sys.stdin.readline().split(' ')
for j in range(N):
    nums.append(int(tmp[j]))
tmp = sys.stdin.readline().split(' ')
for j in range(K):
    nums.append(int(tmp[j]))
    

nums = sorted(nums)

for i in range(len(nums)):
    print(nums[i], end=' ')
