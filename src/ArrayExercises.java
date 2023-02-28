public class ArrayExercises {
    public static void main(String[] args) {
        //Aufgabe1();
        //Aufgabe2();

        int[] numbers = new int[100];
        for(int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        for(int i = 0; i < numbers.length; i++){
            numbers[i] = i + 1;
        }

        System.out.println(numbers[89]);

        numbers[49] = 1060;

        numbers[0] = 2023;
        numbers[numbers.length - 1] = 2023;

        for(int i = 0; i < numbers.length; i++){
            System.out.println("Index " + i + " - Inhalt: " + numbers[i]);
        }

        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        double av = sum / numbers.length;
        System.out.println("Durchschnitt der Array-Elemente: " + av);
    }

    public static void Aufgabe1(){
        int[] zahlen = {1, 6, 3, 7, 2};
        int i = 4;

        System.out.println(zahlen[1]); // => 6
        //System.out.println(zahlen[5]); => out of bounds
        System.out.println(zahlen[3]); // => 7
        System.out.println(zahlen[i]); // => 2
        System.out.println(zahlen[i-2]); // => 3
        System.out.println(zahlen[zahlen[4]]); // => 3
        System.out.println();
    }

    public static void Aufgabe2(){
        int[] zahlen = {1, 6, 3, 7, 2, 2, 4, 8};

        for (int i=2; i<=3; i++) {
            System.out.print(zahlen[i] + ", ");
        } // => 3, 7,
        System.out.println();

        for (int i=0;  i<=zahlen.length;  i++) {
            // System.out.print (zahlen[i] + ", ");
        } // => 1, 6, 3, 7, 2, 2, 4, 8, error out of bounds
        System.out.println();

        for (int i=1; i<=zahlen.length-1; i=i+2) {
            System.out.print(zahlen[i] + ", ");
        } // => 6, 7, 2, 8,
        System.out.println();
    }
}
