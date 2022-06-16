package chapter_1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import chapter_1.dup_str.DuplicateStringChecker;
import chapter_1.non_repeating.NonRepeatingChecker;
import chapter_1.probs_4_x.ChapOneSolutions;
import chapter_1.reverse.ReverseText;

class ChapterOne_Tests {

	// Count duplicate chars...
	@Test
	void count_computeInBasicWay() {
		DuplicateStringChecker checker = new DuplicateStringChecker("$w$abbcdded$q$a");
		checker.computeInBasicWay();
		
		assertEquals(7, checker.getTotalNumberOfDuplicates());
	}
	@Test
	void count_computeUsingCompute() {
		DuplicateStringChecker checker = new DuplicateStringChecker("$w$abbcdded$q$a");
		checker.computeWithCompute();
		
		assertEquals(7, checker.getTotalNumberOfDuplicates());
	}
	
	// First non repeating char...
	@Test
	void firstNonRepeatingChar_usingList() {
		NonRepeatingChecker checker = new NonRepeatingChecker("$w$abbcdded$q$a");
		checker.computeUsingList();
		assertEquals('w', checker.getFirstNonRepeatingChar().get());
	}
	@Test
	void firstNonRepeatingChar_usingCodePoint() {
		NonRepeatingChecker checker = new NonRepeatingChecker("$w$abbcdded$q$a");
		checker.computeUsingCodePoints();
		assertEquals('w', checker.getFirstNonRepeatingChar().get());
	}
	
	// Reverse text
	@Test
	void reverseLettersInWords() {
		ReverseText reverser = new ReverseText("The fox jumps over the hedge.");
		reverser.reverseTextInWords();
		
		assertEquals("ehT xof spmuj revo eht .egdeh ", reverser.getReversedText());
	}
	@Test
	void reverseLettersInWords_functionally() {
		ReverseText reverser = new ReverseText("The fox jumps over the hedge.");
		reverser.reverseTextInWordsFunctionally();;
		
		assertEquals("ehT xof spmuj revo eht .egdeh", reverser.getReversedText());
	}
	@Test
	void reverseLettersInWordsAndWordOrder() {
		ReverseText reverser = new ReverseText("The fox jumps over the hedge.");
		reverser.reverseTextInWordsAndWordOrder();
		
		assertEquals(".egdeh eht revo spmuj xof ehT", reverser.getReversedText());
	}
	
	//Problem 4 - String contains only digits.
	@Test
	void prob4_true() {
		assertTrue(ChapOneSolutions.stringContainsOnlyDigits("123"));
	}
	@Test
	void prob4_false() {
		assertFalse(ChapOneSolutions.stringContainsOnlyDigits("123a"));
	}
	
	//Problem 5 - How many vowels and consonants in a string.
	@Test
	void prob5_getConsonants() {
		ChapOneSolutions.computeNumVowelsAndConsonants("The fox jumps over the hedge.");
		assertEquals(15, ChapOneSolutions.getNumConsts());
	}
	@Test
	void prob5_getVowels() {
		ChapOneSolutions.computeNumVowelsAndConsonants("The fox jumps over the hedge.");
		assertEquals(8, ChapOneSolutions.getNumVowels());
	}
	
	//Problem 6 - Get occurrences of char in string.
	@Test 
	void prob6_getOccurs(){
		assertEquals(2, ChapOneSolutions.getNumOccursOfCharInStr('A', "AaABBB"));
	}
	@Test 
	void prob6_getOccurs_withStream(){
		assertEquals(2, ChapOneSolutions.getNumOccursOfCharInStr_UisngStream('A', "AaABBB"));
	}

	//Problem 7 - Convert string to long.
	@Test
	void prob7_convertStrToLong_withGoodVal() {
		assertEquals(4321L, ChapOneSolutions.convertStrToLong("4321"));
	}
	@Test
	void prob7_convertStrToLong_withBadVal() {
		assertEquals(-1L, ChapOneSolutions.convertStrToLong("4321s"));
	}

	//Problem 8 - Remove white space from string
	@Test
	void prob8_removeWhiteSpaceFromStr() {
		assertEquals("ABCD", ChapOneSolutions.removeWhiteSpace("A BC D"));
	}
	
	//Problem 9 - Join strings with delimiter.
	@Test
	void prob9_joinStrings() {
		String [] strings = {"abcd","efgh"};
		assertEquals("abcd;efgh;", ChapOneSolutions.joinStringsWithDelimiter(strings, ";"));
	}
	@Test
	void prob9_joinStrings_Java8() {
		String [] strings = {"abcd","efgh"};
		assertEquals("abcd;efgh", ChapOneSolutions.joinStringsWithDelimiter_Java8(strings, ";"));
	}
	
	//Problem 10 - Generate all permutations of a string.
	@Test
	void prob10_allPerms() {
		ChapOneSolutions.generateAllPermsOfString("abc");
	}
}
