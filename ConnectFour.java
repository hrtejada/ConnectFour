//Hector Roberto Tejada
//Advanced Object Oriented Programming
//Connect 4 
//September 24, 2014


import java.awt.Component;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner; 
import javax.swing.JOptionPane;
public class ConnectFour extends Board{
	static Scanner Input = new Scanner(System.in);
	public static Player first;
	public static Player second;
        public static boolean win = false;
	public static Player curr;
        
	public static void main(String[] args) {
            WelcomeGUI.run();

	}
	 
        public static boolean check(Player player){
		win = false;//win always set to false to start checking.
		curr = player;
		checkHorizontal();//starrts checking wth horizontal
		return win;
	}

	public static void checkHorizontal(){//Checks to see if player has won horizontally
		int count = 0; //lazy count and temp checker method. try algorithm instead.
		String temp = "";// empty string temp
		
			for(int i = 6; i > 0; i--){//loops to go trhough board
			for(int j = 0; j < guiFrame.Grid[0].length; j++){
				if(guiFrame.Grid[i][j].getText().equals(temp) && !guiFrame.Grid[i][j].getText().equals("~")){
					count++;
					if(count == 3){
						//JOptionPane.showConfirmDialog(null, "Player " + curr.getName() + " Won! Play Again?");//System.out.println("Player: " + curr.getName() + " has won!!!");
						int result = JOptionPane.showConfirmDialog((Component) null, curr.getName() + " Won. Play Again? ","alert", JOptionPane.YES_NO_OPTION);
                                                guiFrame.Win(result);
                                                //0 yes
                                                //1 no
                                                //2 cancel
                                                win = true;
					}
					temp = guiFrame.Grid[i][j].getText();///Don't think i need this....Come back and check!!!!!!!
				}
				else{
					count = 0;//reset tempp and counter if temp does not match next token
					temp = guiFrame.Grid[i][j].getText();
				}
			}
			}
		
		if(win == false){//if win not recognized go to next check
			checkVertical();
		}
		
	}
	
	
	public static void checkVertical(){//Method to check Vertical Wins
		
		for (int i = 0 ;i < 8; i++)// first for loop is going to traverse the different columns.
	    {
	      for (int j = 0; j < 4; j++)//only need to go up to 4 because of amount of rows. traverses rows
	      {
	    	  //System.out.println("test" + i + j);
	            if((!guiFrame.Grid[j][i].getText().equals("~"))//algorithm to check vertical win
	            && (!guiFrame.Grid[j+1][i].getText().equals("~"))
	            && (!guiFrame.Grid[j+2][i].getText().equals("~"))
	            && (!guiFrame.Grid[j+3][i].getText().equals("~"))
	            && ((guiFrame.Grid[j][i].getText().equals(guiFrame.Grid[j+1][i].getText()))
	            && (guiFrame.Grid[j+1][i].getText().equals(guiFrame.Grid[j+2][i].getText()))
	            && (guiFrame.Grid[j+2][i].getText().equals(guiFrame.Grid[j+3][i].getText())))){
                                        int result = JOptionPane.showConfirmDialog((Component) null, curr.getName() + " Won. Play Again? ","alert", JOptionPane.YES_NO_OPTION);
                                        guiFrame.Win(result);
					win = true;	
	            }
	      } 
	    }
		
		if(win == false){//if win not recognized go to next check
			checkDownDiagonal();
		}
		
	}
	
	public static void checkDownDiagonal(){
		
		for(int i = 0;i < 4;i++){//for loops to check diagonal. no need to check whole board. last 3 rows do not need to be checked.
	      for(int j = 0;j < 5;j++){//goes through columns. does not need to check final 3 columns
	    	  
	            if((!guiFrame.Grid[i][j].getText().equals("~"))//algorithm to check DownDiagonal
	            && (!guiFrame.Grid[i+1][j+1].getText().equals("~")) 
	            && (!guiFrame.Grid[i+2][j+2].getText().equals("~"))
	            && (!guiFrame.Grid[i+3][j+3].getText().equals("~")) 
	            && ((guiFrame.Grid[i][j].getText().equals(guiFrame.Grid[i+1][j+1].getText())) 
	            && (guiFrame.Grid[i+1][j+1].getText().equals(guiFrame.Grid[i+2][j+2].getText()))
	            && (guiFrame.Grid[i+2][j+2].getText().equals(guiFrame.Grid[i+3][j+3].getText())))){
                            int result = JOptionPane.showConfirmDialog((Component) null, curr.getName() + " Won. Play Again? ","alert", JOptionPane.YES_NO_OPTION);
                            guiFrame.Win(result);
		              win = true;
	            }
	      } 
	      
	    }
		
		if(win == false){//if win not recognized go to next check
			checkUpDiagonal();
		}
		
	}
	
	public static void checkUpDiagonal(){
		
	for(int i = 3; i < 7; i++){//no need to check top three rows
			int jlimit = 8;
	      for(int j = 0; j < 8; j++){//need to check all columns
	    	  if(j+1 < jlimit && j+2 < jlimit && j+3 < jlimit){
	            if((!guiFrame.Grid[i][j].getText().equals("~"))//algorithm for checking up diagonal
	            && (!guiFrame.Grid[i-1][j+1].getText().equals("~"))
	            && (!guiFrame.Grid[i-2][j+2].getText().equals("~"))
	            && (!guiFrame.Grid[i-3][j+3].getText().equals("~"))
	            && ((guiFrame.Grid[i][j].getText().equals(guiFrame.Grid[i-1][j+1].getText()))
	            && (guiFrame.Grid[i-1][j+1].getText().equals(guiFrame.Grid[i-2][j+2].getText()))
	            && (guiFrame.Grid[i-2][j+2].getText().equals(guiFrame.Grid[i-3][j+3].getText())))){
                              int result = JOptionPane.showConfirmDialog((Component) null, curr.getName() + " Won. Play Again? ","alert", JOptionPane.YES_NO_OPTION);
                              guiFrame.Win(result);
		              win = true;
	            }  
	    	  }
	      } 
	      
	    }
		
		if(win == false){//if win not recognized go to next check
			checkTie();
		}
		
	}
	
	public static void checkTie(){//final check. if board is full win is true. else, win stays as false.
		int count = 0;
		for(int i = 0; i < rows; i++){
			for(int j = 0; j < columns; j++){
				if(!guiFrame.Grid[i][j].getText().equals("~")){
					count++;//counter to check if all spaces are filled with tokens
				}
			}
		}
		
		if(count == 56){//amount of tokens possible
			int result = JOptionPane.showConfirmDialog((Component) null, "TIE Game. Play Again? ","alert", JOptionPane.YES_NO_OPTION);
                        guiFrame.Win(result);//System.out.println("No more spaces. Tie game.");
			win = true;
		}
		
		
	}
	
			
}