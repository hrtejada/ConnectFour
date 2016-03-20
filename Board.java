

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Board {
	/* Main functions when creating/editing/resetting board are done in this class */
	/* Aslo this class sets the game pieces */
	
	public static int rows = 7;
	public static int columns = 8;
	public static int[] xaxis = new int[8];//To show column numbers
	public static String[][] gameBoard = new String[rows][columns];//Matrix of Board
	public static int moveCount = 0;
	
        public static void saveBoard(String filename){
        String C4File = "ConnectFour" + filename;
        File file = new File("/home/beto/GameLogs/" + C4File);
        try {
            FileOutputStream OS = new FileOutputStream(file);
            
            ObjectOutputStream os = new ObjectOutputStream(OS); 
            os.writeObject(gameBoard);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(guiFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(guiFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
        
	public static void matchBoards(String[][] loadedBoard){
            for(int i = 0; i < loadedBoard.length; i++){
                for(int j = 0; j < loadedBoard[i].length; j++){
                    guiFrame.Grid[i][j].setText(loadedBoard[i][j]);
                    gameBoard[i][j] = loadedBoard[i][j];
                }
            }
        }
        
	public static void makeBoard(){//Makes the board and fills it with blanks
		for(int x = 0; x < 8; x++){
			xaxis[x] = x;
		}
		
		for(int i =0; i < gameBoard.length; i++){
			for(int j = 0; j < gameBoard[i].length; j++){
				gameBoard[i][j] = "~";
			}			
		}
	}
	
	public static void printBoard(){//prints out the board
		for(int i =0; i < gameBoard.length; i++){
			for(int j = 0; j < gameBoard[i].length; j++){
				if(j == 0){
					System.out.print((i+1) + "|");//Prints out row number
				}
				System.out.print("|");
				System.out.print(gameBoard[i][j]);
				System.out.print("|");
			}		
			System.out.println();
		}
		System.out.print("  ");
		for(int y = 0; y < xaxis.length; y++){
			System.out.print("|");
			System.out.print(xaxis[y]+1);
			System.out.print("|");
		}
	}
	
	public static boolean notFull(){//checks if board is full. returns false if not.
		for(int i =0; i < gameBoard.length; i++){
			for(int j = 0; j < gameBoard[i].length; j++){
				if(gameBoard[i][j] == " "){
					return true;
				}		
			}
		}
		
		return false;
		
	}
        
}