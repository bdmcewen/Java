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
from YahtzeeHand import YahtzeeHand


myHand = YahtzeeHand()
myHand.PopulateDiceArray()
myHand.rollDice()

# myHand.SortDice()
# myHand.RemoveDups()


myHand.PrintManReportHeader(10)
myHand.ManualTesterTests()
myHand.rando1000(1000)
