package SE_Package;

public class Main {

    public static void main(String[] args) {
        // Création du système expert
        ES sysExpert = new ES();

        // Création des polygones

        // Triangle isocèle rectangle
        Poly poly1 = new Poly(3, 1, 2);
        System.out.println(poly1.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly1));

        // Rectangle
        Poly poly2 = new Poly(4,4, 2);
        System.out.println(poly2.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly2));

        // Carré
        Poly poly4 = new Poly(4,4, 4);
        System.out.println(poly4.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly4));

        // Test reconnaissance du rectangle isocèle
        Poly poly3 = new Poly(3, 1, 2);
        System.out.println(poly3.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly3));

        // Triangle quelconque
        Poly poly5 = new Poly(3, 0, 0);
        System.out.println(poly5.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly5));

        // Triangle isocèle
        Poly poly6 = new Poly(3, 0, 2);
        System.out.println(poly6.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly6));

        // Triangle équilatéral
        Poly poly7 = new Poly(3, 0, 3);
        System.out.println(poly7.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly7));

        // Triangle rectangle
        Poly poly8 = new Poly(3, 1, 0);
        System.out.println(poly8.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly8));





    }
}
