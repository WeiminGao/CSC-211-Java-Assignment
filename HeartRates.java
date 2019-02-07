/* Name: Weimin Gao
 * Date: 9/14/2017
 * Type: Programming assignment 1
 * File: HearRates.java
 */
package progassignment_1;

import java.util.Scanner;
public class HeartRates {
  private String FirstName;
  private String LastName;
  private int month;
  private int date;
  private int year;
 
  public HeartRates (){}
  
  public void setInformation (){
      Scanner input = new Scanner(System.in);
      System.out.print("Enter your first name: ");
      FirstName= input.nextLine();
      System.out.print("Enter your last name: ");
      LastName= input.nextLine();
      System.out.print("Enter your date of birth (mmddyyyy): ");
      int birth = input.nextInt();
      year = birth%10000;
      date = (birth/10000)%100;
      month = (birth/1000000)%100;
      
  }
 
  public String getFirstName (){
      return FirstName;
  }
  public String getLastName (){
      return LastName;
  }
  public int getMonth (){
      return month;
  }
  public int getDate (){
      return date;
  }
  public int getYear (){
      return year;
  }
  
  public int calculateAge (int y){
      return 2017-y;
  }
  
  public int calculateMaxHR (int y){
      return 220-y; // here y is age.
  }// or return 220-calculateAge(y), then y is year of birth.
  
  public double calculateTargetHR_lowest (int y){// here y is age.
      return 220-y*0.5;//or return 220-calculateAge(y)*0,5, then y is year of birth.
  }
  public double calculateTargetHR_highest (int y){
      return 220-y*0.85;//or return 220-calculateAge(y)*0,85, then y is year of birt
  }
  
  public void getInformation (){
      System.out.printf("\nYour personal information: \n\nYour name: %s %s", FirstName, LastName); //or getFirstName (), getLastName ()
      System.out.printf("\nYour date of birth: %d/%d/%d",getMonth(),getDate(),getYear());// or month, date, year
      System.out.printf("\nYour age: %d",calculateAge (year));
      System.out.printf("\nYour maximum heart rate: %d",calculateMaxHR (calculateAge (year)));
      System.out.printf("\nYour heart-rate range: %s-%s%n",calculateTargetHR_lowest (calculateAge (year))
                                                         ,calculateTargetHR_highest (calculateAge (year)));
      
  }
  
}
