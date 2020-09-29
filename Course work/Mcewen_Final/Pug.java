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
 * This class is designed to simulate a pug which is a sub class                *
 * of Dog which uses the Prey interface                                         *
 *                                                                              *
 * COPYRIGHT:                                                                   *
 * This program is copyright (c) 2019 Ben McEwen. This is original work,        *
 * without use of outside sources.                                              *
 *******************************************************************************/

public class Pug extends Dog implements Prey {

    public Pug(String name_,String species, double runningSpeed_, double variationOfSpeed_){

        //inherited
        super(name_, "Pug",runningSpeed_, variationOfSpeed_, 0, 0 );

        //unique

        this.setColumnWidth(25);
        this.setFerocity(5);
        this.setStrength(.2);

    }

    public Pug(){

    }
    @Override
    public void defends() {
        while(getHealth() > 0){
            if(isCurrentlyFighting()){
                if (this.isFlight() && !this.isFight()){
                    this.setSquirrel(false);
                    this.setRunningSpeed(this.getRunningSpeed()*-1.2);
                }
            }
        }
    }


}
