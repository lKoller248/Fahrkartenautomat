public class Sum {

    public static void main(String[] args) {
        int a = 7; // 1
        int b = 19; // 1
        int ergebnis;
        ergebnis = Summe(a, b); // 2
        System.out.println("Summe der Menge: " + ergebnis);
    }

    // Summe der Zahlen zwischen a und b inc. a und b werden summiert
    public static int Summe(int start, int ende) { // 3
        int wert = 0; // 4
        for (int i = start; i <= ende; i++) { // 4
            wert = wert + i; // 4
        } // 4
        return wert; // 5
    }

}

