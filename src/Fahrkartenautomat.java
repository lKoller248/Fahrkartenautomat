import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

class Fahrkartenautomat {
    public static void main(String[] args) {

        Scanner tastatur = new Scanner(System.in);

        double zuZahlenderBetrag = 0;

        Begruessung();

        zuZahlenderBetrag = FahrkertenbestellungErfassen(tastatur);

        BigDecimal gesamt = new BigDecimal(FahrkartenBezahlen(tastatur, zuZahlenderBetrag));

        FahrkartenAusgeben();

        RueckgeldAusgeben(zuZahlenderBetrag, gesamt);

        tastatur.close();
    }

    public static void Begruessung(){
        System.out.println("Herzlich Willkommen!\n");
    }

    public static double FahrkertenbestellungErfassen(Scanner tastatur){

        double[] prices = {3.0, 3.5, 3.8, 2.0, 8.6, 9.2, 10.0, 9.4, 12.6, 13.8, 25.5, 26.0, 26.5};
        String[] tickets = {"Einzelfahrschein AB","Einzelfahrschein BC","Einzelfahrschein ABC","Kurzstrecke AB","Tageskarte AB","Tageskarte BC","Tageskarte ABC","4-Fahrten-Karte AB","4-Fahrten-Karte BC","4-Fahrten-Karte ABC","Kleingruppen-Tageskarte AB","Kleingruppen-Tageskarte BC","Kleingruppen-Tageskarte ABC"};

        int anzTickets;
        int ticket;
        double ticketPrice = 0;
        boolean bezahlen = false;

        double zuZahlenderBetrag = 0;

        System.out.println("Fahrkartenbestellvorgang:");
        System.out.println("=========================\n");

        System.out.println("Wählen Sie ihre Wunschfahrkarte aus:");

        while(!bezahlen){
            for(int i = 0; i < tickets.length; i++){
                System.out.printf("  " + tickets[i] + " [%.2f€] (" + (i + 1) + ")\n", prices[i]);
            }
            System.out.println("  Bezahlen (0)");
            System.out.println();

            boolean x = true;
            do{
                System.out.print("Ihre Wahl: ");
                ticket = tastatur.nextInt();
                switch(ticket){
                    case 0:
                        bezahlen = true;
                        x = false;
                        break;
                    default:
                        if(ticket > tickets.length){
                            System.out.println("  >> Falsche Eingabe <<");
                            break;
                        }else{
                            ticketPrice = prices[ticket - 1];
                            x = false;
                            break;
                        }
                }
            }while(x);

            if(!bezahlen){
                do{
                    System.out.print("Anzahl der Tickets: ");
                    anzTickets = tastatur.nextInt();
                    if(anzTickets > 10 || anzTickets < 1){
                        System.out.println(" >> Waehlen Sie bitte eine Anzahl von 1 bis 10 Tickets aus. <<");
                    }
                }while (anzTickets > 10 || anzTickets < 1);

                zuZahlenderBetrag += anzTickets * ticketPrice;
            }

            if(!bezahlen){
                System.out.printf("\nZwischensumme: %.2f €\n\n", zuZahlenderBetrag);
            }
        }

        return zuZahlenderBetrag;
    }

    public static double FahrkartenBezahlen(Scanner tastatur, double zuZahlenderBetrag){

        double[] Zahlungsmittel = {0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20};
        boolean gueltig = false;
        double eingezahlterGesamtbetrag;
        double eingeworfeneMuenze;

        eingezahlterGesamtbetrag = 0.0;
        BigDecimal zuZahlen = new BigDecimal(zuZahlenderBetrag);

        System.out.println();
        while (eingezahlterGesamtbetrag < zuZahlenderBetrag) {
            zuZahlen = BigDecimal.valueOf(zuZahlenderBetrag).subtract(BigDecimal.valueOf(eingezahlterGesamtbetrag));
            System.out.printf("Noch zu zahlen: %.2f €\n", zuZahlen);
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
        return eingezahlterGesamtbetrag;
    }

    public static void FahrkartenAusgeben(){
        System.out.println("\nFahrschein wird ausgegeben");
        for (int i = 0; i < 26; i++) {
            System.out.print("=");
            try {
                Thread.sleep(150);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\n\n");
    }

    public static void RueckgeldAusgeben(double zuZahlenderBetrag, BigDecimal eingezahlterGesamtbetrag){

        BigDecimal rueckgabe = eingezahlterGesamtbetrag.subtract(BigDecimal.valueOf(zuZahlenderBetrag));
        MathContext m = new MathContext(2);
        rueckgabe = rueckgabe.round(m);

        if (rueckgabe.compareTo(BigDecimal.valueOf(0)) > 0) {
            System.out.printf("Der Rueckgabebetrag in Hoehe von %.2f Euro\n", rueckgabe);
            System.out.println("wird in folgenden Muenzen ausgezahlt:");

            rueckgabe = MuenzRueckgabe(rueckgabe, 2.0, "2 Euro");
            rueckgabe = MuenzRueckgabe(rueckgabe, 1.0, "1 Euro");
            rueckgabe = MuenzRueckgabe(rueckgabe, 0.5, "50 Cent");
            rueckgabe = MuenzRueckgabe(rueckgabe, 0.2, "20 Cent");
            rueckgabe = MuenzRueckgabe(rueckgabe, 0.1, "10 Cent");
            MuenzRueckgabe(rueckgabe, 0.05, "5 Cent");
        }

        System.out.println("\nVergessen Sie nicht, den Fahrschein\n" + "vor Fahrtantritt entwerten zu lassen!\n"
                + "Wir wuenschen Ihnen eine gute Fahrt.");
    }

    public static BigDecimal MuenzRueckgabe(BigDecimal rueckgabe, double value, String ausgabe){
        while (rueckgabe.compareTo(BigDecimal.valueOf(value)) >= 0) {
            System.out.println(ausgabe);
            rueckgabe = rueckgabe.subtract(BigDecimal.valueOf(value));
        }
        return rueckgabe;
    }
}