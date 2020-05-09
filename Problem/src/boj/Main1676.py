num = int(input())

ten = 0
five = 0
two = 0
ans = 0

for i in range(1, num+1):
    while (i % 10) == 0:
        ten = ten + 1
        i = i/10
    
        
    while (i % 5) == 0:
        five = five + 1
        i = i/5
        
    while (i % 2) == 0:
        two = two + 1
        i = i/2
ans = ans + ten
ans = ans + min(five, two)
ans = int(ans)
print(ans)
# print(ten, five, two)