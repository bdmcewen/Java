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
 * This class is designed to simulate a Caucasian which is a sub class          *
 * of Dog which uses the Predator interface                                     *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

public class Caucasian extends Dog implements Predator {

    public Caucasian(String name_, String species, double runningSpeed_, double variationOfSpeed_){

        //inherited
        super(name_, "Caucasian",runningSpeed_, variationOfSpeed_, 0, 0 );

        //unique

        this.setColumnWidth(25);
        this.setFerocity(100);
        this.setStrength(1.0);

    }

    public Caucasian(){

    }

    @Override
    public void attacks() {
        while(getHealth() > 0){
            if(isCurrentlyFighting()){
                this.setSquirrel(false);
                this.setRunningSpeed(this.getRunningSpeed()*0);
            }
        }
    }
}
