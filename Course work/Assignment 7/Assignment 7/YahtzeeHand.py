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

class YahtzeeHand:
    dice = []
    sorteddice = []
    sorteddie = []
    sortedstring = ""

    #####################################################################
    # __init__                                                          #
    #                                                                   #
    # purpose:                                                          #
    #     - initializes attribtes                                       #
    # parameters: numberofdice_, numberofsides_                         #
    # return value: none                                                #
    #####################################################################
    def __init__(self, numberofdice_=5,
                 numberofsides_=6,
                 ):
        self.NumberOfDice = numberofdice_
        self.NumberOfSides = numberofsides_

    #####################################################################
    # PopulateDiceArray                                                 #
    #                                                                   #
    # purpose:                                                          #
    #     - uses for loop to create new instances of die object to      #
    #     populate the dice array                                       #
    # parameters: sides_                                                #
    # return value: none                                                #
    #####################################################################
    def PopulateDiceArray(self):
        for x in range(self.NumberOfDice):
            die = Die()
            self.dice.append(die)
        ##print (self.NumberOfDice)
        #for d in self.dice: print (d.getValue())

    #####################################################################
    # rollDice                                                          #
    #                                                                   #
    # purpose:                                                          #
    #     - calls roll method to roll all die in dice array             #
    # parameters: sides_                                                #
    # return value: none                                                #
    #####################################################################
    def rollDice(self):
        for d in self.dice:
            d.roll(self.NumberOfDice)
        #for d in self.dice: print (d.getValue())

    #####################################################################
    # To String                                                         #
    #                                                                   #
    # purpose:                                                          #
    #     - writes the value of each die from the array into a string   #
    # parameters: none                                                  #
    # return value: s                                                   #
    #####################################################################
    def ToString(self):
        s = ""
        for d in self.dice:
            s += str(d.getValue())
        return s

    #####################################################################
    # CountDice                                                         #
    #                                                                   #
    # purpose:                                                          #
    #     - counts the number of die with a specified value             #
    # parameters: n                                                     #
    # return value: count                                               #
    #####################################################################
    def CountDice(self, n):
        count = 0
        for d in self.dice:
            if d.getValue() == n:
                count += 1
        return count

    #####################################################################
    # SetDice                                                           #
    #                                                                   #
    # purpose:                                                          #
    #     - allows the die to be set to specified values                #
    # parameters: d1, d2, d3, d4, d5                                    #
    # return value: none                                                #
    #####################################################################
    def SetDice(self, d1, d2, d3, d4, d5):
        self.dice[0].cheat(d1)
        self.dice[1].cheat(d2)
        self.dice[2].cheat(d3)
        self.dice[3].cheat(d4)
        self.dice[4].cheat(d5)

    #####################################################################
    # FaceValue                                                         #
    #                                                                   #
    # purpose:                                                          #
    #     -  calculates scoring for face value rows                     #
    # parameters: n                                                     #
    # return value: self.CountDice(n) * n                               #
    #####################################################################
    def FaceValue(self, n):
        return self.CountDice(n) * n
    #####################################################################
    # ThreeKindValue                                                    #
    #                                                                   #
    # purpose:                                                          #
    #     - calculates scoring for three of a kind                      #
    # parameters: none                                                  #
    # return value:  tempsum                                            #
    #####################################################################
    def ThreeKindValue(self):
        tempsum = 0
        if bool(self.TriplesCheck()) or bool(self.QuadruplesCheck()) or bool(self.QuintuplesCheck()):
            tempsum = self.ChanceValue()
        return tempsum
    #####################################################################
    # FourKindValue                                                     #
    #                                                                   #
    # purpose:                                                          #
    #     - calculates scoring for four of a kind                       #
    # parameters: none                                                  #
    # return value:  tempsum                                            #
    #####################################################################
    def FourKindValue(self):
        tempsum = 0
        if bool(self.QuadruplesCheck()) or bool(self.QuintuplesCheck()):
            tempsum = self.ChanceValue()
        return tempsum

    #####################################################################
    # FullHouseValue                                                    #
    #                                                                   #
    # purpose:                                                          #
    #     - calculates scoring for full house                           #
    # parameters: none                                                  #
    # return value:  tempsum                                            #
    #####################################################################
    def FullHouseValue(self):
        tempsum = 0
        if bool(self.doublesCheck()) and bool(self.TriplesCheck()):
            tempsum = 25
        return tempsum

    #####################################################################
    # SortDice                                                          #
    #                                                                   #
    # purpose:                                                          #
    #     - sorts dice by value in ascending order                      #
    # parameters: none                                                  #
    # return value:  none                                               #
    #####################################################################
    def SortDice(self):
        for d in self.dice:
            #print (d.getValue())
            self.sorteddice.append(d.getValue())
        #print (self.sorteddice)
        self.sorteddice.sort()
        #print (self.sorteddice)

    #####################################################################
    # RemoveDups                                                        #
    #                                                                   #
    # purpose:                                                          #
    #     - removes duplicates from array                               #
    # parameters: none                                                  #
    # return value:  none                                               #
    #####################################################################
    def RemoveDups(self):
        for d in self.sorteddice:
            if d not in self.sorteddie:
                self.sorteddie.append(d)
        #print (self.sorteddie)

        for d in self.sorteddie:
            self.sortedstring += str(d)
        #print (self.sortedstring)

    #####################################################################
    # SmallStraightValue                                                #
    #                                                                   #
    # purpose:                                                          #
    #     - calculates scoring for small straight                       #
    # parameters: none                                                  #
    # return value:  tempsum                                            #
    #####################################################################
    def SmallStraightValue(self):
        tempsum = 0
        self.SortDice()
        self.RemoveDups()
        if "1234" in self.sortedstring or "2345" in self.sortedstring or "3456" in self.sortedstring:
            tempsum = 30
        self.sortedstring = ""
        self.sorteddie.clear()
        self.sorteddice.clear()
        return tempsum
    #####################################################################
    # LargeStraightValue                                                #
    #                                                                   #
    # purpose:                                                          #
    #     - calculates scoring for large straight                       #
    # parameters: none                                                  #
    # return value:  tempsum                                            #
    #####################################################################
    def LargeStraightValue(self):
        tempsum = 0
        self.SortDice()
        self.RemoveDups()
        if "12345" in self.sortedstring or "23456" in self.sortedstring:
            tempsum = 30
        self.sortedstring = ""
        self.sorteddie.clear()
        self.sorteddice.clear()
        return tempsum
    #####################################################################
    # YahtzeeValue                                                      #
    #                                                                   #
    # purpose:                                                          #
    #     - calculates scoring for yahtzee                              #
    # parameters: none                                                  #
    # return value:  tempsum                                            #
    #####################################################################
    def YahtzeeValue(self):
        tempsum = 0
        if bool(self.QuintuplesCheck()):
            tempsum = 25
        return tempsum
    #####################################################################
    # ChanceValue                                                       #
    #                                                                   #
    # purpose:                                                          #
    #     - calculates scoring for chance                               #
    # parameters: none                                                  #
    # return value:  tempsum                                            #
    #####################################################################
    def ChanceValue(self):
        tempsum = 0
        for d in self.dice:
            tempsum += d.getValue()
        return tempsum

    # Boolean Checks
    #####################################################################
    # DoublesCheck                                                      #
    #                                                                   #
    # purpose:                                                          #
    #     - boolean to check for presence of similar values             #
    # parameters: none                                                  #
    # return value:  check                                              #
    #####################################################################
    def doublesCheck(self):
        check = False
        for i in range(self.NumberOfSides):
            if self.CountDice(i) == 2:
                check = True
        return check
    #####################################################################
    # TriplesCheck                                                      #
    #                                                                   #
    # purpose:                                                          #
    #     - boolean to check for presence of similar values             #
    # parameters: none                                                  #
    # return value:  check                                              #
    #####################################################################
    def TriplesCheck(self):
        check = False
        for i in range(self.NumberOfSides):
            if self.CountDice(i) == 3:
                check = True
        return check
    #####################################################################
    # QuadruplesCheck                                                   #
    #                                                                   #
    # purpose:                                                          #
    #     - boolean to check for presence of similar values             #
    # parameters: none                                                  #
    # return value:  check                                              #
    #####################################################################
    def QuadruplesCheck(self):
        check = False
        for i in range(self.NumberOfSides):
            if self.CountDice(i) == 4:
                check = True
        return check
    #####################################################################
    # QuintuplesCheck                                                   #
    #                                                                   #
    # purpose:                                                          #
    #     - boolean to check for presence of similar values             #
    # parameters: none                                                  #
    # return value:  check                                              #
    #####################################################################
    def QuintuplesCheck(self):
        check = False
        for i in range(self.NumberOfSides):
            if self.CountDice(i) == 5:
                check = True
        return check

    @staticmethod
    #####################################################################
    # PrintManReportHeader                                              #
    #                                                                   #
    # purpose:                                                          #
    #     - outputs values                                              #
    # parameters: none                                                  #
    # return value:  none                                               #
    #####################################################################
    def PrintManReportHeader(n):
        print("Yahtzee Hand Report")
        print("Creating ", n, " manual YahtzeeHand examples")
        print("   Dice             1s    2s    3s    4s    5s    6s    3k    4k    FH    Sm    Lg    Yt    Ch")
    #####################################################################
    # PrintRandoReportHeader                                            #
    #                                                                   #
    # purpose:                                                          #
    #     - outputs values                                              #
    # parameters: n                                                     #
    # return value:  none                                               #
    #####################################################################
    @staticmethod
    def PrintRandoReportHeader(n):
        print("Yahtzee Hand Report")
        print("Creating ", n, " random YahtzeeHand examples")
        print("   Dice             1s    2s    3s    4s    5s    6s    3k    4k    FH    Sm    Lg    Yt    Ch")
    #####################################################################
    # PrintReportLine                                                   #
    #                                                                   #
    # purpose:                                                          #
    #     - outputs values                                              #
    # parameters: line                                                  #
    # return value:  output                                             #
    #####################################################################
    def ReportLine(self, line):
        header = str('%-3s' %line) + "." + " "+ self.ToString()
        output = '%5s %5d %5d %5d  %5d  %5d  %5d  %5d  %5d  %5d  %5d  %5d  %5d  %5d ' % (header,
            self.FaceValue(1),
            self.FaceValue(2),
            self.FaceValue(3),
            self.FaceValue(4),
            self.FaceValue(5),
            self.FaceValue(6),
            self.ThreeKindValue(),
            self.FourKindValue(),
            self.FullHouseValue(),
            self.SmallStraightValue(),
            self.LargeStraightValue(),
            self.YahtzeeValue(),
            self.ChanceValue()
        )

        return output
    #####################################################################
    # ManualTestertests                                                 #
    #                                                                   #
    # purpose:                                                          #
    #     - outputs values                                              #
    # parameters: none                                                  #
    # return value:  check                                              #
    #####################################################################
    def ManualTesterTests(self):
        self.SetDice(2, 1, 3, 6, 1)
        print(self.ReportLine(1))
        self.SetDice(6, 2, 5, 3, 4)
        print(self.ReportLine(2))
        self.SetDice(5, 5, 2, 1, 5)
        print(self.ReportLine(3))
        self.SetDice(2, 2, 4, 2, 4)
        print(self.ReportLine(4))
        self.SetDice(4, 4, 4, 4, 4)
        print(self.ReportLine(5))
        self.SetDice(2, 3, 4, 5, 4)
        print(self.ReportLine(6))
        self.SetDice(6, 2, 6, 6, 6)
        print(self.ReportLine(7))
        self.SetDice(1, 1, 1, 1, 4)
        print(self.ReportLine(8))
        self.SetDice(4, 1, 3, 1, 6)
        print(self.ReportLine(9))
        self.SetDice(3, 5, 2, 6, 1)
        print(self.ReportLine(10))
        print()

    @staticmethod
    #####################################################################
    # Instance                                                          #
    #                                                                   #
    # purpose:                                                          #
    #     - determines if instance of value is present                  #
    # parameters: none                                                  #
    # return value:  count                                              #
    #####################################################################
    def Instance(n):
        count = 0
        if n != 0:
            count = 1
        return count

    #####################################################################
    # Rando1000                                                         #
    #                                                                   #
    # purpose:                                                          #
    #     - doutputs values                                             #
    # parameters: statsteses                                            #
    # return value:  none                                               #
    #####################################################################
    def rando1000(self, statstests):

        sum_of_ones = 0
        instance_of_ones = 0

        sum_of_twos = 0
        instance_of_twos = 0

        sum_of_threes = 0
        instance_of_three = 0

        sum_of_fours = 0
        instance_of_fours = 0

        sum_of_fives = 0
        instance_of_fives = 0

        sum_of_sixes = 0
        instance_of_sixes = 0

        sum_of3_o_ks = 0
        instance_of3_o_ks = 0

        sum_of4_o_ks = 0
        instance_of4_o_ks = 0

        sum_of_full_houses = 0
        instance_of_full_houses = 0

        sum_of_small_straits = 0
        instance_of_small_straits = 0

        sum_of_large_straits = 0
        instance_of_large_straits = 0

        sum_of_yahtzees = 0
        instance_of_yahtzees = 0

        sum_of_chances = 0
        instance_of_chances = 0

        counter = 0

        self.PrintRandoReportHeader(statstests)
        for i in range(statstests):
            self.rollDice()

            sum_of_ones += self.FaceValue(1)
            instance_of_ones += self.Instance(self.FaceValue(1))

            sum_of_twos += self.FaceValue(2)
            instance_of_twos += self.Instance(self.FaceValue(2))

            sum_of_threes += self.FaceValue(3)
            instance_of_three += self.Instance(self.FaceValue(3))

            sum_of_fours += self.FaceValue(4)
            instance_of_fours += self.Instance(self.FaceValue(4))

            sum_of_fives += self.FaceValue(5)
            instance_of_fives += self.Instance(self.FaceValue(5))

            sum_of_sixes += self.FaceValue(6)
            instance_of_sixes += self.Instance(self.FaceValue(6))

            sum_of3_o_ks += self.ThreeKindValue()
            instance_of3_o_ks += self.Instance(self.ThreeKindValue())

            sum_of4_o_ks += self.FourKindValue()
            instance_of4_o_ks += self.Instance(self.FourKindValue())

            sum_of_full_houses += self.FullHouseValue()
            instance_of_full_houses += self.Instance(self.FullHouseValue())

            sum_of_small_straits += self.SmallStraightValue()
            instance_of_small_straits += self.Instance(self.SmallStraightValue())

            sum_of_large_straits += self.LargeStraightValue()
            instance_of_large_straits += self.Instance(self.LargeStraightValue())

            sum_of_yahtzees += self.YahtzeeValue()
            instance_of_yahtzees += self.Instance(self.YahtzeeValue())

            sum_of_chances += self.ChanceValue()
            instance_of_chances += self.Instance(self.ChanceValue())
            counter += 1

            print(self.ReportLine(i))

        print()
        print("                    1s    2s    3s    4s    5s    6s    3k    4k    FH    Sm    Lg    Yt    Ch")

        header = "% non-zero      "
        output = '%5s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s %4.0f%s ' \
                 '%4.0f%s' % (header,
                              ((instance_of_ones / statstests) * 100), "%",
                              ((instance_of_twos / statstests) * 100), "%",
                              ((instance_of_three / statstests) * 100), "%",
                              ((instance_of_fours / statstests) * 100), "%",
                              ((instance_of_fives / statstests) * 100), "%",
                              ((instance_of_sixes / statstests) * 100), "%",
                              ((instance_of3_o_ks / statstests) * 100), "%",
                              ((instance_of4_o_ks / statstests) * 100), "%",
                              ((instance_of_full_houses / statstests) * 100), "%",
                              ((instance_of_small_straits / statstests) * 100), "%",
                              ((instance_of_large_straits / statstests) * 100), "%",
                              ((instance_of_yahtzees / statstests) * 100), "%",
                              ((instance_of_chances / statstests) * 100), "%"
                              )

        print(output)
        header = "Average Score   "

        averages = '%5s %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f %5.1f' % \
                   (
                       header,
                       sum_of_ones / statstests,
                       sum_of_twos / statstests,
                       sum_of_threes / statstests,
                       sum_of_fours / statstests,
                       sum_of_fives / statstests,
                       sum_of_sixes / statstests,
                       sum_of3_o_ks / statstests,
                       sum_of4_o_ks / statstests,
                       sum_of_full_houses / statstests,
                       sum_of_small_straits / statstests,
                       sum_of_large_straits / statstests,
                       sum_of_yahtzees / statstests,
                       sum_of_chances / statstests
                   )
        print(averages)
