import java.util.Scanner;

public class tictactoe {
    Space[] board;

    public tictactoe(){
        board = new Space[9];

        for(short i = 0; i < board.length; i++){
            board[i] = new Space();
            board[i].number = i ;
            board[i].number++;

            /* if(i % 2 ==0)
            board[i].occupant = 'X';
            if(i % 2 == 1)
            board[i].occupant = 'O'; */
        }
    }
    public void draw_board(){
        short cursor = 1;

        for(Space s : board){
            if(s.occupant == '\u0000'){
                if(cursor < 3){
                    System.out.print(s.number);
                    System.out.print("|");
                    cursor++;
                }else{
                    System.out.print(s.number);
                    System.out.print("\n");
                    if(s.number == 9){
                        break;
                    }
                    cursor = 1;
                    draw_tween();
                }
            }else {
                if(cursor < 3){
                    System.out.print(s.occupant);
                    System.out.print("|");
                    cursor++;
                }else{
                    System.out.print(s.occupant);
                    System.out.print("\n");
                    if(s.number == 9){
                        break;
                    }
                    cursor = 1;
                    draw_tween();
                }
            }
        }
    }

    private void draw_tween(){
        System.out.print("_|_|_\n");
    }

    public void game_loop(){
        boolean game_over = false;
        Scanner sc = new Scanner(System.in);
        String move = "";
        int location = 0;
        char piece = ' ';

        while(!game_over){
            System.out.println("Enter a move (PieceLocation ex. X3): ");
            move = sc.nextLine();
            location = Integer.parseInt(move.substring(1)) - 1;
            piece = move.charAt(0);
            board[location].occupant = piece;
            draw_board();
        }
    }

    public static void main(String[] args) {
        tictactoe t = new tictactoe();
        t.draw_board();
        t.game_loop();
    }
}

class Space {
    short number;
    char occupant;
}
