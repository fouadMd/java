package battleship.io ;


import java.io.IOException;
import java.util.Scanner;

/**
 * tool class for inputs (String or int)
 *
 * @author <a href="mailto:routier@univ-lille.fr">Jean-Christophe Routier</a>
 */
public class Input {

	private static Scanner scanner = new Scanner(System.in);

	/**
	 * reads a string in standard input
	 * 
	 * @return the read string
	 */
	public static String readString() {
	    return Input.scanner.next();
	}

	/**
	 * reads an int in standard input
	 * 
	 * @return the read int
	 * @exception java.io.IOException if input does not correspond to an int
	 */
	public static int readInt(){
	    return Input.scanner.nextInt();
	    
	}

}// Input
