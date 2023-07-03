
import java.util.Random;

public class Dice {

    public int pro20;

    public Dice()throws NumberDiceException {
        setPro();
    }

    private void setPro() throws NumberDiceException{
        Random random = new Random();
        pro20 = random.nextInt(6) + 1;
        if( pro20 > 6 || pro20 <=0 ) 
            throw new NumberDiceException("Number 20% probability in Dice is not in range ");
    }

}
