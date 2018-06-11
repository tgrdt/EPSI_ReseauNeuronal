package SE_Package;

public class Main {

    public static void main(String[] args) {
        // Création du système expert
        ES sysExpert = new ES();

        // Création des polygones
        Poly poly1 = new Poly(3, 1, 2);
        System.out.println(poly1.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly1));

        Poly poly2 = new Poly(4,4, 2);
        System.out.println(poly2.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly2));

        Poly poly4 = new Poly(4,4, 4);
        System.out.println(poly4.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly4));

        Poly poly3 = poly1;
        System.out.println(poly3.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly3));



    }
}
