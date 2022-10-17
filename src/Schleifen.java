public class Schleifen {
    public static void main(String[] args) {
        for(int i=1; i<=10; i=i+1) {
            System.out.printf("%d ", i*i);
        }
        System.out.println();
        for(int i=10; i<=20; i=i+1) {
            System.out.printf("%d ", i*i);
        }

        System.out.print("\n\n");

        int i = 1;
        while(i <= 10) {
            System.out.printf("%d ", i*i);
            i = i+1;
        }
        System.out.println();
        i = 10;
        while(i <= 20) {
            System.out.printf("%d ", i*i);
            i = i+1;
        }
        System.out.println();       // Bricht nach i==18 ab.
        i = 10;
        while(i <= 20) {
            if (i == 18) break;
            System.out.printf("%d ", i*i);
            i = i+1;
        }
        System.out.println();       // Hängt nach continue in Schleife fest, weil sich i nicht mehr verändert.
        i = 10;
        while(i <= 20) {
            if (i == 11) continue;
            System.out.printf("%d ", i*i);
            i = i+1;
        }
    }
}
