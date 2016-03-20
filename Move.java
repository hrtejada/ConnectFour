import java.util.Scanner;
import javax.swing.JOptionPane;


public class Move extends Board{//Move like a noun
	static String currentToken;
	static int currentMove;
	static Player curr;
	
	public static void getMove(Player player, int move){//gets move and player and assigns curr's
		curr = player;
		currentToken = player.getToken();
		currentMove = move;
		setMove();
	}
	
	public static void setMove(){//sets move in the board
		Scanner Input = new Scanner(System.in);
		int newMove = -1;
		int r = 6;
		
		while (r >= 0 && !guiFrame.Grid[r][currentMove].getText().equals("~")) {
		r--;//looks for free space in board to place token
		}
		
		if(r == -1){
			JOptionPane.showMessageDialog(null, "Column Full");
		}
		
		else if(guiFrame.Grid[r][currentMove].getText() == "X" || guiFrame.Grid[r][currentMove].getText() == "O"){
			//System.out.println("Space taken by token, input another move ");
			newMove = Input.nextInt();
			getMove(curr, newMove);
		}
		else{
			Board.gameBoard[r][currentMove] = currentToken;
                        guiFrame.Grid[r][currentMove].setText(currentToken);
			//Board.printBoard();//sets token in board
			//System.out.println();
		}
	}
	
	

}