import java.math.BigDecimal;
import java.math.MathContext;
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
        int ticket;
        double ticketPrice = 0;

        System.out.println("Fahrkartenbestellvorgang:");
        System.out.println("=========================\n");

        System.out.println("Wählen Sie ihre Wunschkarte für Berlin AB aus:");
        System.out.println("  Kurzstrecke AB [2,00 EUR] (1)");
        System.out.println("  Einzelfahrschein AB [3,00 EUR] (2)");
        System.out.println("  Tageskarte AB [8,80 EUR] (3)");
        System.out.println("  4-Fahrten-Karte AB [9,40 EUR] (4)");
        System.out.println();

        boolean x = true;
        do{
            System.out.print("Ihre Wahl: ");
            ticket = tastatur.nextInt();
            switch(ticket){
                case 1:
                    ticketPrice = 2.00;
                    x = false;
                    break;
                case 2:
                    ticketPrice = 3.00;
                    x = false;
                    break;
                case 3:
                    ticketPrice = 8.80;
                    x = false;
                    break;
                case 4:
                    ticketPrice = 9.40;
                    x = false;
                    break;
                default:
                    System.out.println("  >> Falsche Eingabe <<");
                    break;
            }
        }while(x);

        do{
            System.out.print("Anzahl der Tickets: ");
            anzTickets = tastatur.nextInt();
            if(anzTickets > 10 || anzTickets < 1){
                System.out.println(" >> Waehlen Sie bitte eine Anzahl von 1 bis 10 Tickets aus. <<");
            }
        }while (anzTickets > 10 || anzTickets < 1);

        zuZahlenderBetrag = anzTickets * ticketPrice;

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