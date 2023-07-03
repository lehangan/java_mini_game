public class VirtualPlayer extends Player{
    public VirtualPlayer(String name){
        super(name);
    }

    public void loseGame(){
        System.out.println("Virtual Player " + this.getName()+ " losing game");
    }
}
