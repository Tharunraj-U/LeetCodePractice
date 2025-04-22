package org.example.ZohoLevel_3.SnakeGame;

import java.util.*;


public class Snake {
    Scanner scanner=new Scanner(System.in);
    char board[][]=new char[8][8];
    Set<String> set=new HashSet<>();
    Queue<int[]> queue=new LinkedList<>();
    int newRow=0;
    int newCol =0;
    Snake(){
       Arrays.stream(board).forEach(e-> Arrays.fill(e,'E'));
       board[0][0]='S';
       board[5][5]='X';
       board[4][7]='X';
        board[2][2]='X';
       queue.offer(new int[]{newRow,newCol});
       set.add("0,0");
    }
    public void playGame(){
          
          while (true){
              print();
              System.out.print("Enter Your Move :");
              char nextMove=scanner.next().toUpperCase().charAt(0);
              if(nextMove == 'L'){
                  newCol--;
              }
              if(nextMove == 'R'){
                  newCol++;
              }
              if(nextMove == 'U'){
                  newRow--;
              }
              if(nextMove == 'D'){
                  newRow++;
              }
              if(newRow > -1 && newRow < 8  && newCol > -1 && newCol < 8){
                  if(board[newRow][newCol] =='E'){
                     board[queue.peek()[0]][queue.peek()[1]] ='E';
                     queue.poll();
                     set.add(newRow+","+newCol);
                  } else if (board[newRow][newCol] == 'X') {
                      createAnPoint();
                      set.remove(newRow+","+newCol);
                  }else if(set.contains(newRow+","+newCol)){
                      System.out.println("You Hit Your Self");
                      System.out.println("Your Score :"+queue.size()+"💪");
                      System.exit(100);
                  }
                  board[newRow][newCol]='S';
                  queue.offer(new int[]{newRow,newCol});
              }else {
                  System.out.println("Game Over ");
                  System.out.println("Your Score :"+queue.size() +"  💪");
                  System.exit(100);
              }
          }
    }

    private void createAnPoint() {

        for(int i=0;i<100;i++){

            int row=(int) (Math.random()*100)%8;
            int col=(int) (Math.random()*100)%8;
            if(!set.contains(row+","+col) && board[row][col] == 'E'){
                board[row][col]='X';
                return;
            }
        }
    }

    public void print(){
        for(char c[]:board){
            for(char a:c){
                if(a == 'S'){
                    System.out.print("🔴 ");
                }else  if(a == 'E'){
                    System.out.print("⬜ ");
                }else {
                    System.out.print("🌟 ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Snake snake=new Snake();
        snake.playGame();
    }
}
