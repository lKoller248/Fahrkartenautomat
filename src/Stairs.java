import java.io.FileOutputStream;
import java.util.Scanner;

public class Stairs {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        boolean x = true;
        int height = 0;
        int width = 0;

        do {
            System.out.print("Stair Height: ");
            String inputH = keyboard.nextLine();

            System.out.print("Step Width: ");
            String inputW = keyboard.nextLine();

            if(TryParse(inputH) && TryParse(inputW)){
                height = Integer.parseInt(inputH);
                width = Integer.parseInt(inputW);
                x = false;
            }
        }while(x);

        for(int i = height; i > 0; i--){
            for(int j = 0; j < i-1; j++){
                for(int z = 0; z < width; z++){
                    System.out.print(" ");
                }
            }
            for(int j = 0; j <= height - i; j++){
                for(int z = 0; z < width; z++){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static boolean TryParse(String input){
        char[] arr = input.toCharArray();

        if(input == "") return false;

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
