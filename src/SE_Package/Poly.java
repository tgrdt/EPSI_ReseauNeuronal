package SE_Package;

/**
 * Created by tgrdt on 11/06/2018.
 */
import java.util.ArrayList;

public class Poly {

    private ArrayList<Side> aSides = new ArrayList<>();
    private ArrayList<Angle> aAngles = new ArrayList<>();
    private ArrayList<String> description = new ArrayList<>();

    private int iSideCount;
    private int iAngleCount;
    private int iAngleDroit;

    public Poly(){

        this.iSideCount = Cfg.Rand.getRandomInt(3,5);

        for(int i = 0; i < this.iSideCount; i++){
            aSides.add(new Side());
        }

        this.iAngleCount = this.iSideCount;

        for(int i = 0; i < this.iAngleCount; i++){
            aAngles.add(new Angle());
        }

    }

    public Poly(int _iSideCount, int _iAngleDroit, int _tab[] ) {
        this.iSideCount = _iSideCount;
        this.iAngleDroit = _iAngleDroit;
        this.iAngleCount = _iSideCount;


        String tmpDesc = "";

        for(int i = 0; i < this.iAngleDroit; i++) {
            this.aAngles.add(new Angle(90));
        }

        for(int i = 0; i < (this.iAngleCount - this.iAngleDroit); i++){
            this.aAngles.add(new Angle());
        }


        for(int i = 0; i < this.iSideCount; i++){
            this.aSides.add(new Side());
        }

        this.description.add("Le polygone construit a " + iSideCount + " cotes, dont " + iAngleDroit + " angle(s) droit.");
        tmpDesc = "Ses cote font : ";

        for(int i = 0; i < _tab.length; i++){
            this.aSides.add(new Side(_tab[i]));
            tmpDesc = " " + _tab[i] + ",";
            if(i == _tab.length -1) {
                tmpDesc += " " + _tab[i] + ".";
            }
        }

        this.description.add(tmpDesc);

    }

    public ArrayList<Side> getaSides() {
        return aSides;
    }

    public void setaSides(ArrayList<Side> aSides) {
        this.aSides = aSides;
    }

    public ArrayList<Angle> getaAngles() {
        return aAngles;
    }

    public void setaAngles(ArrayList<Angle> aAngles) {
        this.aAngles = aAngles;
    }

    public int getSideCount() {
        return iSideCount;
    }

    public int getiAngleCount() {
        return iAngleCount;
    }

    public ArrayList<String> getDescription() { return description; }


}
