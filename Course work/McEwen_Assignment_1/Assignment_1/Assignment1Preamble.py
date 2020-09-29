# Demo1 -- Mathematical Operations
print()
print("Demo1 -- Mathematical Operations")
a = 10
b =  5
c = 30
sum = a + b + c
avg = sum / 3
print(sum, avg)

# Demo2 -- User input (strings)
print()
print("Demo2 -- User Input (strings)")
name = input("Enter your name => ")
nickname = input("Enter your nickname => ")
print("Hello "+name+". Can I call you "+nickname+"?")

# Demo3 -- User input (integers)
print()
print("Demo3 -- User Input (integers)")
response = input("Enter first number => ")
a = int(response)
response = input("Enter second number => ")
b = int(response)
response = input("Enter third number => ")
c = int(response)
sum = a + b + c
avg = sum / 3
print("Sum =",sum)
print("Avg =",avg)

# Demo4 -- Conditional Statement
print()
print("Demo4 -- Conditional Statements")
response = input("Enter first number => ")
a = int(response)
response = input("Enter second number => ")
b = int(response)
if a>b:
    max = a
    print(a,"is larger.")
elif a<b:
    max = b
    print(b,"is larger.")
else:
    max = a
    print("They are equal.")

    # Demo5 -- Logical Operators
print()
print("Demo5 -- Logical Operators")
response = input("Enter first number => ")
a = int(response)
response = input("Enter second number => ")
b = int(response)
response = input("Enter third number => ")
c = int(response)
if a>b and a>c:
    max = a
    print(a,"is largest.")
elif b>a and b>c:
    max = b
    print(b,"is largest.")
elif c>a and c>b:
    max = c
    print(c,"is largest.")
else:
    print("The largest is at least two of the numbers.")


# Demo6 -- For Loop
print()
print("Demo6 -- For Loop")
print("Adding numbers 0 through 9.")
sum = 0
for i in range(10):
    print("Adding",i)
    sum += i
print("The sum is",sum)



# Demo7 -- While Loop
print()
print("Demo7 -- While Loop")
print("Enter numbers, end with a negative.")
num = 0
sum = 0
while num >= 0:
    sum += num
    response = input("Enter a number => ")
    num = int(response)
print("Sum =",sum)

