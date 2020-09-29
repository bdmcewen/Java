public class YahtzeeScoreCardTester
{
    public static void main(String[] args)
    {
        YahtzeeScoreCard myScores = new YahtzeeScoreCard();

        //tester for set die
		myScores.myHand.setDice(1,2,3,4,5);
		System.out.println("cheater/set test");
		System.out.print(myScores.myHand.toString());

        // tester random roll
        myScores.setScoresArray();
        System.out.println();

        //tester for scoring
        myScores.setTotalScore();
        System.out.println("Scores test");
        System.out.print(myScores.scores.toString());
        System.out.println();
        System.out.println("Total score test:" + myScores.getTotalScore());
        System.out.println();

        //tester for reroll
        System.out.println("Reroll test1");
        myScores.rerollDice(true, true, true, true, true);
        System.out.println();
        System.out.println("Reroll test2");
        myScores.rerollDice(false, false, true, true, true);
        System.out.println();
        System.out.println("New Hand");
        System.out.print(myScores.myHand.toString());

        myScores.displayScoresheet();

    }
}
