package util ;

/*
* Defines a class to read moves for a pfc program
*/ 

public class pfcInput {

	// contains a string corresponding to last user's input
    private String lastInput ;

	/**
	* builds an pfcInput with last input <code>null</code>
	*/
	public pfcInput() {
		this.lastInput = null ;
	}

	/**
	*converts the "name" of a move to a number
	*@param c the char representing the name of the move, respectively <code>'r'</code>, <code>'p'</code>, <code>'s'</code>
	* @return the number for this move, respectively 0, 1, 2
	*/
	private int num(char c) {
		switch(c) {
			case 'r' : return 0 ;
			case 'p' : return 1 ;
			case 's' : return 2 ;
			default : return - 1 ;
		}
	}

	/**
	* checks if the given string is a legal input
    * a legal move is composed of two chars among : 'r', 'p', 's'
    * @param s the input to be checked
    *@return <code>true</code> off the input is legal
    */
	private boolean isAnInput(String s) {
		if (s == null) return false ;
		if (s.length() != 1) return false ;
		return this.num(s.charAt(0)) > -1;
	}

	/**
	* waits until the user provides a legal input
	* the input is stored as les "last input"
	*/
	public void readInput() {
		String s = null ;
		while (! isAnInput(s)) {
			System.out.print("> ") ;
			Input input =new Input();
			s = Input.readString().trim().toLowerCase() ;
			if (! isAnInput(s)) System.out.println("   ?") ;
		}
		this.lastInput = s ;
	}

	/**
	*converts the last input of a move to a number
	*@return the number for this move, respectively 0, 1, 2
	*/
	public int getMove(){
		return this.num(this.lastInput.charAt(0));
	}
}
