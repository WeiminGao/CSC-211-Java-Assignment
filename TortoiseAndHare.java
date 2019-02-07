/* Name: Weimin Gao
 * Date: 10/14/2017
 * Type: Programming assignment 2
 * File: TortoiseAndHare.java
 */
package tortoiseandhare;

import java.util.Scanner;
import java.util.Random; 
public class TortoiseAndHare {
    private int numberOfSquare;
    private int tortoise;
    private int hare;

    public TortoiseAndHare (){
        numberOfSquare = 70;
        tortoise = 0;
        hare = 0;
        
    }
    public TortoiseAndHare (int n){
        numberOfSquare = n;
        tortoise = 0;
        hare = 0;
    }
    public void setNumberOfSquare (int n){
        numberOfSquare = n;
    }
    public void setTortoise (int n){
        tortoise = n;
    }
    public void setHare (int n){
        hare = n;
    }
    public void setcheat(char animal){
        if (animal == 't') tortoise=numberOfSquare+5;
        else if ((animal == 'h')) hare = numberOfSquare+11;
        else tortoise = hare = numberOfSquare+11;
    }

    public int getNumberOfSquare(){
        return numberOfSquare;
    }
    public int getTortoise(){
        return tortoise;
    }
    public int getHare(){
        return hare;
    }
    public void displayLocationOfTortoise(int n, int t){
        for (int i = 0; i < n*4; i++){
            if (i==4*t+2) System.out.printf("T");
            else if (i%4==0) System.out.printf("|");
            else System.out.printf(" ");
        }
        System.out.printf("|");
    }
    public void displayLocationOfHare(int n, int h){
        for (int i = 0; i < n*4; i++){
            if (i==4*h+2) System.out.printf("H");
            else if (i%4==0) System.out.printf("|");
            else System.out.printf(" ");
        }
        System.out.printf("|");
    }
    public void displaySquareSides(int n){
         for (int i = 0; i <= n*4; i++) System.out.printf("-");
    }
    public void displaySquareNumber(int n){
        for (int i = 0; i < n; i++){
            if (i == 0) System.out.printf("  %d",i+1);
            else if (i<9) System.out.printf("   %d",i+1);
            else if (i<100) System.out.printf("  %d",i+1);
            else System.out.printf(" %d",i+1);
        }
    }
    public void displayResult(){
        if (tortoise == hare) System.out.println("OUCH!!!");
        displaySquareNumber(numberOfSquare);
        System.out.println();
        displaySquareSides(numberOfSquare);
        System.out.println();
        displayLocationOfTortoise(numberOfSquare, tortoise);
        System.out.println();
        displayLocationOfHare(numberOfSquare, hare);
        System.out.println();
        displaySquareSides(numberOfSquare);
        System.out.println();
    }
    public int Adjustment (int animal) {
        if (animal < 0) return 0;
        else if (animal > numberOfSquare-1) return numberOfSquare-1;
        else return animal;
    }//Check function: location of animals should not smaller than 0 and should not greater than the numbers of square.
    public void animalMove (){
        Random randomNumbers1 = new Random(); 
        Random randomNumbers2 = new Random(); 
        int tortoiseMoveType;
        int hareMoveType;
        tortoiseMoveType = 1 + randomNumbers1.nextInt( 10 );
        hareMoveType = 1 + randomNumbers2.nextInt( 10 );
        //Need Exception (check is it between 0-10)
        if (tortoiseMoveType<6) tortoise=tortoise+3;
        else if (tortoiseMoveType<8) tortoise=tortoise-6;
        else tortoise=tortoise+1;
        tortoise = Adjustment (tortoise);
        //Another Exception (check is it between 0-10)
        if (hareMoveType<3) ;
        else if (hareMoveType<5) hare=hare+9;
        else if (hareMoveType==5) hare=hare-12;
        else if (hareMoveType<9) hare=hare+1;
        else hare=hare-2;
        hare = Adjustment (hare);
    }
    public void checkStatus (){
        if (tortoise == numberOfSquare-1 && hare == numberOfSquare-1) System.out.println("Draw!! Both animals win on the same time");
        else if (tortoise == numberOfSquare-1) System.out.println("TORTOISE WINS!!! YAY!!!");
        else if (hare == numberOfSquare-1) System.out.println("Hare wins. Yuch.");
        else System.out.println("System Error!! Please check the code");
    }
    public void startRace (){
        try {
            while (tortoise != numberOfSquare-1 && hare != numberOfSquare-1){
            animalMove ();
            displayResult();
            Thread.sleep(1000);//Loop will print the current time once every 1 second.
            //Reference:https://stackoverflow.com/questions/2702980/java-loop-every-minute.
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkStatus ();   
    }
    public void setData (){
      char select;
      int number=0;
      Scanner input = new Scanner(System.in);
        System.out.println("Do you want to set number of square. If yes, enter y. If no, enter n.");
        select= input.next().charAt(0);
        select = checkEnter(select);
        if (select == 'y'){
            System.out.printf("Enter your number(defult is 70): ");
            try {
                number = input.nextInt();
            }
            catch (Exception e) {
                System.out.println("Exception occurred!! Your enter number must be integers");
            }
            number = checkEnter3 (number);
            setNumberOfSquare (number);
        }
        System.out.println("Do you want to cheat. If yes, enter y. If no, enter n.");
        select= input.next().charAt(0);
        select = checkEnter(select);
        if (select == 'y'){
            System.out.printf("If you want tortoise to win, enter t. If you want hare to win, enter h. If you want draw, enter d: ");
            select= input.next().charAt(0);
            select = checkEnter2(select);
            setcheat(select);
         }
    }
    public char checkEnter (char enter){
        Scanner input = new Scanner(System.in);
        switch (enter) {
            case 'y':
            case 'Y':
                enter = 'y';
                break;
            case 'n':
            case 'N':
                enter = 'n';
                break;
            default:
                System.out.printf("Please enter \"y\" for yes or \"n\" for no, otherwise the race will not start: ");
                enter= input.next().charAt(0);
                enter = checkEnter(enter);
                break;
        }
        return enter;
    }
    
    public char checkEnter2 (char enter){
        Scanner input = new Scanner(System.in);
        if (enter == 't' || enter == 'T') enter = 't';
        else if (enter == 'h' || enter == 'H') enter = 'h';
        else if (enter == 'd' || enter == 'D') enter = 'd';
        else {
            System.out.printf("Please enter \"t\" for tortoise win, \"h\" for hare win or \"d\" for draw, otherwise the race will not start: ");
            enter= input.next().charAt(0);
            enter = checkEnter2(enter);
        }
        return enter;
    }
    
    public int checkEnter3 (int enter){
        Scanner input = new Scanner(System.in);
        if (enter > 0 && enter < 1000) ;
        else {
            System.out.printf("The range of the number of the square is between 1 to 999, so please enter number within the range: ");
            try {
                enter = input.nextInt();
            }
            catch (Exception e) {
                System.out.println("Exception occurred!! Your enter number must be integers");
            }
            enter = checkEnter3(enter);
        }
        return enter;
    }
    
}