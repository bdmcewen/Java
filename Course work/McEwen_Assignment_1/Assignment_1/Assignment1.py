################################################################################
#                       Assignment 1 – Python to Java I                        #
#                                                                              #
# PROGRAMMER:       Ben-Mcewen                                                 #
# CLASS:            CS102                                                      #
# ASSIGNMENT:       Assignment 1                                               #
# INSTRUCTOR:       Dean Zeller                                                #
# SUBMISSION DATE:  Friday, January 18th 2019                                  #
#                                                                              #
# DESCRIPTION:                                                                 #
# This program applies basic satistical calulations                            #
# to a series of positive integers.                                            #
#                                                                              #                                                                              
# COPYRIGHT:                                                                   #
# This program is (c) 2019 Ben-McEwen and Dean Zeller. This is original work,  #
# without use of outside sources.                                              #
################################################################################

#declaration of variables
data = []
num = 1
sum = 0
count = 1

#requests a tilte for the report
title = input("Enter a title for this report \n => ")

#requests a series of positive integers, appends them to an array and calculates
#their sum
print()
print("Enter a series of positive numbers, ending with a 0.")

while num > 0:
    response = int(input("  num#%s => " % count))
    num = response
    if num != 0:
        data.append(num)
        sum += num
        count += 1
        
#Displays the user defined series of positive integers along with a count of the
#number of integers entered        
print()
print(len(data), "numbers were entered: ", end = "")
for d in data:
    print(d, end=" ")    
print() 

#determines the integer with the largest value
largest = data[0]
for large in data:
    if large > largest:
        largest = large

#determines the integer with the smallest value
smallest = data[0]
for small in data:
    if small < smallest:
        smallest = small
        
#calculates average        
average = sum/len(data)

#Displays report summary including count, sum, average, min, max, and range.
print()
print(title)
for x in title:
    print("-", end="") #credit to K. Ritter for teaching me this.
print()
print("  N:        %-4d"    % len(data))
print("  Sum:      %-4d"    % sum)
print("  Average:  %-4.1f"  % average)
print("  Smallest: %-4d"    % smallest)
print("  Largest:  %-4d"    % largest)
print("  Range:    %-4d"    % (largest - smallest))
print()
      
