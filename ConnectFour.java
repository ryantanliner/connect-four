class connectFour{
  private static String[][] board = new String[6][7];
  private static String turn = "R";
  public static boolean over = false;
  private static int tie = 0;

  public static void setBoard() {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = " ";
      }
    }
  }

  public static void printBoard() {
    for (String[] x : board) {
      System.out.print("|");
      for (String a : x) {
        System.out.print(a + "|");
      }
      System.out.println();
    }
    System.out.println("---------------");
  }

  public static void addDisk(int col) {
    for (int i = board.length - 1; i >= 0 && over == false; i--) {
      if (board[i][col].equals(" ")) {
        if (turn.equals("R")) {
          board[i][col] = turn; 
          tie++;
          printBoard(); 
          if(check4(i, col)){ 
            over = true; 
            return;
          } 
          else{
            turn = "Y"; 
            return; 
          }
        } 
        else {
          board[i][col] = turn; 
          tie++;
          printBoard(); 
          if(check4(i, col)) over = true;  
          else{
            turn = "R"; 
            return; 
          }
        }
      }
    }
  }

  public static void playerTurn() {
    if (turn.equals("R")) {
      System.out.println("Player 1, drop your red disk at column (0-6) :");
    } else {
      System.out.println("Player 2, drop your yellow disk at the column (0-6) :");
    }
  }

  public static boolean check4(int row, int colu) {
    // Check if win horizontally
    int count = 0;
    for (int i = 0; i < board[row].length && count < 4; i++) {
      if (board[row][i].equals(turn)) count++;
      else count = 0;
    }
    if(count == 4) return true;
    
    // Check if win vertically
    count = 0;
    for (int i = board.length - 1; i >= 0 && count < 4; i--) {
      if (board[i][colu].equals(turn)) count++;
      else count = 0;
    }
    if (count == 4) return true;
    // Check if win minor diagonal
    int newRow = row;
    int newCol = colu;
    int num = 0;
    //Left Diagonal up
    while(newRow < board.length - 1 && newCol > 0){
      if(board[++newRow][--newCol].equals(turn)) num++; 
      else break;
    }
    if(num == 3) return true;
    
    newRow = row;
    newCol = colu;
    //Right diagonal up
    while(newRow > 0 && newCol < board[row].length - 1){
      if(board[--newRow][++newCol].equals(turn)) num++;
      else break;
    }
    
    if(num >= 3) return true;
    
    // Check if win major Diagonal
    num = 0;
    newRow = row;
    newCol = colu;
    //Right diagonal down
    while(newRow < board.length - 1 && newCol < board[row].length - 1){
      if(board[++newRow][++newCol].equals(turn)) num++;
      else break;
    }

    if(num == 3) return true;
    
    newRow = row;
    newCol = colu;
    //Left Diagonal up
    while(newRow > 0 && newCol > 0){
      if(board[--newRow][--newCol].equals(turn)) num++;
      else break;
    }

    if(num >= 3) return true;

    // Check if game tie
    if(tie == 42){
      turn = null;
      return true;
    }

    return false;
  }

  
  public static void winner() {
    if(turn == null) System.out.println("Tie");
    else if (turn.equals("R"))
      System.out.println("Player 1 won");
    else
      System.out.println("Player 2 won");
  }
}