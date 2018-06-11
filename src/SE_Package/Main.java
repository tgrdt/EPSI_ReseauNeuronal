package SE_Package;

public class Main {

    public static void main(String[] args) {
        // Création du système expert
        ES sysExpert = new ES();

        // Création des polygones
        int tab1[] = {3,3,2};
        Poly poly1 = new Poly(3, 1, tab1);
        System.out.println(poly1.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly1));

        int tab2[] = {3,5,3,5};
        Poly poly2 = new Poly(4,4, tab2);
        System.out.println(poly2.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly2));

        int tab4[] = {3,3,3,3};
        Poly poly4 = new Poly(4,4, tab4);
        System.out.println(poly4.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly4));

        Poly poly3 = poly1;
        System.out.println(poly3.getDescription());
        System.out.println(" Résultat = " + sysExpert.getInfo(poly3));



    }
}
