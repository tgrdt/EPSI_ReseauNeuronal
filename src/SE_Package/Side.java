package SE_Package;

/**
 * Created by tgrdt on 11/06/2018.
 */
public class Side {

    private Rand _random = new Rand();
    private int length;

    public Side(){

        this.length = Cfg.Rand.getRandomSideLenght();
    }

    public Side(int length){

        if(length < 1){
            length = 1;
        } else if (length > 9){
            length = 9;
        }

        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}