public class Fahrplan {
    public static void main(String[] args) {

        // Weichestellungen
        int fahrzeit = 0;
        char haltInSpandau = 'n';
        char richtungHamburg = 'n';
        char haltInStendal = 'j';
        char endetIn = 'h';

        fahrzeit = fahrzeit + 8; // Fahrzeit Hbf -> Spandau

        if (haltInSpandau == 'j') {
            fahrzeit = fahrzeit + 2; // Halt in Spandau
        }

        if(richtungHamburg == 'j'){
            fahrzeit += 96;
        }else{
            fahrzeit += 34;
        }

        if(haltInStendal == 'j'){
            fahrzeit += 16;
        }else{
            fahrzeit +=6;
        }

        if(endetIn == 'w'){
            fahrzeit += 29;
        }else if(endetIn == 'b'){
            fahrzeit += 50;
        }else if(endetIn == 'h'){
            fahrzeit += 62;
        }
    }
}
