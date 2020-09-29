################################################################################
#                           Assignment7 Yahtzee in Python                      #
#                                                                              #
# PROGRAMMER:       Ben McEwen                                                 #
# CLASS:            CS102                                                      #
# ASSIGNMENT:       Assignment 7                                               #
# INSTRUCTOR:       Dean Zeller                                                #
# SUBMISSION DATE:  4/5/2018                                                   #
#                                                                              #
# DESCRIPTION:                                                                 #
# This program is a copy of some of the yahtzee assignments                    #
# translated to Python                                                         #
#                                                                              #
# COPYRIGHT:                                                                   #
# This program is (c) 2018 Ben McEwen and Dean Zeller. This is original work,  #
# without use of outside sources.                                              #
################################################################################
from Die import Die

cube = Die("Cube", 6, 1)
print("\nTest 1: Six-sided die (D6)")
print("\t Range 1 to", cube.getSides())
cube.roll(cube.sides)
print("\t Single number Test:", cube.value)
print("\t Multiple number test:")
for x in range(0, 5):
    cube.roll(cube.sides)
print("\t ", cube.getValue())

print()
