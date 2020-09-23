public class Wrapper {
	// static function wrap that returns new instance of Wrapper class with args
	  public static String wrap(String str, int col) {
	    return new Wrapper(col).wrap(str);
	  }

	  int col;
	  // instantiate Wrapper to use col arg later
	  public Wrapper(int col) {
	    this.col = col;
	  }
	  // lineBreak method that returns substring to current substring position
	  // followed be newline, followed by method call to wrap for that substring
	  // including the current substring (position and ending) and col # condition
	  private String lineBreak(String str, int position, int end) {
		    return str.substring(0, position) + "\n" + wrap(str.substring(position + end), col);
		  }
	 
	  // wrap method for handling logic
	  public String wrap(String str) {
		// condition to check if str length (line length) is longer than col # provided
	    if (str.length() <= col)
	      return str;
	    // initiatlive variable to equal the substring and including last index of
	    // position if there is a space at the end
	    int stringinput = (str.substring(0, col).lastIndexOf(' '));
	    // if stringinput is valid and not out of bounds
	    if (stringinput != -1)
	    // call to lineBreak method for adding linebreaks at the end
	      return lineBreak(str, stringinput, 1);
	    else if (str.charAt(col) == ' ')
	      return lineBreak(str, col, 1);
	    else
	      return lineBreak(str, col, 0);
	  }
	  
	  public static void main(String[] args) {
			// sample input cases
			System.out.println(wrap("hat",  4));
			System.out.println(wrap("hat hat", 4));
			System.out.println(wrap("hat hat hat", 4));
			System.out.println(wrap("I am at the store", 4));
		}
	}