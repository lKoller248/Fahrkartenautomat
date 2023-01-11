import java.util.Scanner;

public class Holiday {

    static int reserveLimit = 100;

    public static void main(String[] args) {

        boolean x = true;
        int budget = Budget();
        ShowSelectionMenu();
        do{
            budget -= ChangeCurrency(budget);

            if(budget < reserveLimit){
                System.out.println("You do not have enough money left. Go home.");
                x = false;
            }
            System.out.println("\nYou have " + budget + "€ left.\n");
        }while(x);
    }

    public static int ChangeCurrency(int budget){
        Scanner keyboard = new Scanner(System.in);
        double exchangeRate = 0;
        int euro = 0;
        String currency = "";
        boolean x = false;

        do{
            x = false;
            System.out.print("Please select the country: ");
            switch (keyboard.nextLine().toLowerCase()){
                case "usa":
                    exchangeRate = 0.98;
                    currency = "$";
                    break;
                case "japan":
                    exchangeRate = 141;
                    currency = "¥";
                    break;
                case "england":
                    exchangeRate = 0.88;
                    currency = "£";
                    break;
                case "schweiz":
                    exchangeRate = 0.96;
                    currency = "CHF";
                    break;
                case "dänemark":
                    exchangeRate = 7.44;
                    currency = "DKK";
                    break;
                default:
                    x = true;
            }
        }while(x);

        x = true;
        do{
            System.out.print("Please enter the amount you want to exchange (in €, min 1€): ");

            String input = keyboard.nextLine();
            if(TryParse(input)){
                euro = Integer.parseInt(input);
                if(euro >= 1){
                    x = false;
                }
            }
            if(euro > budget){
                System.out.println("You do not have enough money. Please try again.");
                x = true;
            }
        }while(x);

        ChangeCurrency(euro, exchangeRate, currency);

        return euro;
    }

    public static void ChangeCurrency(int euro, double exchangeRate, String currency){
        System.out.println("\nYou exchanged " + euro + "€: " + euro * exchangeRate + currency + "\n");
    }

    public static void ShowSelectionMenu(){
        System.out.println();
        System.out.println("USA: 1 Euro > 0,98 USD (Dollar)");
        System.out.println("Japan: 1 Euro > 141 JPY (Yen)");
        System.out.println("England: 1 Euro > 0,88 GBP (Pfund)");
        System.out.println("Schweiz: 1 Euro > 0,96 CHF (Franken)");
        System.out.println("Dänemark: 1 Euro > 7,44 DKK (Kronen)");
        System.out.println();
    }
    public static int Budget(){
        Scanner keyboard = new Scanner(System.in);
        int budget = 0;
        boolean x = true;

        do {
            System.out.println("Your reserve limit is " + reserveLimit + "€.");
            System.out.print("Please enter your travel budget (in €, min 100€): ");

            String input = keyboard.nextLine();
            if(TryParse(input)){
                budget = Integer.parseInt(input);
                if(budget > 100){
                    x = false;
                }
            }
        }while(x);

        return budget;
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
