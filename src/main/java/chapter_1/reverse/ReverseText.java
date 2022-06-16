/**
 * 
 */
package chapter_1.reverse;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author SteveBrown
 */
public class ReverseText {
	private static final String WHITESPACE = " ";
	
	private String textIn;
	private StringBuilder reversedText;

	public ReverseText(String text) {
		this.textIn = text;
	}
	
	public void reverseTextInWords() {
		String[] words = textIn.split(WHITESPACE);
		reversedText = new StringBuilder();

		for(String word: words) {

			StringBuilder reversedWord = new StringBuilder();
			int wordLen = word.length();
			for(int idx1 = wordLen-1; idx1 >= 0; idx1--) {
				reversedWord.append(word.charAt(idx1));
			}			
			reversedText.append(reversedWord).append(WHITESPACE); 
		}
	}
	
	public void reverseTextInWordsFunctionally() {
		final Pattern PATTERN = Pattern.compile(" +");
	  String rev = PATTERN.splitAsStream(textIn)
	    .map(w -> new StringBuilder(w).reverse())   	
	    .collect(Collectors.joining(" "));
 	
	  reversedText = new StringBuilder(rev); 	
	}
	
	public void reverseTextInWordsAndWordOrder() { 	
	  reversedText = new StringBuilder(textIn).reverse(); 	
	}
	
	public String getReversedText() {
		return reversedText.toString();
	}
}
