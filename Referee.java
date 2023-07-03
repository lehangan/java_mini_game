public class Referee {

    public void nextPlayer() {

    }

    public int calPoint(Player player, int new_point) {
        int now_point = player.getPoint();
        if (now_point + new_point == 21) {
            player.setPoint(21);
            return 21;
        }
        else if(now_point + new_point > 21) {
            player.setPoint(0);
            return 0;
        } else {
            player.setPoint(now_point + new_point);
        }
        return now_point + new_point;
    }

    public void stateEnd(Player player) {
        if( player.winGame == true){
            System.out.println("Player " + player.getName() + " win this game");
        }
        else {
            player.loseGame();
        }

    }
}
