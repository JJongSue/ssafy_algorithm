import sys 

N, K = map(int, input().split()) 

nums = sys.stdin.readline().split(' ')

for i in range(N):
    nums[i] = int(nums[i]) 


nums = sorted(nums)
print(nums[K-1])

