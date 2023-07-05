import java.util.*;
class Main {
   public static void main(String[] args) {
    connectFour.setBoard();
    connectFour.printBoard();
    Scanner obj = new Scanner(System.in);
    while(!connectFour.over){
      connectFour.playerTurn();
      int column = obj.nextInt();
      connectFour.addDisk(column);
    }
    connectFour.winner();
    obj.close();
  }
}