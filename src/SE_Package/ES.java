package SE_Package;

/**
 * Created by tgrdt on 11/06/2018.
 */
import java.util.ArrayList;

public class ES {

    //ArrayList<String> historique = new ArrayList<>();

    public  ArrayList<String> getInfo(Poly oPoly, ArrayList<String> _historique){
        String res = "Ce polygone est ";
        Boolean dejaConnnu = false;

        if(_historique.size() != 0) {
            for(int i = 0; i < _historique.size(); i = i + 3){
                if(_historique.get(i).equals(oPoly.getDescription())) {
                    dejaConnnu = true;
                    System.out.println("Polygon deja connu.");
                    res = _historique.get(i + 1);
                }
            }
        }

        if(dejaConnnu == false) {
            switch (oPoly.getSideCount()){

                case Cfg.IS_TRIANGLE:

                    res += "un triangle";

                    if(isTriangleRectangle(oPoly)){
                        if(isAllSidesEqual(oPoly)){
                            res += " équilatéral rectangle";
                        } else if(isTriangleIsocele(oPoly)) {
                            res += " isocèle rectangle";
                        }
                    } else if(oPoly.getNbCoteEgaux() == 3){
                        res += " équilatéral";
                    } else if(oPoly.getNbCoteEgaux() == 2) {
                        res += " isocèle";
                    } else if(oPoly.getiAngleDroit() == 0) {
                        res += " quelconque";
                    }
                    break;

                case Cfg.IS_QUADRILATERE:

                    res += "un quadrilatère";

                    int iCountRightAngle = oPoly.getiAngleDroit();
                    if(oPoly.getNbCoteEgaux() == 2 && oPoly.getiAngleDroit() == 4){
                        res += " de type rectangle";
                    } else if(oPoly.getNbCoteEgaux() == 4 && oPoly.getiAngleDroit() == 4) {
                        res += " de type carré";
                    } else if(oPoly.isCoteParallele() == true) {
                        if(oPoly.getNbParallele() == 2 && oPoly.getNbCoteEgaux() == 0) {
                            res += " trapeze";
                        } else if(oPoly.getNbParallele() == 4) {
                            if(oPoly.getNbCoteEgaux() == 2 ) {
                                res += " parallélogramme";
                            } else if( oPoly.getNbCoteEgaux() == 4) {
                                res += " losange";
                            }
                        }
                    } else {
                        res += " quelconque";

                }
                    break;
                case Cfg.IS_PENTAGONE:
                    res += "un pentagone";
                    break;
                case Cfg.IS_SEXTAGONE:
                    res += " un sextagone";
                    break;
                case Cfg.IS_SEPTAGONE:
                    res += " un septagone";
                    break;
                case Cfg.IS_OCTOGONE:
                    res += " un octogone";
                    break;

                default:
                    res += "un polygone à " + oPoly.getSideCount() + " côtés.";
                    break;

            }
        }


        _historique.add(oPoly.getDescription());
        _historique.add(res);
        if(dejaConnnu) {
            _historique.add("Connu");
        } else {
            _historique.add("Non");
        }
        return _historique;
    }

    private boolean isTriangleRectangle(Poly oPoly){

        boolean res = false;

        if(getCountRightAngle(oPoly) == 1){
            res = true;
        }

        return res;
    }

    private boolean isTriangleIsocele(Poly oPoly){

        boolean res = false;

        ArrayList<Side> aSides = oPoly.getaSides();

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(aSides.get(i) == aSides.get(j)) {
                    res = true;
                }
            }
        }

        return res;
    }

    private int getCountRightAngle(Poly oPoly){

        int res = 0;

        for (Angle oAngle: oPoly.getaAngles()) {

            if(oAngle.getAngle() == 90){
                res++;
            }
        }

        return res;
    }

    private boolean isAllSidesEqual(Poly oPoly){

        boolean res = true;

        ArrayList<Side> aSides = oPoly.getaSides();

        for(Side oSide: aSides){

            if(oSide.getLength() != aSides.get(0).getLength()){
                res = false;
            }
        }


        return res;
    }

}
