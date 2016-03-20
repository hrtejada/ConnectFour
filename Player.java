
public class Player extends ConnectFour{
	
	String playerName;
	private String Token;
        Player next;
	
	public Player(String name, String token){//Constructor that sets player name
		playerName = name;
                Token = token;
                
	}
	
	public String getName(){//returns player name
		return playerName;
	}
	
	
	public String getToken(){//returns token
		return Token;
	}
	
}
