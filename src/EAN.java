import java.util.Locale;
import java.util.Scanner;

public class EAN {
    public static void main(String[] args) {
        Scanner tastatur = new Scanner(System.in);
        String input;

        while(true){
            do{
                System.out.println("Check if the following EAN-13-Code is valid.");
                input = tastatur.nextLine();
            }while(!TryParse(input));

            if(CheckEAN(input)){
                System.out.println("This is true.");
            }else{
                System.out.println("It was a shitty number. Try again next time. :)");
            }
        }
    }

    public static boolean CheckEAN(String input){
        char[] arr = input.toCharArray();
        int checksum = 0;

        for(int i = 0; i < arr.length-1; i++){
            int x = Integer.parseInt(String.valueOf(arr[i]));
            if(i % 2 == 0){
                checksum += x * 1;
            }else{
                checksum += x * 3;
            }
        }

        int rest = checksum % 10;
        int y = Integer.parseInt(String.valueOf(arr[12]));
        if(10-rest == y){
            return true;
        }

        return false;
    }

    public static boolean TryParse(String input){
        char[] arr = input.toCharArray();

        if(input.length() != 13){
            return false;
        }

        for(int i = 0; i < arr.length; i++){
            try{
                Integer.parseInt(String.valueOf(arr[i]));
            }
            catch(NumberFormatException e){
                return false;
            }
        }
        return true;
    }
}

// 9783815820865 true

// 4780201379636 true
// 2222222222221 false
// 1234567890128 true
// 9807522453694 true
// 7539518524561 false