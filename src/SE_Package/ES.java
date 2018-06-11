package SE_Package;

/**
 * Created by tgrdt on 11/06/2018.
 */
import java.util.ArrayList;

public class ES {

    public String getInfo(Poly oPoly){
        String res = "Ce polygone est ";

        switch (oPoly.getSideCount()){

            case Cfg.IS_TRIANGLE:

                res += "un triangle";

                if(isTriangleRectangle(oPoly)){

                    if(isAllSidesEqual(oPoly)){

                        res += " équilatéral rectangle";

                    } else if(isTriangleIsocele(oPoly)) {

                        res += " isocèle rectangle";
                    }

                } else if(isAllSidesEqual(oPoly)){

                    res += "équilatéral";
                }

                break;

            case Cfg.IS_QUADRILATERE:

                res += "un quadrilatère";

                int iCountRightAngle = oPoly.getiAngleDroit();
                int tmpTab[] = oPoly.getTabMesure();
                if(iCountRightAngle == 4) {

                    if(tmpTab[0] == tmpTab[2] && tmpTab[1] == tmpTab[3]){
                        res += " de type rectangle";
                    } else if(tmpTab[0] == tmpTab[2] && tmpTab[1] == tmpTab[3] && tmpTab[2] == tmpTab[1]  ) {
                        res += " de type carré";
                    }
                }

                break;



            default:
                res += "un polygone à " + oPoly.getSideCount() + " côtés.";
                break;

        }

        return res;
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
