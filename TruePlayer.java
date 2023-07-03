
public class TruePlayer extends Player{
    public TruePlayer(String name){
        super(name);
    }

    public void loseGame(){
        System.out.println("Person Player " + this.getName()+ " Losing Game");
    }

}
