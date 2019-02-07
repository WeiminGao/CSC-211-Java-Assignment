/* Name: Weimin Gao
 * Date: 10/14/2017
 * Type: Programming assignment 2
 * File: TortoiseAndHareTest.java
 */
package tortoiseandhare;

import java.util.Scanner;
public class TortoiseAndHareTest {
    public static void main (String[] args){
        TortoiseAndHare startTortoiseAndHare = new TortoiseAndHare();
        startTortoiseAndHare.displayResult();
        System.out.println("BANG !!!!! \nAND THEY'RE OFF !!!!!.");
        //startTortoiseAndHare.setTortoise(69); //This statement activities for test input or enter only!! Then don't need to waste time to wait first race end.
        startTortoiseAndHare.startRace ();
        
        char select;
        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to restart and set data. If yes, enter y. If no, enter n.");
        select= input.next().charAt(0);
        select = startTortoiseAndHare.checkEnter(select);
        while (select == 'y'){
            startTortoiseAndHare.setTortoise (0);
            startTortoiseAndHare.setHare (0);
            System.out.println("Do you want to set data the number of square or get hint. If yes, enter y. If no, enter n.");
            select= input.next().charAt(0);
            select = startTortoiseAndHare.checkEnter(select);
            if (select == 'y') startTortoiseAndHare.setData ();
            startTortoiseAndHare.displayResult();
            System.out.println("BANG !!!!! \n AND THEY'RE OFF !!!!!.");
            startTortoiseAndHare.startRace ();
            System.out.println("Do you want to restart and set data. If yes, enter y. If no, enter n.");
            select= input.next().charAt(0);
            select = startTortoiseAndHare.checkEnter(select);
        }
    }
}
