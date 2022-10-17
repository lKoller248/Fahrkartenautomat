import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        int year;
        boolean leap;

        System.out.print("Please enter a year: ");
        year = keyboard.nextInt();

        if(year >= -45){
            if(year >= 1582){
                if(year % 4 == 0){
                    leap = true;
                    if(year % 100 == 0){
                        leap = false;
                        if(year % 400 == 0){
                            leap = true;
                        }
                    }
                }else{
                    leap = false;
                }
            }else{
                if(year % 4 == 0){
                    leap = true;
                }else{
                    leap = false;
                }
            }
        }else{
            leap = false;
        }

        if(leap){
            System.out.println("It is a leap year.");
        }else{
            System.out.println("It is not a leap year.");
        }
    }
}
