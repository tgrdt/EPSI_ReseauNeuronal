package SE_Package;

/**
 * Created by tgrdt on 11/06/2018.
 */
import java.util.Random;

public class Rand {

    private Random Random = new Random();

    public int getRandomInt(int lowerBound, int upperBound){

        int res = 0;

        res = lowerBound + Random.nextInt(upperBound - lowerBound);

        return res;
    }

    public int getRandomSideLenght(){

        int res = 0;

        res = Cfg.MIN_SIDE_VALUE + Random.nextInt(Cfg.MAX_SIDE_VALUE - Cfg.MIN_SIDE_VALUE);

        return res;
    }

    public int getRandomAngleLenght(){

        int res = 0;

        res = Cfg.MIN_ANGLE_VALUE + Random.nextInt(Cfg.MAX_ANGLE_VALUE - Cfg.MIN_ANGLE_VALUE);

        return res;
    }
}
