/********************************************************************************
 *                            Final Project TvH++                               *
 *                                                                              *
 * PROGRAMMER:       Ben McEwen                                                 *
 * CLASS:            CS200                                                      *
 * ASSIGNMENT:       Final Project                                              *
 * INSTRUCTOR:       Dean Zeller                                                *
 * SUBMISSION DATE:  12/07/2019                                                 *
 *                                                                              *
 * DESCRIPTION:                                                                 *
 * This class defines the behaviors used  to simulate fighting between          *
 * the animals                                                                  *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

import java.util.ArrayList;

public class Fight {

    public void fight(Animal fighter1, Animal fighter2) {

        if(fighter1.getFerocity() > fighter2.getFerocity()){
            fighter1.setFight(true);
            fighter1.setCurrentlyFighting(true);
            fighter1.setFlight(false);

            fighter2.setFight(false);
            fighter2.setFlight(true);
        }

        if(fighter1.getFerocity() < fighter2.getFerocity()){
            fighter1.setFight(false);
            fighter1.setFlight(true);

            fighter2.setFight(true);
            fighter2.setCurrentlyFighting(true);
            fighter2.setFlight(false);
        }
        if(fighter1.isPrey() && fighter1.isFlight()){
            System.out.println(fighter1.getName() + " is running away");
            fighter1.setFightingAllowed(false);
            fighter1.setCurrentlyFighting(false);
        }

        if(fighter2.isPrey() && fighter2.isFlight()){
            System.out.println(fighter2.getName() + " is running away");
            fighter2.setFightingAllowed(false);
            fighter2.setCurrentlyFighting(false);
        }

        if(fighter1.isCurrentlyFighting() && fighter2.isCurrentlyFighting()){

            if(fighter1.isFightingAllowed() && fighter2.isFightingAllowed()){
                System.out.println(fighter1.getName() + " and " + fighter2.getName() + " are fighting!!!");
            }


            while (fighter1.getHealth() > 0 && fighter2.getHealth() > 0){
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    System.out.println("INTERUPTED DELAY");
                }

                fighter1.attack(fighter2);
                if (fighter2.isDead()) {
                    System.out.println(fighter2.getName() + " is down!");
                    fighter1.setRunningSpeed(0);
                    fighter1.setFightingAllowed(false);
                    fighter2.setFightingAllowed(false);
                    fighter1.setLifeStatus(false);
                    fighter1.setCurrentlyFighting(false);
                    fighter2.setCurrentlyFighting(false);
                    fighter1.setStatus("");
                    fighter2.setStatus("");
                    victory(fighter1, fighter2);
                    return;
                }

                fighter2.attack(fighter1);
                if (fighter1.isDead()) {
                    System.out.println(fighter1.getName() + " is down!");
                    fighter2.setRunningSpeed(0);
                    fighter1.setFightingAllowed(false);
                    fighter2.setFightingAllowed(false);
                    fighter2.setLifeStatus(false);
                    fighter1.setCurrentlyFighting(false);
                    fighter2.setCurrentlyFighting(false);
                    fighter1.setStatus("");
                    fighter2.setStatus("");
                    victory(fighter2, fighter1);
                    return;
                }
            }
        }
    }

    private void victory(Animal winner, Animal loser) {
        System.out.println(winner.getName() + " has defeated " + loser.getName());

    }

}
