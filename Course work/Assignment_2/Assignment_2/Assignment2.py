################################################################################
#                       Assignment 2 – Python to Java II                       #
#                                                                              #
# PROGRAMMER:       Ben-Mcewen                                                 #
# CLASS:            CS102                                                      #
# ASSIGNMENT:       Assignment 2                                               #
# INSTRUCTOR:       Dean Zeller                                                #
# SUBMISSION DATE:  Feb 4                                                      #
#                                                                              #
# DESCRIPTION:                                                                 #
# This program applies basic statistical calculations                          #
# to a series of positive numbers.                                             #
#                                                                              #                                                                              
# COPYRIGHT:                                                                   #
# This program is (c) 2019 Ben-McEwen and Dean Zeller. This is original work,  #
# without use of outside sources.                                              #
################################################################################
import math

print("Welcome to Dean's statistics program.\n")

# Get name of report
title = input("Please enter the name of the report.\n    => ")

# Define array
data = []

# Read data from user
print("Enter data, ending with a negative number.")
num = 0.00
count = 0.00
while True:
    num = float(input("    => "))
    if num < 0:  # negative, end of list
        print("End of data.")
        break
    data.append(num)
    count += 1

# Calculate sum
sum = 0.00
for d in data:
    sum += d

# Calculate average
avg = sum / count

# Calculate smallest
min = data[0]
for small in data:
    if small < min:
        min = small

# Calculate largest
max = data[0]
for large in data:
    if large > max:
        max = large

# Calculate range
range = (max - min)

# Calculate variance
n = len(data)
vartop = 0.00

for x in data:
    vartop +=((x-avg) ** 2)
var = vartop / (n-1)

# Calculate standard deviation
stdev = math.sqrt(var)

# Print report
print()
print(title)
print()
print("Data: ",end=" ")
for d in data:
    print(d , end=" ")
print()
print("Count:     %8d"   % (count))
print("Sum:       %8.2f" % (sum))
print("Average:   %8.2f" % (avg))
print("Smallest:  %8.2f" % (min))
print("Largest:   %8.2f" % (max))
print("Range:     %8.2f" % (range))
print("Variance:  %8.2f" % (var))
print("Stdev:     %8.2f" % (stdev))
