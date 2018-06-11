package SE_Package;

/**
 * Created by tgrdt on 11/06/2018.
 */
public class Angle {

    private int angle;

    public Angle(int angle) {
        this.angle = angle;
    }

    public Angle(){

        this.angle = Cfg.Rand.getRandomAngleLenght();

    }


    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}
