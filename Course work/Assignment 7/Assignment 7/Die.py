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
import random


class Die:

    #####################################################################
    # __init__                                                          #
    #                                                                   #
    # purpose:                                                          #
    #     - initialize the attributes to default values                 #
    # parameters: none                                                  #
    # return value: none                                                #
    #####################################################################
    def __init__(self, name_="Die", sides_=6, value_=1):
        self.name = name_
        self.sides = sides_
        self.value = value_

    #####################################################################
    # __str__                                                           #
    #                                                                   #
    # purpose:                                                          #
    #     - overwrites default "to String" method                       #
    # parameters: none                                                  #
    # return value: none                                                #
    #####################################################################
    def __str__(self):
        result = ""
        result += "\n+-----------------------+"
        result += ("\n| name %10s |" % self.name)
        result += ("\n| sides %10d |" % self.sides)
        result += ("\n| value %10d |" % self.value)
        result += "\n+-----------------------+"
        return result

    # get-methods
    #####################################################################
    # getName                                                           #
    #                                                                   #
    # purpose:                                                          #
    #     - allows read access to attribute value                       #
    # parameters: none                                                  #
    # return value: name                                                #
    #####################################################################
    def getName(self):
        return self.name

    #####################################################################
    # getSides                                                          #
    #                                                                   #
    # purpose:                                                          #
    #     - allows read access to attribute value                       #
    # parameters: none                                                  #
    # return value: sides                                               #
    #####################################################################
    def getSides(self):
        return self.sides

    #####################################################################
    # getValue                                                          #
    #                                                                   #
    # purpose:                                                          #
    #     - allows read access to attribute value                       #
    # parameters: none                                                  #
    # return value: value                                               #
    #####################################################################
    def getValue(self):
        return self.value

    # set-methods
    #####################################################################
    # setName                                                           #
    #                                                                   #
    # purpose:                                                          #
    #     - allows write access to attribute value                      #
    # parameters: name_                                                 #
    # return value: none                                                #
    #####################################################################
    def setName(self, name_):
        self.name = name_

    #####################################################################
    # setSides                                                          #
    #                                                                   #
    # purpose:                                                          #
    #     - allows write access to attribute value                      #
    # parameters: sides_                                                #
    # return value: none                                                #
    #####################################################################
    def setSides(self, sides_):
        # error checking
        if sides_ < 0.0:
            print("Warning: cannot set sides to below 0.0.")
            print("Attribute not changed.")
            return
        self.sides = sides_

    #####################################################################
    # setValue                                                          #
    #                                                                   #
    # purpose:                                                          #
    #     - allows write access to attribute value                      #
    # parameters: value_                                                #
    # return value: none                                                #
    #####################################################################
    def setValue(self, value_):
        self.value = value_

    # other methods
    #####################################################################
    # addToValue                                                        #
    #                                                                   #
    # purpose:                                                          #
    #     - allows addition one value to another                        #
    # parameters: addto                                                 #
    # return value: none                                                #
    #####################################################################
    def addToValue(self, addto):
        self.value += addto

    #####################################################################
    # clearValue                                                        #
    #                                                                   #
    # purpose:                                                          #
    #     - allows value to be cleared                                  #
    # parameters: none                                                  #
    # return value: none                                                #
    #####################################################################
    def clearValue(self):
        self.value = ""

    #####################################################################
    # countToSides                                                      #
    #                                                                   #
    # purpose:                                                          #
    #     - counts to ...wait for it... the number of sides             #
    # parameters: none                                                  #
    # return value: none                                                #
    #####################################################################
    def countToSides(self):
        for i in range(self.sides):
            print(i)

    #####################################################################
    # roll                                                              #
    #                                                                   #
    # purpose:                                                          #
    #     - roll die                                                    #
    # parameters: n ( the highest value possible for the die            #
    # return value: value                                               #
    #####################################################################
    def roll(self, n):
        for x in range(n):
            self.value = random.randint(1, self.sides)
        return self.value

    #####################################################################
    # cheat                                                             #
    #                                                                   #
    # purpose:                                                          #
    #     - allows value to be set manually                             #
    # parameters: value                                                 #
    # return value: none                                                #
    #####################################################################
    def cheat(self, value):
        cheatvalue = value
        if cheatvalue <= self.sides:
            self.value = cheatvalue
