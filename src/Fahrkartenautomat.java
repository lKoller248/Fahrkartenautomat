import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

class Fahrkartenautomat {
    public static void main(String[] args) {

        double[] Zahlungsmittel = {0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20};
        boolean gueltig = false;

        Scanner tastatur = new Scanner(System.in);

        double zuZahlenderBetrag;
        double eingezahlterGesamtbetrag;
        double eingeworfeneMuenze;
        int anzTickets;

        // 1    Geldbetrag eingeben
        System.out.print("Ticketpreis(Euro): ");
        zuZahlenderBetrag = tastatur.nextDouble();
        if(zuZahlenderBetrag <= 0){
            zuZahlenderBetrag = 1;
            System.out.println("Fehlerhafte Eingabe - Ticketpreis wird auf 1 gesetzt.");
        }

        System.out.println("Fahrkartenbestellvorgang:");
        System.out.println("=========================\n");

        do{
            System.out.print("Anzahl der Tickets: ");
            anzTickets = tastatur.nextInt();
            if(anzTickets > 10 || anzTickets < 1){
                System.out.println(" >> Waehlen Sie bitte eine Anzahl von 1 bis 10 Tickets aus. <<");
            }
        }while (anzTickets > 10 || anzTickets < 1);

        zuZahlenderBetrag *= anzTickets;

        // 2    Geldeinwurf
        eingezahlterGesamtbetrag = 0.0;
        BigDecimal zuZahlen = new BigDecimal(zuZahlenderBetrag);
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            zuZahlen = BigDecimal.valueOf(zuZahlenderBetrag).subtract(BigDecimal.valueOf(eingezahlterGesamtbetrag));
            System.out.printf("Noch zu zahlen: %.2f Euro\n", zuZahlen);
            System.out.print("Eingabe (mind. 5 Cent, hoechstens 20 Euro): ");
            gueltig = false;
            eingeworfeneMuenze = tastatur.nextDouble();
            for(int i = 0; i < Zahlungsmittel.length; i++){
                if(Zahlungsmittel[i] == eingeworfeneMuenze){
                    gueltig = true;
                }
            }
            if(gueltig){
                eingezahlterGesamtbetrag = eingezahlterGesamtbetrag + eingeworfeneMuenze;
            }else{
                System.out.println(">> Kein gueltiges Zahlungsmittel.");
            }
        }

        BigDecimal gesamt = new BigDecimal(eingezahlterGesamtbetrag);

        // 3    Fahrscheinausgabe
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 8; i++) {
            System.out.print("=");
            try {
                Thread.sleep(200);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");

        // 4    Rückgeldberechnung und -ausgabe
        BigDecimal rueckgabe = gesamt.subtract(BigDecimal.valueOf(zuZahlenderBetrag));
        MathContext m = new MathContext(2);
        rueckgabe = rueckgabe.round(m);

        if (rueckgabe.compareTo(BigDecimal.valueOf(0)) > 0) {
            System.out.printf("Der Rueckgabebetrag in Hoehe von %.2f Euro\n", rueckgabe);
            System.out.println("wird in folgenden Muenzen ausgezahlt:");

            while (rueckgabe.compareTo(BigDecimal.valueOf(2.0)) >= 0) { // 2-Euro-Münzen
                System.out.println("2 Euro");
                rueckgabe = rueckgabe.subtract(BigDecimal.valueOf(2.0));
            }
            while (rueckgabe.compareTo(BigDecimal.valueOf(1.0)) >= 0) { // 1-Euro-Münzen
                System.out.println("1 Euro");
                rueckgabe = rueckgabe.subtract(BigDecimal.valueOf(1.0));
            }
            while (rueckgabe.compareTo(BigDecimal.valueOf(0.5)) >= 0) { // 50-Cent-Münzen
                System.out.println("50 Cent");
                rueckgabe = rueckgabe.subtract(BigDecimal.valueOf(0.5));
            }
            while (rueckgabe.compareTo(BigDecimal.valueOf(0.2)) >= 0) { // 20-Cent-Münzen
                System.out.println("20 Cent");
                rueckgabe = rueckgabe.subtract(BigDecimal.valueOf(0.2));
            }
            while (rueckgabe.compareTo(BigDecimal.valueOf(0.1)) >= 0) { // 10-Cent-Münzen
                System.out.println("10 Cent");
                rueckgabe = rueckgabe.subtract(BigDecimal.valueOf(0.1));
            }
            while (rueckgabe.compareTo(BigDecimal.valueOf(0.05)) >= 0) { // 5-Cent-Münzen
                System.out.println("5 Cent");
                rueckgabe = rueckgabe.subtract(BigDecimal.valueOf(0.05));
            }
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wuenschen Ihnen eine gute Fahrt.");

        tastatur.close();
    }
}