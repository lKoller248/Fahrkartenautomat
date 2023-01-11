import java.util.Scanner;

public class Matrix {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        boolean x = true;
        int number = 0;

        do {
            System.out.print("Bitte geben Sie eine Zahl zwischen 2 und 9 ein: ");
            String input = keyboard.nextLine();
            if(TryParse(input)){
                number = Integer.parseInt(input);
                if(number <= 9 && number >= 2){
                    x = false;
                }
            }
        }while(x);

        for(int i = 0; i < 100; i++){
            if(i == 0){
                System.out.printf("%3s", "*");
            }
            else if(WithoutRest(number, i) || ContainsNumber(number, i) || CheckSumEqual(number, i)){
                System.out.printf("%3s", "*");
            }
            else{
                System.out.printf("%3d", i);
            }
            if(i % 10 == 9) System.out.println();
        }
        System.out.println();
    }

    public static boolean WithoutRest(int z, int c){
        if(c % z == 0) return true;
        return false;
    }

    public static boolean ContainsNumber(int z, int c){
        if(Integer.toString(c).contains(Integer.toString(z))) return true;
        return false;
    }

    public static boolean CheckSumEqual(int z, int c){
        if(CheckSum(z) == CheckSum(c)) return true;
        return false;
    }

    public static int CheckSum(int z){
        return z / 10 + z % 10;
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
